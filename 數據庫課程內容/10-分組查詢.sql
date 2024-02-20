USE tedu;
#查詢所有老師的人數
SELECT COUNT(*)
FROM teacher;

#查詢各個職稱的老師的人數
SELECT title,  -- 聚合一般只跟分組的字段進行查詢
       COUNT(*) -- 對於分完組後的各個虛擬表,再次進行聚合函數的操作
FROM teacher
GROUP BY title;

# 查詢各個職位的老師之最高薪資是多少(各加入name可以查看薪資排序內容)
SELECT title,name, MAX(salary)
FROM teacher
GROUP BY title,name
ORDER BY MAX(salary);

#每個班級中,每個職位的學生人數,按班級編號排序
SELECT class_id,job,count(*)
FROM student
WHERE  class_id IS NOT NULL
    GROUP BY class_id,job;-- 根據班級分組,分組後對各個虛擬表再次根據職位分組

/*
 分組語句中定義Where關鍵字 ,那麼這個where是在分組之前執行還是在分組之後執行的?
 ANS: 分組之前執行的,通過WHERE 篩選符合要求的數據,然後再次進行分組,提高值性效率

 -- *可能會存在分組後 依然想再次篩選* --
問:如果要在分組之後進行再次的篩選,還能使用WHERE?
 ANS: 不能 ,這個時候必須要使用HAVING來再次篩選

 Tips: WHERE 篩選前篩選        HAVING 篩選後篩選

 WHERE 中可以使用聚合函數嗎?
 ANS: 不能 因為聚合函數是在分組執行後執行, 而WHERE是在分組之前運行的

 HAVING 能取代 WHERE嗎?
 ANS:不能 因為篩選順序不同,影響分組效率
 HAVING 只是和在分組之後進行篩選,否則其餘情況下,與WHERE相較效率低下許多
 */
#只有3學生人數的班級
SELECT class_id, COUNT(*) student_scount
FROM student
WHERE class_id IS NOT NULL -- WHERE 關鍵字災分組之前執行,篩選出班級不為null的紀錄
GROUP BY class_id
HAVING COUNT(*) = 3 ;

-- WHERE 能實現的功能, HAVING都能實現
SELECT * FROM teacher HAVING  salary >6000;

SELECT  class_id,COUNT(*) c
FROM student
GROUP BY class_id
HAVING  class_id IS NOT NULL AND c = 3;

SELECT class_id, COUNT(*) c
FROM student
WHERE class_id IS NOT NULL
GROUP BY class_id
HAVING c > 60;


