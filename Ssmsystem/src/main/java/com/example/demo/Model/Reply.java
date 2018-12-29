package com.example.demo.Model;

import java.util.Date;

public class Reply {
    private  int id;
    private  int messageid;
    private String replyid;
    private  String replydetail;
    private Date replydate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public String getReplydetail() {
        return replydetail;
    }

    public void setReplydetail(String replydetail) {
        this.replydetail = replydetail;
    }

    public Date getReplydate() {
        return replydate;
    }

    public void setReplydate(Date replydate) {
        this.replydate = replydate;
    }
}
