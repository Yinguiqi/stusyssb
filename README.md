# 齐工学生宿舍管理系统

## 项目简介
齐工学生宿舍管理系统是一个基于 Spring Boot 的学生宿舍管理应用。它提供了管理宿舍里学生信息的功能，并采用了 Spring MVC、MySQL、Maven 和 MyBatis 技术栈。前端方面使用了 jsp、Bootstrap 和 layui 等框架。系统还使用拦截器实现了登录验证和基于 RBAC 模型的权限管理。

## 技术栈
- 后端：Spring Boot、Spring MVC、MySQL、Maven、MyBatis
- 前端：jsp、Bootstrap、layui

## 功能特性
- 学生信息管理：管理员账号登录后可以执行增加、删除、查询和修改学生信息的操作。
- 权限管理：使用拦截器实现了基于 RBAC 模型的权限管理，管理员账号具有完整的功能权限，普通账号只能查看学生信息。
- 动态代理：使用了Profile 进行动态配置切换
- 错误页面处理：系统配置了错误页面的回跳转功能，当出现错误时，会自动跳转到指定的错误页面。（一般不会出错）

## 快速开始
### 前提条件
- JDK 8 或更高版本
- Maven 3.x
- MySQL 数据库
  
### 安装和配置
克隆项目到本地：
```BASH
git clone https://github.com/Yinguiqi/stusyssb.git
```

进入项目目录：
```BASH
cd stusyssb
```

修改数据库配置：

打开 src/main/resources/application-dev.yml 文件。
根据你的 MySQL 配置，修改以下属性：
```java
spring.datasource.url=jdbc:mysql://localhost:3306/student_dormitory_management
spring.datasource.username=your-username
spring.datasource.password=your-password
```

编译和运行：
```BASH
mvn spring-boot:run
```

在浏览器中访问：http://localhost:8080

## 许可证
该项目使用 GPL（GNU General Public License） 许可证。

## 联系方式
bilibili：烤棉花糖总是好的
邮箱：yinhe2360@163.com
