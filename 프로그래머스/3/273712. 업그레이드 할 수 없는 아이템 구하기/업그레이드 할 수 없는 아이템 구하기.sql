-- 코드를 작성해주세요
select item_id, item_name, RARITY
from ITEM_INFO 
where item_id not in ( 
    select PARENT_ITEM_ID
    from ITEM_TREE 
    where PARENT_ITEM_ID is not null
    
)

order by item_id desc
;

# ITEM_INFO
# ITEM_ID, ITEM_NAME, RARITY, PRIC
# 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격

# ITEM_TREE
# ITEM_ID, PARENT_ITEM_ID
# 아이템 ID, PARENT 아이템의 ID

# 0 -> 1,2
# 업글 못하려면 -> parent_item_id가 0, Null 이 아님.

