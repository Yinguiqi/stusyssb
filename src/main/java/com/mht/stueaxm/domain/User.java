package com.mht.stueaxm.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kirtico
 * @date 2022/9/9&9:57
 */
@Data
public class User {
   private int id;
   private String username;
   private String password;
   private String email;
   private String mobile;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private Role role; // 角色信息，与用户关联

   public User() {
      // 默认构造方法
   }

}
