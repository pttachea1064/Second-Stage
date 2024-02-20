/*笛卡爾積查詢 可以將關聯的表中數據查詢出來,可是非關聯的數據內容不顯示
 */
 #  大題目要求:查詢老師訊息,並且顯示老師所教授的課程
-- 使用笛卡爾積查詢,只顯示出匹配的數據
USE tedu;



SELECT t.name 教師 ,
       s.name 科目
FROM teacher t,subject s
WHERE t.subject_id = s.id;
# 老師總共20人 但是結果卻僅有19條列出來(因為老闆所授科目是null,或是科目沒有被輸入該配對內容)

#將上述的SQL語句改造成左外連接
-- 將","改成 LEFT JOIN     WHERE關鍵字改成ON
-- LEFT JOIN 會將左邊表中的所有數據顯示出來,而右邊只會顯示匹配的數據紀錄
SELECT t.name 教師 ,
       s.name 科目
FROM teacher t LEFT JOIN  subject s
ON t.subject_id = s.id;

#將上述的SQL語句改成右外連接
-- 將 ","改成 RIGHT JOIN   WHERE關鍵字改成ON
-- RIGHT JOIN 會將右邊表中的所有數據顯示出來,而左邊的表只會顯示匹配的數據紀錄
SELECT t.name 教師 ,
       s.name 科目
FROM teacher t RIGHT JOIN subject s
ON t.subject_id = s.id;

#將上述的SQL語句改成內連接
-- 將 ","改成 INNER JOIN   WHERE關鍵字改成ON
-- INNER JOIN 只顯示匹配的紀錄==笛卡爾積
SELECT t.name 教師 ,
       s.name 科目
FROM teacher t
    INNER JOIN subject s
ON t.subject_id = s.id;


#Practice 學生訊息,並顯示學生所在城市,沒有城市的學生顯示NULL
-- 學生訊息全部顯示, 城市顯示匹配內容
SELECT s.name 學生 ,l.name 城市
FROM student s LEFT JOIN location l
ON s.location_id = l.id ;

#查詢班級負責老師,以及老師所教的科目
-- class 表的 teacher_id 關聯 teacher表的id
-- teacher 表的subject_id 關聯 subject表的 id
SELECT c.name 班級 , t.name 老師 , s.name
FROM class c
    LEFT JOIN  teacher t
        ON c.teacher_id = t.id
    LEFT JOIN subject s
        ON t.subject_id = s.id;

#查詢學生的各個科目成績
-- t_stu_subject_score表的 stu_id 關聯 student表的 id
-- t_stu_subject_score 表的subject_id 關聯 subject表的id
SELECT s.name 學生  ,s2.name 科目 ,tsss.score 分數
FROM t_stu_subject_score tsss
    LEFT JOIN student s ON tsss.stu_id = s.id
    LEFT JOIN subject s2 ON tsss.subject_id = s2.id;
