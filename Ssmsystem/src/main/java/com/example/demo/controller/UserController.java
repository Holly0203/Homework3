package com.example.demo.controller;


import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/usercontroller")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/toregister")
    public String toregister(){//Model model 定义一个“容器”来将数据存放进去 以便传到前端
        return "register";
    }

    @RequestMapping("/register")
    public String register(String name,String phone, String password, HttpServletResponse response){
        System.out.println(name+"11111111111111111111111111111111111111111111111111111111111");

        if(this.userService.adduser(name,phone,password)==1){
            return "login";
        }
        try {
            response.setCharacterEncoding("UTF8");
            response.getWriter().print("手机号已被注册");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "register";

    }


    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login (String phone, String password, HttpSession session){
        int flag=0;
        System.out.println("phone:"+phone+"password:"+password);
        if(this.userService.iflogin(phone, password)==1){
            int s=0;
           s= this.userService.findTypeByPhone(phone);
            session.setAttribute("type",s);
            session.setAttribute("loginphone",phone);
            flag=1;
        }else if(this.userService.iflogin(phone, password)==3){
            session.setAttribute("loginphone",phone);
            int s=0;
            s= this.userService.findTypeByPhone(phone);
            session.setAttribute("type",s);

            flag=2;

        }
        System.out.println("flag="+flag);
        return flag;
    }



}
