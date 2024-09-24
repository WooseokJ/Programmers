-- 코드를 작성해주세요
select count(fi.fish_type) as fish_count, fni.fish_name
from fish_info as fi left join fish_name_info as fni 
on fi.fish_type = fni.fish_type
group by fi.fish_type, fni.fish_name
order by fish_count desc
;