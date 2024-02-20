#①拿最低工资的老师
-- 差尋出老師中的最低薪資是多少
SELECT MIN(salary)
FROM teacher;
-- 根據薪資查老師的薪資
SELECT *
FROM teacher
WHERE salary = 1;

/*
 嵌套查詢(子查詢)
 為了解決要分兩段來實現查詢
 */

# 使用子查詢來實現SQL的嵌套(子SQL的結果只有一個十,稱之為單行子查詢
SELECT *
FROM teacher
WHERE salary = (SELECT MIN(salary) FROM teacher);

#工資低於平均薪資的老師
SELECT*
FROM teacher
WHERE salary < (SELECT AVG(salary) FROM teacher);

#查詢只有4個人擁有的職稱之老師訊息
-- 根據職稱分組
SELECT title, COUNT(*)
FROM teacher
GROUP BY title
HAVING COUNT(*) = 4;
-- 利用職稱,過濾出老師訊息(子SQL 含有多條結果,稱之為多行子查詢 使用關鍵字IN連接
SELECT *
FROM teacher
WHERE title IN (SELECT title FROM teacher GROUP BY title HAVING COUNT(*) = 4);

#每個職稱中,拿工資最低的老師訊息
-- 根據職稱分組,查詢出各個職稱中的最低薪資訊息
SELECT title, MIN(salary)
FROM teacher
GROUP BY title;

SELECT *
FROM teacher
WHERE (title, salary) IN (SELECT title, MIN(salary) FROM teacher GROUP BY title)

