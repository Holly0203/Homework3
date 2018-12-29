package com.example.demo.dao;

import com.example.demo.Model.Reply;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReplyMapper {
    //根据登录的手机号进行查询所有相关的消息
    public List<Reply> queryReplyByMessageId(int messageid);
    //插入评论
    public void insertReply(Integer messageid, String replyid, String replydetail, Date replydate);

    public  int findCountById(int messageid);

    public Date findTimeById(int message);

}
