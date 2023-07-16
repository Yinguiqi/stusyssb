package com.mht.stueaxm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Kirtico
 * @date 2022/9/14&19:00
 */
@Data
@TableName("student")
public class Student {
    private int id;

    private int studentId;
    private int dormitoryId;
    private String name;
    private int age;
    private String sex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    public Student() {
    }

    public Student(int id, int studentId,int dormitoryId ,String name, int age, String sex, Date birthday) {
        this.id = id;
        this.studentId = studentId;
        this.dormitoryId = dormitoryId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }


}