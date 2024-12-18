-- 코드를 작성해주세요
select count(id) as fish_count
from FISH_INFO
where length is null

# FISH_INFO
#  ID, FISH_TYPE, LENGTH, TIME
# 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜


# length <= 10 -> null
# 잡은 물고기 중 길이가 10cm 이하인 물고기의 수를 출력하는 SQL 문을 작성해주세요.
# 물고기의 수를 나타내는 컬럼 명은 FISH_COUNT로 해주세요.



