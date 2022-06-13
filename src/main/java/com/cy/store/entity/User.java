package com.cy.store.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
/*通常来说要加@Companent才可以装配到Spring容器中，但是在SpringBoot中,开发简介，遵循约定大于配置
    */

/**
 * 如果字段的名字相同，SpringBoot可以自动完成值的初始化
 */

/**
 * equals方便与比较两个对象是否相同，可以定义自己的比较规则
 */

/**
 * hashCode可以hash地址的输出
 */

/**
 * tostring用来输出查看对象是否有值
 */
@Data
@Component
public class User extends BaseEntity implements Serializable {
    private int uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private int gender;
    private int avatar;
    private int isDelete;

    //1.get和set方法，equals和hashCode（）方法，toString（）方法

}
