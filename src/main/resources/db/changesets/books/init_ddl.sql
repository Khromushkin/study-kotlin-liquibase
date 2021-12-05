create table books_schema.books
(
    id     bigint generated always as identity primary key,
    uid    uuid default gen_random_uuid() unique,
    name   varchar not null,
    author varchar not null
);