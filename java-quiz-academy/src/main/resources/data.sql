insert into quizUserRole (id, authority) values (1, 'ROLE_ADMIN');
insert into quizUserRole (id, authority) values (2, 'ROLE_USER');

insert into quizUser (id, name, email, password) values (1, 'Administrator', 'admin', '$2a$10$LgANaJAQD9NIeUem5AXdLuPD90VX/dDCjTLZARLVDeaL0LhDYIzIa');
insert into quizUser (id, name, email, password) values (2, 'Waldek', 'test', '$2a$10$pZYb5IGsCAWCOIKH4VhnKeO.AtkG9zpAmlEwFOC2k8OvYdICBSFcO');

insert into user_roles (user_id, role_id) values (1,1);
insert into user_roles (user_id, role_id) values (1,2);
insert into user_roles (user_id, role_id) values (2,2);

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


insert into question (id, text, type, level, area_id, availablePoints) values (1,'Skrot DI oznacza:', 'SINGLE_CHOICE', 'ADVANCED', 9, 1);
insert into questionOption (id, text, points, question_id) values(1,'Dependency Inversion',0,1);
insert into questionOption (id, text, points, question_id) values(2,'Dependency Injection',1,1);
insert into questionOption (id, text, points, question_id) values(3,'Dependency Intelligent',0,1);

insert into question (id, text, type, level, area_id, availablePoints) values (2,'Jakie sa bean scope w Springu?', 'MULTIPLE_CHOICE', 'ADVANCED', 9, 2);
insert into questionOption (id, text, points, question_id) values(4,'singleton',1,2);
insert into questionOption (id, text, points, question_id) values(5,'global-singleton',0,2);
insert into questionOption (id, text, points, question_id) values(6,'prototype',1,2);

insert into question (id, text, type, level, area_id, availablePoints) values (3,'Jaki jest domyslny bean scope w Springu?', 'SINGLE_CHOICE', 'ADVANCED', 9, 1);
insert into questionOption (id, text, points, question_id) values(7,'request',0,3);
insert into questionOption (id, text, points, question_id) values(8,'singleton',1,3);
insert into questionOption (id, text, points, question_id) values(9,'prototype',0,3);

insert into question (id, text, type, level, area_id, availablePoints) values (4,'Aby zintegrowac testy jednostkowe JUnit z kontenerem springowym nalezy:', 'MULTIPLE_CHOICE', 'ADVANCED', 9, 2);
insert into questionOption (id, text, points, question_id) values(10,'Skorzystac z adnotacji @RunWith oraz jako argument podajac runner springowy dla Junita.',1,4);
insert into questionOption (id, text, points, question_id) values(11,'Za pomoca adnotacji @ContextConfiguration wskazac konfiguracje kontekstu springowego',1,4);
insert into questionOption (id, text, points, question_id) values(12,'Za pomoca adnotacji @ContextLocation wskazac konfiguracje kontekstu springowego',0,4);
insert into questionOption (id, text, points, question_id) values(13,'Skorzystac z adnotacji @BeforeClass ktora zainicjalizuje nam kontekst aplikacji',0,4);
insert into questionOption (id, text, points, question_id) values(14,'Nic nie trzeba robic, Junit automatycznie integruje sie ze springiem.',0,4);

insert into question (id, text, type, level, area_id, availablePoints) values (5,'W Springu MVC role Front-Controllera pelni:', 'SINGLE_CHOICE', 'MID', 9, 1);
insert into questionOption (id, text, points, question_id) values(16,'ProxyServlet',0,5);
insert into questionOption (id, text, points, question_id) values(17,'DispatcherFilter',0,5);
insert into questionOption (id, text, points, question_id) values(18,'DispatcherServlet',1,5);

insert into question (id, text, type, level, area_id, availablePoints) values (6,'Heap to miejsce pamieci w ktorym:', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(19,'Przechowujemy wszystkie obiekty',1,6);
insert into questionOption (id, text, points, question_id) values(20,'Przechowujemy wszystkie wywolania metod',0,6);
insert into questionOption (id, text, points, question_id) values(21,'Przechowujemy wszystkie instrukcje warunkowe',0,6);

insert into question (id, text, type, level, area_id, availablePoints) values (7,'Ktore z ponizszych to implementacje java.util.List?', 'MULTIPLE_CHOICE', 'ADVANCED', 8, 2);
insert into questionOption (id, text, points, question_id) values(22,'ArrayList',1,7);
insert into questionOption (id, text, points, question_id) values(23,'LinkedList',1,7);
insert into questionOption (id, text, points, question_id) values(24,'SortedList',0,7);

insert into question (id, text, type, level, area_id, availablePoints) values (8,'Ktore z ponizszych to implementacje java.util.Set?', 'MULTIPLE_CHOICE', 'ADVANCED', 8, 3);
insert into questionOption (id, text, points, question_id) values(25,'HashSet',1,8);
insert into questionOption (id, text, points, question_id) values(26,'LinkedHashSet',1,8);
insert into questionOption (id, text, points, question_id) values(27,'TreeSet',1,8);

insert into question (id, text, type, level, area_id, availablePoints) values (9,'Co domyslnie robi metoda equals w klasie Object?', 'SINGLE_CHOICE', 'MID', 8, 1);
insert into questionOption (id, text, points, question_id) values(28,'Porownuje wartosci wszystkich pol klasy',0,9);
insert into questionOption (id, text, points, question_id) values(29,'Zwraca zawsze false',0,9);
insert into questionOption (id, text, points, question_id) values(30,'Porownuje referencje dwoch obiektow',1,9);

insert into question (id, text, type, level, area_id, availablePoints) values (10,'Co domyslnie zwraca metoda hashCode z klasy Object?', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(31,'Zwraca numer komorki pamieci w ktorej znajduje sie obiekt',1,10);
insert into questionOption (id, text, points, question_id) values(32,'Zwraca numer instancji obiektu',0,10);
insert into questionOption (id, text, points, question_id) values(33,'Zwraca date stworzenia obiektu w postaci milisekund',0,10);

insert into question (id, text, type, level, area_id, availablePoints) values (11,'Jakiego interfejsu J2EE Hibernate jest implementacja?', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(34,'JPA',1,11);
insert into questionOption (id, text, points, question_id) values(35,'JAAS',0,11);
insert into questionOption (id, text, points, question_id) values(36,'JTA',0,11);

insert into question (id, text, type, level, area_id, availablePoints) values (12,'Minimalny zbior adnotacji ktory jest potrzeby aby stworzyc encje w Hibernate to:', 'SINGLE_CHOICE', 'MID', 10, 1);
insert into questionOption (id, text, points, question_id) values(37,'@Entity, @Id',1,12);
insert into questionOption (id, text, points, question_id) values(38,'@Entity, @Table, @Id',0,12);
insert into questionOption (id, text, points, question_id) values(39,'@Entity, @Id, @GeneratedValue',0,12);

insert into question (id, text, type, level, area_id, availablePoints) values (13,'N+1 Problem dotoczy:', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(40,'Generowania zbyt duzej ilosci zapytan do bazy danych',1,13);
insert into questionOption (id, text, points, question_id) values(41,'Zwracaniem zbyt duzej ilosci obiektow w wyniku',0,13);
insert into questionOption (id, text, points, question_id) values(42,'Nadmiarem kolumn w bazie danych',0,13);

insert into question (id, text, type, level, area_id, availablePoints) values (14,'Jakie sa strategie dziedziczenia obiektow w Hibernate?', 'MULTIPLE_CHOICE', 'ADVANCED', 10, 2);
insert into questionOption (id, text, points, question_id) values(43,'Pojedyncza tabela dla calej hierarchii obiektu: Single table',1,14);
insert into questionOption (id, text, points, question_id) values(44,'Kazdy obiekt z hierarchii posiada swoja tabele w bazie: Table per class',1,14);
insert into questionOption (id, text, points, question_id) values(45,'W hibernate nie da sie mapowac dziedziczenia',0,14);

insert into question (id, text, type, level, area_id, availablePoints) values (15,'First Level Cache w hibernate:', 'SINGLE_CHOICE', 'ADVANCED', 10, 1);
insert into questionOption (id, text, points, question_id) values(46,'nie mozna go wylaczyc',1,15);
insert into questionOption (id, text, points, question_id) values(47,'jest miedzysesyjny',0,15);
insert into questionOption (id, text, points, question_id) values(48,'implementuje go hazelcast',0,15);

insert into question (id, text, type, level, area_id, availablePoints) values (16,'Aby stworzyc relacje many-to-many w hibernate nalezy:', 'MULTIPLE_CHOICE', 'ADVANCED', 10, 3);
insert into questionOption (id, text, points, question_id) values(49,'Oznaczyc kolekcje adnotacja @ManyToMany',1,16);
insert into questionOption (id, text, points, question_id) values(50,'Stworzyc mapowanie tabeli asocjacyjnej za pomoca adnotacji @JoinTable',1,16);
insert into questionOption (id, text, points, question_id) values(51,'W Adnotacji @JoinTable nalezy podac klucze glowne z obu stron asocjacji',1,16);

insert into question (id, text, type, level, area_id, availablePoints) values (17,'Eden to obszar pamieci:', 'MULTIPLE_CHOICE', 'ADVANCED', 8, 2);
insert into questionOption (id, text, points, question_id) values(52,'Nalezacy do sterty',1,17);
insert into questionOption (id, text, points, question_id) values(53,'Nalezacy do stosu',0,17);
insert into questionOption (id, text, points, question_id) values(54,'Przestrzen do ktorej trafiaja wszystkie nowo stworzone obiekty',1,17);

insert into question (id, text, type, level, area_id, availablePoints) values (18,'Czy final zapobiega dodawaniu lub usuwaniu elementow na ArrayList?', 'SINGLE_CHOICE', 'ADVANCED', 8, 1);
insert into questionOption (id, text, points, question_id) values(55,'Tak',0,18);
insert into questionOption (id, text, points, question_id) values(56,'Nie',1,18);



insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (19,'Pytanie niezatwierdzone przez administratora numer 1', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(57,'Tak',0,19);
insert into questionOption (id, text, points, question_id) values(58,'Nie',1,19);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (20,'Pytanie niezatwierdzone przez administratora numer 2', 'SINGLE_CHOICE', 'JUNIOR', 4, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(59,'Tak',0,20);
insert into questionOption (id, text, points, question_id) values(60,'Nie',1,20);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (21,'Pytanie niezatwierdzone przez administratora numer 3', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(61,'Tak',0,21);
insert into questionOption (id, text, points, question_id) values(62,'Nie',1,21);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (22,'Pytanie niezatwierdzone przez administratora numer 4', 'SINGLE_CHOICE', 'ADVANCED', 9, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(63,'Tak',0,22);
insert into questionOption (id, text, points, question_id) values(64,'Nie',1,22);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (23,'Pytanie niezatwierdzone przez administratora numer 5', 'SINGLE_CHOICE', 'JUNIOR', 7, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(65,'Tak',0,23);
insert into questionOption (id, text, points, question_id) values(66,'Nie',1,23);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (24,'Pytanie niezatwierdzone przez administratora numer 6', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(67,'Tak',0,24);
insert into questionOption (id, text, points, question_id) values(68,'Nie',1,24);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (25,'Pytanie niezatwierdzone przez administratora numer 7', 'SINGLE_CHOICE', 'ADVANCED', 5, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(69,'Tak',0,25);
insert into questionOption (id, text, points, question_id) values(70,'Nie',1,25);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (26,'Pytanie niezatwierdzone przez administratora numer 8', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(71,'Tak',0,26);
insert into questionOption (id, text, points, question_id) values(72,'Nie',1,26);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (27,'Pytanie niezatwierdzone przez administratora numer 9', 'SINGLE_CHOICE', 'ADVANCED', 5, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(73,'Tak',0,27);
insert into questionOption (id, text, points, question_id) values(74,'Nie',1,27);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (28,'Pytanie niezatwierdzone przez administratora numer 10', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(75,'Tak',0,28);
insert into questionOption (id, text, points, question_id) values(76,'Nie',1,28);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (29,'Pytanie niezatwierdzone przez administratora numer 11', 'SINGLE_CHOICE', 'ADVANCED', 9, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(77,'Tak',0,29);
insert into questionOption (id, text, points, question_id) values(78,'Nie',1,29);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (30,'Pytanie niezatwierdzone przez administratora numer 12', 'SINGLE_CHOICE', 'JUNIOR', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(79,'Tak',0,30);
insert into questionOption (id, text, points, question_id) values(80,'Nie',1,30);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (31,'Pytanie niezatwierdzone przez administratora numer 13', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(81,'Tak',0,31);
insert into questionOption (id, text, points, question_id) values(82,'Nie',1,31);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (32,'Pytanie niezatwierdzone przez administratora numer 14', 'SINGLE_CHOICE', 'ADVANCED', 2, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(83,'Tak',0,32);
insert into questionOption (id, text, points, question_id) values(84,'Nie',1,32);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (33,'Pytanie niezatwierdzone przez administratora numer 15', 'SINGLE_CHOICE', 'ADVANCED', 3, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(85,'Tak',0,33);
insert into questionOption (id, text, points, question_id) values(86,'Nie',1,33);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (34,'Pytanie niezatwierdzone przez administratora numer 16', 'SINGLE_CHOICE', 'JUNIOR', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(87,'Tak',0,34);
insert into questionOption (id, text, points, question_id) values(88,'Nie',1,34);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (35,'Pytanie niezatwierdzone przez administratora numer 17', 'SINGLE_CHOICE', 'ADVANCED', 4, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(89,'Tak',0,35);
insert into questionOption (id, text, points, question_id) values(90,'Nie',1,35);
insert into question (id, text, type, level, area_id, availablePoints, user_id, active) values (36,'Pytanie niezatwierdzone przez administratora numer 18', 'SINGLE_CHOICE', 'ADVANCED', 8, 1, 2, 0);
insert into questionOption (id, text, points, question_id) values(91,'Tak',0,36);
insert into questionOption (id, text, points, question_id) values(92,'Nie',1,36);

