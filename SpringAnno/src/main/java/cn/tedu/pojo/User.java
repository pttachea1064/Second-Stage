package cn.tedu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 如果类中的属性和配置文件中的key同名的情况,我们可以设置前缀,进行自动注入
 * ①在类上添加@ConfigurationProperties注解
 * ②在@ConfigurationProperties中声明自动配置的key的前缀
 * ③该前缀下一层级的所有key如果和属性同名,则会自动注入
 *
 * 配置文件中的前缀不能是user,因为user在底层是默认值
 */
@ConfigurationProperties(prefix = "person")
@Component
public class User {
    /**
     * @Value註解: 可以給標記的屬性賦值
     */
    @Value("馬小桃")
    public String name;
    @Value("21")
    public Integer age;

    /**
     * @Value註解:
     * 通過值與屬性拆分
     * 將配置文件中的數值,賦予到屬性上(而這個功能才是該註解的真實作用)
     * 會自動讀取resources下的application.properties配置文件
     * 使用${},指定配置文件中的key值 可以將對應的Value值注入其中
     */
//    @Value("${user.address}")
    public String address;
//    @Value("${user.tel}")
    public String tel;
//    @Value("${user.idCard}")
    public String idCard;
    public boolean wife;
    public Date birth;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isWife() {
        return wife;
    }

    public void setWife(boolean wife) {
        this.wife = wife;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", wife=" + wife +
                ", birth=" + birth +
                '}';
    }
}
