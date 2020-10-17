CREATE TABLE technical_user (
    id BIGSERIAL NOT NULL,
    username VARCHAR(250),
    password VARCHAR(512),
    active BOOLEAN,
    constraint pk_technical_user_id primary key (id),
    constraint u_technical_user_username UNIQUE (username)
)