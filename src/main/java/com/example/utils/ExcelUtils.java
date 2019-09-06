package com.example.utils;

/**
 * @Author: xiaguangyong
 * @ClassName: ExcelUtils
 * @Description: excel工具
 * @Date: 2019/9/6 14:03
 * @Version: 1.0
 * @Modify:
 */
public class ExcelUtils {

    /**判断2003*/
    public static boolean isExcel2003(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**判断2007*/
    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
