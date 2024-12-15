-- 코드를 입력하세요
SELECT book_id as BOOK_ID, author_name as AUTHOR_NAME, date_format(published_date,'%Y-%m-%d' ) as PUBLISHED_DATE
from book b join author a
on (b.AUTHOR_ID = a.AUTHOR_ID)
where b.category = '경제'
order by PUBLISHED_DATE 
;



# 도서 정보(BOOK), 저자 정보(AUTHOR)

# book_id	category	author_id	price	published_date
# 1	경제	1	9000	2020-01-10 00:00:00
# 2	경제	1	12000	2021-06-10 00:00:00
# 3	인문	1	11000	2021-10-24 00:00:00
# 4	소설	2	7500	2020-03-03 00:00:00
# 5	기술	3	11000	2020-02-17 00:00:00
# 6	기술	3	8000	2020-04-29 00:00:00
# 7	생활	3	9500	2021-08-20 00:00:00

# author_id	author_name
# 1	홍길동
# 2	김영호
# 3	김수진