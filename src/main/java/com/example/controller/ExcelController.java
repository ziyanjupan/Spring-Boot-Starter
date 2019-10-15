package com.example.controller;

import com.example.pojo.SysUser;
import com.example.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaguangyong
 * @ClassName: ExcelController
 * @Description: Excel控制器
 * @Date: 2019/9/6 14:15
 * @Version: 1.0
 * @Modify:
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {



    /**
     * @Description 导入Excel
     * @Author xiaguangyong
     * @Date 2019/9/6 14:37
     * @Param file
     * @Return java.util.List<java.lang.String>
     */
    public List<SysUser> importData(File file) {
        Workbook wb = null;
        List<SysUser> sysUserList = new ArrayList();
        try {
            if (ExcelUtils.isExcel2007(file.getPath())) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

        //获取第一张表
        Sheet sheet = wb.getSheetAt(0);
        //getLastRowNum()并非获取实际行数。因此，需要coder自行判断，是否已经到了最后一行（有效行）。
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            //获取索引为i的行，以0开始
            Row row = sheet.getRow(i);
            //获取第i行的索引为0的单元格数据
            String name = row.getCell(0).getStringCellValue();
            //有些单元格为Numeric格式，带有指数E。因此，若想获取其String类型时，需要进行格式转换。
            double age = row.getCell(1).getNumericCellValue();
            if (age == 0 && name == null) {
                break;
            }
            SysUser sysUser = new SysUser();
            sysUser.setName(name);
            sysUser.setAge((int) age);
            sysUserList.add(sysUser);
        }
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sysUserList;
    }


    public static String getStringFromNumericCell(Cell cell) {
        return new DecimalFormat("#").format(cell.getNumericCellValue());
    }

    /**
     * @Description 导出excel
     * @Author xiaguangyong
     * @Date 2019/9/6 14:38
     * @Param heroList
     * @Param templetFilePath
     * @Param exportFilePath
     * @Return void
     */
    public static void exportHeroInfo(List<SysUser> sysUserList, String templetFilePath, String exportFilePath) {
        try {
            File exportFile = new File(exportFilePath);
            File templetFile = new File(templetFilePath);
            Workbook workBook;

            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(exportFile);
            FileInputStream fis = new FileInputStream(templetFile);
            if (ExcelUtils.isExcel2007(templetFile.getPath())) {
                workBook = new XSSFWorkbook(fis);
            } else {
                workBook = new HSSFWorkbook(fis);
            }

            Sheet sheet = workBook.getSheetAt(0);

            int rowIndex = 1;
            for (SysUser item :
                    sysUserList) {
                Row row = sheet.createRow(rowIndex);
                row.createCell(0).setCellValue(item.getAge());
                row.createCell(1).setCellValue(item.getName());
                rowIndex++;
            }

            workBook.write(out);
            out.flush();
            out.close();

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
