package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDepulitedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制层类的基类
public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;

    //请求处理方法，这个方法的返回值就是需要传递给前端的数据
    //被ExceptionHandler修饰的方法，会自动将异常对象传递给此方法的参数列表, 所以用Throwable e接受抛出的异常对象
    //当前项目中产生了异常，被统一拦截到此方法中，这个方法此时充当是请求处理方法，方法的返回值直接传回前端
    @ExceptionHandler(ServiceException.class)//统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e) ;
        if(e instanceof UsernameDepulitedException){
            result.setState(4000);
            result.setMessage("用户名被占用实现于BaseController");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时未知异常");
        }
        return result;

    }
}
