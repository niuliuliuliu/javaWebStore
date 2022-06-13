package com.cy.store.service.ex;

import lombok.Data;

/** 作为业务层异常的基类: throw new ServiceException("业务层产生未知异常") */
/*  只想抛出一个异常，则只需重写无参构造函数throw new ServiceException()
    如果提供一个信息，可以使用带一个参数throw new ServiceException("业务层产生未知异常")
    如果要返回异常的对象，就用这个ServiceException(Throwable cause)
    总之要抛出什么就用什么函数
 */
@Data
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
