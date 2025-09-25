# Write your MySQL query statement below
select unique_id, name
from Employees A
Left join EmployeeUNI B 
ON
A.id = B.id;