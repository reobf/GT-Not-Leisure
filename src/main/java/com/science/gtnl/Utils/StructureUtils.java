package com.science.gtnl.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StructureUtils {

    // 基础路径
    public static final String BASE_PATH = "/assets/";
    public static final ConcurrentHashMap<String, List<String[]>> MULTIBLOCK_CACHE = new ConcurrentHashMap<>();

    /**
     * 从文件读取多方块结构
     *
     * @param fileName 文件名
     * @return 多方块结构的二维字符串数组
     */
    public static String[][] readStructureFromFile(String fileName) {
        return MULTIBLOCK_CACHE.computeIfAbsent(fileName, name -> {
            List<String[]> structure = new ArrayList<>();
            String filePath = BASE_PATH + name.replace(':', '/') + ".mb";
            try (InputStream is = StructureUtils.class.getResourceAsStream(filePath)) {
                if (is == null) {
                    throw new IllegalArgumentException("无法读取文件: " + name + "，请检查文件是否存在。");
                }
                try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        structure.add(line.split(","));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return structure;
        })
            .toArray(new String[0][]);
    }

    /**
     * 转置二维数组
     *
     * @param original 原始二维数组
     * @return 转置后的二维数组
     */
    public static String[][] transposeStructure(String[][] original) {
        if (original == null || original.length == 0) {
            throw new IllegalArgumentException("矩阵为空，无法转置！");
        }

        int rows = original.length;
        int cols = original[0].length;
        String[][] transposed = new String[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = original[i][j];
            }
        }

        return transposed;
    }

    /**
     * 打印二维数组
     *
     * @param structure 二维字符串数组
     */
    public static void printStructure(String[][] structure) {
        for (String[] row : structure) {
            System.out.println(String.join(",", row));
        }
    }
}
