-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(fh.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF as fh join ICECREAM_INFO as ii
on ii.FLAVOR = fh.FLAVOR
group by ii.INGREDIENT_TYPE
;



# FIRST_HALF
# SHIPMENT_ID, FLAVOR, TOTAL_ORDER
# 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량


# ICECREAM_INFO
# FLAVOR, INGREDITENT_TYPE
# 아이스크림 맛, 아이스크림의 성분 타입
# 