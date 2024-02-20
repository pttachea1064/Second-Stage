#創建transaction資料庫
Create DATABASE  transacation CHARSET UTF8;

USE transacation;
#創建user表
CREATE Table user(
    id Int PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(50),
    money DOUBLE
)CHARSET UTF8;
INSERT INTO user
VALUES (null,'LM',500),
       (null,'LY',500);
SELECT * FROM user;

/*事務提交DEMO COMMIT */

/*事務回滾DEMO ROLLBACK*/

/*
 事務的併發問題如何發生
 1.贓讀
 一個事務讀取到另一個"尚未提交"的數據內容

 2.不可重複讀
 一個事務提交的數據可以被另一个事务立即读取,可能发生与第一次查询数据不一致

 &不可重複讀與髒讀的區別
一個讀取到提交的一個讀取到沒有提交的

 3.幻读
一个事务读取数据时，另外一个事务进行更新，导致第一个事务读取到了没有更新的数据,读取不到新插入的数据

 避免事務併發問題
 (是製事務的隔離級別)
 READ UNCOMMITTED 讀取尚未提交
 READ COMMITTED 讀取已經提交(可以避免髒讀)
 &{默認} REPEATABLE READ 為可以重複讀 可以免贓讀與不可重複讀取
 SERIALIZABLE 序列畫 可以避免髒讀 不可重複讀 和幻讀

 */

-- 查看 隔離級別
SELECT @@tx_isolation; -- REPEATABLE-READ