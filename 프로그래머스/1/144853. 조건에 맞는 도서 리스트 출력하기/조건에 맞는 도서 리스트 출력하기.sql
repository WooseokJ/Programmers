-- 코드를 입력하세요
SELECT book_id, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from book
where year(PUBLISHED_DATE) = 2021 and CATEGORY = '인문'
order by PUBLISHED_DATE
;

# BOOK
# BOOK_ID	CATEGORY	AUTHOR_ID	PRICE	PUBLISHED_DATE
# 도서 id,  - -  , 판매가, 출판일

# 2021에 출판, 인문에 속한 도서리스트 찾아 book_id, publisheddate