insert into questionArea (id, name) values (1, 'Wzorce Projektowe');
insert into questionArea (id, name) values (2, 'Zarzadzanie Projektem');
insert into questionArea (id, name) values (3, 'Architektura');
insert into questionArea (id, name) values (4, 'Wielowatkowosc');
insert into questionArea (id, name) values (5, 'Messaging');
insert into questionArea (id, name) values (6, 'Bazy danych - jezyk SQL');
insert into questionArea (id, name) values (7, 'Testowanie aplikacji');
insert into questionArea (id, name) values (8, 'Core Java');
insert into questionArea (id, name) values (9, 'Spring');
insert into questionArea (id, name) values (10, 'Hibernate');
insert into questionArea (id, name) values (11, 'Aplikacje Webowe');
insert into questionArea (id, name) values (12, 'Algorytmy');


insert into question (id, text, type, level, area_id, availablePoints) values (1,'Spring question 1', 'SINGLE_CHOICE', 'ADVANCED', 9, 1);
insert into questionOption (id, text, points, question_id) values(1,'Option 1',1,1);
insert into questionOption (id, text, points, question_id) values(2,'Option 2',0,1);
insert into questionOption (id, text, points, question_id) values(3,'Option 3',0,1);


insert into question (id, text, type, level, area_id, availablePoints) values (2,'Spring question 2', 'MULTIPLE_CHOICE', 'ADVANCED', 9, 2);
insert into questionOption (id, text, points, question_id) values(4,'Option 1',1,2);
insert into questionOption (id, text, points, question_id) values(5,'Option 2',0,2);
insert into questionOption (id, text, points, question_id) values(6,'Option 3',1,2);

insert into question (id, text, type, level, area_id, availablePoints) values (3,'Spring question 3', 'SINGLE_CHOICE', 'ADVANCED', 9, 1);
insert into questionOption (id, text, points, question_id) values(7,'Option 1',1,3);
insert into questionOption (id, text, points, question_id) values(8,'Option 2',0,3);
insert into questionOption (id, text, points, question_id) values(9,'Option 3',0,3);

insert into question (id, text, type, level, area_id, availablePoints) values (4,'Spring question 4', 'MULTIPLE_CHOICE', 'ADVANCED', 9, 2);
insert into questionOption (id, text, points, question_id) values(10,'Option 1',1,4);
insert into questionOption (id, text, points, question_id) values(11,'Option 2',0,4);
insert into questionOption (id, text, points, question_id) values(12,'Option 3',0,4);
insert into questionOption (id, text, points, question_id) values(13,'Option 4',1,4);
insert into questionOption (id, text, points, question_id) values(14,'Option 5',0,4);
insert into questionOption (id, text, points, question_id) values(15,'Option 6',0,4);

insert into question (id, text, type, level, area_id, availablePoints) values (5,'Spring question 5', 'SINGLE_CHOICE', 'MID', 9, 1);
insert into questionOption (id, text, points, question_id) values(16,'Option 1',1,5);
insert into questionOption (id, text, points, question_id) values(17,'Option 2',0,5);
insert into questionOption (id, text, points, question_id) values(18,'Option 3',0,5);

insert into question (id, text, type, level, area_id, availablePoints) values (6,'Java Question 1', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(19,'Option 1',1,6);
insert into questionOption (id, text, points, question_id) values(20,'Option 2',0,6);
insert into questionOption (id, text, points, question_id) values(21,'Option 3',0,6);

insert into question (id, text, type, level, area_id, availablePoints) values (7,'Java Question 2', 'MULTIPLE_CHOICE', 'ADVANCED', 8, 2);
insert into questionOption (id, text, points, question_id) values(22,'Option 1',1,7);
insert into questionOption (id, text, points, question_id) values(23,'Option 2',0,7);
insert into questionOption (id, text, points, question_id) values(24,'Option 3',1,7);

insert into question (id, text, type, level, area_id, availablePoints) values (8,'Java Question 3', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(25,'Option 1',1,8);
insert into questionOption (id, text, points, question_id) values(26,'Option 2',0,8);
insert into questionOption (id, text, points, question_id) values(27,'Option 3',0,8);

insert into question (id, text, type, level, area_id, availablePoints) values (9,'Java Question 4', 'MULTIPLE_CHOICE', 'MID', 8, 3);
insert into questionOption (id, text, points, question_id) values(28,'Option 1',1,9);
insert into questionOption (id, text, points, question_id) values(29,'Option 2',1,9);
insert into questionOption (id, text, points, question_id) values(30,'Option 3',1,9);

insert into question (id, text, type, level, area_id, availablePoints) values (10,'Java Question 5', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(31,'Option 1',1,10);
insert into questionOption (id, text, points, question_id) values(32,'Option 2',0,10);
insert into questionOption (id, text, points, question_id) values(33,'Option 3',0,10);

insert into question (id, text, type, level, area_id, availablePoints) values (11,'Hibernate Question 1', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(34,'Option 1',1,11);
insert into questionOption (id, text, points, question_id) values(35,'Option 2',0,11);
insert into questionOption (id, text, points, question_id) values(36,'Option 3',0,11);

insert into question (id, text, type, level, area_id, availablePoints) values (12,'Hibernate Question 2', 'MULTIPLE_CHOICE', 'MID', 10, 2);
insert into questionOption (id, text, points, question_id) values(37,'Option 1',1,12);
insert into questionOption (id, text, points, question_id) values(38,'Option 2',1,12);
insert into questionOption (id, text, points, question_id) values(39,'Option 3',0,12);

insert into question (id, text, type, level, area_id, availablePoints) values (13,'Hibernate Question 3', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(40,'Option 1',1,13);
insert into questionOption (id, text, points, question_id) values(41,'Option 2',0,13);
insert into questionOption (id, text, points, question_id) values(42,'Option 3',0,13);

insert into question (id, text, type, level, area_id, availablePoints) values (14,'Hibernate question 4', 'MULTIPLE_CHOICE', 'ADVANCED', 10, 2);
insert into questionOption (id, text, points, question_id) values(43,'Option 1',1,14);
insert into questionOption (id, text, points, question_id) values(44,'Option 2',1,14);
insert into questionOption (id, text, points, question_id) values(45,'Option 3',0,14);

insert into question (id, text, type, level, area_id, availablePoints) values (15,'Hibernate question 5', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(46,'Option 1',1,15);
insert into questionOption (id, text, points, question_id) values(47,'Option 2',0,15);
insert into questionOption (id, text, points, question_id) values(48,'Option 3',0,15);

