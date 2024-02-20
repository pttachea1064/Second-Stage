package cn.tedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 被@Configuration注解标记的类,是配置类
 */
@Configuration
public class MyConfig {
    static {
        System.out.println("配置类MyConfig被加载了");
    }

    /**
     * 被@Bean注解修饰的方法,会被自动执行,在该方法中,如果有对象希望交给Spring容器管理
     * 则直接将该对象作为返回值返回即可,返回值会被@Bean注解扫描,并且交给到Spring容器中
     * 该对象在容器中的id就是方法名
     */
    @Bean
    public Connection getConnection() throws Exception {
        System.out.println("配置类@Bean给容器中添加组件了...");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}

