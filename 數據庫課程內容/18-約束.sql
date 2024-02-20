/* 約束 */

 /*
            主鍵約束
    ex.ID/身分證 此類具有唯一性
  (表示數據有唯一性的字段)稱為主鍵
  約束:創建列表時,給表中的字段添加之限制條件
  主鍵約束: 限制主鍵的值唯一且非空

    -- 希望主鍵的字段不與業務溝邊 --
  */

CREATE DATABASE db6 CHARSET UTF8;
USE db6;
/*主鍵約束*/
#創建一張表,包含id列和name列,其中id列,設置為主鍵約束
CREATE TABLE demo1
( id INT PRIMARY KEY , -- 設置id列為主鍵,主鍵要求該列的值非空且唯一
name VARCHAR(10))
CHARSET  UTF8;

INSERT INTO  demo1 VALUES (1,'老安');
-- Duplicate entry '1' for key 'PRIMARY' 表示紀錄的數值1是重複的不允許紀錄
INSERT INTO  demo1 VALUES (1,'老安');
-- Column 'id' cannot be null 表示id的值不能為null值
INSERT INTO demo1 VALUES (null,null);
-- Field 'id' doesn't have a default value 給指定的字段紀錄內容
-- 由於id是主鍵,所以默認值是null,而id是不能null的(因為是PRIMARY KEY)
INSERT INTO  demo1 (name) VALUES ('老張');

/*主鍵烈可以設置為主鍵字增*/
CREATE TABLE demo2
( id INT PRIMARY KEY AUTO_INCREMENT , -- 設置主鍵為自增主鍵 只能存儲整數值(因為是+1+1這樣進行
  name VARCHAR(10))
    CHARSET  UTF8;
INSERT INTO  demo2 VALUES (1,'老安');
-- id會自動進行值的紀錄,並且會自動加1
INSERT INTO  demo2 VALUES (null,'老安');
INSERT INTO  demo2 (name) VALUES ('老安');
-- 現在表中最後一條紀錄是id為12的紀錄,先將這條紀錄刪除
DELETE FROM demo2 WHERE id = 12 ;
-- 下方這條則會產生id 13的紀錄
INSERT INTO  demo2 VALUES (null,'老安');

/*主鍵字增的原理:
  主鍵自增的id值不是通過上一條紀錄的id來+1進行執行的,而是每執行一次新增,會將次數記錄在鍵表與劇中的AUTO_INCREAMENT,
  也就是初始值為1,執行一次新增,會將1作為id進行寫除,然後該值會增1變成2
  再次執行一次新增 主鍵變成2 該值再次+1變成3
  */

DELETE FROM demo2;-- 只刪除數據不罪將字增消除
TRUNCATE demo2;-- 刪除數據 也會刪除自增數值(先執行DROP 再進行CREATE)

SHOW CREATE TABLE demo2;
SELECT * FROM demo2;

DESC demo1;
SELECT * FROM demo1;

/*非空約束*/
CREATE TABLE demo3
( id INT PRIMARY KEY AUTO_INCREMENT , -- 設置id列為主鍵,主鍵要求該列的值非空且唯一
  name VARCHAR(10),
  gender VARCHAR(10) NOT NULL ) -- 設置gender列的數值不能為空
    CHARSET  UTF8;
INSERT INTO  demo3 Values (null,'老潘','男');
-- Column 'gender' cannot be null 表示gender紀錄不能是空值
INSERT INTO  demo3 Values (null,'老潘',null);
-- 空字符串不是null
INSERT INTO  demo3 Values (null,'老潘','');-- gender那行不是null只是沒有數值
INSERT INTO  demo3 Values (null,'老潘','null');-- gender那行不是null只是用KEY的NULL在裡面


/*唯一約束*/
CREATE TABLE demo4
( id INT PRIMARY KEY AUTO_INCREMENT , -- 設置id列為主鍵,主鍵要求該列的值非空且唯一
  name VARCHAR(10),
  gender VARCHAR(10) NOT NULL,-- 設置gender列的數值不能為空
   tel VARCHAR(13) UNIQUE) -- 設置tel字段為唯一約束,紀錄的數值不能重複
    CHARSET  UTF8;
INSERT INTO  demo4 VALUES (null,'安','男','8008208820');
INSERT INTO  demo4 VALUES (null, 'an','boy','800208820');
-- Duplicate entry '800208820' for key 'tel'表示tel重複的紀錄不能重複
INSERT INTO  demo4 VALUES (null, 'an','boy','800208820');
INSERT INTO demo4 VALUES(null,'an','boy',null);
-- null值可以重複
INSERT INTO demo4 VALUES(null,'an','boy',null);
DESC demo4;
SELECT * FROM demo4;


SELECT * FROM demo3;
DESC demo3;

/*檢查約束 */
-- 檢查約束替代方案: 通過程序控制紀錄的數值符合表中約束的要求
CREATE TABLE demo5
( id INT PRIMARY KEY AUTO_INCREMENT , -- 設置id列為主鍵,主鍵要求該列的值非空且唯一
  name VARCHAR(10),
  gender VARCHAR(10) NOT NULL,-- 設置gender列的數值不能為空
  tel VARCHAR(13) UNIQUE,
  age INT, CHECK ( age>=0 AND age <=150) ,
            CHECK ( gender IN ('男性','女性') )
  )
    CHARSET  UTF8;
INSERT INTO  demo5 VALUES (null,'an','男性','1234',18);
-- Constraint Constraint_1 failed for db6 demo5  表示紀錄的數值不合格 超出了範圍
INSERT INTO  demo5 VALUES (null,'an','男性','1234',1000);
-- CONSTRAINT CONSTRAINT_2 failed for db6 demo5 表示紀錄的數值檢驗不合規格 不是指定的數值
INSERT INTO  demo5 VALUES (null,'an','男女性','1234',10);

DESC demo5;
SELECT * FROM demo5;

/*默認約束*/
CREATE TABLE demo6
( id INT PRIMARY KEY AUTO_INCREMENT , -- 設置id列為主鍵,主鍵要求該列的值非空且唯一
  name VARCHAR(10),
  gender VARCHAR(10) NOT NULL,-- 設置gender列的數值不能為空
  tel VARCHAR(13) UNIQUE,
  age INT, CHECK ( age>=0 AND age <=150) ,
  CHECK ( gender IN ('男性','女性') )
)
    CHARSET  UTF8;

/*外鍵約束(非常重要)*/
-- 基本上不太會使用 因為太過消耗性能
-- 解決方案 通過我們的大腦去記憶多表之間的關聯關係
CREATE TABLE banji(
                      id   INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(20)
) CHARSET = utf8;
CREATE TABLE xuesheng(
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(20),
                         ban_id INT,
                         FOREIGN KEY (ban_id) REFERENCES banji (id)-- 設置班級id為外鍵,並且該字段的數值只能取自班級表的id列的值
) CHARSET = utf8;
INSERT INTO banji(name) VALUES('A'),('B');
INSERT INTO xuesheng(name,ban_id)VALUES('张三',1),('李四',2),('王五',1);
-- 下方的班級id不符合我們限定的內容
INSERT INTO xuesheng(name,ban_id)VALUES('aaa',99);

SELECT  * FROM banji;
SELECT  * FROM xuesheng;
-- 表中不能刪除之原因 已經被其餘的表引用了
DELETE FROM banji WHERE id = 1 ;