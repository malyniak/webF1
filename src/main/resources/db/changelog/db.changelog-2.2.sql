--liquibase formatted sql

--changeset Volodymyr Malyniak:1

insert into users  (username, email, password, phone_number, role)
values ('admin',
        'user@gmail.com',
        'password',
                '380986449643',
                1);
