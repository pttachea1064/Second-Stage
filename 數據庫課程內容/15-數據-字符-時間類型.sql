#增刪改數據類型
-- 數值 日期 字符串
-- 不同數據庫的數值類型 都會有所不同(會存在差異)
#新增的語法 INSERT INTO 表 VALUES ()

/*
數值類型(存儲整數或是浮點數字【小數】)
A.  1個字節有多大

1個字節 tinyint    (byte)通常表示8位2進制,00000000-11111111
即是10進制的0-255區間(但默認的是-127~+128)區間
2個字節 smallint 通常表示16位2進制,000000000000000-1111111111111111
即是10進制的-三萬多到+三萬多區間
4個字節 int -21億多到正的21億多
8個字節 bigint 負2^63到2^63

B.數據庫的整數類型與java中的基本類型的對應關係

tinyint   對應 byte       1字節
smallint  對應 short      2字節
int       對應 int        4字節
bigint    對應 long       8字節

C.float單精度 與 double双精度
單精度 表示的小數位 少於 双精度 的小數位
一般情況下,基本上使用double方式

D. float double and decimal
1) float 適合精度不高但是對於內存要節省的情況,比如遊戲開發
2) double 適合於精確度高的情況,但是能接受一定的誤差存在之情況,比如金融運算,科學計算
3) decimal 適合高精度的貨幣計算,但是速度會比較慢
 */
CREATE DATABASE  db5 CHARSET utf8;
USE db5;
CREATE TABLE tb1(
                    a INT(5),-- a字段存儲整數
                    b DOUBLE(6, 4),-- b字段存儲小數(6表示6位數值,4是4位小數,2位是整數)
                    c DECIMAL(6, 4)-- c字段存儲小數
) CHARSET = utf8;
INSERT INTO  tb1 VALUES (123,12,23);
INSERT INTO  tb1 VALUES (1234,1,2);
INSERT INTO  tb1 VALUES (1234,0.12345,0.12345);-- DOUBLE 會無條件捨去 DECIMAL 會四捨五入
SELECT  * FROM tb1;

/*
 字符串類型
 1. char 類型 : 定長字符串 name char(3) 該字符串表示最多有三個字符 ,最多指定的字符號串長度是255個
 name char(3) 存儲a ,實際存儲"a  "不足的空間會在空格區域補上空格
 2. char 類型存儲的字符串所佔的最大空間
 要根據存儲的字符串的編碼定奪

1)編碼latin1的情況,所有的字符號串都只會佔去1字節,所以255個字符號佔去255個字節
 2)編碼UTF8 的情況,所有的中文字 字符號串都占去3個字節, 所以255個字符號串佔去765個字節
 3) 編碼GBK的情況 ,所有的情況中文字 字符串都站2個字節, 所以255個字符號串佔去510個字節

 3.varchar類型:變長字符號串,最大的存儲空間為65535個字節
 name varchar(3) 存儲a,實際存儲"a"

 4.char and varchar 的區別
 char的效率要高於varchar
 varchar的空間卻比char更節省空間
 如果存儲身分證號使用char更好
 如果存儲姓名使用varchar更好

 5.varchar存儲的字符號串的數量是多少
 會根據實際編碼的情況去計算
 1)編碼latin1的情況,所有的字符號串都只會佔去1字節,所以佔去65535個字符
 2)編碼UTF8 的情況,所有的中文字 字符號串都占去3個字節, 所以佔去65535/3個字符
 3) 編碼GBK的情況 ,所有的情況中文字 字符串都站2個字節, 所以佔去65535/2個字符

 6.text 是定長的 但存儲空間是與varchar一樣

 */

CREATE TABLE tb2
(
    a CHAR(5),    -- a字段存储定长字符串
    b VARCHAR(5), -- b字段存储不定长字符串
    c TEXT        -- c字段存储大文本字符串
) CHARSET = utf8;
INSERT INTO tb2 VALUES ('a','b','c');
INSERT INTO tb2 VALUES ('abcde','abcde','abcdef');
SELECT * FROM tb2 ;

/*
 時間日期類型
 年月日時分秒擁有具體的格式 年-月-日 時:分:秒
 可以接受 年月日用"/""做區分
         年月日時分秒可以不用區隔開 但有要求 年(西元4位數)月(2位數)日(2位數)時(2位數)分(2位數)秒(2位數)
 */

CREATE TABLE tb3
(
    a DATETIME, -- a字段存储年月日时分秒
    b DATE,     -- b字段存储年月日
    c TIME,     -- c字段存储时分秒
    d TIMESTAMP -- d字段存储是时间戳,当修改记录时,会自动记录当前系统时间
) CHARSET = utf8;
INSERT INTO tb3 VALUES (NOW(),NOW(),NOW(),null);
INSERT INTO tb3 VALUES ('2023-01-01 11:13:14','1999-01-17 11:11:11','2000-02-03 12:00:05',null);
INSERT INTO tb3 VALUES ('2023/01/01 11:13:14','1999/01/17 11:11:11','2000/02/03 12:00:05',null);
INSERT INTO tb3 VALUES ('20230101111314','19990117111111','20000203120005',null);
SELECT * FROM tb3 ;
