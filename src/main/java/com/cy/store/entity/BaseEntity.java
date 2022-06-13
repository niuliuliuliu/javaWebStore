package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 作为实体类的基类
 */

/**
 * 只要java底层需要和数据库进行交互，则必须要序列化
 */
@Data
public class BaseEntity implements Serializable {
    private String createdUser ;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
