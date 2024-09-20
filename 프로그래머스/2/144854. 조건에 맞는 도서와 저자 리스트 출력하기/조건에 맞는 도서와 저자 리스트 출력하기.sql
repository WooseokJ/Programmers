-- 코드를 입력하세요
SELECT book_id, AUTHOR_NAME, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from book as b left join author as a 
on b.AUTHOR_ID = a.AUTHOR_ID
where category = '경제'
order by PUBLISHED_DATE
;