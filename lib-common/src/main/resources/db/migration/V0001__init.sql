create table if not exists sample_items (
    id bigserial primary key,
    name varchar(200) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null
);
