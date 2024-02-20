package cn.tedu;

import cn.tedu.mapper.SubjectMapper;
import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Subject;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResultMapTests {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    void test01() {
        Teacher teacher = teacherMapper.selectOneById(1);
        System.out.println(teacher);
    }

    @Test
    void test02() {
        Teacher teacher = teacherMapper.selectOneById2(1);
        System.out.println(teacher);
    }

    @Test
    void test03() {
        Teacher teacher = teacherMapper.selectTeacherSubjectById(1);
        System.out.println("老师信息:" + teacher);
        System.out.println("科目信息:" + teacher.getSubject());
    }
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    void test04() {
        Subject subject = subjectMapper.selectSubjectTeacherByName("数学");
        System.out.println("科目信息: " + subject);
        List<Teacher> teacherList = subject.getTeacherList();
        for (Teacher teacher : teacherList) {
            System.out.println(subject.getName() + "科目的授课老师信息: " + teacher);
        }
    }
}
