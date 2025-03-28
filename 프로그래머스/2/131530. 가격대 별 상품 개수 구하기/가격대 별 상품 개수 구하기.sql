-- 코드를 입력하세요

select Truncate(price / 10000,0) * 10000 as price_group, count(*) products
from product
group by Truncate(price / 10000,0)
order by price
;

# PRODUCT
# PRODUCT_ID, PRODUCT_CODE, PRICE
# 상품 ID, 상품코드, 판매가

