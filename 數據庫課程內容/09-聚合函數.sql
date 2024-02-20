#查詢全體教師的薪資總和
USE tedu;
select * from teacher;

SELECT SUM(salary) 薪資總和
FROM teacher;-- 針對salary求和

#查詢全體教師的最低薪資 {以下都是忽略NULL值}
SELECT SUM(salary) 薪資總和,
       MIN(salary) 最低薪資,-- 篩選出salary中最小值
       MAX(salary) 最高薪資,-- 最大值
       COUNT(salary) 人數,-- 求出salary字段中有多少個有效數值,即人數
       AVG(salary)平均薪資 -- 通過salary的總和除以salary的有效數值,即是平均值
FROM teacher;

#ROUND函數來控制小數位的控制
SELECT ROUND( AVG(salary),2)
FROM teacher;-- 使用ROUND去顯示小數第幾位(該前題目是控制到第二位數)

SELECT COUNT(comm),-- 求出comm有多少個有效的數值,null不能算是有效數值
       COUNT(*), -- 求出整張表中所有紀錄的有效值個數
       COUNT(10) -- 求出整張表中除了10之外的非空行資料
FROM teacher;

#查出共有多少個職業稱號
SELECT COUNT(DISTINCT title)
FROM teacher;-- 計算去除重複的結果之字段的個數

#
SELECT COUNT(*) FROM teacher
WHERE title = '一级讲师'
