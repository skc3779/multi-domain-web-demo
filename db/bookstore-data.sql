/*
 bookstore 샘플 테이블 데이터
 아래의 데이터 생성 스크립트를 MySql Client 툴을 이용해 등록합니다.
 */

insert into bookstore.users( name,password,point,level ) values( 'User01','user01' , 10, 1);
insert into bookstore.users( name,password,point,level ) values( 'User02','user01' , 25, 2);
insert into bookstore.users( name,password,point,level ) values( 'User03','user01' ,  5, 0);

insert into bookstore.books( name,author,publishDate,comment,status,rentUserId ) values('Book01','Book01 Name','2013-04-05 12:12:12','Text01', 1, 1);
insert into bookstore.books( name,author,publishDate,comment,status,rentUserId ) values('Book02','Book02 Name','2013-04-07 12:12:12','Text02', 1, 2);
insert into bookstore.books( name,author,publishDate,comment,status,rentUserId ) values('Book03','Book03 Name','2013-04-07 12:12:12','Text03', 1, 2);

insert into bookstore.histories( userId,bookId,actionType,insertDate ) values(1, 1, 0 , '2013-04-05 12:12:12' );
insert into bookstore.histories( userId,bookId,actionType,insertDate ) values(2, 2, 0 , '2013-04-07 12:12:12' );
insert into bookstore.histories( userId,bookId,actionType,insertDate ) values(2, 3, 0 , '2013-04-07 12:12:12' );
