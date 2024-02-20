package cn.tedu.smartblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的配置類
 */

@MapperScan("cn.tedu.smartblog.dao")
@Configuration
public class MyBatisConfig {
    static{
        System.out.println("配置類啟動了");
    }
}
