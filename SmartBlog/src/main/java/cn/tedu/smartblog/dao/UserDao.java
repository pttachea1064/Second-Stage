package cn.tedu.smartblog.dao;

import cn.tedu.smartblog.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 向tb_users表中新增一條紀錄
     * @param user 用戶訊息
     * @return 新增的紀錄數量
     */
    public Integer insertOne (User user);

    /**
     * 根據指定的時間範圍 查詢對應的用戶訊息
     * @param beginTime 開始時間/創建時間
     * @param endTime 結束時間/註銷時間
     * @return
     */
    public List<User> selectListByTime(String beginTime, String endTime);

    /**
     *  根據id修改指定的用戶訊息
     * @param user 包含被修改的用戶id與訊息和修改的具體訊息
     * @return 修改的紀錄數量
     */
    public Integer updateOne (User user);

    /**
     * 批量修改用戶的狀態數值
     * @param ids 多個被修改的用戶之id
     * @param status  修改的狀態數值
     * @return 修改的紀錄數量
     */
    public Integer updateStatusByIds(Integer[] ids ,Integer status);

    /**
     * 根據查詢條件 自己定義查詢SQL
     * 如果傳入user名稱 根據用戶查詢
     * 如果傳入暱稱 則根據暱稱查詢
     * 如果傳遞上方兩個 則根據用戶名稱查詢
     * 否則查詢id>10的訊息
     * @param user 包含了條件之實際案例
     * @return 多條符合的紀錄
     */
    public List<User> selectListByChoose(User user);

    /**
     * 分頁查詢
     * @param index 索引數值
     * @param size 每頁的紀錄數量
     * @return 指定頁面的使用者數據
     */
    public List<User> selectByPage (Integer index,Integer size);

    /**
     * 分頁查詢 根據PageHelper依賴
     * @return
     */
    public List<User> selectByPage02 ();


}
