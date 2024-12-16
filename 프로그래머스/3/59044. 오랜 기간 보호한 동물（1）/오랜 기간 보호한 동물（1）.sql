-- 코드를 입력하세요
SELECT ai.name as NAME, ai.datetime as DATETIME
from animal_ins as ai left join animal_outs as ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ao.datetime is null
order by ai.DATETIME
limit 3
;

# 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.

# animal_ins 
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종,      보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# out: 입양감 
# ANIMAL_ID(외래키), ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디,       생물 종,         입양일, 이름, 성별 및 중성화 여부

# 