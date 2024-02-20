package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于测试JDBC获取数据库链接是否通畅的案例
 */
public class TestConnection {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        /**
         * 代碼(驅動)數據庫
         * 而Driver類就是驅動類,而Driver類中的DriverManager.registerDriver(new Driver());才是真正的創見驅動代碼
         * Class.forName(類的全路徑) 獲取該類的字節碼文件 獲取該類的字節碼文件-->家仔該類型-->靜態資源就會被自動加載
         * Class.forName("com.mysql.jdbc.Driver")
         */
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取和数据库的连接
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding" +
                "=utf8&serverTimezone=Asia/Shanghai";
        //2.1指定URL,确定要连接哪个数据库
        /**
         * JDBC URL組成分析:
         *  URL 是通過冒號分隔 , ?部分開始是附加訊息內容,然後再用&做更多的附加內容連接
         * 1.jdbc 協議,通過JDBC連接數據庫
         * 2.mysql 子協議,表示要連接的數據庫類型是MYSQL
         * 3. //localhost:3306/tedu 子名稱,表示連接的數據庫地址訊息
         *   a. localhost IP地址/區域名稱 ,表示服務器所在的網路地址
         *      因為我們現在是連接"本機"所以IP就是直接使用localhost
         *   b. 3306 端口號,MYSQL的默認端口號是3306,但是後期是會改變的
         *   c. tedu 數據庫名稱,表示我們要連接的服務器的數據庫
         * 4. useUnicode=true 表示在傳輸數據時,使用Unicode字符集
         * 5. characterEncoding=utf8 表示傳輸過程中,使用UTF-8編碼來解析
         * 6. serverTimezone=Asia/Shanghai 表示設置時區
         * -------------------------------------------------------------------------
         * 如果要連接的是本機的數據庫服務器,並且端口號是3306,則可以省略IP和端口號的內容
         * "jdbc:mysql:///tedu?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
         */

        //2.2指定使用的用户名
        String username = "root";
        //2.3指定使用的密码 --- 當時自己設置的密碼
        String password = "root";
        //2.4调用 DriverManager 类的 getConnection() 方法建立到数据库的连接
        /**
         * DriverManger 類 是驅動管理類
         * getConnection方法 根據提供的URL、用戶名稱、密碼、連接數據庫
         * 如果連接失敗,會提供相關的錯誤
         * ex. Unknown database 不是服務器中存有的數據庫,更正數據庫名稱
         *     Access denied for user 'root'@'.... 用戶名稱沒有問題 但是密碼有問題要改正密碼
         * 如果連接成功,回返回一個Connection對象(物件),該物件稱為  連接器物件
         */
        Connection conn = DriverManager.getConnection(url,username,password);

        System.out.println("加載成功");
    }
}
