--liquibase formatted sql

--changeset Volodymyr Malyniak:1

insert into team  (boss, name, engine)
values ('Christian Horner',
        'Oracle Red Bull Racing',
        'Honda RBPT'),

       ('Toto Wolff',
        'Mercedes-AMG PETRONAS',
        'Mercedes'),

       ('Frederic Vasseur',
        'Scuderia Ferrari',
        'Ferrari'),

       ('Andrea Stella',
        'McLaren',
        'Mercedes'),

       ('Mike Krack',
        'Aston Martin Aramco',
        'Mercedes'),

       ('Bruno Famin',
        'BWT Alpine',
        'Renault'),

       ('Laurent Mekies',
        'Visa Cash App RB',
        'Honda RBPT'),

       ('Ayao Komatsu',
        'MoneyGram Haas',
        'Ferrari'),

       ('James Vowles',
        'Williams Racing',
        'Mercedes'),

       ('Alessandro Alunni Bravi',
        'Stake Kick Sauber',
        'Ferrari');



--changeset Volodymyr Malyniak:2
insert into car (number, team)
values (1, 1),
       (11, 1),
       (44, 2),
       (63, 2),
       (16, 3),
       (55, 3),
       (4, 4),
       (81, 4),
       (14, 5),
       (18, 5),
       (10, 6),
       (31, 6),
       (22, 7),
       (3, 7),
       (27, 8),
       (20, 8),
       (23, 9),
       (2, 9),
       (77, 10),
       (24, 10);


--changeset Volodymyr Malyniak:3
insert into driver (firstname, lastname, birthdate, nationality, height, weight, car_number, team, driver_status)
values ('Max ', 'Verstappen', '1997-09-30', 'Netherlands', 180,
        81, 1, 1, 1),
       ('Sergio', 'Perez', '1990-01-26', 'Mexico', 173,
        63, 11, 1, 1),
       ('Lewis', 'Hamilton', '1985-01-07', 'England', 175,
        66, 44, 2, 1),
       ('George', 'Russell', '1998-02-15', 'England', 185,
        70, 63, 2, 1),
       ('Charles', 'Leclerc', '1997-10-16', 'Monaco', 180,
        69, 16, 3, 1),
       ('Carlos', 'Sainz', '1994-09-01', 'Spain', 178,
        66, 55, 3, 1),
       ('Lando', 'Norris', '1999-11-13', 'England', 170,
        68, 4, 4, 1),
       ('Oscar', 'Piastri', '2001-04-06', 'Australia', 178,
        68, 81, 4, 1),
       ('Fernando', 'Alonso', '1981-07-29', 'Spain', 171,
        68, 14, 5, 1),
       ('Lance', 'Stroll', '1998-10-29', 'Canada', 182,
        70, 18, 5, 1),
        ('Pierre', 'Gasly', '1996-02-07', 'France', 177,
        70, 10, 6, 1),
       ('Esteban', 'Ocon', '1996-09-17', 'France', 186,
        66, 31, 6, 1),
       ('Yuki', 'Tsunoda', '2000-02-11', 'Japan', 159,
        54, 22, 7, 1),
       ('Daniel', 'Ricciardo', '1989-07-01', 'Australia', 179,
        66, 3, 7, 1),
       ('Nico', 'Hulkenberg', '1987-08-19', 'Germany', 184,
        78, 27, 8, 1),
       ('Kevin', 'Magnussen', '1992-10-05', 'Denmark', 174,
        68, 20, 8, 1),
       ('Alexander', 'Albon', '1996-03-23', 'Thailand', 186,
        73, 23, 9, 1),
       ('Logan', 'Sargeant', '2000-12-31', 'United States', 181,
        71, 2, 9, 1),
       ('Valtteri', 'Bottas', '1989-08-28', 'Finland', 173,
        69, 77, 10, 1),
       ('Zhou', 'Guanyu', '1999-05-30', 'China', 176,
        63, 24, 10, 1);

--changeset Volodymyr Malyniak:4
insert into contract (driver, team, salary, last_year)
values (1, 1, 55, 2028),
       (2, 1, 14, 2026),
       (3, 2, 45, 2024),
       (4, 2, 18, 2025),
       (5, 3, 34, 2028),
       (6, 3, 12, 2024),
       (7, 4, 20, 2025),
       (8, 4, 6, 2026),
       (9, 5, 18, 2024),
       (10, 5, 3, 2024),
       (11, 6, 6, 2024),
       (12, 6, 6, 2024),
       (13, 7, 1, 2024),
       (14, 7, 7, 2024),
       (15, 8, 2, 2024),
       (16, 8, 5, 2024),
       (17, 9, 3, 2024),
       (18, 9, 1, 2025),
       (19, 10, 10, 2024),
       (20, 10, 2, 2024);
