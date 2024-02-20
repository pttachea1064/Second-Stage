/*
 難度高(需要邏輯清晰)於工作時很常使用 所以很重要
 多表查詢
 1.先查詢學生的具體訊息
 2.根據學生訊息的class_id ,去class表中查詢id值等於class_id值的訊息
 應該讓這兩個動作變成一個動作
 #笛卡爾積查詢:會將兩張表的紀錄一一組合,會查詢出大量錯誤的訊息
 Select * FROM 表1,表2
 */
 -- teacher表有20條紀錄,subject表有5條紀錄 所以查詢結果20*5條紀錄
SELECT * FROM teacher, subject;

SELECT id,name ,subject_id
FROM teacher
WHERE id <=5;

SELECT id,name ,subject_id
FROM teacher
WHERE subject_id

-- 基於teacher 表的subject_id 的值如果等於subject表的id值,這個條件可以篩選出正確紀錄
-- 由於teacher 表中包含id 列和name列,subject表也包含id列和name列,所以不能同時查詢
-- 所以處理方式必須要標明列的所屬關係
-- 盡量用表別名簡化
SELECT t.name, t.subject_id,s.id,s.name
FROM teacher t, subject s
WHERE  t.subject_id = s.id;

#查詢班級訊息以及班級負責老師
-- 基於class表的teacher_id 和 teacher表的id 列的值相同,作為條件篩選出對應的訊息
SELECT c.name , c.teacher_id ,t.id ,t.name
FROM class c, teacher t
WHERE  c.teacher_id = t.id;

#查詢學生訊息以及學生的城市
-- 基於student 表的 location_id 列的值和 location表的id值相等 作為條件
SELECT  s.name,s.location_id,l.id,l.name
FROM student s , location l
WHERE  s.location_id = l.id;

#查詢老師訊息並包含老師的主管訊息
-- 基於teacher表 的manager列的值和 teacher表的id列的值相等,作為條件
SELECT t1.id ,t1.name,t1.title,t1.manager,t2.id ,t2.name, t2.title
FROM teacher t1,
     teacher t2
WHERE t1.manager = t2.id;