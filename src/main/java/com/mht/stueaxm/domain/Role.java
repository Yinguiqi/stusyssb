package com.mht.stueaxm.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kirtico
 * @date 2023/7/6&14:43
 */
@Data
public class Role {
    private int id;
    private String name;
    private String description;
    private Permission permission;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Role() {
        // 默认构造方法
    }
}
