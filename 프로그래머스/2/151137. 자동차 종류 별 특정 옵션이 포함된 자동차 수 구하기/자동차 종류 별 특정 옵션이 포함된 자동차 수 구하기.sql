-- 코드를 입력하세요
SELECT car_type, count(car_id) cars
from CAR_RENTAL_COMPANY_CAR
where options like "%열선시트%" 
or options like "%통풍시트%"
or options like "%가죽시트%"
group by CAR_TYPE
order by CAR_TYPE
# CAR_RENTAL_COMPANY_CAR
# CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
# 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트