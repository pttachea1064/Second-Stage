#新增的語法
USE  tedu;
-- 向teacher表新增一紀錄
INSERT INTO teacher -- 表示向teacher新增紀錄
Values (21,'老安','18','直播講師','20',1000,20,'男',1);-- 括號中寫插入的值,順序要與表中的字段順序一致

Insert Into teacher Values (22,'張鵬',null,null,null,null,null,'男',null );

-- 向teacher 表新增一條紀錄,但是只記錄指定字段的內容
-- 沒有指定的內容會被記錄默認的數值
Insert Into teacher(id,name,gender) -- 表示只給teacher表 中的id ,name ,gender紀錄數值
Values(23,'田浩','男');

Insert Into teacher
Values (24,'張鵬2',null,null,null,null,null,'男',null ),
       (25,'張鵬3',null,null,null,null,null,'男',null ),
       (26,'張鵬4',null,null,null,null,null,'男',null ),
       (27,'張鵬5',null,null,null,null,null,'男',null );

Insert into teacher( id , name , title )
Values (28,'李四1','Java工程師'),
       (29,'李四1','Java工程師'),
       (30,'李四1','Java工程師');

/*  刪除表中的數據   */
-- 刪除teacher表中id 為21的紀錄
DELETE
FROM teacher
WHERE id = 21;

/*刪除teacher表中的id大於20的紀錄*/
DELETE FROM teacher WHERE id >20;
-- 刪除操作時 要慎重使用 因為下方的操作則會刪除整張表中的內容(意思是直接空白表單)
DELETE FROM teacher;


/*清空表中的內容*/-- 包含約束的限定
-- Truncate 會將整張表的紀錄刪除,但這個刪除會將整張表的配置初始化
-- DELETE 則是會被約束(所以刪除後新增的內容則會繼續添加)
TRUNCATE teacher;