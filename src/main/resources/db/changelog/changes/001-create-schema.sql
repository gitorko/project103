CREATE TABLE customer (
      id bigserial PRIMARY KEY,
      name varchar(255) UNIQUE NOT NULL,
      description text,
      tsv tsvector
);

CREATE FUNCTION update_customer_tsv() RETURNS trigger AS $$
BEGIN
    NEW.tsv := to_tsvector(NEW.name || ' ' || coalesce(NEW.description, ''));
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tsvectorupdate BEFORE INSERT OR UPDATE
    ON customer FOR EACH ROW EXECUTE FUNCTION update_customer_tsv();

CREATE INDEX customer_search_idx ON customer USING gin(tsv);
