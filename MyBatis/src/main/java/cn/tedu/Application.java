package cn.tedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyBatis接口开发,要求每个接口上,都添加@Mapper注解,不添加会报错
 * 所以为了简化这部分,可以在主启动类或者配置类上,添加@MapperScan,
 * 该注解,可以指定接口所在的包路径,当项目启动后,会自动扫描这些接口,
 * 创建子类实例,添加到Spring容器中,以此来解放双手
 */
@MapperScan("cn.tedu.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
