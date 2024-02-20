package cn.tedu.smartblog;

import cn.tedu.smartblog.dao.ArticleDao;
import cn.tedu.smartblog.dao.ArticleTagDao;
import cn.tedu.smartblog.dao.TagDao;
import cn.tedu.smartblog.dao.UserDao;
import cn.tedu.smartblog.pojo.Article;
import cn.tedu.smartblog.pojo.Tag;
import cn.tedu.smartblog.pojo.User;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ArticleApplicationTests {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void test1() {
        Article article = new Article();
        article.setTitle("帅哥是怎么练成的");
        article.setContent("1. 保持良好的卫生习惯：注重个人卫生，勤洗脸、洗头、刷牙等，保持整洁清爽的外貌。2. 健康生活方式：保持均衡的饮食、适量的运动和充足的睡眠，有助于提高肤质、塑造身材和焕发精神。");
        article.setType("1");
        article.setStatus("1");
        article.setUserId(1L);
        Integer rows = articleDao.insertOne(article);
        System.out.println("新增" + rows + "条记录成功!");
    }

    @Autowired
    private ArticleTagDao articleTagDao;

    @Test
    public void test2() {
        Article article = new Article();
        article.setTitle("测试文章01");
        article.setContent("测试内容01");
        article.setType("1");
        article.setStatus("1");
        article.setUserId(1L);
        System.out.println("新增文章之前的文章id:" + article.getId());
        Integer rows = articleDao.insertOne(article);
        System.out.println("新增文章之后的文章id:" + article.getId());
        System.out.println(rows > 0 ? "新增文章成功!" : "新增文章失败!");
        Long articleId = article.getId();
        Long[] tagIds = {1L, 2L, 3L, 4L};
        rows = articleTagDao.insertList(articleId, tagIds);
        System.out.println(rows > 0 ? "新增文章标签关系成功!" : "新增文章标签关系失败!");
    }

    @Test
    public void test3() {
        Article article = articleDao.selectOneById(1L);
        System.out.println("文章信息:" + article);
        User user = article.getUser();
        System.out.println("作者信息:" + user);
        List<Tag> tags = article.getTags();
        for (Tag tag : tags) {
            System.out.println("标签信息:" + tag);
        }
    }

    @Test
    public void test4() {
        List<Article> articles = articleDao.selectList();
        for (Article article : articles) {
            System.out.println("文章信息:" + article);
            User user = article.getUser();
            System.out.println("作者信息:" + user);
            List<Tag> tags = article.getTags();
            for (Tag tag : tags) {
                System.out.println("标签信息:" + tag);
            }
            System.out.println("==============================================================");
        }
    }
    @Autowired
    private UserDao userDao;

    @Test
    public void test5 (){
        List<User> list = userDao.selectByPage(0,5);
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void test6(){
        /**
         * PageHelper中提供了一個靜態方法startPage,有兩個參數
         * 1.pageNum 查詢第幾頁
         * 2.pagesize 這一頁要顯示幾條紀錄
         */
        PageHelper.startPage(2,5);
        /**
         * 当执行接口方法时,PageHelper插件会自动根据指定的参数,计算出LIMIT后面的值,
         * 然后自动在接口绑定的SQL语句后面,添加LIMIT关键字
         */
        List<User> users = userDao.selectByPage02();
        for (User user
                :users) {
            System.out.println(user);

        }
    }
}