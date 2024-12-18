-- 코드를 입력하세요
select Round(AVG(daily_fee),0) as AVERAGE_FEE 
from CAR_RENTAL_COMPANY_CAR
where car_type = 'SUV'

;
# 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정해주세요.

