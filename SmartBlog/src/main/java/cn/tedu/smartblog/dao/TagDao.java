package cn.tedu.smartblog.dao;

import cn.tedu.smartblog.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao.TageDao =mapper.TagMapper = dao.TagMapper
 */
@Repository
public interface TagDao {
    /**
     * 向tb_中的tags添加表中新增一條紀錄
     *
     * @param tag 封裝了新增的標籤訊息
     * @return 新增的紀錄數量
     */
    @Insert("INSERT INTO tb_tags(name,remark,created_time,modified_time) " +
            "VALUES (#{name},#{remark},#{createdTime},#{modifiedTime})")
    public Integer insertOne(Tag tag);

    /**
     * 查詢tb_tags表中的所有紀錄
     * @return 以集合的形式 查詢所有的紀錄
     */
    @Select("SELECT * FROM tb_tags")
    public List<Tag> selectList();

    /**
     * 根據id 修改tb_tags表中的紀錄
     * @param tag
     * @return 修改的紀錄
     */

    @Update("UPDATE tb_tags SET name =#{name},remark=#{remark},modified_time=#{modifiedTime} WHERE id =#{id}")
    public Integer updateOne(Tag tag);

    /**
     * 根據id刪除tb_tags表中的紀錄
     * @param id 刪除的紀錄之id
     * @return 刪除紀錄數量
     */
    @Delete("DELETE FROM tb_tags WHERE id = #{id}")
    public Integer deleteOne(Integer id);
}
