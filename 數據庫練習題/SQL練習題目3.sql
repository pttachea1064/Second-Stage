USE sqlpractice;
-- ---------------------------------
#先製作表
CREATE TABLE SQL3student (
    S_ID VARCHAR(10),
    S_Name VARCHAR(10),
    S_Sex CHAR(2),
    Age INT,
    DEPT_NO VARCHAR(10)
)CHARSET UTF8;

SELECT *
FROM SQL3student;
-- ---------------------------------
CREATE TABLE SQL3course(
    C_ID VARCHAR(10),
    C_Name VARCHAR(10),
    T_ID VARCHAR(10)
)CHARSET UTF8;

SELECT *
FROM SQL3course;
-- ---------------------------------
CREATE TABLE SQL3teacher (
    T_ID VARCHAR(10),
    T_Name VARCHAR(10)
)CHARSET UTF8;

SELECT *
FROM sql3teacher;
-- ---------------------------------
CREATE TABLE SQL3score(
    S_ID VARCHAR(10),
    C_ID VARCHAR(10),
    S_Score INT
)CHARSET UTF8;

SELECT *
FROM SQL3score;
-- ---------------------------------
#新增資料紀錄
INSERT INTO SQL3student
VALUES('10001','吳好','男',18,'計算機系'),
       ('10002','崔平','男',21,'經管系'),
       ('10003','錢筱','女',19,'電子系');
-- ---------------------------------
INSERT INTO SQL3course
VALUES ('0001','SQL Server','10001'),
       ('0002','數據結構','10002'),
       ('0003','JAVA','10004');
-- ---------------------------------
INSERT INTO SQL3teacher
VALUES ('10001','張三'),
       ('10002','李四'),
       ('10003','王五'),
       ('10004','張柳');
-- ---------------------------------
INSERT INTO  SQL3score
VALUES ('10001','0001',80),
       ('10002','0002',75),
       ('10003','0003',90),
       ('1001','0002',55);
UPDATE SQL3score SET S_ID = '10001' Where S_ID = '1001';
SELECT *
FROM SQL3score;

-- ---------------------------------
-- 1.查询“01”课程比"02"课程成绩高的学生的信息及课程分数
SELECT s.S_ID,S_Name,S_Sex,Age,DEPT_NO,S_Score
FROM sql3student s
    JOIN sql3score s3s1 on s.S_ID = s3s1.S_ID
    JOIN sql3course s3c2 on s3c2.C_ID =s3s1.C_ID
WHERE (SELECT S_Score FROM sql3score WHERE SQL3score.C_ID='0001'AND SQL3score.S_ID=s.S_ID)>
      (SELECT S_Score FROM sql3score WHERE SQL3score.C_ID = '0002' AND SQL3score.S_ID=s.S_ID);
-- 2.查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
SELECT s3s.S_ID,S_Name,AVG(S_Score)
FROM SQL3score JOIN SQL3student S3s on SQL3score.S_ID = S3s.S_ID
WHERE S_Score
GROUP BY S_Score
HAVING AVG(S_Score)>60;
-- 3.所有同学的学生学号、学生姓名、选课总数、所有课程的总成绩
SELECT *
FROM SQL3student
    LEFT JOIN SQL3score S3s on SQL3student.S_ID = S3s.S_ID
    LEFT JOIN SQL3course S3c on S3s.C_ID = S3c.C_ID;