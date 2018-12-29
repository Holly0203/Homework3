package com.example.demo.dao;

import com.example.demo.Model.Message;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface MessageMapper {
    //查询所有相关的消息
    public List<Message> queryMessageAll();
    //编辑某一条消息
    public Message editone(Integer messageid);
    //删除某一条消息
    public void deleteon(Integer messageid);
    //修改某一条记录
    public void updatemessage(Message message);
    //根据用户登录的手机号查询自己的文章
    public List<Message>findMessageByPhone(String phone);
    //新增一条消息
    public void addMessage(String messagetitle, String messagedetail , Date date, String phone);
    //评论时修改文章表中最后评论时间
    public void updateReply(Date date,int id);
}
