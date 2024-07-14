--liquibase formatted sql

--changeset Volodymyr Malyniak:1
CREATE TABLE IF NOT EXISTS team (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    boss VARCHAR(255) UNIQUE NOT NULL,
                                    name VARCHAR(255) UNIQUE NOT NULL ,
                                    engine VARCHAR(255) NOT NULL

);

--changeset Volodymyr Malyniak:2
CREATE TABLE IF NOT EXISTS car (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   number INT UNIQUE NOT NULL ,
                                   team INT NOT NULL,
                                   FOREIGN KEY (team) references team(id)
);


--changeset Volodymyr Malyniak:3
CREATE TABLE IF NOT EXISTS driver (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    firstname VARCHAR(255) NOT NULL,
                                    lastname VARCHAR(255) NOT NULL,
                                    birthdate DATE,
                                    nationality VARCHAR(255),
                                    height INT NOT NULL ,
                                    weight INT NOT NULL ,
                                    car_number INT,
                                    driver_status INT,
                                    FOREIGN KEY (car_number) REFERENCES car(number),
                                    team INT,
                                    FOREIGN KEY (team) REFERENCES team(id)
);

--changeset Volodymyr Malyniak:4
CREATE TABLE IF NOT EXISTS contract (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    driver INT,
                                    team INT,
                                    salary INT,
                                    last_year INT,
                                    FOREIGN KEY (driver) REFERENCES driver(id),
                                    FOREIGN KEY (team) REFERENCES team(id)
);

