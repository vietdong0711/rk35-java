create database if not exists finalexam1;

create table candidate(
	id int primary key auto_increment,
    fisrtname varchar(50),
    lastname varchar(50),
    phone varchar(14),
    email varchar(50),
    `password` varchar(50),
    exp_in_year int,
    pro_skill varchar(50),
    GraduationRank varchar(50),
    `role` varchar(50)
);