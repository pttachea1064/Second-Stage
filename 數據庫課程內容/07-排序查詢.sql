#查詢老師的薪資訊息,並且按照薪俸大小排序(小到大)升序ascend/默認
SELECT * FROM teacher ORDER BY salary ASC ;
#查詢老師的薪資訊息,並且按照薪俸大小排序(大到小)降序descend
SELECT * FROM teacher ORDER BY salary DESC ;

#查詢老師訊息 並按照科目的編號升序 然後在依照工資降序
SELECT name , title ,salary ,subject_id  FROM teacher where
subject_id is not null ORDER BY  subject_id;
-- 上面這條 Salary 沒有照排序
SELECT name , title ,salary ,subject_id  FROM teacher where
subject_id is not null ORDER BY  subject_id,salary DESC ;

-- 排序查詢 ORDER BY 來排序
-- 一般不會針對字符串來排序,如果是需要排序 是會根據字符串的編碼來排序(ASCII編碼表)
SELECT * FROM teacher ORDER BY name;