package com.cy.store.service;

import com.cy.store.entity.User;

/** 用户模块业务接口
 * 完成注册功能
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);//用来完成注册功能
}
