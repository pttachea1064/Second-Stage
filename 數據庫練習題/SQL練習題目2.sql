USE sqlpractice;
#1.創建用戶表
CREATE TABLE user
(
    no    CHAR(10) PRIMARY KEY,
    name  VARCHAR(20),
    valid DATE,
    state CHAR(1) NOT NULL
        DEFAULT 'A'
        CHECK ( state IN ('A', '1', 'X') )
) CHARSET UTF8;
SELECT *
FROM user;

#2.插入紀錄(2018090001,張三,date(2099-12-13)A
INSERT INTO user
VALUES ('2018090001', '張三', date('2099-12-31'), 'A');

#3.查詢2018-09-01(包含)尚未過期的使用者
-- 檢測用
INSERT INTO user
VALUES ('2018090002', '李四', date('2018-08-31'), '1');

SELECT name, valid, state
FROM user
WHERE valid >= '2018-09-01'
  And state = 'A';

SELECT name, valid, state
FROM user
WHERE valid >= '2017-09-01'
  And state = 'A';
