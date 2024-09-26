-- 코드를 입력하세요
# SELECT round(price / 10000) * 10000 as PRICE_GROUP, count(product_id) as PRODUCTS
select truncate(price, -4) as PRICE_GROUP, count(product_id) as PRODUCTS
from product
group by PRICE_GROUP

order by price


# order by PRICE_GROUP 




;

# 15000
# 19000
# 21000
# 22000
# 31000
# 32000
# 35000
# 42000
# 42000
# 46000
# 46000
# 51000
# 51000
# 51000
# 54000
# 54000
# 55000
# 60000
# 60000
# 61000
# 62000
# 63000
# 65000
# 65000
# 72000
# 72000
# 80000
# 80000
# 82000
# 85000