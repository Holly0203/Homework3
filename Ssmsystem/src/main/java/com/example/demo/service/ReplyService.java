package com.example.demo.service;



import com.example.demo.Model.Reply;

import java.util.Date;
import java.util.List;

public interface ReplyService {
    public List<Reply>queryReplyByMessageId(int messageid);
    //添加评论
    public Integer insertReply(Integer messageid,String replyid,String replydetail,Date replydate);
    //查询评论数
    public int findCountById(int messageid);
    //查询最近评论数
    public Date findTimeById(int messageid);
}
