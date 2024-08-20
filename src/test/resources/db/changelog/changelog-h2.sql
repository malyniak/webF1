--liquibase formatted sql

--changeset Volodymyr Malyniak:1
CREATE TABLE IF NOT EXISTS team (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    boss VARCHAR(255) UNIQUE NOT NULL,
                                    name VARCHAR(255) UNIQUE NOT NULL ,
                                    engine VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS car (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   number INT UNIQUE NOT NULL ,
                                   team INT NOT NULL,
                                   FOREIGN KEY (team) references team(id)
);



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
                                      FOREIGN KEY (car_number) REFERENCES car(number) ON UPDATE CASCADE ,
                                      team INT,
                                      FOREIGN KEY (team) REFERENCES team(id)
);

CREATE TABLE IF NOT EXISTS contract (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        driver INT,
                                        team INT,
                                        salary INT,
                                        last_year INT,
                                        FOREIGN KEY (driver) REFERENCES driver(id) ON DELETE CASCADE ,
                                        FOREIGN KEY (team) REFERENCES team(id)
);

CREATE TABLE IF NOT EXISTS f1_news
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(256) UNIQUE   NOT NULL,
    short_text VARCHAR(1028)  NOT NULL,
    content    TEXT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by BIGINT,
    last_updated_by BIGINT
);

CREATE TABLE IF NOT EXISTS users
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    username     VARCHAR(128),
    email        VARCHAR(128) UNIQUE NOT NULL,
    phone_number VARCHAR(16) UNIQUE  NOT NULL,
    password     VARCHAR(128) NOT NULL,
    role         TINYINT NOT NULL
);
