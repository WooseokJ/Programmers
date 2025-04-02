-- 코드를 작성해주세요
select count(fi.fish_type) as fish_count, fni.fish_name 
from FISH_NAME_INFO fni join FISH_INFO fi
on fi.FISH_TYPE = fni.FISH_TYPE
group by fni.FISH_TYPE, fni.fish_name
order by fish_count desc


# FISH_INFO
# ID, FISH_TYPE, LENGTH, TIME
# 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜


# FISH_NAME_INFO
# FISH_TYPE, FISH_NAME
# 물고기의 종류(숫자), 물고기의 이름(문자)