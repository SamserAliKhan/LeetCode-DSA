# Write your MySQL query statement below
select product_name, year, price
from Sales A
Left join Product B
on
A.product_id = B.product_id;