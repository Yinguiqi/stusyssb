package com.mht.stueaxm.controller;

import com.alibaba.fastjson.JSONObject;
import com.mht.stueaxm.domain.Page;
import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/3&19:26
 */
@Controller
@SessionAttributes("student")
public class StudentInfoController {


    @Autowired
    private StudentInfoService studentInfo;

    @RequestMapping("/addStudent")
    public String addStudent(HttpServletRequest request, HttpServletResponse response){
        Student student = new Student();

        // 获取前端传值
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        Date birthday = null;
        // 将 String 类型的日期按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setStudent_id(studentId);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setBirthday(birthday);

        studentInfo.addStudent(student);
        return "redirect:listStudent";
    }
    /**
     * 根据 id 删除一个学生信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(int id){
        studentInfo.deleteStudent(id);
        return "redirect:listStudent";
    }


    /**
     * 修改一个学生信息,进入修改界面editStudent后再调用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/updateStudent")
    public String updateStudent(HttpServletRequest request, HttpServletResponse response){
        Student student = new Student();
        int id = Integer.parseInt(request.getParameter("id"));
        // 获取前端传值
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        Date birthday = null;
        // 将 String 类型的日期按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setId(id);
        student.setStudent_id(studentId);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setBirthday(birthday);

        studentInfo.updateStudent(student);
        return "redirect:listStudent";
    }

    /**
     * 分页显示学生信息
     */
    @RequestMapping("/listStudent")
    public String listStudent(HttpServletRequest request, HttpServletResponse response) {

        // 获取分页参数
        int start = 0;
        int count = 6;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }

        // 创建分页模型
        Page page = new Page(start, count);

        // 按照页码查询学生信息
        List<Student> students = studentInfo.list(page.getStart(), page.getCount());
        int total = studentInfo.getTotal();
        page.setTotal(total);

        // 将查询出来的学生信息放在域中
        request.setAttribute("students", students);
        request.setAttribute("page", page);

        return "listStudent";
    }

    @RequestMapping("/retrieveStudent")
    public String retrieveStudent(HttpServletRequest request, HttpServletResponse response){
        Student student = new Student();
        // 获取前端传值
        int studentId ;
        int age;
        if (request.getParameter("student_id") == null || request.getParameter("student_id") == ""){
            studentId = -1;
        }else {
            studentId =  Integer.parseInt(request.getParameter("student_id"));
        }
        if (request.getParameter("age") == null || request.getParameter("age") == ""){
            age = -1;
        }else {
            age =  Integer.parseInt(request.getParameter("age"));
        }
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Date birthday = null;
        // 将 String 类型的日期按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setStudent_id(studentId);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setBirthday(birthday);


        // 获取分页参数
        int start = 0;
        int count = 6;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }

        // 创建分页模型
        Page page = new Page(start, count);

        // 按照页码查询学生信息
        List<Student> students = studentInfo.retrieveStudent(student);
        int total = students.size();
        page.setTotal(total);

        // 将查询出来的学生信息放在域中
        request.setAttribute("students", students);
        request.setAttribute("page", page);
        return "listStudent";
    }

}
