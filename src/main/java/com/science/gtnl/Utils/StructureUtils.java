package com.science.gtnl.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StructureUtils {

    // 全局路径
    private static final String BASE_PATH = "/assets/";
    private static final ConcurrentHashMap<String, List<String[]>> MULTIBLOCK_CACHE = new ConcurrentHashMap<>();

    /**
     * 从文件读取多方块结构
     *
     * @param fileName 文件名
     * @return 多方块结构的二维字符串数组
     */
    public static String[][] readStructureFromFile(String fileName) {
        return MULTIBLOCK_CACHE.computeIfAbsent(fileName, (name) -> {
            List<String[]> structure = new ArrayList<>();
            String filePath = BASE_PATH + name.replace(':', '/') + ".mb";
            try (InputStream is = StructureUtils.class.getResourceAsStream(filePath)) {
                if (is == null) {
                    throw new IllegalArgumentException("无法读取文件: " + name + "，请检查文件是否存在。");
                }
                try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        // 解析并保留空格和逗号后无空格
                        String[] row = line.split(",");
                        structure.add(row);
                        // 已删除的调试输出行: System.out.println(Arrays.toString(row));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return structure;
        })
            .toArray(new String[0][]);
    }
}
