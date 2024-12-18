-- 코드를 입력하세요
SELECT count(*) as users
from USER_INFO
where year(joined) = 2021 and age between 20 and 29
;