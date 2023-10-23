drop table tb_comment;
CREATE TABLE tb_comment (
   id  int NOT NULL,
   name  varchar(15) NOT NULL,
   content varchar(30) NOT NULL
);

ALTER TABLE tb_comment ADD PRIMARY KEY (id);

insert into tb_comment(id, content, name) values(1,'abc', 'abc');

select * from tb_comment;