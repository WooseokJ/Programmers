-- 코드를 작성해주세요
select ii.item_id, ii.item_name, ii.rarity
from ITEM_INFO as ii join item_tree as it
on ii.item_id = it.item_id
where it.item_id not in(select PARENT_ITEM_ID
                       from item_tree
                       where PARENT_ITEM_ID is not null
                       group by PARENT_ITEM_ID)
order by ii.item_id desc
;