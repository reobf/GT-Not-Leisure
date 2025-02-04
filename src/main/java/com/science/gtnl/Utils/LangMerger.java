package com.science.gtnl.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.client.Minecraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LangMerger {

    private static final String MOD_ID = "sciencenotleisure";
    private static final String LANG_DIR = "assets/" + MOD_ID + "/lang/";
    private static final String GT_PREFIX = "GregTech_";
    private static final Pattern ENTRY_PATTERN = Pattern.compile("^\\s*([^=]+)=(.*)$");
    private static final String CONFLICT_MARKER = "# AutoMerge: enableConflictCheck";

    @SideOnly(Side.CLIENT)
    public void processLanguageFiles() {
        try {
            // 获取 options.txt 中的语言代码
            String currentLangCode = getLanguageFromOptions();

            // 处理 GregTech.lang 文件
            processLanguageFile("GregTech.lang", currentLangCode);

            // 处理所有支持的语言文件
            String[] langCodes = getSupportedLanguages();
            for (String langCode : langCodes) {
                processLanguageFile(GT_PREFIX + langCode + ".lang", langCode);
            }

        } catch (Exception e) {
            System.err.println("Language file processing failed:");
            e.printStackTrace();
        }
    }

    private void processLanguageFile(String fileName, String langCode) throws IOException {
        File targetFile = new File(getGameDir(), fileName);
        Map<String, String> modEntries = loadModEntries(langCode);
        if (modEntries.isEmpty()) {
            System.out.println("No entries found for language: " + langCode);
            return;
        }
        mergeIntoTarget(targetFile, modEntries, true);
    }

    private String[] getSupportedLanguages() {
        return new String[] { "en_US", "zh_CN" }; // 可以根据需要添加更多语言代码
    }

    private Map<String, String> loadModEntries(String langCode) throws IOException {
        Map<String, String> entries = new LinkedHashMap<>();
        String resourcePath = LANG_DIR + langCode + ".lang";
        URL resourceUrl = getClass().getClassLoader()
            .getResource(resourcePath);

        if (resourceUrl != null) {
            System.out.println("Loading language file from: " + resourceUrl.getPath());
        } else {
            System.out.println("Language file not found: " + resourcePath);
            return entries;
        }

        try (InputStream is = resourceUrl.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher m = ENTRY_PATTERN.matcher(line);
                if (m.find()) {
                    String key = m.group(1)
                        .trim();
                    String value = m.group(2)
                        .trim();
                    entries.put(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading language file: " + resourceUrl.getPath());
            e.printStackTrace();
        }

        // 打印抓取到的语言文件内容
        System.out.println("Loaded entries from " + resourcePath + ":");
        entries.forEach((key, value) -> System.out.println(key + " = " + value));

        return entries;
    }

    private void mergeIntoTarget(File targetFile, Map<String, String> newEntries, boolean isLocalized)
        throws IOException {
        // 创建目录结构
        if (!targetFile.getParentFile()
            .exists()
            && !targetFile.getParentFile()
                .mkdirs()) {
            throw new IOException("无法创建目录: " + targetFile.getParent());
        }

        // 读取现有内容
        StringBuilder header = new StringBuilder();
        Map<String, String> existingEntries = new LinkedHashMap<>();
        boolean hasConflictMarker = false;
        boolean hasLanguageBlock = false;
        boolean hasConfigFileHeader = false;
        boolean hasClosingBracket = false;

        if (targetFile.exists()) {
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(targetFile), StandardCharsets.UTF_8))) {
                String line;
                boolean inLanguageBlock = false;
                while ((line = reader.readLine()) != null) {
                    // 检测冲突检查标记
                    if (line.trim()
                        .equals(CONFLICT_MARKER)) {
                        hasConflictMarker = true;
                    }

                    if (line.trim()
                        .equalsIgnoreCase("languagefile {")) {
                        inLanguageBlock = true;
                        hasLanguageBlock = true;
                        header.append(line)
                            .append("\n");
                        continue;
                    }

                    if (line.trim()
                        .equals("# Configuration file")) {
                        hasConfigFileHeader = true;
                    }

                    if (line.trim()
                        .equals("}")) {
                        hasClosingBracket = true;
                    }

                    if (inLanguageBlock) {
                        if (line.trim()
                            .equals("}")) {
                            inLanguageBlock = false;
                            continue;
                        }

                        Matcher m = ENTRY_PATTERN.matcher(line);
                        if (m.find()) {
                            String key = m.group(1)
                                .trim();
                            existingEntries.put(
                                key,
                                line.substring(line.indexOf('=') + 1)
                                    .trim());
                        }
                    } else {
                        header.append(line)
                            .append("\n");
                    }
                }
            }
        }

        // 构建新内容
        StringBuilder content = new StringBuilder();
        if (!hasConfigFileHeader) {
            content.append("# Configuration file\n");
        }

        // 添加或保留冲突检查标记
        if (!header.toString()
            .contains(CONFLICT_MARKER)) {
            content.append(CONFLICT_MARKER)
                .append("\n");
        } else {
            content.append(header);
        }

        content.append("\n");
        if (!hasLanguageBlock) {
            content.append("languagefile {\n");
        }

        // 合并策略：根据标记决定是否检查冲突
        LinkedHashMap<String, String> mergedEntries = new LinkedHashMap<>();
        if (hasConflictMarker) {
            // 冲突检查模式：只添加不存在的条目
            newEntries.forEach((k, v) -> mergedEntries.putIfAbsent(k, v));
            existingEntries.forEach(mergedEntries::putIfAbsent);
        } else {
            // 直接插入模式：新条目在前
            newEntries.forEach((k, v) -> mergedEntries.put(k, v));
            existingEntries.forEach((k, v) -> mergedEntries.putIfAbsent(k, v));
        }

        // 写入条目，添加 " S:" 前缀
        mergedEntries.forEach(
            (key, value) -> {
                content.append("    S:")
                    .append(key)
                    .append("=")
                    .append(value)
                    .append("\n");
            });

        if (!hasLanguageBlock) {
            content.append("}\n");
        } else if (!hasClosingBracket) {
            content.append("}\n");
        }

        // 写入文件
        try (BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(targetFile), StandardCharsets.UTF_8))) {
            writer.write(content.toString());
        }
    }

    @SideOnly(Side.CLIENT)
    private String getLanguageFromOptions() {
        File optionsFile = new File(getGameDir(), "options.txt");
        if (!optionsFile.exists()) {
            return "zh_CN"; // 默认语言
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(optionsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("lang:")) {
                    return line.split(":")[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "zh_CN"; // 默认语言
    }

    private File getGameDir() {
        if (FMLCommonHandler.instance()
            .getSide()
            .isClient()) {
            return Minecraft.getMinecraft().mcDataDir;
        }
        return new File(".").getAbsoluteFile();
    }
}
