-- 코드를 작성해주세요
select concat(max(length),'cm')  as MAX_LENGTH
from fish_info

# FISH_INFO
# ID, FISH_TYPE, LENGTH, TIME
# 고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜

# length <= 10 -> null


# FISH_INFO 테이블에서 잡은 물고기 중 가장 큰 물고기의 길이를 'cm' 를 붙여 출력하는 SQL 문을 작성해주세요.
# 칼러명 MAX_LENGTH