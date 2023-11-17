CREATE TABLE IF NOT EXISTS gdsc."role"
(
    id                     integer                  NOT NULL,
    database_version       integer                  NOT NULL,
    create_date            timestamp with time zone NOT NULL,
    update_date            timestamp with time zone,
    name                   character varying(64)    NOT NULL,
    priority               integer,
    user_id                integer,

    CONSTRAINT role_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES gdsc."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)