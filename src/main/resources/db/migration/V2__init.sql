create table users(
    id BIGSERIAL PRIMARY KEY,
    email varchar(100) not null unique,
    password_hash varchar(255) not null,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
create table accounts(
    id BIGSERIAL PRIMARY KEY,
    owner_type varchar(100) not null ,
    owner_id bigint not null ,
    purpose varchar(100) not null,
    normal_balance CHAR(1) NOT NULL check ( normal_balance in ('D','C')),
    currency varchar(3) not null,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    unique (owner_type, owner_id, purpose, currency)
);
create table transactions(
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status varchar(20) not null default 'PENDING'
        check (status in ('PENDING','POSTED','REVERSED','FAILED')),
    idempotency_key varchar(100) unique
);
create table ledger_entries (
    id BIGSERIAL primary key,
    transaction_id bigint references transactions(id),
    account_id bigint references accounts(id),
    direction char(1) not null check (direction in ('D','C')),
    amount BIGINT not null check ( amount>0 ),
    currency varchar(3) not null,
    created_at TIMESTAMP not null default current_timestamp
);
create table idempotency_keys (
    key varchar(100) primary key,
    request_hash varchar(64) not null,
    response_body jsonb,
    created_at timestamp not null default current_timestamp,
    expires_at timestamp not null
);
create index idx_ledger_entries_account_id on ledger_entries(account_id);
create index idx_ledger_entries_transaction_id on ledger_entries(transaction_id);