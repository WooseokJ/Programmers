-- 코드를 입력하세요
select b.category, sum(sales) as total_sales from book as b
inner join book_sales bs on b.book_id = bs.book_id
# where "2022-01-01" < bs.sales_date < "2022-02-01"
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'

group by b.category
order by b.category;