-- 코드를 작성해주세요

select count(id) FISH_COUNT, max(LENGTH) max_length, fish_type
# select AVG(length)
from FISH_INFO
group by FISH_TYPE
having avg(ifnull(length, 10)) >= 33
order by fish_type
# FISH_INFO
# ID, FISH_TYPE, LENGTH, TIME
# 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜