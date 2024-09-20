
SELECT ugu.user_id as USER_ID, ugu.nickname as NICKNAME, sum(ugb.price) as TOTAL_SALES

from USED_GOODS_USER as ugu join USED_GOODS_BOARD as ugb
on ugu.user_id = ugb.WRITER_ID
where ugb.status = 'DONE'
group by ugu.user_id
having sum(ugb.price) >= 700000
order by total_sales
;