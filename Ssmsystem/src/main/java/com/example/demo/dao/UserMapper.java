package com.example.demo.dao;

import com.example.demo.Model.Message;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //查询所有用户
    public List<User> queryUserAll();
    public void insertuser( String name,String phone,String password);
    public User queryuser(String phone);
    public void updateuser(User user);

    public User seeone(Integer userid);
    //根据手机号查询昵称
    public String findNameByPhone(String phone);
    //根据手机号查询类型
    public Integer findTypeByPhone(String phone);
}
