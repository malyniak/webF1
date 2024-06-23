--liquibase formatted sql

--changeset Volodymyr Malyniak:1
CREATE TABLE IF NOT EXISTS Team (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    boss VARCHAR(255) UNIQUE NOT NULL,
                                    name VARCHAR(255) UNIQUE NOT NULL ,
                                    engine VARCHAR(255) NOT NULL

);

--changeset Volodymyr Malyniak:2
CREATE TABLE IF NOT EXISTS Car (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   number INT UNIQUE NOT NULL ,
                                   team INT NOT NULL ,
                                   FOREIGN KEY (team) references Team(id)
);


--changeset Volodymyr Malyniak:3
CREATE TABLE IF NOT EXISTS Driver (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    firstname VARCHAR(255) NOT NULL,
                                    lastname VARCHAR(255) NOT NULL,
                                    birthdate DATE,
                                    nationality VARCHAR(255),
                                    height INT NOT NULL ,
                                    weight INT NOT NULL ,
                                    car_number INT,
                                    driver_status INT,
                                    FOREIGN KEY (car_number) REFERENCES Car(number),
                                    team INT,
                                    FOREIGN KEY (team) REFERENCES Team(id)
);

--changeset Volodymyr Malyniak:4
CREATE TABLE IF NOT EXISTS Contract (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    driver INT,
                                    team INT,
                                    salary INT,
                                    last_year INT,
                                    FOREIGN KEY (driver) REFERENCES Driver(id),
                                    FOREIGN KEY (team) REFERENCES Team(id)
);

