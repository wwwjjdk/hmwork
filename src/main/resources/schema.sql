create table CUSTOMERS
(
    id           int primary key not null,
    nameOf       varchar(20)     not null default 'неизвестен',
    lastname     varchar(20)     not null default 'неизвестен',
    age          int check ( age > 0 ),
    phone_number varchar(20)     not null default '-'
);

create table ORDERS
(
    id           serial primary key not null,
    dateOf       datetime                    default now() not null,
    customer_id  int                not null,
    product_name varchar(20)        not null default 'неизвестен',
    price        int check ( price > 0 ),
    foreign key (customer_id) references CUSTOMERS (id)
);