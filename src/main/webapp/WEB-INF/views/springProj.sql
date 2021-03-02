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

-- 회원 테이블 생성
create table tbl_user
(
uid varchar(50) not null,
upw varchar(50) not null,
uname varchar(100),
upoint int(11),
primary key(uid)
);

-- message 테이블 생성
create table tbl_message
(
mid int(11) not null auto_increment,
targetid varchar(50),
sender varchar(50),
message varchar(100),
opendate timestamp,
senddate timestamp,
primary key(mid)
);

alter table tbl_message add constraint fk_targetid foreign key(targetid) references tbl_user(uid);

alter table tbl_message add constraint fk_sender foreign key(sender) references tbl_user(uid);

select distinct writer from tbl_board;

insert into tbl_user(uid, upw, uname) values('', '1234', 'noName');

select distinct replyer from tbl_reply;

alter table tbl_board add constraint fk_writer_tbl foreign key(writer) references tbl_user(uid);

select uid from tbl_user;

alter table tbl_reply add constraint fk_reply_replyer foreign key(replyer) references tbl_user(uid);

delete from tbl_user where uid in('');