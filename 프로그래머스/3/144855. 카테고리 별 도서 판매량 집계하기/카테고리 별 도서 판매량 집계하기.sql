-- 코드를 입력하세요
SELECT b.category, sum(bs.sales) as total_sales
from book b join book_sales bs
on b.book_id = bs.book_id
where date_format(bs.sales_date, '%y-%m-%d') between '22-01-01' and '22-01-31'
group by b.category
order by b.category
;


# BOOK
# book_Id, category, author_id, price, published_date

# book_sales
# book_id, sales_date, sales