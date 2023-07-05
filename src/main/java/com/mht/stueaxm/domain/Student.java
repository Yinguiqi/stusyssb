package com.mht.stueaxm.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Kirtico
 * @date 2022/9/14&19:00
 */
@Data
public class Student {

    private int id;
    private int student_id;

    private int dormitory_id;
    private String name;
    private int age;
    private String sex;
    private Date birthday;

    public Student() {
    }

    public Student(int id, int student_id,int dormitory_id ,String name, int age, String sex, Date birthday) {
        this.id = id;
        this.student_id = student_id;
        this.dormitory_id = dormitory_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }


}