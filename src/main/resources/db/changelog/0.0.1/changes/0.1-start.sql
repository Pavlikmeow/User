CREATE SCHEMA IF NOT EXISTS users;
CREATE TABLE IF NOT EXISTS users.users
(
    id uuid not null
    constraint users_pkey primary key,
    username varchar,
    password varchar,
    email varchar,
    balance int,
    is_frozen boolean
);