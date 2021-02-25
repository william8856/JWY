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

select * from tbl_board where title like '%글쓰기%';
select * from tbl_board where content like '%글쓰기%';
select * from tbl_board where writer like '%aaa%';


create table tbl_reply
(
no int not null auto_increment,
bno int not null default 0,
replytext varchar(500) not null,
replyer varchar(50) not null,
regdate timestamp default now(),
updatedate timestamp default now(),
primary key(no)
);

alter table tbl_reply add constraint fk_board foreign key(bno) references tbl_board(no);

select * from tbl_reply;