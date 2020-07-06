insert into course(id,name)values(10001,'JPA in 50 steps');
insert into course(id,name)values(10002,'Spring in 50 steps');
insert into course(id,name)values(10003,'SpringBoot in 50 steps');


insert into passport(id,number)values(40001,'E123456');
insert into passport(id,number)values(40002,'N123457');
insert into passport(id,number)values(40003,'L123890');

insert into student(id,name,passport_id)values(20001,'Jiya',40001);
insert into student(id,name,passport_id)values(20002,'Khushi',40002);
insert into student(id,name,passport_id)values(20003,'Divya',40003);

insert into review(id,rating,description,course_id)values(50001,'5','Great Course',10001);
insert into review(id,rating,description,course_id)values(50002,'3','Good course',10001);
insert into review(id,rating,description,course_id)values(50003,'5','Awesome Course',10003);