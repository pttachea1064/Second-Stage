package cn.tedu;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestJDBC {
    /**
     * DataSource是基於所有JDBC使用的工具之數據源頭的超類
     * 可以通過該對象獲取容器中的連接持,間接獲取池中的連接
     */
    @Autowired
    private DataSource dataSource;
//    private HikariDataSource dataSource;

    @Test
    public void testAdd() throws Exception {
        //1.获取连接
        /**
         * 數據根源中提供的getConnection()
         * 從數據根源(連接池子)中獲取一個連接
         */
        Connection conn = dataSource.getConnection();
        //2.创建PreparedStatement对象(基于该对象发送sql)
        String sql = "INSERT INTO location VALUES(null,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.为sql骨架插入具体的参数值
        ps.setString(1,"河北");
        //4.发送sql
        int rows = ps.executeUpdate();
        //5.处理结果(一般都是查询操作处理结果)
        System.out.println(rows>0? "成功新增":"新增失敗");

        //6.释放资源
        ps.close();
        conn.close();
        /**
         * close()在JDBC時候 殺死連接器對象
         * 而在連接池子中close方法的作用是將連接歸還於連接池子中
         */
    }

    @Test
    public void testQuery() throws Exception {
        //1.获取连接
        Connection connection = dataSource.getConnection();
        //2.创建Statement(基于此对象发送sql)
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM class WHERE name = ?");
        ps.setString(1,"2年級2班");
        //3.发送sql
        ResultSet rs = ps.executeQuery();
        //4.处理结果
        List list = new ArrayList();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", rs.getString("id"));
            map.put("name", rs.getString("name"));
            map.put("floor", rs.getDouble("floor"));
            map.put("teacher_id", rs.getInt("teacher_id"));
            list.add(map);
        }
        System.out.println(list);
        //5.释放资源
        rs.close();
        ps.close();
        connection.close();
    }
}
