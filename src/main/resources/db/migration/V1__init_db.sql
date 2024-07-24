CREATE SEQUENCE IF NOT EXISTS seq_note_id
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS note
(
    id   BIGINT DEFAULT nextval('seq_note_id'),
    title VARCHAR(200),
    content TEXT,
    CONSTRAINT pk_note_id PRIMARY KEY (id)
);