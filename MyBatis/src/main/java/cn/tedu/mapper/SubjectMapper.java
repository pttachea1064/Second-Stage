package cn.tedu.mapper;

import cn.tedu.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

//指定这是一个操作数据库的mapper
@Mapper
public interface SubjectMapper {
    /**
     * Subject 包含科目的訊息 與多條科目的老師訊息
     */
    public Subject selectSubjectTeacherByName(String name);
}
