select customer_id, customer_name from customers a where 1<(select count(*) from orders b where a.customer_id = b.customer_id)
UNION
select salesman_id, salesman_name from salesman a where 1<(select count(*) from orders b where a.salesman_id = b.salesman_id) order by customer_name;

select a.salesman_id, salesman_name, order_no, 'highest on', order_date from salesman a, orders b where a.salesman_id=b.salesman_id and b.purchase_amount=(select max(purchase_amount) from orders c where c.order_date = b.order_date)
UNION
select a.salesman_id, salesman_name, order_no, 'lowest on', order_date from salesman a, orders b where a.salesman_id=b.salesman_id and b.purchase_amount=(select min(purchase_amount) from orders c where c.order_date = b.order_date);
