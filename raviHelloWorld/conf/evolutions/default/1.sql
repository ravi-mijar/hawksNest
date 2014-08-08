# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table expense (
  id                        bigint AUTOINCREMENT primary key,
  category                  varchar(255),
  description               varchar(255),
  amount                    integer)
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table expense;

PRAGMA foreign_keys = ON;

