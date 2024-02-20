package jdbc;

import java.sql.*;

/**
 * 用于测试JDBC查询记录
 */
public class TestSelect {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1定义sql语句
        String sql = "SELECT id, name, age, title, manager, salary, comm, gender, subject_id FROM teacher";
        //2创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //3通过PreparedStatement调用executeQuery()方法执行查询操作
        /**
         * 当执行查询SQL时,数据库服务器会将查询的结果,返回到程序中,
         * 那么JDBC就会以ResultSet对象进行数据的封装,该对象我们称之为结果集对象,
         * 该结果集不能直接输出,如果需要获取其中的数据,需要进行结果集的解析
         */
        ResultSet rs = ps.executeQuery();
        //4.遍历结果集
        /**
         * next() 可以对结果集中的多条数据进行遍历,初始位置,在第一行数据之前,
         * 每调用方法一次,会判断是否有下一行数据,如果有,会自动向下移动一行,直到没有数据为止
         * ResultSet中提供了很多的getXxx(),用于提取当前行指定类型的数据
         * getInt() 获取整数内容 getString() 获取字符串内容 getDouble() 获取浮点数内容
         * 这些getXxx()方法,都需要指定获取的字段,会自动获取指定字段的值
         */
        while (rs.next()) {
            //对每一行的取值操作
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String title = rs.getString("title");
            int manager = rs.getInt("manager");
            double salary = rs.getDouble("salary");
            double comm = rs.getDouble("comm");
            String gender = rs.getString("gender");
            int subject_id = rs.getInt("subject_id");
            System.out.println(id + "\t" + name + "\t" + age + "\t" + title + "\t" + manager + "\t" + salary + "\t" + comm + "\t" + gender + "\t" + subject_id);
        }
        // ResultSetMetaData metaData = rs.getMetaData(); //获取所有表数据
        // int columnCount = metaData.getColumnCount(); //获取表中数据的列数
        // while (rs.next()){
        //     for (int i = 1; i <= columnCount; i++) {
        //         String columnName = metaData.getColumnName(i); //获取表中的列名
        //         String columnTypeName = metaData.getColumnTypeName(i); //获取表中各列的类型
        //         int columnDisplaySize = metaData.getColumnDisplaySize(i);//获取表中各列的默认大小
        //         Object object = rs.getObject(i);
        //         System.out.print(object+" ");
        //     }
        //     System.out.println();
        // }
        //5.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
