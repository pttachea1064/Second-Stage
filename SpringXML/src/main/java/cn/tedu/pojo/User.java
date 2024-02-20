package cn.tedu.pojo;

/**
 * 用于交给Spring容器管理
 */
public class User {
    private String name = "朱逸群";
    private int age = 25;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("開始注入:"+name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("開始注入:"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "我叫 " + name + ",今年 " + age + " 岁!";
    }
}
