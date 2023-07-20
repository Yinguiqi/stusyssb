package com.mht.stueaxm.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
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
    private DormStatus leftDorm;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    public Student() {
    }

    public Student(int id, int studentId,int dormitoryId ,String name, int age, String sex, Date birthday, DormStatus leftDorm) {
        this.id = id;
        this.studentId = studentId;
        this.dormitoryId = dormitoryId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.leftDorm = leftDorm;
    }

    public enum DormStatus {
        IN(1, "在"),
        IN_NOT(2, "不在");

        @EnumValue
        private Integer key;

        @JsonValue
        private String display;

        DormStatus(Integer key, String display) {
            this.key = key;
            this.display = display;
        }

        public Integer getKey() {
            return key;
        }

        public String getDisplay() {
            return display;
        }
    }
}