-- 코드를 입력하세요
SELECT user_id, product_id

from ONLINE_SALE
group by user_id, product_id
having count(*) != 1
order by user_id , PRODUCT_ID desc


# ONLINE_SALE
#ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
#온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일

# 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 
# 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.

