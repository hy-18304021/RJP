/***********************************
UserçÏê¨çœÇ›ëOíÒ
***********************************/

conn maguser/magpass

drop table res_table;
drop table thread_table;
drop SEQUENCE s_thread_number;


create table thread_table(
	thread_number  number generated always as identity PRIMARY KEY,
	thread_name varchar2(80) UNIQUE,
	thread_create_time date DEFAULT SYSDATE NOT NULL,
	thread_update_time date DEFAULT SYSDATE NOT NULL
);

create table res_table(
	res_number number generated always as identity PRIMARY KEY,
	thread_name varchar2(80) REFERENCES thread_table(thread_name),
	res_con varchar2(400) NOT NULL,
	res_time date DEFAULT SYSDATE UNIQUE
);

CREATE SEQUENCE s_thread_number START WITH 1 INCREMENT BY 1;

commit;



