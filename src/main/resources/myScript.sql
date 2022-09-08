select c.nameOf, O.product_name, O.price
from CUSTOMERS c
join ORDERS O on c.id = O.customer_id
where lower(c.nameOf) = :nameOf
