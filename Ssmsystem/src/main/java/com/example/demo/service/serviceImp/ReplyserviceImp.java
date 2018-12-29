package com.example.demo.service.serviceImp;

import com.example.demo.Model.Reply;
import com.example.demo.dao.ReplyMapper;
import com.example.demo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ReplyserviceImp implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Reply>queryReplyByMessageId(int messageid) {
        return this.replyMapper.queryReplyByMessageId(messageid);
    }

    @Override
    public Integer insertReply(Integer messageid, String replyid, String replydetail,Date replydate) {
        int flag=1;
        this.replyMapper.insertReply(messageid,replyid,replydetail,replydate);
        return flag;
    }

    @Override
    public int findCountById(int messageid) {
        return this.replyMapper.findCountById(messageid);
    }

    @Override
    public Date findTimeById(int messageid) {
        return this.replyMapper.findTimeById(messageid);
    }

}
