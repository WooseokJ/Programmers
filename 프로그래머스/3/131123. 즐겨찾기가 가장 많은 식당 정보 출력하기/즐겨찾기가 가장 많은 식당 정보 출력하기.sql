-- 코드를 입력하세요
# SELECT *, max(favorites)
# select *
select food_type, rest_id, rest_name, max(favorites) as favorites
from REST_INFO
where favorites in (select max(favorites) 
                   from rest_info 
                  group by food_type)
group by FOOD_TYPE
order by food_type desc
;

# REST_ID, REST_NAME, FOOD_TYPE, VIEWS, FAVORITES, PARKING_LOT, ADDRESS, TEL
# 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호

    # 00001	은돼지식당	한식	1150345	734
	# 00015	만정	중식	12340	20
    # 00004	스시사카우스	일식	1522074	230
    # 00003	따띠따띠뜨	양식	1234023	102
    # 00008	애플우스	분식	15340	151