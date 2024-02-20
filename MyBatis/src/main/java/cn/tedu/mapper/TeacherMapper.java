package cn.tedu.mapper;

import cn.tedu.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * MyBatis要求,绑定SQL的方法,都是抽象方法,所以要定义在接口中,所以MyBatis开发,也被称为接口开发
 * 在这里,有一些行业习惯,需要大家遵守:
 * ①一般接口中定义的方法,都是操作一张表的方法
 * ②并且会将多个接口都存放到mapper包下,也可以放在dao包下
 * ③所以接口的命名,一般都是基于表名+Mapper的形式命名 TeacherMapper TeacherDao
 */

/**
 * @Mapper 这是MyBatis提供的注解, 表示当前接口, 需要添加到Spring容器中,
 * MyBatis会自动基于接口,生成实例类,将实例类添加到Spring容器中
 */
@Mapper
// @Repository //标记当前类是数据层
public interface TeacherMapper {
    /**
     * MyBatis是通过接口方法,来和SQL进行绑定的,所以对于接口方法就有很多的要求:
     * ①方法名要求见名知意,可以根据方法名,大致猜测该接口绑定的SQL的语义
     * ②方法的返回值,要基于执行的SQL结果来进行指定,接收SQL执行后,返回的结果的
     * 情况一: 绑定的是增删改的SQL语句,要求返回执行的记录数,返回值就是Integer
     * 情况二: 绑定的是增删改的SQL语句,要求不返回执行的记录数,返回值就是void
     * 情况三: 绑定的是查询的SQL语句,如果返回的是一条结果,返回值就声明具体的实体类型
     * 情况四: 绑定的是查询的SQL语句,如果返回的是多条结果,返回值就声明List,并且指定返回为封装的实体类型
     * ③方法的参数,参数要和SQL语句中需要的参数进行绑定
     * 情况一: 如果SQL语句不需要参数,声明为无参方法即可
     * ...
     */
    /**
     * MyBatis支持注解方式为方法绑定SQL语句:
     * ①如果绑定的是新增SQL语句 @Insert
     * ②如果绑定的是修改SQL语句 @Update → @Update注解,可以执行增删改SQL
     * ③如果绑定的是删除SQL语句 @Delete
     * ④如果绑定的是查询SQL语句 @Select → 查询SQL,必须使用@Select注解,不允许使用别的注解替代!!!!
     */
    @Select("SELECT * FROM teacher")
    public List<Teacher> selectTeacherAll();

    @Insert("INSERT INTO teacher(id, name, age, title, manager, salary, comm, gender, subject_id) VALUES (6666,'光头师傅',22,'宗师',null,100000,50000,'男',0)")
    public Integer insertOne();

    @Update("UPDATE teacher SET name = '一拳超人' WHERE id = 6666")
    public Integer updateOne();

    @Delete("DELETE FROM teacher WHERE id = 6666")
    public Integer deleteOne();
//resultMap
    public Teacher selectOneById(Integer id);

    public Teacher selectOneById2(Integer id);

    public Teacher selectTeacherSubjectById(Integer id);


}
