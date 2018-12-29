package com.example.demo.controller;

import com.example.demo.service.MessageService;
import com.example.demo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("replycontroller")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private MessageService messageService;
    @RequestMapping("/addReply")
    @ResponseBody
   public String insertReply(HttpSession session,Integer messageid, String replyid , String replydetail){
        System.out.println("执行了");
        String c= session.getAttribute("loginphone").toString();
        replyid=c;
        Date date = new Date();

        this.replyService.insertReply(messageid,replyid,replydetail,date);
        this.messageService.updateReply(date,messageid);

        int types=(int)session.getAttribute("type");
        System.out.println("=============="+types);
        if (types==2){
            System.out.println("09099009090");
            return "redirect:messagecontroller/querymessage";
        }
        return "redirect:messagecontroller/querymessage2";
        /*return "messagecontroller/see";*/

    }
}
