-- 코드를 입력하세요
SELECT ingredient_type , sum(total_order) as total_order
from ICECREAM_INFO as ii join first_half as fh
on ii.flavor = fh.flavor
group by INGREDIENT_TYPE
order by total_order
;

