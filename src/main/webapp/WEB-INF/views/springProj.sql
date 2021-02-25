use test;

-- 게시판 테이블 생성
create table tbl_board
(
no int not null auto_increment,
title varchar(100) not null,
content text null,
writer varchar(50) not null,
regdate timestamp not null default now(),
viewcnt int default 0,
primary key(no)
);


select * from tbl_board order by no desc;

insert into tbl_board(title, content, writer)
(select title, content, writer from tbl_board);

select * from tbl_board order by no desc limit 2, 10;