/*
 分頁查詢
 當我們進行查詢操作時候,查詢的結果數據量較大,一般不會一次性將數據發送給用戶
 原因如下:
 1.便於用戶讀取數據
 2.由於後期的數據,都是從數據庫中查詢,
 然後通過網路傳輸給用戶,如果傳輸的數據過大,
 會造成傳輸時間過長之問題產生,降低用戶體驗
 3.龐大的數據量進行傳輸,對於服務氣性能要求更高,
 所以查詢操作,原則上都應該進行分頁處理(將多條數據,按照指定的條數,一頁一頁的分頁發送)
 ex.1000條紀錄,通過分頁,就可以以10條為一頁,共100頁發送給用戶,用戶看完一頁,則再發送下一頁數據給用戶

 #分頁查詢 一般都要求 :

 1. 每頁的條數固定
 2.每頁的數據都是連續的
 3.最後一頁,如果不夠每頁的紀錄數支要求 則有多少顯數多少

 #分頁語法
 SELECT * FROM 表名 LIMIT b
 SELECT * FROM 表名 LIMIT a,b
 參數描述:
 參數a 表示當前頁中的第一條紀錄之索引值
 參數b 表示一頁要顯示多少條紀錄數 LIMIT
 a b c d e f g h i j  k  l  m  n
 0 1 2 3 4 5 6 7 8 9 10 11 12 13
 第一頁 a b c d e LIMIT 0,5
 第二頁 f g h i j LIMIT 5,5
 第三頁 k l m n   LIMIT 10,5
 第n頁            LIMIT 5*(n-1),5

 當我們知道每頁顯示size條紀錄,第n頁,分頁寫法為LIMIT b*(n-1),b
 */

 #每頁顯示10條紀錄
#第一頁紀錄
SELECT *
FROM student
LIMIT 0,10;
-- 也可以直接寫成
#查詢前10條紀錄
SELECT *
FROM student
LIMIT 10;

-- 查詢後10條紀錄(先根據id 降序排列 ,再取前10條)
SELECT * FROM student GROUP BY id DESC LIMIT 10;
#第二頁紀錄
SELECT *
FROM student
LIMIT 10,10;

#第三十頁紀錄
SELECT *
FROM student
LIMIT 290,10;