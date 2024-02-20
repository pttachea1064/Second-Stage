package cn.tedu.smartblog;

import cn.tedu.smartblog.dao.ArticleDao;
import cn.tedu.smartblog.dao.TagDao;
import cn.tedu.smartblog.dao.UserDao;
import cn.tedu.smartblog.pojo.Article;
import cn.tedu.smartblog.pojo.Tag;
import cn.tedu.smartblog.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SmartBlogApplicationTests {

    /**
     * Mybatis鐘用於執行SQL語句的核心實際例子
     */

    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        Connection conn = sqlSession.getConnection();
        System.out.println(conn);
    }

    /**
     * TagDao此處會拋紅 但不用處理 因為IDEA 工具認為接口沒有寫上任何註解
     * 所以接口部會交給Spring容器管理 但我們已經使用配置的@MapperScan註解
     * 指定了掃描的包
     * 所以是錯誤報錯
     * 如果不想看到該拋紅 則可以去接口上方添加@Repository註解
     */
    @Autowired
    private TagDao tagDao;


    private String dateUtil() {
        //Ctrl+Alt+M 快速抽取代码为方法
        Date date = new Date();//获取系统时间 java.util.Date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式化工具
        return format.format(date);
    }


    @Test
    public void test01() {
        Tag tag = new Tag();
        tag.setName("IDEA");
        tag.setRemark("这是一个非常牛掰的开发工具!!!");
        Date date = new Date();//获取系统时间 java.util.Date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式化工具
        String s = format.format(date);//将Date类型格式化为字符串类型
        System.out.println(s);
        tag.setCreatedTime(s);
        tag.setModifiedTime(s);
        Integer rows = tagDao.insertOne(tag);
        System.out.println("新增" + rows + "条记录成功!");
    }
    @Test
    public void test02 (){
        List<Tag> tags = tagDao.selectList();
        for (Tag tag :
                tags) {
            System.out.println(tag);
        }
    }
    @Test
    public void test03() {
        Tag tag = new Tag();
        tag.setId(16L);
        tag.setName("IDEA使用教程");
        tag.setRemark("简直牛了去了");
        tag.setModifiedTime(dateUtil());
        Integer rows = tagDao.updateOne(tag);
        System.out.println("修改" + rows + "条记录成功!");
    }
    @Test
    public  void test04(){
        Integer rows = tagDao.deleteOne(16);
        System.out.println("刪除" + rows + "條紀錄");
    }

    @Autowired
    private UserDao userDao;
    @Test
    public void test05() {
        User user = new User();
        user.setUsername("老安");
        user.setNickname("小安");
        user.setMobile("13261712222");
        user.setPassword("123456");
        user.setStatus(1);
        user.setCreatedTime(dateUtil());
        user.setModifiedTime(dateUtil());
        Integer rows = userDao.insertOne(user);
        System.out.println("新增" + rows + "条记录成功!");
    }

    /**
     * 情況一 輸入 開始時間 也輸入 終止時間 查詢範圍之間的所有訊息
     * SELECT * FROM t_users WHERE created_time >= ? AND created_time <= ?
     * 情況二 輸入 開始時間 查詢大於開始時間範圍的所有訊息
     * 情況三 輸入 終止時間 查詢小於終止時間範圍的所有訊息
     * 情況四 不輸入 查詢全部訊息
     */
    @Test
    public void test06() {
        String beginTime = null;
//        String beginTime = "2022-08-05";
//        String endTime = "2022-08-11";
        String endTime = null;

        List<User> users = userDao.selectListByTime(beginTime, endTime);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test07(){
        User user = new User();
        user.setId(34);
        user.setUsername("GG俠");
        user.setNickname("LY俠");
        user.setPassword("123321");
        user.setStatus(1);
        user.setCreatedTime(dateUtil());
        user.setModifiedTime(dateUtil());
        user.setMobile("123123123");
        Integer rows = userDao.updateOne(user);
        System.out.println("修改" + rows + "條紀錄");
    }

    @Test
    public void test08() {
        Integer status = 1;
        // Integer[] ids = {1,2,3,4};
        Integer[] ids = null;
        Integer rows = userDao.updateStatusByIds(ids, status);
        System.out.println("修改" + rows + "条记录成功!");
    }

    @Test
    public void test09(){
        User user = new User();
        user.setUsername("徐娜");
        user.setNickname("糖糖");
        List<User> users = userDao.selectListByChoose(user);
        for (User u :
                users) {
            System.out.println(u);
        }
    }

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void test10(){
        Article article = new Article();
        article.setTitle("帅哥是怎么练成的");
        article.setContent("1. 保持良好的卫生习惯：注重个人卫生，勤洗脸、洗头、刷牙等，保持整洁清爽的外貌。2. 健康生活方式：保持均衡的饮食、适量的运动和充足的睡眠，有助于提高肤质、塑造身材和焕发精神。");
        article.setType("1");
        article.setStatus("1");
        article.setUserId(1L);
        Integer rows = articleDao.insertOne(article);
        System.out.println("新增" + rows + "条记录成功!");
    }
}