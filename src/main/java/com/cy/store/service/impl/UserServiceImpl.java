package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDepulitedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/** 用户模块业务层的实现类
 *
 */
@Service//@service 将当前类的对象交给spring管理，自动创建对象和对象的维护
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void reg(User user) {
        //通过user参数来获取传递过来的username
        String username = user.getUsername();
        //调用findByUsername判断用户是否被注册
        User result = userMapper.findByUsername(username);
        //判断结构及是否部位null则抛出用户名被占用的异常
        if(result!=null){
            //抛出异常
            throw new UsernameDepulitedException("用户名被占用实现于UserServiceImpl");
        }

        // 密码加密处理的实现：md5算法的形式：.。。。
        // （串+password+串）----md5算法进行加密，来纳许加载三次
        // 盐值+password+盐值----盐值就是随机字符串，
        String oldPassword = user.getPassword();
        // 获取盐值（随机生成一个盐值）
        String salt =  UUID.randomUUID().toString().toUpperCase();
        // 将密码和盐值作为整体进行加密处理
        String newPassword = getMd5Password(oldPassword,salt);
        // 补全密码
        user.setPassword(newPassword);
        // 记录盐值
        user.setSalt(salt);
        //另外补全数据is_delete
        user.setIsDelete(0);
        //补全日志
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setModifiedTime(date);
        user.setCreatedTime(date);
        //注册业务功能实现
        int rows = userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("用户注册中产生未知异常");
        }
    }

    //定义一个md5加密算法
    private String getMd5Password(String password, String salt){
        // md5加密算法方法的调用加密三次
        for(int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        // 返回加密后的密码
        return password;

    }
}
