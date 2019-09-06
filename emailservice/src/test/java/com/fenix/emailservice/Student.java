package com.fenix.emailservice;

/**
 * @Author: xiaguangyong
 * @ClassName: Student
 * @Description: Student
 * @Date: 2019/8/27 13:31
 * @Version: 1.0
 * @Modify:
 */
public class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
