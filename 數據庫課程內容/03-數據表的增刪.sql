#注意:必須要先切換到指定的數據庫中,然後才可以定位庫中的列表

CREATE DATABASE db3 CHARSET UTF8;
#在db3中存放表的話要從右上角的區域挑選
#也可以用命令將表指定的數據庫中
USE  db3;-- 切換到db3數據庫中

#創建表的語句(關注表的名字和表中的字段)
#創建一個Person表
#創建表的時候需要聲明表字段,但是數據庫中的要求表字段的類型需要固定
(類似於java聲明屬性,給屬性指定的類型)
CREATE TABLE person(-- 聲明表名為person 然後用括號去寫字段內容

    name VARCHAR(32),-- 聲明name字段,類型為字符串
    age  INT         -- 聲明age字段,類型是整數
)CHARSET UTF8; -- 通過指定的編碼去運行

#查看當前數據庫中有哪些表
SHOW TABLES ;

#查看指定表的建立表之語句(包含該表的編碼訊息)
SHOW CREATE  TABLE person; -- 查看person表的建表語句

#查看指定表字段的訊息(包含字段名稱,字段類型,是否允許為空值,鍵類型,默認值)
DESC person;

#刪除指定的表
DROP TABLE person;

#查看數據庫的編碼默認種類
SHOW VARIABLES LIKE'character_set_%';