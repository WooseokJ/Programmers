-- 코드를 작성해주세요
select ii.item_id, ii.item_name, ii.rarity
from item_info as ii join item_tree as it
on ii.item_id = it.item_id
where it.item_id not in (select coalesce(PARENT_ITEM_ID, 0) 
                         from item_tree 
                         

                         group by PARENT_ITEM_ID
                    ) 
order by ii.item_id desc
;
-- null 0 1 