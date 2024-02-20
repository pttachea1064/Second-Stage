package cn.tedu.test;

import cn.tedu.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Spring容器中獲取指定的物件
 */
public class TestBean {
    public static void main(String[] args) {
        //指定讀取的配置文件
        /**
         * SpringBoot項目中的resources目錄,是配置文件的目錄
         * 所以很多的框架在定位配置文件十 都會將resources認為是起始目錄
         */
        ClassPathXmlApplicationContext context =//context可以理解為Spring容器
                new ClassPathXmlApplicationContext("application.xml");
        //通過context中提供的getBean方法,可以獲取容器中的物件
        User user01 =(User) context.getBean("user01");
        System.out.println("user01 = "+ user01);
        User user02 = (User) context.getBean("user02");
        System.out.println("user02 = " + user02);
        User user03 = (User) context.getBean("user03");
        System.out.println("user03 = " + user03);
        User user04 = (User) context.getBean("user04");
        System.out.println("user03 = " + user04);
//        User user = new User("李四",18);
//        user.setAge(18);
//        user.setName("張三");

    }
}
