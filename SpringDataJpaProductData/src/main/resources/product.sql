use TestDB;

create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

select * from product;
drop table product;

insert into PRODUCT values(1, "iWatch", "From Apple Inc.", 400);
insert into PRODUCT values(2, "TV", "From Samsung Inc.", 1000);
insert into PRODUCT values(3, "Washer", "From LG Inc.", 2000);
insert into PRODUCT values(4, "Dryer", "From LG Inc.", 1500);

create table student(
id int PRIMARY KEY auto_increment,
lname varchar(20),
fname varchar(20),
score int
);

select * from student;