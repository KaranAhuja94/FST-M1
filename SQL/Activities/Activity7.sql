select sum(purchase_amount) as "Total Purchase Amount" from orders 

select avg(purchase_amount) as "Average Purchase Amount" from orders 

select max(purchase_amount) as "Maximum Purchase Amount" from orders 

select min(purchase_amount) as "Purchase Amount" from orders

select count(distinct salesman_id) from orders