CREATE TABLE customer (
      id bigserial PRIMARY KEY,
      name varchar(255) UNIQUE NOT NULL,
      description text,
      tsv tsvector generated always as ( to_tsvector('english'::regconfig, name || ' ' || coalesce(description, '')) ) stored
);
