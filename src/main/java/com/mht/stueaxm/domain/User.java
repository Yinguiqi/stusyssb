package com.mht.stueaxm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kirtico
 * @date 2022/9/9&9:57
 */
@Data
public class User {
   @TableId(value = "id", type = IdType.AUTO)//指定自增策略
   private int id;
   private String username;
   private String password;
   private String email;
   private String mobile;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;

   public User() {
      // 默认构造方法
   }

}
