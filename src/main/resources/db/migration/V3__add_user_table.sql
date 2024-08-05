CREATE SEQUENCE IF NOT EXISTS seq_user_id
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS users
(
    id   BIGINT DEFAULT nextval('seq_user_id'),
    username VARCHAR(200),
    password VARCHAR(250),
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);