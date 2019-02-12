/***********************************
User�쐬�ςݑO��
***********************************/

conn maguser/magpass

drop table user_table;
drop table thread_table;
drop table res_table;

create table user_table(
	user_name varchar2(20) PRIMARY KEY,
	user_password varchar2(20) UNIQUE
);

create table thread_table(
	thread_number  number generated always as identity PRIMARY KEY,
	res_id number(4) UNIQUE,
	thread_name varchar2(80) NOT NULL UNIQUE,
	thread_create_time varchar2(4) ,
	thread_update_time varchar2(4) ,
	user_name varchar2(20) REFERENCES user_table(user_name),
	UNIQUE(thread_create_time,thread_update_time)
);

create table res_table(
	res_number number generated always as identity PRIMARY KEY,
	res_id number(4) REFERENCES thread_table(res_id),
	thread_name varchar2(80) REFERENCES thread_table(thread_name),
	res_con varchar2(400) NOT NULL,
	res_cont_time date DEFAULT SYSDATE UNIQUE,
	res_cont_time2 date DEFAULT SYSDATE UNIQUE,
	user_name varchar2(20) REFERENCES user_table(user_name)
);

commit;


