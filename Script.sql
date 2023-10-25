drop table account;

CREATE TABLE account (
	idnum int NOT NULL,
	id varchar(10),
	username varchar(10),
	password varchar(20),
	author int,
	joindate timestamp
);

ALTER TABLE account ADD PRIMARY KEY (idnum);

insert into account(idnum, id, username, password, author) values(1, 'admin', 'manager', 'asdf',10);

select * from account;