package cn.tedu.mapper;

import cn.tedu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List<Student> selectStudentAll();

    public Integer insertOne();

    public Integer updateOne();

    public Integer deleteOne();

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
     * 情况二: 如果SQL语句需要一个参数,方法中就需要定义一个参数,类型和SQL需要的参数类型保持一致,参数名任意
     * 情况二: 如果SQL语句需要多个参数,方法中就需要定义能够接受多个参数的载体
     * ①需要什么声明什么形参,并且参数名和占位符的名字最好相同
     * ②需要什么声明什么形参,如果占位符和参数名不同,可以使用@Param("占位符名")来绑定
     * ③如果多个参数都是属于一个实体类的属性时,可以直接以实体类作为形参来传递
     * ④如果多个参数没有在一个实体类中,为了方便,可以将参数以Map的形式封装,但是这种方式了解即可
     * ...
     */
    public Student selectOneById(Integer id);

    public List<Student> selectListByIdAndGender(@Param("id") Integer id, @Param("gender") String location_id);

    public List<Student> selectListByLocationId(Integer lid1, Integer lid2);

    public Integer insertOne2(Student student);

    public Integer updateOne2(Map<String, Object> map);

    public Integer deleteOne2(String name);

    @Select("SELECT * FROM student WHERE class_id = #{classId}")
    public List<Student> selectListByClassId(Integer classId);

}
