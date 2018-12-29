package com.example.demo.controller;

import com.example.demo.Model.Message;
import com.example.demo.service.MessageService;
import com.example.demo.service.ReplyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/messagecontroller")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    @RequestMapping("/querymessage")
    public String queryMessage(Model model){
        model.addAttribute("messagelist",this.messageService.queryMessageAll());
        model.addAttribute("replyService",replyService);
        model.addAttribute("userService",userService);
        return "message_list";
    }
    @RequestMapping("/querymessage2")
    public String queryMessage2( Model model){
        model.addAttribute("messagelist",this.messageService.queryMessageAll());
        return "message_list2";
    }
    @RequestMapping("/see")
    public String see(Integer messageid,Model model){
        model.addAttribute("messagedetail",this.messageService.editone(messageid));
        model.addAttribute("replydetail",this.replyService.queryReplyByMessageId(messageid));
        model.addAttribute("userService",userService);

        return "message_detail";
    }
    @RequestMapping("/deleteone")
    public String deleteone(Integer messageid){
        this.messageService.deleteon(messageid);
        return "redirect:querymessage";

    }
    @RequestMapping("/preupdate")
    public String preupdate(Integer messageid,Model model) {
        System.out.println("进入了preupdate");
        model.addAttribute("messagedetail",this.messageService.editone(messageid));
        return "message_update";
    }
    @RequestMapping("/update")
    @ResponseBody
    public Integer updatemessage(Message message) {
        int flag=0;
        this.messageService.updatemessage(message);
        return flag;
    }

   @RequestMapping("/judge")
   public String judegement(HttpSession session,Model model){
       String types=session.getAttribute("type").toString();
       if (Integer.parseInt(types)==2){
           return "redirect:querymessage";
       }
       return "redirect:querymessage2";
    }
    @RequestMapping("/queryMyMessage")
    public String querymymessage(HttpSession session,Model model){
        model.addAttribute("articles",this.messageService.findMessageByPhone(session.getAttribute("loginphone").toString()));
        return "mymessages_list";
    }
    @RequestMapping("/preAddMessage")
    public String preAddMessage(){
        return "addMessage";
    }
    @RequestMapping("/addMessage")
    public String addMessage(String messagetitle, String messagedetail , HttpSession session){
        String c= session.getAttribute("loginphone").toString();
        System.out.println("这里进来了");
        Date date2 = new Date();
        this.messageService.addMessage(messagetitle,messagedetail ,date2,c);
        return "redirect:/judge";
    }


}
