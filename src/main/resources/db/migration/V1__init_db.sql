CREATE SEQUENCE IF NOT EXISTS seq_notes_id
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS seq_users_id
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS seq_roles_id
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS users
(
    id   BIGINT DEFAULT nextval('seq_users_id'),
    username VARCHAR(100),
    password VARCHAR(100),
    CONSTRAINT pk_users_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS notes
(
    id   BIGINT DEFAULT nextval('seq_notes_id'),
    title VARCHAR(200),
    content TEXT,
    CONSTRAINT pk_notes_id PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS roles
(
    id BIGINT DEFAULT nextval('seq_roles_id'),
    name VARCHAR(250),
    CONSTRAINT pk_roles_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_roles
(
    users_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    PRIMARY KEY (users_id,roles_id),
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
)

