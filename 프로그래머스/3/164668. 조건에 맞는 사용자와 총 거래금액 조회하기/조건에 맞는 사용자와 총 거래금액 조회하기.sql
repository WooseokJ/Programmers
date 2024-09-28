-- 코드를 입력하세요
SELECT user_id as USER_ID, nickname as nickname, sum(price) as total_sales
from USED_GOODS_BOARD as ugb join USED_GOODS_USER as ugu
on WRITER_ID = user_id
where status = 'DONE'
group by user_id
having sum(price) >= 700000
order by total_sales
