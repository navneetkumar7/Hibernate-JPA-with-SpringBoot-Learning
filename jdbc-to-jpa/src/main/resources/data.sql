/*
create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);
*/
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'NAVNEET', 'GURGAON', '2000-01-01 12:00:00.000');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'Rahul', 'Delhi', '2001-01-01 12:00:00.000');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'Shally', 'Mumbai', '2002-01-01 12:00:00.000');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10004, 'Shally', 'California', '2003-01-01 12:00:00.000');