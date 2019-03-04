/************************************************

Å‰‚Íusqlplus /nologv‚Å“ü‚éB

************************************************/
sqlplus /nolog

conn sys/orcl as sysdba

create user maguser identified by maguser account unlock;
grant dba to maguser;

conn maguser/maguser

show user






