#SQL Q1

CREATE  DATABASE SQLpractice;
USE SQLpractice;

Create Table student(
    ID CHAR(8) NOT NULL ,
    Name CHAR(8) NOT NULL ,
    Sex CHAR(2) ,
    Age INT
);

Create  Table course(
    ID CHAR(8) NOT NULL ,
    Name CHAR(20) NOT NULL ,
    Description CHAR(50)
);

#課程course 與 學生 student 的關係表
Create Table course2student(
    ID_Course CHAR(4) NOT NULL ,
    ID_Student CHAR(8) NOT NULL
);

-- 1) 在課程表course 中增加一個課程(編號 DB-1 名稱DB2-SQL-1 )
-- 在其中增加一個學生(學生ID:20080001 名字:張三 ),學習DB-1課程內容

INSERT INTO course (ID,Name) VALUES  ('DB-1','DB2-SQL-1');
INSERT INTO student(ID, Name) VALUES  ('20080001','張三');
INSERT INTO course2student VALUES ('DB-1','20080001');

-- 2)更新課程中編號DB-1 的課程名稱為DB2SQL语法及其使用
UPDATE course Set Name = 'DB2SQL语法及其使用' WHERE ID='DB-1';
SELECT * FROM  course;

-- 3)查询课程名称以“DB2”开头的课程有哪些?需要列出课程编号，课程名称。
SELECT id, name
FROM course
WHERE Name LIKE 'DB2%';

-- 4) 查询课程编号为“DB-1”有哪些学生的SQL语句是什么?列出学生編號、姓名、性別
SELECT s.ID, s.Name , s.Sex
FROM student s
         INNER JOIN course2student cs
             ON s.ID = cs.ID_STUDENT
         INNER JOIN course c
             ON c.ID = cs.ID_COURSE
WHERE c.ID = 'DB-1';

-- ---------------------下方是檢測用新增數據------------------------
INSERT INTO course2student VALUES ('DB-1','20080002');
INSERT INTO course2student VALUES ('DB-1','20080003');
INSERT INTO student VALUES ('20080002','李四',null,null   );
INSERT INTO student VALUES ('20080003','王五',null,null   );

UPDATE course2student set ID_Course ='DB-2' Where ID_Student = '20080003';
INSERT INTO course VALUES ('DB-2','SQL語法構建',null);
SELECT *FROM course2student;

SELECT * FROM student;
-- --------------------上方是檢測用新增數據-------------------------
-- 4) 另外的寫法
SELECT s.ID, s.Name, s.Sex
FROM student s, course c, course2student c2s
WHERE s.ID = c2s.ID_Student and c2s.ID_Course = c.ID;


-- 5)统计所有课程的学生人数，并按人数从低到高排列。只有列出课程编号，上课人数
SELECT
       c.ID,
       COUNT(cs.ID_Student)  所有課程學生人數
FROM course c,course2student cs
WHERE cs.ID_Course = c.ID
ORDER BY COUNT(cs.ID_Student)DESC;
