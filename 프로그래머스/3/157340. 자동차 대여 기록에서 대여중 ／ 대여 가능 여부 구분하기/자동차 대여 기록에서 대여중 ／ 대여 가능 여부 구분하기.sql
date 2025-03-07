-- 코드를 입력하세요
SELECT car_id, max(case 
                    when start_date <= '2022-10-16' and '2022-10-16' <= end_date  then "대여중"
                    else "대여 가능"
                end )as AVAILABILITY
                # , start_date, end_date
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc
;

# CAR_RENTAL_COMPANY_RENTAL_HISTORY
# HISTORY_ID, CAR_ID, START_DATE, END_DATE
# 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일

