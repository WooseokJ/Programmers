-- 코드를 입력하세요

select food_type, rest_id, rest_name, favorites
from rest_info ri
where ri.favorites = (select max(favorites) 
                   from rest_info
                  where ri.food_type = food_type)
group by food_type
order by food_type desc


# REST_INFO
# REST_ID, REST_NAME, FOOD_TYPE, VIEWS, FAVORITES, PARKING_LOT, ADDRESS, TEL
# 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호

