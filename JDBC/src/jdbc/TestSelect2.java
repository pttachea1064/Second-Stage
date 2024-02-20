package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 用于测试JDBC的SQL注入问题
 */
public class TestSelect2 {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.定义sql语句
        System.out.println("请输入要查询的id和name");
        Scanner scanner = new Scanner(System.in);
        /**
         * 当我们输入id为任意值,name为' OR '1'='1值时,会查询出所有的记录,为什么?
         * 本质上,我们的SQL语句语义是根据id和name,查询符合条件的信息
         * 生成的SQL: SELECT * FROM location WHERE id = 2 AND name = '' OR '1'='1'
         * 该SQL发生了语义的变化,由于OR连接,由于右侧的'1'='1'永远成立所以左侧的条件不需要判断了,所以会查询出所有的记录
         * 这种情况,源头就是因为我们的SQL语句是通过字符串拼接而来的,由于外部传入的字符串可能会影响整个SQL字符串的语义,
         * 这种情况就被称为SQL注入,应该被严令禁止
         */
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        String sql = "SELECT * FROM location WHERE id = " + id + " AND name = '" + name + "'";
        // sql.sout → System.out.println(sql);
        // sql.soutv → System.out.println("sql = " + sql);
        System.out.println("sql = " + sql);
        //2.创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //3.通过PreparedStatement调用executeQuery()方法执行查询操作
        rs = ps.executeQuery();
        //4.判断结果
        System.out.println(rs.next() == true ? "记录存在!" : "记录不存在!");
        //5.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
