insert into course(id, name) values(10001, 'jpa learning');
insert into course(id, name) values(10002, 'hibernate learning');
insert into course(id, name) values(10003, 'spring learning');

insert into passport(id,number) values(40001, 'E2987');
insert into passport(id,number) values(40002, 'J7898');
insert into passport(id,number) values(40003, 'K0973');

insert into student(id,name, passport_id) values(20001, 'Navneet' ,40001);
insert into student(id,name, passport_id) values(20002, 'Shubham' ,40002);
insert into student(id,name, passport_id) values(20003, 'Gautam', 40003);



insert into review(id,rating, description, course_id) values(50001,'5', 'Great Course',10001);
insert into review(id,rating, description, course_id) values(50002,'4', 'Wonderful Course',10001);
insert into review(id,rating, description, course_id) values(50003,'3', 'Average Course',10003);

insert into student_course(student_id, course_id) values(20001,10001);
insert into student_course(student_id, course_id) values(20003,10001);
insert into student_course(student_id, course_id) values(20002,10001);
insert into student_course(student_id, course_id) values(20001,10002);
