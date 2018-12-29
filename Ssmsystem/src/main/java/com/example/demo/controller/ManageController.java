package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/managecontroller")
public class ManageController {
    @Autowired
    private UserService userService;
    @RequestMapping("/queryuser")
    public String queryUser( Model model){
        model.addAttribute("userlist",this.userService.queryUserAll());
        return "manage";
    }

    @RequestMapping("/preupdate")
    public String preupdate(Integer userid,Model model) {
        System.out.println("进入了preupdate");
        model.addAttribute("userdetail",this.userService.seeone(userid));
        return "manage_update";
    }


    @RequestMapping("update")
    @ResponseBody
    public  Integer updateuser(User user,Model model){
        int flag=0;
        System.out.println("进入了update");
        this.userService.updateuser(user);
        return flag;
    }

}
