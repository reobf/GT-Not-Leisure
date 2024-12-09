package com.science.gtnl.Utils;

public class FilpStructure {

    /**
     * 从指定文件路径读取结构，并返回转置后的结果
     *
     * @param filePath 文件路径
     * @return 转置后的结构
     */
    public static String[][] loadAndTransposeStructure(String filePath) {
        // 读取原始结构
        String[][] originalShape = StructureUtils.readStructureFromFile(filePath);

        // 直接转置
        return StructureUtils.transposeStructure(originalShape);
    }
}
