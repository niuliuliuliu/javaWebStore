package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.springframework.stereotype.Repository;

//@Repository
/**
 * 用户模块的持久层接口
 */
//@Mapper 不建议，因为要写很多mapper接口
//因为mybatis利用动态代理帮我们生成了接口的实现类
//源码剖析 Mybatis 映射器(Mapper)工作原理https://cloud.tencent.com/developer/article/1430026
public interface UserMapper {
    //直接传入User类，不用写一个个成员变量了
    /*javadoc注释标签语法

    @author  对类的说明 标明开发该类模块的作者

    @version  对类的说明 标明该类模块的版本

    @see    对类、属性、方法的说明 参考转向，也就是相关主题

    @param    对方法的说明 对方法中某参数的说明

    @return  对方法的说明 对方法返回值的说明

    @exception  对方法的说明 对方法可能抛出的异常进行说明
    */
    /**
     *
     * @param user 用户的数据
     * @return 受影响的行数（增删改，都有受影响的行数作为返回值，根据返回值判断是否执行成功）
     */
    int insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 找到对应用户则返回用户数据，没有找到返回null值
     */
    User findByUsername(String username);



}
