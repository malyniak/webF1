--liquibase formatted sql

--changeset Volodymyr Malyniak:1

ALTER TABLE driver
    ADD COLUMN created_by VARCHAR(255),
    ADD COLUMN last_updated_by VARCHAR(255);