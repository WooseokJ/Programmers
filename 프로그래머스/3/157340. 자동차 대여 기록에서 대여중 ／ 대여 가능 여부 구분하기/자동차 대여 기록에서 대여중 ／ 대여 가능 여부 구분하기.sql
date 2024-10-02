-- 코드를 입력하세요
SELECT car_id, case when car_id in (select car_id 
                                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                                    where start_date <= '2022-10-16' and end_date >= '2022-10-16') then '대여중'
                                    else '대여 가능' end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc
;

#       HISTORY_ID, CAR_ID, START_DATE, END_DATE
# 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일