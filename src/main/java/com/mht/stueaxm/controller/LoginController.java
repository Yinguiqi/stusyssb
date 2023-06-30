package com.mht.stueaxm.controller;

import com.mht.stueaxm.domain.Page;
import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Kirtico
 * @date 2022/9/9&10:33
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value = "/LoginController",produces = "text/html;charset=utf-8")
public class LoginController {
    //LoginServiceImpl loginService = new LoginServiceImpl();
    @Autowired
    private LoginService service;


    @GetMapping("/")
    public String index(){
        return "login";
    }

    @ResponseBody()
    @RequestMapping("StudentLogin")
    private void studentLogin (HttpServletRequest req, HttpServletResponse resp)throws IOException {
        //创建输出流
        PrintWriter out=resp.getWriter();
        HttpSession session=req.getSession();
        //接受验证码
        String checkcode = req.getParameter("checkcode");
        if(checkcode!=null&&!checkcode.equals("")){
            checkcode=checkcode.toLowerCase();
        }
        String checkcode1 = (String)session.getAttribute("checkcode");
        System.out.println(checkcode1);
        System.out.println(checkcode);
        if(!checkcode1.toLowerCase().equals(checkcode)){
            out.print("error");
        }else {
            //接收来自客户端的账号密码
            System.out.println(321);
            String userName=req.getParameter("userName");
            String passWord=req.getParameter("passWord");
            //调用验证方法
            User userStudent = service.login(userName,passWord);
            if (userStudent!=null){
                out.print("ok");
            }else{
                System.out.println(123);
                out.print("no");
            }
        }

    }

    //绘制验证码
    private static final String result="ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
    @ResponseBody()
    @RequestMapping("CheckCodeServlet1")
    private String drawImg(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //宽
        int width=139;
        //高
        int height=45;
        //1、生成图片
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2、美化图片
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        g.setColor(Color.CYAN);
        g.fillRect(0,0,width,height);
        g.setColor(Color.black);
        Font f=new Font("宋体",Font.BOLD,30);
        g.setFont(f);
        Color[] colors=new Color[]{Color.ORANGE,Color.BLUE,Color.PINK,Color.YELLOW,Color.GREEN };
        String checkcode="";
        for (int i=0;i<4;i++){
            Random r=new Random();
            int i1 = r.nextInt(result.length());
            int i2 = r.nextInt(colors.length);
            g.setColor(colors[i2]);
            String c = result.charAt(i1)+"";
            g.drawString(c,(i*30)+10,30);
            checkcode+=c;
        }
        HttpSession session = req.getSession();
        session.setAttribute("checkcode",checkcode);
        System.err.println(checkcode);

        //3、输出图片
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
        return checkcode;
    }

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

        service.addStudent(student);
        return "redirect:listStudent1";
    }
    /**
     * 根据 id 删除一个学生信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(int id){
        service.deleteStudent(id);
        return "redirect:listStudent1";
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

        service.updateStudent(student);
        return "redirect:listStudent1";
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
        List<Student> students = service.list(page.getStart(), page.getCount());
        int total = service.getTotal();
        page.setTotal(total);

        // 将查询出来的学生信息放在域中
        request.setAttribute("students", students);
        request.setAttribute("page", page);

        return "listStudent";
    }
    /**
     * 分页显示学生信息1
     */
    @RequestMapping("/listStudent1")
    public String listStudent1(HttpServletRequest request, HttpServletResponse response) {

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
        List<Student> students = service.list(page.getStart(), page.getCount());
        int total = service.getTotal();
        page.setTotal(total);

        // 将查询出来的学生信息放在域中
        request.setAttribute("students", students);
        request.setAttribute("page", page);

        return "listStudent1";
    }
    /**
     * 用于修改学生信息界面的信息回显
     * @param id
     * @return
     */
    @RequestMapping("/editStudent")
    public ModelAndView editStudent(int id){
        // 创建一个模型视图对象
        ModelAndView mv = new ModelAndView();
        // 查询学生信息
        Student student = service.getStudent(id);
        // 将数据放置到 ModelAndView 对象视图中
        mv.addObject("student",student);
        // 放入 jsp 界面
        mv.setViewName("editStudent");
        return mv;
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
        List<Student> students = service.retrieveStudent(student);
        int total = students.size();
        page.setTotal(total);

        // 将查询出来的学生信息放在域中
        request.setAttribute("students", students);
        request.setAttribute("page", page);
        return "listStudent1";
    }
    @RequestMapping("/editStudent1")
    protected void editStudent1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Student student = service.getStudent(id);
        JSONObject object = new JSONObject();
        String object1 = object.toJSONString(student);
        System.out.println(object1);
        response.getWriter().write(object1);
}
}
//    int studentId =  Integer.parseInt(request.getParameter("student_id"));
//    String name = request.getParameter("name");
//    int age = Integer.parseInt(request.getParameter("age"));
//    String sex = request.getParameter("sex");
//    Date birthday = null;