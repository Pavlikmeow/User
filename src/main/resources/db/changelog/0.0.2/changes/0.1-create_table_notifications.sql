CREATE TABLE IF NOT EXISTS users.notifications
(
    id uuid not null
    constraint notifications_pkey primary key,
    message varchar,
    date date,
    user_id uuid
);