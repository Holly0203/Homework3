package com.example.demo.service;
import com.example.demo.Model.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserAll();
    //成功插入数据库
    public Integer adduser(String name,String phone,String password);
    //登录判断账号密码是否正确
    public Integer iflogin(String phone ,String  password);
    //修改某一条记录
    public void updateuser(User user);

    public User seeone(Integer userid);
    //根据手机号查询对应昵称
    public String findNameByPhone(String phone);
    //根据手机号查询对应权限
    public Integer findTypeByPhone(String phone);
}
