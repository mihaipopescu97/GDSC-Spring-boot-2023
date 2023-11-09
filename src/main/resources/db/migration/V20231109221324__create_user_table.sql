CREATE TABLE IF NOT EXISTS gdsc."user"
(
    id                     integer                  NOT NULL,
    database_version       integer                  NOT NULL,
    create_date            timestamp with time zone NOT NULL,
    update_date            timestamp with time zone,
    name                   character varying(64)    NOT NULL,

    CONSTRAINT user_pkey PRIMARY KEY (id)
)