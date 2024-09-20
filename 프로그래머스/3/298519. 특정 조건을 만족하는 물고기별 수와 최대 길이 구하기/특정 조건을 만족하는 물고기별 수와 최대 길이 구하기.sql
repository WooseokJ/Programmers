select count(fish_type) as fish_count, max(length) as max_length, fish_type
from  fish_info
group by FISH_TYPE
having avg(ifnull(length, 10)) >= 33

order by FISH_TYPE
;