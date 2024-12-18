-- 코드를 입력하세요
SELECT fh.flavor
from FIRST_HALF fh join ICECREAM_INFO ii 
on fh.flavor = ii.flavor
where fh.TOTAL_ORDER > 3000 and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.total_order desc
;


# 상반기 아이스크림 총주문량이 3,000보다 높으면서 
# 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.



# FIRST_HALF 상반기 주문정보
# SHIPMENT_ID, FLAVOR(PK), TOTAL_ORDER
# 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량

# ICECREAM_INFO ice크림성분
# FLAVOR(FK), INGREDITENT_TYPE
# 아이스크림 맛, 아이스크림의 성분 타입(sugar_based설탕, fruit_based 과일)

