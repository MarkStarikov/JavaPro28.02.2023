create table users(
                      username char(50) not null primary key,
                      password char(500) not null,
                      enabled boolean not null
);

create table authorities (
                             username char(50) not null,
                             authority char(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);