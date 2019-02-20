/***********************************
UserçÏê¨çœÇ›ëOíÒ
***********************************/

conn maguser/magpass

drop table res_table;
drop table thread_table;


create table thread_table(
	thread_number  number generated always as identity PRIMARY KEY,
	res_id number(4) UNIQUE,
	thread_name varchar2(80) NOT NULL UNIQUE,
	thread_create_time date DEFAULT SYSDATE UNIQUE,
	thread_update_time date DEFAULT SYSDATE UNIQUE
);

create table res_table(
	res_number number generated always as identity PRIMARY KEY,
	res_id number(4) REFERENCES thread_table(res_id),
	thread_name varchar2(80) REFERENCES thread_table(thread_name),
	res_con varchar2(400) NOT NULL,
	res_cont_time date DEFAULT SYSDATE UNIQUE
);

commit;



