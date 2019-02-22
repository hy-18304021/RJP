/***********************************
UserçÏê¨çœÇ›ëOíÒ
***********************************/

conn maguser/magpass

drop table res_table;
drop table thread_table;
drop SEQUENCE s_thread_number;
drop SEQUENCE s_res_number;
drop SEQUENCE s_res_id;


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

CREATE SEQUENCE s_thread_number START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE s_res_number START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE s_res_id START WITH 1 INCREMENT BY 1;

commit;



