--liquibase formatted sql

--changeset Volodymyr Malyniak:2

insert into users  (username, email, password, phone_number, role)
values ('dev',
        'dev@gmail.com',
        '$2a$12$4ubmFI/Sh2O5rEUBs10yIufkA1PLg0MrfZc95HfO.7d/bkRewa9ru',
        '380986449512',
        2);
