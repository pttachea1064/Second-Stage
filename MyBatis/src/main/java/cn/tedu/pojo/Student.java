package cn.tedu.pojo;

/**
 * 如果表中的字段类型是date、datetime等时间类型,
 * 建议属性设置为String类型,方便表示,后期学了SpringMVC框架时,
 * 会有更方便的表达方式
 * 数据库字段类型  →   实体类属性类型
 * tinyint           byte Byte
 * smallint          short Short
 * int               int Integer
 * bigint            long Long
 * varchar           String
 * char              String
 * date              java.util.Date String
 * time              java.util.Date String
 * datetime          java.util.Date String
 * timestamp         java.util.Date String
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String job;
    private String birth;
    private Integer locationId;
    private Integer teamLeader;
    private Integer classId;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Integer teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", birth='" + birth + '\'' +
                ", locationId=" + locationId +
                ", teamLeader=" + teamLeader +
                ", classId=" + classId +
                '}';
    }
}
