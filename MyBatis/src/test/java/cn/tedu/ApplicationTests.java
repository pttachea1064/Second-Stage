package cn.tedu;

import cn.tedu.mapper.StudentMapper;
import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Student;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {
    /**
     * 在Mybatis框架的加持下,我们只需要调用接口,即可执行接口绑定的方法,
     * 并且SpringBoot项目,已经支持MyBatis和Spring互相合作!
     * 所以可以直接注入接口,通过接口实例,调用方法即可
     */
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    void test1() {
        List<Teacher> teachers = teacherMapper.selectTeacherAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Test
    void test2() {
        Integer rows = teacherMapper.insertOne();
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
    }

    @Test
    void test3() {
        Integer rows = teacherMapper.updateOne();
        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }

    @Test
    void test4() {
        Integer rows = teacherMapper.deleteOne();
        System.out.println(rows > 0 ? "删除成功!" : "删除失败!");
    }

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void test5() {
        List<Student> students = studentMapper.selectStudentAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void test6() {
        Integer rows = studentMapper.insertOne();
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
    }

    @Test
    void test7() {
        Integer rows = studentMapper.updateOne();
        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }

    @Test
    void test8() {
        Integer rows = studentMapper.deleteOne();
        System.out.println(rows > 0 ? "删除成功!" : "删除失败!");
    }

    @Test
    void test9() {
        Student student = studentMapper.selectOneById(1);
        System.out.println(student);
    }

    @Test
    void test10() {
        List<Student> students = studentMapper.selectListByIdAndGender(1000, "男");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void test11() {
        List<Student> students = studentMapper.selectListByLocationId(1, 3);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void test12() {
        Student student = new Student();
        student.setName("孙悟空");
        student.setAge(3000);
        student.setGender("男");
        student.setJob("取经大师兄");
        student.setBirth("1013-1-1");
        student.setLocationId(1);
        student.setTeamLeader(1);
        student.setClassId(1);
        Integer rows = studentMapper.insertOne2(student);
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
    }

    @Test
    void test18() {
            Integer rows = studentMapper.deleteOne2("孙悟空");
            System.out.println(rows > 0 ? "删除成功!" : "删除失败!");
        }


    @Test
    void test13() {
        Map<String, Object> map = new HashMap<>();
        //map中的key要和绑定占位符的名字一致
        map.put("job", "斗战圣佛");
        map.put("name", "孙悟空");
        map.put("age", 10000);
        Integer rows = studentMapper.updateOne2(map);
        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }

    @Test
    void test14() {
        List<Student> students = studentMapper.selectListByClassId(1);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
