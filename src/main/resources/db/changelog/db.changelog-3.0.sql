--liquibase formatted sql

--changeset Volodymyr Malyniak:1


ALTER TABLE contract
    ADD CONSTRAINT contract_ibfk_1
        FOREIGN KEY (driver) REFERENCES driver(id)
            ON DELETE CASCADE;