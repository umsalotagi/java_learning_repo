use TestDB;

# for this AUTO_INCREMENT, we use INDENTITY in JPA
create table employee(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

# for TABLE Generation and Generic sutom generator type use are removing AUTO_INCREMENT
create table employee(
id int PRIMARY KEY,
name varchar(20)
);


drop table employee;

drop table id_gen;

select * from employee;

# tabel for TABLE generation type
create table id_gen(
gen_name VARCHAR(60) PRIMARY KEY,
gen_val	int(20)
);

select * from id_gen;