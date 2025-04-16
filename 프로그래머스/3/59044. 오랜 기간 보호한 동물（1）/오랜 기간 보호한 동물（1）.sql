-- 코드를 입력하세요
# SELECT * 
select ai.name, ai.datetime
from ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.animal_id = ao.animal_id
where ao.animal_id is null
order by ai.DATETIME
limit 3





# ANIMAL_INS: 보호소 들어옴
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# ANIMAL_OUTS: 입영 보낸 정보 
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부