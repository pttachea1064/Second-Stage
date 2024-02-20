USE tedu;
/*
 模糊查詢 就是指根據部分的內容 查詢出相關的訊息
 Select * From 表名 Where 字段 Like  '通配字符串'
 如果忘記了一個字,使用"_"來表示
 如果忘了不知道幾個字(1個或2個或更多)則用"%"來表示
 */
 #查詢以王字開頭的名字為 兩個字的學生訊息
SELECT * FROM student WHERE name LIKE '王_';
#查詢以王字開頭的名字為 三個字的學生訊息
SELECT * FROM student WHERE name LIKE '王__';
#查詢以王字開頭的名字即可 因為不曉得有幾個字
SELECT * FROM student WHERE name LIKE '王%';
-- 查詢名字中有王字的學生訊息 (王XX、 X王X、 XX王)
SELECT * FROM student WHERE name LIKE '%王%';
-- 查詢名字中 第二個名字是王的學生訊息
SELECT * FROM student WHERE name LIKE '_王%';

/*
 去除重複(去重)的操作
 #Distinct關鍵字可以去除重複的數據
 去除重複的依據: 所有字段的內容相同時,才算相同
 */
 #查詢學員中的所有職位訊息
SELECT job FROM student;-- 這樣會給所有職位的內容所以會有重複
SELECT DISTINCT job FROM student;-- 這樣會給所有職位但不會重複
SELECT DISTINCT job FROM student WHERE  job IS NOT NULL;-- 這樣會給所有職位不會重複也不會為空

-- 查詢每個班級 都有哪些職位
-- 會發現 1班的數學課代表 2班的數學課代表 (不算重複) 因為班級不同
-- 會發現 1班的數學課代表 1班的語文課代表 (不算重複) 因為職位不同
-- 只有在 兩個條件相同時 才會去除重複
SELECT DISTINCT class_id,job FROM student
WHERE job IS NOT NULL AND class_id is not null;

