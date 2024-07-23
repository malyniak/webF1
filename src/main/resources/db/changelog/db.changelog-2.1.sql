--liquibase formatted sql

--changeset Volodymyr Malyniak:1

insert into f1_news  (title, short_text, content)
values ('title1',
        'short_text1',
        'content1');
