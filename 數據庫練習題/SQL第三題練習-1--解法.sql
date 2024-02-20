Use sqlpractice;

-- step 1 找課程01的成績之學生
Select * From sql3score WHERE C_ID =01;
-- step 2 找課程02的成績之學生
SELECT * From sql3score Where C_ID= 02;
-- step 3 查詢01大於02課成績存在之學生
SELECT *
FROM
     (Select * From sql3score WHERE C_ID =01) as a ,
     (SELECT * From sql3score Where C_ID= 02) as b
Where a.S_ID = b.S_ID And a.S_Score>b.S_Score;

# 查詢學生訊息
SELECT *
From
sql3student where S_ID=10001;

-- 然後使用join on來進行多表連查(查詢01課程分數比02課程分數高的同學訊息與分數

SELECT *
FROM sql3student s
Join (
    SELECT a.S_ID,
           a.S_Score as sc1,
           a.C_ID as cid1,
           b.S_Score sc2,
           b.C_ID cid2
    FROM
        (Select * From sql3score WHERE C_ID =01) as a ,
        (SELECT * From sql3score Where C_ID= 02) as b
    Where a.S_ID = b.S_ID And a.S_Score>b.S_Score
    ) as r ON s.S_ID = r.S_ID ;


