package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@SpringBootTest:表示标注当前类是测试类，不会随同项目一块打包发送
@SpringBootTest
//@RunWith:表示启动这个单元测试类（单元测试类不能运行），需要传递参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    //为什么userMapper报错，因为idea有检测功能，检测到接口不能直接创建Bean的，
    //但是为什么能运行接口，因为Mybatis帮我们创建了接口的动态代理，完成对象的创建
    //解决方法：可以在UserMapper接口加一个@Repository，or，在Settings中Inspections有一个Springcore下的Springcode中把第二个Bean的error选项改为warning
    @Autowired
    private UserServiceImpl userServiceImpl;
    //单元测试类中必须是单元测试方法
    /**
     * 单元测试方法必须：可以单独运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须背@Test注解修饰
     * 2.返回值必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuanxin02");
            user.setPassword("123");
            userServiceImpl.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取类的对现象，在获取异常名称
            System.out.println(e.getClass());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());

        }
    }

}
