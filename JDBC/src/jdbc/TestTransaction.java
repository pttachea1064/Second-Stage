package jdbc;

import java.sql.*;

/**
 * 用于测试JDBC的事务处理
 */
public class TestTransaction {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.开启手动提交事务(默认是自动提交事务)
        /**
         * 類似於MYSQL中的BEGIN命令
         */
        conn.setAutoCommit(false);

        //2.定义多条SQL语句
        String sql1 = "UPDATE location SET name = '青岛' WHERE id = 6";
        String sql2 = "UPDATE location SET name = '大冶' WHERE id = 4";

        /**
         * Ctrl+Alt+T 快捷選擇包裹類型
         */
        try {
            //3.执行SQL,如果SQL语句定义有误,执行时,会抛出SQLException
            ps = conn.prepareStatement(sql1);
            ps.executeUpdate();
            System.out.println("第一條數據修改成功");
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            System.out.println("第一條數據修改成功");
            //4.提交事务
            /**
             * 相當於MYSQL中的COMMIT
             */
            conn.commit();
        } catch (SQLException throwables) {
            //5.回滚事务
            System.out.println("運行時發生異常");
            /**
             * 相當於MYSQL 中的ROLLBACK
             */
            conn.rollback();

        }
        
        //6.释放资源
        ps.close();
        conn.close();
    }
}
