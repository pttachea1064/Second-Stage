/*
 別名(外號) 作用在表明稱長時 使用來替代原本的名稱
 AS 關鍵字 將原本的表名稱 AS 替代名稱
 - AS：关键字为可选参数 ALIAS
 -- AS可以省略
 表名稱太過長時 容易使SQL語句變的繁雜 所以可以簡化
 */
 USE tedu;

 SELECT * FROM  t_stu_subject_score
 WHERE t_stu_subject_score.score>50;

-- 上面是原本的 下方用AS 來簡化SQL名稱
 SELECT * FROM  t_stu_subject_score AS t
 WHERE t.score>50;

-- AS省略
SELECT * FROM  t_stu_subject_score t
 WHERE t.score>50;

-- 表別名不要起中文
SELECT * FROM  t_stu_subject_score 表
WHERE 表.score>50;
-- 表別名不要加雙引號
SELECT * FROM  t_stu_subject_score "t1"
WHERE t1.score>50;

-- 不能在表別名中加入空格 除非用雙引號包住
SELECT * FROM  t_stu_subject_score "t 1"
WHERE "t 1".score>50;

#計算每個老師的年薪 並篩選出年薪大於10萬的老師訊息
-- 這裡使用中文是方便理解 ,一般不要使用中文
-- 下方是用字段別名
SELECT id AS     老师id, -- 可以添加AS
       name      姓名,  -- 可以省略AS
       age       "年 龄", -- 如果別名中有空格,請給別名添加引號
       title     职称,
       manager   领导id,
       salary    薪资,
       comm      奖金,
       salary*12 + IFNULL(comm,0) 年薪, -- 計算如果有null,結果一定是null
       -- 所以避免null產生的錯誤結果 運用IFNULL去調整 會判斷(參數,視為值)將NULL轉換成視為的數值
       gender    性别,
       subject_id 所教科目
FROM teacher
WHERE salary*12 > 100000
ORDER BY 年薪 DESC;
-- Where中 是不能使用字段別名的 (Where會在 別名生成前率先執行)
-- ORDER BY 是在查詢結束後 才進行排序的 (所以會在別名生成後排序)所以可以使用別名