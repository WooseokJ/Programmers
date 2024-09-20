-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, favorites
from rest_info
where FAVORITES in (select max(FAVORITES) from rest_info group by food_type)
group by food_type
order by food_type desc
                      

;


# 한식	00001	은돼지식당	734
# 중식	00015	만정	20
# 일식	00002	하이가쯔네	230
# 양식	00003	따띠따띠뜨	102
# 분식	00008	애플우스	151

# from where group by having select order by
# 이전: food_type기준 그룹화후, select통해 max를 찾음.
# 이후: food_type별 가장많은 favorite레코드 찾고 그다음 그룹화.