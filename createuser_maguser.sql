/************************************************

最初は「sqlplus /nolog」で入る。

************************************************/
sqlplus /nolog

conn sys/orcl as sysdba

create user maguser identified by maguser account unlock;
grant dba to tuser;

conn maguser/magpass

show user






