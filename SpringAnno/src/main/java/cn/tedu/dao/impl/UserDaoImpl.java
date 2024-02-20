package cn.tedu.dao.impl;


import cn.tedu.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 注釋:給程序員添加的描述訊息,不會隨著程序而執行被執行
 * 註解: 虛擬機的注釋,不是給程序原看得,而是給虛擬機看的
 * ---------------------------------------------
 * 添加 @Component 標記的類 會自動添加到Spring容器中
 * <bean class = "cn.tedu.dao.impl.UserDaoImpl"/>
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save运行了~");
    }
}