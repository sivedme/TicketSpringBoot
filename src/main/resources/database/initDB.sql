DROP TYPE IF EXISTS e_status CASCADE;

CREATE TYPE e_status as ENUM (
    'NEW', 'FAILED', 'DONE'
    );

DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS tickets;

CREATE TABLE IF NOT EXISTS requests
(
    id bigserial PRIMARY KEY,
    client_name varchar NOT NULL,
    sum bigint not null,
    status e_status NOT NULL DEFAULT 'NEW'
);
CREATE TABLE IF NOT EXISTS tickets
(
    id bigserial PRIMARY KEY,
    departure varchar NOT NULL,
    arrival varchar not null,
    dep_time varchar not null,
    price bigint not null,
    qty_available bigint not null
);
CREATE TABLE IF NOT EXISTS ticket_base
(
    id bigserial PRIMARY KEY,
    departure varchar NOT NULL,
    arrival varchar not null,
    dep_time varchar not null,
    price bigint not null,
    qty_available bigint not null
);