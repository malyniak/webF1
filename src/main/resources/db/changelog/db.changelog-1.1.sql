--liquibase formatted sql

--changeset Volodymyr Malyniak:1
CREATE TABLE IF NOT EXISTS f1_news
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(256) UNIQUE   NOT NULL,
    short_text VARCHAR(1028) UNICODE NOT NULL,
    content    TEXT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by BIGINT,
    last_updated_by BIGINT
);
