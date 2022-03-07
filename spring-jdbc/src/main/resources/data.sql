-- DDL : Data Definition lamguage
-- schema.sql will also do

CREATE SEQUENCE PERSON_SEQUENCE_ID START WITH (select max(ID) + 1 from PERSON);

INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());
INSERT INTO person VALUES ( 10004, 'Umesh', 'Solapur', sysdate() );