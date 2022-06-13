package com.cy.store.controller;

import com.cy.store.entity.BaseEntity;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDepulitedException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController//等于@ResponseBody+@Controller
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userservice;

    @RequestMapping("reg")
    //@ResponseBody//表示此方法响应结果以json格式
    public JsonResult<Void> reg(User user) {
        //创建响应结果对象
        JsonResult<Void> result = new JsonResult<Void>(OK);
        userservice.reg(user);
        result.setMessage("成功注册");
        return result;
    }
    /*
    @RequestMapping("reg")
    //@ResponseBody//表示此方法响应结果以json格式
    public JsonResult<Void> reg(User user) {
        //创建响应结果对象
        JsonResult<Void> result = new JsonResult<>();
        try {
            userservice.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDepulitedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");

        } catch (InsertException e){
            result.setState(5000);
            result.setMessage("插入过程失败");
        }
        return result;
    }
    */


}
