package com.example.demo.service.serviceImp;

import com.example.demo.Model.User;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserserviceImp implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> queryUserAll() {
        return this.userMapper.queryUserAll();
    }

    @Override
    public Integer adduser(String name, String phone, String password) {
        //0:代表注册失败   1:注册成功
        int flag=0;
        if(this.userMapper.queryuser(phone)==null){
            this.userMapper.insertuser(name,phone,password);
            flag=1;
        }
        return flag;
    }

    @Override
    public Integer iflogin(String phone, String password) {
        int flag=0;
        System.out.println(password+"**************");
        //0:代表手机号不存在  1代表登录成功 2代表密码错误
        if(this.userMapper.queryuser(phone)==null){
            //手机号有误
            flag=0;
        }else{
            System.out.println("用户密码"+password+":数据库密码："+this.userMapper.queryuser(phone).getPassword());
            if (password.equals(this.userMapper.queryuser(phone).getPassword())){
                flag=1;
                if(this.userMapper.queryuser(phone).getType()==2){
                    //超级会员
                    flag=3;
                }
                }
        }
        return flag;
    }

    @Override
    public void updateuser(User user) {
        this.userMapper.updateuser(user);
    }

    @Override
    public User seeone(Integer userid) {
        return this.userMapper.seeone(userid);
    }

    @Override
    public String findNameByPhone(String phone) {
        return this.userMapper.findNameByPhone(phone);
    }

    @Override
    public Integer findTypeByPhone(String phone) {
        return this.userMapper.findTypeByPhone(phone);
    }
}
