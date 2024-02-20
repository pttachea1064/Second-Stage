#列表中的紀錄之新增,修改,刪除與查詢(增刪改查 -> CRUD)
#其中查詢是最常使用 最重要的( 因為在一坨數據中撈要的東西 )
#先用tedu的資料庫來舉例

#基礎查詢(思考成篩選/查詢)
SELECT 1; -- 查詢常量值
SELECT 45*48; -- 查詢表達式的結果
SELECT NOW(); -- 查詢當前服務器系統時間 (NOW () 是MYSQL 中提供的函數)

#查詢表中的訊息
USE tedu;

/*
用"SELECT * FROM 表名"
 表示查詢的表中所有的字段
*/
SELECT  *  FROM student; -- 查詢student表中的所有字段

/*
用"SELECT FROM 表名 再從FROM前方加入id產生所有字段
*/
SELECT id, name, age, gender, job, birth, location_id, team_leader, class_id
From student;

#雖然*顯示的方便,但是可讀性很差,所以工作中,更推薦使用將所有字段寫出來的方式
#所以建議平常要用id,......_id的方式顯示所有字段

-- 表示只查詢studnet表中的name,age和gender字段的內容
SELECT name,age,gender FROM student;

SELECT id, name, age, gender, job, birth, location_id, team_leader, class_id
FROM student;