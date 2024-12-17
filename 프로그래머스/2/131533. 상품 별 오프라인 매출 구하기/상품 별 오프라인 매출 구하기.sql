-- 코드를 입력하세요
SELECT p.product_code, sum(p.price * os.sales_amount) SALES
from product p join offline_sale os
on p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code 
;

# 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 
# 결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.

# 
# product 
# PRODUCT_ID, PRODUCT_CODE, PRICE
 # 상품 ID, 상품코드, 판매가


#OFFLINE_SALE 
# OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
#  판매 ID,           상품 ID,      판매량,        판매일