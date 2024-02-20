USE sqlpractice;

CREATE TABLE info(
    id INT primary key ,
    name VARCHAR(50),
    age INT,
    birth DATE,
    gender VARCHAR(5)
)CHARSET UTF8;

INSERT INTO info
VALUES (1,'徐剛',23,'1998-03-23','男'),
       (2,'徐剛',26,'1995-10-11','女'),
       (3,'徐剛',24,'1997-04-09','女'),
       (4,'徐剛',30,'1991-11-23','男'),
       (5,'徐剛',27,'1994-12-28','男'),
       (6,'徐剛',22,'1996-08-06','男');
SELECT * FROM info;

UPDATE info SET  name = '王菲' WHERE id=2;
UPDATE info SET  name = '徐鳳' WHERE id=3;
UPDATE info SET  name = '李剛' WHERE id=4;
UPDATE info SET  name = '王璐' WHERE id=5;
UPDATE info SET  name = '鄭皇' WHERE id=6;

-- ---------------------------------

-- a. 请编写SQL 语句对年龄进行升序排列（1分）
SELECT *
FROM info
ORDER BY age;

-- b. 请编写 SQL语句查询对"徐"姓开头的人员名单（1分）

SELECT *
FROM info
WHERE name LIKE '徐%';

-- c. 请统计表中男女各有多少人？（1分）

SELECT SUM(gender='男') 男性人數,
      SUM(gender='女') 女性人數
FROM info;
