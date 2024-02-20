/*  修改表中記錄  */
-- 修改 teacher表 表中id 為22的紀錄
UPDATE teacher -- 表示要修改teacher表
SET age =30,
    title= '直播講師' -- 表示要修改的字段和值
WHERE id =22 ;

UPDATE teacher
SET  title='中國人'
WHERE id >20;

-- 如果修改操作不添加WHERE ,則會直接修改整張表的所有紀錄!要審慎使用
UPDATE  teacher
SET  salary = 10000000
WHERE id> 20;