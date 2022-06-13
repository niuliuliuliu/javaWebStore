package com.cy.store.util;

import lombok.Data;

import java.io.Serializable;

/**
 * Json格式的数据进行相应。
 */
@Data
public class JsonResult<E> implements Serializable {
    /** 状态码*/
    private int state;

    /** 描述信息*/
    private String message;

    /** 数据*/
    private E data;

    /**
     * 构造方法，方便之后再不同场景为这三个属性设置不同的值
     */
    public JsonResult() {
    }

    public JsonResult(int state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(int state, E data) {
        this.state = state;
        this.data = data;
    }


}
