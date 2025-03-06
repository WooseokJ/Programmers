-- 코드를 작성해주세요
select round(avg(ifnull(length, 10)),2) as AVERAGE_LENGTH
from FISH_INFO

# FISH_INFO
# ID,       FISH_TYPE,       LENGTH,             TIME
# 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜
# length <= 10 는 null