--liquibase formatted sql

--changeset Volodymyr Malyniak:1
CREATE TABLE IF NOT EXISTS users
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    username     VARCHAR(128),
    email        VARCHAR(128) UNIQUE NOT NULL,
    phone_number VARCHAR(16) UNIQUE  NOT NULL,
    password     VARCHAR(128) NOT NULL,
    role         TINYINT NOT NULL
);
