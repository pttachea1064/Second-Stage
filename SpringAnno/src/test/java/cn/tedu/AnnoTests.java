package cn.tedu;

import cn.tedu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
public class AnnoTests {
    @Autowired
    private User user;

    @Test
    void test01 (){
        System.out.println(user.name);
        System.out.println(user.age);
    }

    @Test
    //由於properties默認的層級高於yml和yaml所以 要使用這兩個配置文件
    //要率先將properties文件檔案名稱改掉 讓它變成非properties
    void    test02 (){
        System.out.println(user.address);
        System.out.println(user.tel);
        System.out.println(user.idCard);
    }
    @Test
    void test03() {
        System.out.println(user);
    }

    @Autowired
    private ApplicationContext context;

    @Test
    void test04() throws SQLException {
        Connection connection = (Connection) context.getBean("getConnection");
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM location");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + "\t" + name);
        }
    }
}
