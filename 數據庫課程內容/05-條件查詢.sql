#條件查詢,基於指定的條件,將需要的數據篩選出來
#SELECT * FROM 表名 WHERE 條件
USE tedu;
#查詢id是666的學生紀錄
SELECT * FROM student WHERE id =666 ;

#查詢name是孫阮平的學生紀錄
-- name字段識字符串類型,所以要和值進行比較時 該值必須要是字符串類型,在MYSQL中字符串需要單引號''顯示
SELECT *FROM student WHERE name = '孙阮平';

#查詢birth是2015-04-21的學生紀錄
-- 在student表中,birth字段的類型是date類型(日期)但在比較時,就當字符串比較就可以了
SELECT * FROM student WHERE birth = '2015-04-21';

/*
    java中 = 賦值
    java中 == 比較/等於
 */


#查詢所有男生訊息
SELECT * FROM student WHERE gender = '男';

#查詢studnet所有性別不是女性的學生訊息
SELECT  * FROM student WHERE gender !='女';-- 表示gender不是女性的紀錄
SELECT  * FROM student WHERE gender <>'女';-- 表示gender不大於也不小於,這個表達方式是SQL92標準寫的方式

#查詢id在10以內的紀錄
SELECT * FROM student WHERE  id<10;
#查詢id在10以內的紀錄(包含10
SELECT * FROM student WHERE  id<=10;

#查詢id 在5-10的學生紀錄(包含5和10)
-- id 邀大於等於5 並且id 要小於等於10
-- 當兩個條件要求都必須同時成立時候,使用AND關鍵字連接
SELECT * FROM student WHERE id >=5 AND id <=10;
-- id BETWEEN 5 AND 10 表示 id 在5-10之間,等價於id >=5 AND id<=10
-- 這個方式只適合於包含上下限的情況產生 ,如果有一邊不包含就不太適合使用
-- Between必須要將小的數值放在前方 大的數值放在後方
SELECT * FROM student WHERE id BETWEEN 5 AND 10;

#查詢name為{马贺 金陶 贝邵}這三個人的訊息
-- 當兩個條件要求只要有一個成立即可的情況下使用OR關鍵字連接
SELECT * FROM student WHERE name = '马贺' OR name = '金陶' OR name = '贝邵';

# IN關鍵字,只要匹配後面的提供之內容,都顯示出來,便於理解
-- 當篩選的數值一多,效率就會降低
SELECT * FROM student WHERE
name IN ('马贺', '金陶', '贝邵');

#表中有時候不一定會有值在其中
/*
 如果表中的紀錄,在新增十,沒有給指定的字段輸入值,那麼該值是<null>
 表示該格為[什麼都沒有]
 ''空字符串不是null
 'null'字符串null不是null
    null 值 三育任何的運算和比較 ,結果都是null
 */
#篩選出job為null的紀錄
-- null值不能參與比較,所以會查詢不出結果
SELECT * FROM student WHERE  job = null;
-- 如果要查詢有空值的資料 要使用 IS Null關鍵字 查詢該字段中是否有null存在
SELECT * FROM student WHERE  job IS null;
-- <=> 這個符號表是安全等於
SELECT * FROM student WHERE  job <=> null;

#AND 的優先級別 高於OR 的優先級別
#查詢ID大於140並且job為語文課代表或數學課代表的學生訊息
-- id 大於140
-- job 為 數學課代表 或 語文課代表
SELECT * FROM student WHERE id > 140 AND ( job='语文课代表' OR job = '数学课代表');

#查詢生日在2010-10-01之前,或是生日在2015-10-01之後的內容
-- 對於日期的比較, 就當作是數值的比較即可,因為數據庫的底層(基本規則)會自動比較日期
SELECT * FROM student WHERE birth <'2010-10-01';
-- 這樣會顯示在2010-10-01前的生日數據內容
-- 下方則是題目所要求的內容
SELECT * FROM student WHERE birth <'2010-10-01' OR birth > '2015-10-01';
-- 另一種方式可以寫成這樣
SELECT * FROM student WHERE  birth NOT BETWEEN '2010-10-01'AND '2015-10-01';
-- 用 NOT 排除不要的訊息區間
/*
 延伸: 排除所有職位是學生、數學課代表、語文課代表的學生訊息
 */

SELECT  * FROM student WHERE  job NOT IN ('数学课代表','语文课代表','学生');

#查詢job為Null 以外的學生訊息
SELECT * FROM student WHERE job IS NOT NULL;


