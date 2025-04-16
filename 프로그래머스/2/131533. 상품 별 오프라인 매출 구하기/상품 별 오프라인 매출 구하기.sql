-- 코드를 입력하세요
SELECT p.product_code, sum(p.price * os.sales_amount) as SALES
from PRODUCT p join OFFLINE_SALE os
on p.product_id = os.product_id
group by p.PRODUCT_CODE
order by SALES desc , PRODUCT_CODE



# PRODUCT
# PRODUCT_ID, PRODUCT_CODE, PRICE
# 상품 ID, 상품코드, 판매가

# OFFLINE_SALE
# oFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
# 오프라인 상품 판매 ID, 상품 ID, 판매량, 판매일


# 