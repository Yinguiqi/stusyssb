package com.mht.stueaxm.controller;

import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Kirtico
 * @date 2022/9/9&10:33
 */
@Controller
@SessionAttributes("user")

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
        if(!checkcode1.toLowerCase().equals(checkcode)){
            out.print("error");
        }else {
            //接收来自客户端的账号密码
            String userName=req.getParameter("userName");
            String passWord=req.getParameter("passWord");
            //调用验证方法
            User userStudent = service.login(userName,passWord);
            if (userStudent!=null){
                out.print("ok");
                session.setAttribute("userName", userName);
            }else{
                out.print("no");
            }
        }

    }

    //绘制验证码
    private static final String result="ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
    @ResponseBody()
    @RequestMapping("CheckCodeServlet")
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


}
