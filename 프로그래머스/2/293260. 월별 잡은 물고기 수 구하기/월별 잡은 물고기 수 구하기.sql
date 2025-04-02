-- 코드를 작성해주세요

select count(fish_type) FISH_COUNT ,month(time) as month
from FISH_INFO
group by month
order by month 


# FISH_INFO
# ID, FISH_TYPE, LENGTH, TIME
#  물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜

