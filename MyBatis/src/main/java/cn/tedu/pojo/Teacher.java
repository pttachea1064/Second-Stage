package cn.tedu.pojo;

/**
 * 实体类中如果要和表中的字段映射,遵循驼峰规则,
 * 发生了属性名和表字段名不完全一致的情况,
 * subject_id   subjectId
 * 那此时,Mybatis是不会自动映射的,所以需要开启自动映射,
 * 在配置文件中application.yml中,添加如下配置
 * mybatis:
 * configuration:
 * map-underscore-to-camel-case: true
 */
public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private String title;
    private Integer manager;
    private Integer salary;
    private Integer comm;
    private String gender;
    private Integer subjectId;
    /**
     * 表明Teacher实体类中,会包含科目的属性
     */
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", manager=" + manager +
                ", salary=" + salary +
                ", comm=" + comm +
                ", gender='" + gender + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
