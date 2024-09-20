-- 코드를 작성해주세요
select count(fish_type) as FISH_COUNT, max(length) as MAX_LENGTH, fish_type as FISH_TYPE
from FISH_INFO

group by fish_type
having AVG(ifnull(length, 10)) >= 33
order by fish_type



;