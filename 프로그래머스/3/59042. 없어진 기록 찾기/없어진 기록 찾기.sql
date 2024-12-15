-- 코드를 입력하세요
SELECT ao.ANIMAL_ID, ao.name
from ANIMAL_INS as ai right join ANIMAL_OUTS as ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.ANIMAL_ID is null
order by animal_id
;


# 입양을 간 기록(outs)은 있는데, 보호소에 들어온(ins) 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.


# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부