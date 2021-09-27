select a.customer_name,a.city,b.salesman_name from customers a inner join salesman b on a.salesman_id = b.salesman_id

select a.customer_name, a.city, a.grade, b.salesman_name, b.salesman_city from customers a left outer join salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 order by a.customer_id;

select a.customer_name,a.city,b.salesman_name from customers a inner join salesman b on a.salesman_id = b.salesman_id where b.commission>12

select a.order_no, a.order_date, a.purchase_amount, b.customer_name, b.grade, c.salesman_name, c.commission from orders a inner join customers b ON a.customer_id=b.customer_id 
inner join salesman c ON a.salesman_id=c.salesman_id;