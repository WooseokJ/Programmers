-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where (food_type, FAVORITES) in (
                select food_type, max(favorites)
                from rest_info
                group by food_type)
# group by FOOD_TYPE

order by FOOD_TYPE desc
;
