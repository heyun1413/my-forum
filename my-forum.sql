create database if not exists myforum;

use myforum;

create table if not exists t_user(
	user_id int primary key auto_increment,
	username char(15) not null,
	password char(32) not null,
	nickname varchar(15) not null,
	gender tinyint not null,
	portrait_path varchar(20) not null,
	integral int not null,
	index iusername(username)
) engine = InnoDB