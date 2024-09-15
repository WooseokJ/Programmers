-- 코드를 입력하세요
SELECT ai.animal_id, ai.name
from animal_outs as ao left join animal_ins as ai
on ao.animal_id = ai.animal_id
where ai.datetime > ao.datetime
order by ai.datetime
;

# 날짜가 현재보다 더 가까울떄 크다. 