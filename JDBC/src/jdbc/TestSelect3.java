package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于测试JDBC通过PreparedStatement解决SQL注入问题
 */
public class TestSelect3 {
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
        /**
         * PreparedStatement 傳輸器物件本身就可以防止SQL注入問題的發生
         * 基於SQL 股價來固定SQL語意
         * 在定義SQL的語句中 將參數替換成為"?" 後期再傳參數到"?"來解決問題
         * ?替代的參數 不考慮參數的位置與類型
         */
        String sql = "SELECT * FROM location WHERE id = ? AND name = ?";
        //2.创建PreparedStatement实例,并接受sql语句作为参数
        /**
         * 將SQL骨架綁定在傳輸器上,這樣就固定了SQL語法意思,不會被SQL注入改變現有的語法
         */
        ps = conn.prepareStatement(sql);
        //3.为SQL骨架传入参数
        /**
         * 給SQL骨架傳入參數,使用的都是傳輸器中定義的setXXX()方法,參數目標是甚麼類性 就調用甚麼的set方法
         * 給方給需要傳入兩個參數: 1. 給第幾個參數傳送參數(起始值是1)
         * 通過給該方法站為符號傳輸參數時候,會自動給參數添加對應的引號,不需要我們額外考慮
         */

        ps.setInt(1,1);// 第一個佔位符號之數值為1
        ps.setString(2,"北京");//第二個佔位的值為北京
        //4.通过PreparedStatement调用executeQuery()方法执行查询操作
        rs = ps.executeQuery();
        //5.遍历结果集
        System.out.println(rs.next() == true ? "记录存在!" : "记录不存在!");
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
