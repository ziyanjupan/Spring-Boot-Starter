package com.example.pojo;

import lombok.Data;
import okhttp3.Credentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final short QUARTER4 = 4;

    @Data
    private class Student {
        private String name;
        private Integer age;
    }

    @Test
    public void contextLoads() {

        Long current = System.currentTimeMillis();
        String code = Credentials.basic("728", "V9cHGvDX4y9yb4A3F3kRLeIlwASRFd4Duc4AZ9ukJpVAPonG4IfU8RmnsGTNMCaM");

        double da = 10.78;
        double b = da * 100;
        List<Student> students = new ArrayList<>();

//        Student stu1 = new Student();
//        stu1.setAge(11);
//        stu1.setName("张三");
//
//        Student stu2 = new Student();
//        stu1.setAge(11);
//        stu1.setName("张三");
//
//        students.add(stu1);
//        students.add(stu1);
//        students.add(stu1);
//        students.add(stu1);
//        students.add(stu2);
//        students.add(stu2);
//
//        List<Student> newList = students.stream()
//                .distinct()
//                .collect(Collectors.toList());

        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("1");
        strList.add("1");
        strList.add("2");
        strList.add("2");
        strList = strList.stream()
                .distinct()
                .collect(Collectors.toList());

        Integer intMax = Integer.MAX_VALUE;
        Long longMax = Long.MAX_VALUE;


        try {
            String base64String = getBase64FromUrl("http://10.1.168.134:30280/INTELb2bTest/6/portal/manual_upload/file/2019-08-01/cf092aee5be2c3305358762fd179fc83.jpg");
            int i = 0;
        } catch (Exception e) {
            System.out.println("报错了");
        }


        int a = 10;
        switch (a) {
            case QUARTER4:
                a = 11;
                break;
        }


        Date now = new Date(2019, 9, 19);
        System.out.println(now);


        Calendar calendar = Calendar.getInstance();

        calendar.setTime(now);
        System.out.println(calendar.getTime());
        //当前年份
        int currentYear = calendar.get(Calendar.YEAR);

        //当前月份
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        //当前季度
        int currentQuarter = (currentMonth + 2) / 3;

        Short year = (short) (currentYear);


        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
        lhm.put(1, "化学");
        lhm.put(2, "生物");
        lhm.put(3, "物理");
        lhm.put(4, "语文");
        lhm.put(5, "体育");
        lhm.entrySet();
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(lhm.get(1));

    }

    private String getBase64FromUrl(String urlAddress) throws Exception {
        URL url = new URL(urlAddress);
        URLConnection conn = url.openConnection();
        InputStream inStream = conn.getInputStream();
        // 将文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    throw new Exception("输入流关闭异常");
                }
            }
        }
        return new BASE64Encoder().encode(data);
    }

}
