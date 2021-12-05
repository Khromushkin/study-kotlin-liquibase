CREATE ROLE books_owner WITH LOGIN PASSWORD 'ownerpassword' NOSUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;
CREATE ROLE books WITH NOLOGIN;

create schema books_schema AUTHORIZATION books_owner;
GRANT ALL ON SCHEMA books_schema to books_owner;
grant usage on schema books_schema to books_owner;
ALTER ROLE books_owner SET search_path TO books_schema,pg_catalog,public;

CREATE USER books_app WITH LOGIN PASSWORD 'apppassword' NOSUPERUSER INHERIT NOREPLICATION;
GRANT USAGE ON SCHEMA books_schema to books_app;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";