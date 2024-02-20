package cn.tedu.smartblog.dao;

import cn.tedu.smartblog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    /**
     * 新增一篇文章
     * @param article 新增的文章訊息
     * @return 新增的紀錄數量
     */


    public Integer insertOne(Article article);

    /**
     * 基於id查詢文章訊息
     *
     * @param id 文章id
     * @return 文章訊息(包含作者訊息與標籤訊息)
     */
    public Article selectOneById(Long id);

    /**
     * 查詢所有的文章訊息
     * @return 文章訊息(包含作者訊息與標籤訊息)
     */
    public List<Article> selectList();


}
