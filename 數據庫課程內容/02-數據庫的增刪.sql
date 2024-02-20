Show DATABASES ;
#查看當前數據庫服務器中有那些數據庫(DATABASE)
#暗助CRTL+ENTER,快捷鍵可以迅速執行當前該行的SQL

#在服務器中建立一個數據庫
CREATE DATABASE db1;

#查看指定數據庫的建庫語句 (可以查看到數據庫的編碼類型)
show create database db1;

/*
安裝數據庫十,如果勾選了數據庫默認編碼,那麼創建庫和表的時候,默認就是UTF8編碼的
如果顯示的是latin1,則需要在創建庫和表的時候,專門指定編碼
 */
CREATE DATABASE db2 CHARSET UTF8;
SHOW CREATE DATABASE db2;

#創建數據庫時候,先判斷,如果數據庫已經存在,則不創建,如果數據庫不存在則創建
CREATE DATABASE IF NOT EXISTS db2 CHARSET UTF8;-- 執行不會報錯
# 其中要加入IF NOT EXISTS

#刪除數據庫(指定)
DROP DATABASE db1;
SHOW DATABASES ;
DROP DATABASE db1;-- 執行時報錯,因為db1已經被刪除,服務器不存在db1的庫,所以會提示庫不存在
#如果已經刪除過了,數據庫不存在,則不刪除的語法是IF NOT EXISTS
DROP DATABASE IF EXISTS db1;

