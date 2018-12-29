package com.example.demo.Model;

import java.util.Date;

public class Message {
    private int id;
    private String phone;
    private String messagetitle;
    private String messagedetail;
    private Date date;
    private Integer Commentcount;
    private  Date lastcomment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessagedetail() {
        return messagedetail;
    }

    public void setMessagedetail(String messagedetail) {
        this.messagedetail = messagedetail;
    }


    public Integer getCommentcount() {
        return Commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        Commentcount = commentcount;
    }

    public Date getLastcomment() {
        return lastcomment;
    }

    public void setLastcomment(Date lastcomment) {
        this.lastcomment = lastcomment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
