package com.example.demo.service.serviceImp;

import com.example.demo.Model.Message;
import com.example.demo.dao.MessageMapper;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageserviceImp implements MessageService {
    @Autowired
    private MessageMapper messagemapper;

    @Override
    public List<Message> queryMessageAll() {
        return  this.messagemapper.queryMessageAll();
    }

    @Override
    public Message editone(Integer messageid) {
        return this.messagemapper.editone(messageid);
    }

    @Override
    public void deleteon(Integer messageid) {
        this.messagemapper.deleteon(messageid);
    }

    @Override
    public void updatemessage(Message message) {
        this.messagemapper.updatemessage(message);
    }

    @Override
    public List<Message> findMessageByPhone(String phone) {
        return this.messagemapper.findMessageByPhone(phone);
    }

    @Override
    public void addMessage(String messagetitle, String messagedetail , Date date, String phone) {
        this.messagemapper.addMessage(messagetitle,messagedetail,date,phone);
    }

    @Override
    public void updateReply(Date date,int id) {
        this.messagemapper.updateReply(date,id);
    }
}
