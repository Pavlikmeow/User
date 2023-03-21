ALTER TABLE users.users
ADD CONSTRAINT username_unique UNIQUE (username);
ALTER TABLE users.users
ADD CONSTRAINT email_unique UNIQUE (email);