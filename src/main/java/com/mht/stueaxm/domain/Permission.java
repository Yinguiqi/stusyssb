package com.mht.stueaxm.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kirtico
 * @date 2023/7/6&15:02
 */
@Data
public class Permission {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Permission() {
        // 默认构造方法
    }
}
