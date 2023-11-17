CREATE TABLE IF NOT EXISTS gdsc."project_user"
(
    user_id                integer,
    project_id integer,

    CONSTRAINT project_user_pkey PRIMARY KEY (user_id, project_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES gdsc."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    CONSTRAINT fk_project FOREIGN KEY (project_id)
        REFERENCES gdsc."project" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)