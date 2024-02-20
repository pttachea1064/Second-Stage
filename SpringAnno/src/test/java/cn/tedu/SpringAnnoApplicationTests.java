package cn.tedu;

import cn.tedu.controller.UserController;
import cn.tedu.dao.UserDao;
import cn.tedu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @SpringBootTest: 當前類是測試類 測試有一個 特點
 * 單測試類型的方法運轉時候 會自動加載SpringBoot中的容器內容
 * 這也就導致了 我們運行的測試類型中的方法不需要啟動主啟動類型
 * 也可以創立Spring容器對象
 *
 */
@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserDao userDao;

    /**
     * @Test注解: 标记的方法为测试方法, 可以脱离main方法单独运行
     * 测试方法一般情况下都是来测试部分代码是否正常执行的常用手段
     * 定义测试方法的要求: 无参无返回值的公开方法
     * 测试方法在SpringBoot项目中一般只在测试类中使用
     */
    @Test
    void contextLoads() {
        userDao.save();
    }

    @Test
    void a() {
        System.out.println("a方法运行了");
    }
    @Autowired
    private UserService userService;
    @Test
    public void b(){
        userService.save();
    }

    @Autowired
    private UserController userController;
    @Test
    public void c(){
        userController.save();
    }
}

