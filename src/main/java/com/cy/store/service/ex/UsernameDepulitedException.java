package com.cy.store.service.ex;

/**
 * 用户名被占用
 */
public class UsernameDepulitedException extends ServiceException{
    //alt+insert ----override methods..

    public UsernameDepulitedException() {
        super();
    }

    public UsernameDepulitedException(String message) {
        super(message);
    }

    public UsernameDepulitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDepulitedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDepulitedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
