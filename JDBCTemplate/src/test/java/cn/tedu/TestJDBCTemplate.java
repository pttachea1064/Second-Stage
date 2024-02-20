package cn.tedu;

import cn.tedu.pojo.Banji;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestJDBCTemplate {
    //注入JDBCTemplate工具实例
/**
 * 只要導入JDBCTemplate的依賴(spring-boot-start-jdbc)
 * 再項目啟動後 就會自動根據配置文件 創建一個JDBCTemplate之實例物件在Spring容器中
 * 由於當前依賴中已經導入了連接池子的依賴
 * 所以會自動從連接池子中獲取連接 使用後 會自動將連接歸還於連接池子
 */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * JDBCTemplate入门案例
     */
    @Test
    public void test01() {
        //1.定义SQL
        String sql = "INSERT INTO class VALUES(null,'JSDVN2306班',99,1)";

        //2.调用update执行SQL
        /**
         * JDBCTemplate中提供了一個 update方法
         * 該方法適用於執行增加刪除修改的SQL語法
         * 並且該方法返回一個整數,紀錄修改的紀錄數據
         * 節省了創建輸出器PrepareStatement的步驟
         */
        int rows = jdbcTemplate.update(sql);
        System.out.println(rows>0? "修改了"+rows+"紀錄" :"修改失敗");
        //也節省了釋放source的步驟
    }

    @Test
    public void testQueryForList() {
        //1.定义SQL
        String sql =" SELECT * FROM class WHERE id >?";
        //2.调用queryForList执行SQL
        /**
         * JdbcTemplate中的queryForList方法,可以执行查询SQL,并且会将查询的结果
         * 每一条结果封装到map中,并把map封装到list中,以此将list返回
         */
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, 10);
        //3.遍历记过,输出所有记录
        for (Map<String, Object> map : list) {
            System.out.println(map);

        }
    }

    @Test
    public void testQuery() {
        //1.定义SQL
        /**
         * JdbcTemplate 提供了 query方法 該方法可以接收一部分參數
         * 執行SQL的語法
         * 指定查詢的結果要封裝的實體類型(借助BeanPropertyRowMapper實際案例來指定實體案例類型)
         * 如果SQL語法中需要參數 可以傳遞
         */
        String sql = " SELECT * FROM class WHERE id >= ?";
        List<Banji> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Banji.class),10);
        for (Banji banji :query){
            System.out.println(banji);
        }
        //2.调用queryForMap执行SQL

        //3.输出结果
    }

    @Test
    public void testQueryForMap() {
        //1.定义SQL
        String sql ="SELECT * FROM class WHERE name =?";
        //2.执行SQL语句,指定将结果集封装到对应的实体类中,并且传入对应的参数
        /**
         * JdbcTemplate中提供的queryForMap方法 執行查詢的SQL
         * 並且這條SQL能查詢出一條結果 會將這條結果封裝到MAP中
         * 會以字段名稱為key 值為value存儲
         *
         * 如果SQL與劇中包含?站為符號,表示需要我們自己給SQL語法傳入參數 那麼可以借助queryForMap方法進行傳入參數
         * 第二個參數對應第一個? 第三個參數對應第二個?...以此類推
         */
        Map<String, Object> map = jdbcTemplate.queryForMap(sql,"JSDVN2306班");
        //3.遍历记过,输出所有记录
        System.out.println(map);
    }

    @Test
    public void testQueryForObject() {
        //1.定义SQL
        String sql = "SELECT COUNT(*) FROM class";
        //2.执行SQL语句,指定将结果集封装到对应的实体类中,并且传入对应的参数
        /**
         * 這個方法適用於聚合函數的方法 主要包含下列參數
         * 執行SQL語法
         * SQL執行時候要封裝的結果類型 主要該方法是用於聚合函數
         */
        Integer rows = jdbcTemplate.queryForObject(sql, Integer.class);
        //3.输出查询总记录数
        System.out.println(rows);
    }

    @Test
    public void testAdd() {
        //1.定义SQL
        String sql = "INSERT INTO class ( name,floor,teacher_id ) VALUES(?,?,?)";

        //2.将参数以数组的形式封装
        /**
         * 如果SQL中需要的參數過多時候 可以選擇將多個參數封裝到陣列中
         * 然後將陣列作為參數 傳入到方法中 可以達到更好的閱讀體驗
         */
        Object[] arg = {"帥哥班級",1,2};
        int rows = jdbcTemplate.update(sql, "帥哥班級", 1, 2);
        System.out.println(rows);

    }

    @Test
    void testUpdate() {

        String sql = " UPDATE class SET name = ?,floor = ? , teacher_id = ? WHERE id = ? ";
        Object[] args = {"高薪班級",21,11,21};
        int rows = jdbcTemplate.update(sql, args);
        System.out.println(rows>0? "成功":"失敗");


        //1.定义SQL
//        String sql = "UPDATE class SET name = ?, floor=?, teacher_id =? WHERE id = ? ";
//        //2.将参数封装为数组
//        Object[] args = {21, "高薪就业班", 11, 99};
//        int rows = jdbcTemplate.update(sql, args);
//        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }
}
