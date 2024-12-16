-- 코드를 입력하세요
SELECT ai.animal_id, ao.name
from ANIMAL_INS as ai join ANIMAL_OUTS as ao
on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime
;



# 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

# ins: 들어온 동물 
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종,     보호 시작일,    보호 시작 시 상태,  이름,   성별 및 중성화 여부

# out: 입양보낸동물
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디, 생물 종,        입양일,    이름, 성별 및 중성화 여부