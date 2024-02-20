#對話窗口1
-- 進行轉帳操作
USE transacation;
SELECT *
FROM user;

-- 開始進行轉帳操作
BEGIN ;-- 另一種寫法Start Transaction
/*
一旦開啟了事務,事物在操作的過程中,只要沒有結束,
操作的所有數據,都只會存在日製表中生效(虛擬數據表),
所以真實的表中數據不會被修改
*/

-- 將LM 轉給LY 100
-- 將LM的金額減少100
UPDATE user
SET money=money-100
WHERE name ='LM';
-- 查詢user表中的金額
SELECT * FROM user; -- 400: 500

-- 將LY的帳戶金額增加100
UPDATE  user
SET  money = money + 100
WHERE name = 'LY';
SELECT * FROM user; -- 400 :600

#庶務中的兩條SQL語句沒有問題,所以提交事務
/*只要提交事務,就意味著事務中包含的多條SQL語句執行成功
  那麼這謝SQL修改的數據,就會被真實的存儲到數據庫中,並且永久保存*/
COMMIT;

/*事務的回滾ROLLBACK*/
-- 依樣轉帳操作
BEGIN ;
UPDATE user
SET money=money-100
WHERE name ='LM';
SELECT * FROM user;-- 400:500

UPDATE  user
SET  money = money + 200
WHERE name = 'LY';
SELECT * FROM user;-- 400:700

-- 存在問題價格對不上轉帳錯誤
-- 所以要使用回滾
#當事務中一條SQL存在錯誤執行是有問題的,那麼會影響多個事務操作的數據
-- 那麼一定要進行回滾將數據修秤的開啟前的狀態
ROLLBACK ;
SELECT * FROM user; -- 都變回500;500