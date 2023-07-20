package com.mht.stueaxm.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Kirtico
 * @date 2023/7/19&15:15
 */
@Data
public class StudentEntryExit {
    private int id;
    private String studentName;
    private Timestamp timestamp;
    private EntryStatus status;

    public StudentEntryExit() {
    }

    public StudentEntryExit(int id, String studentName, Timestamp timestamp, EntryStatus status) {
        this.id = id;
        this.studentName = studentName;
        this.timestamp = timestamp;
        this.status = status;
    }
    public enum EntryStatus {
        IN(1, "进"),
        IN_NOT(2, "出");

        @EnumValue
        private Integer key;

        @JsonValue
        private String display;

        EntryStatus(Integer key, String display) {
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
