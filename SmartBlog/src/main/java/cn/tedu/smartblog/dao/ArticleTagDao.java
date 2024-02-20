package cn.tedu.smartblog.dao;

import org.springframework.stereotype.Repository;

/**
 * 多表查詢 操作文章與標籤的接口
 */
@Repository
public interface ArticleTagDao {

    /**
     * 新增文章標籤的關聯數據
     * @param articleId 文章id
     * @param tagIds 文章關聯的標籤id組
     * @return
     */
    public Integer insertList(Long articleId , Long[] tagIds);
}
