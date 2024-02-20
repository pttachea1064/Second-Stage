package cn.tedu.service.impl;

import cn.tedu.dao.UserDao;
import cn.tedu.dao.impl.UserDaoImpl;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /**
     * UserDaoImpl已經交給Spring容器來管理 所以獲取實例對象餔需要userDao = new UserDaoImpl();
     * 現在想要獲取容器中的對象 只要
     * 1.聲明想要獲取的對象
     * 2.在變量上,添加Autowrie註解 該註解可以識別對象的類型 然後自動從容器中獲取同類型的實際案例
     *
     */
    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }
}
