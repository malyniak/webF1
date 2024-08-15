--liquibase formatted sql

--changeset Volodymyr Malyniak:1

ALTER TABLE driver
    ADD COLUMN created_at TIMESTAMP,
    ADD COLUMN last_updated_at TIMESTAMP;