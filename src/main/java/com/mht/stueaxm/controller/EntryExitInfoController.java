package com.mht.stueaxm.controller;

import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.StudentEntryExit;
import com.mht.stueaxm.service.EntryExitInfoService;
import com.mht.stueaxm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/19&16:22
 */
@Controller
public class EntryExitInfoController {

    @Autowired
    private StudentInfoService studentInfo;

    @Autowired
    private EntryExitInfoService entryExitInfo;

    @RequestMapping("/leftDormStudent")
    public String leftDormStudent(HttpServletRequest request, HttpServletResponse response) {
        //根据id找到student
        Integer id = Integer.parseInt(request.getParameter("id"));
        Student student = studentInfo.getStudent(id);
        String name = student.getName();
        //创建studentEntryExit对象
        StudentEntryExit studentEntryExit = new StudentEntryExit();
        StudentEntryExit.EntryStatus status;
        //根据student的在寝情况更改
        Student.DormStatus leftDorm = student.getLeftDorm();
        if (leftDorm.getKey().equals(1)) {
            student.setLeftDorm(Student.DormStatus.IN_NOT);
            status = StudentEntryExit.EntryStatus.IN_NOT;
        }else {
            student.setLeftDorm(Student.DormStatus.IN);
            status = StudentEntryExit.EntryStatus.IN;
        }
        studentEntryExit.setStudentName(name);
        studentEntryExit.setStatus(status);
        studentInfo.updateStudent(student);
        entryExitInfo.addEntryExitInfo(studentEntryExit);
        return "redirect:listStudent";
    }

    @RequestMapping("/listStudentEntryExit")
    public String listStudentEntryExit(HttpServletRequest request, HttpServletResponse response) {
        List<StudentEntryExit> list = entryExitInfo.list();
        request.setAttribute("list",list);
        return "leftDorm";
    }
}
