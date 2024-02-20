package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于测试JDBC添加记录
 */
public class TestInsert {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.获取PreparedStatement的实例
        //1.1定义sql语句
        String sql = "INSERT INTO teacher(id, name, age, title, manager, salary, comm, gender, subject_id)\n" +
                "VALUES (null,'老安',18,'直播讲师',1,1000,100,'男',1)";
        //1.2创建PreparedStatement实例,并接受sql语句作为参数
        /**
         * prepareStatement方法 可以绑定SQL语句,并且建立程序和数据库服务器的连接通道,
         * 该方法会返回一个PreparedStatement对象,也被称为输出器对象
         * 将SQL语句和参数传给服务器
         * 也可以接收服务器传回的结果数据
         */
        ps = conn.prepareStatement(sql);
        //1.3通过PreparedStatement调用executeUpdate()方法执行新增操作
        /**
         * executeUpdate方法 可以执行增删改的SQL,执行后,会返回一个整数,表示影响的行数
         * executeQuery方法 可以执行查询的SQL,执行后,会返回一个结果集对象
         */
        int rows = ps.executeUpdate();
        /**
         * 判断rows>0吗?
         * 如果成立,执行"成功修改了" + rows + "条记录"
         * 如果不成立,执行"修改失败!"
         */
        System.out.println(rows > 0 ? "成功修改了" + rows + "条记录" : "修改失败!");
        //2.释放资源
        ps.close();
        conn.close();
    }
}
