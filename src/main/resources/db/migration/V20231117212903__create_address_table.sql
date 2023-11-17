CREATE TABLE IF NOT EXISTS gdsc."address"
(
    id                     integer                  NOT NULL,
    database_version       integer                  NOT NULL,
    create_date            timestamp with time zone NOT NULL,
    update_date            timestamp with time zone,
    street_name            character varying(64)    NOT NULL,
    street_number          integer,
    user_id                integer,

    CONSTRAINT address_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES gdsc."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)