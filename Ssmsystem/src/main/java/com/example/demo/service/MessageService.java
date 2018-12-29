package com.example.demo.service;

import com.example.demo.Model.Message;

import java.util.Date;
import java.util.List;

public interface MessageService {
    public List<Message> queryMessageAll();
    //编辑某一条消息
    public Message editone(Integer messageid);
    //删除某一条消息
    public void deleteon(Integer messageid);
    //修改某一条记录
    public void updatemessage(Message message);
    //根据手机号查询自己的所有文章
    public  List<Message> findMessageByPhone(String phone);
    //新增一条消息
    public void addMessage(String messagetitle, String messagedetail , Date date, String phone);
    //评论时修改文章表中最后评论时间
    public void updateReply(Date date,int id);

}
