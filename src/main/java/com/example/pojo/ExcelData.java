package com.example.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xiaguangyong
 * @ClassName: ExcelData
 * @Description: excel
 * @Date: 2019/9/6 14:00
 * @Version: 1.0
 * @Modify:
 */
@Data
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;
}
