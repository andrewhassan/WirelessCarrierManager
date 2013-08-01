# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  billing_address           varchar(255),
  customer_id               bigint,
  constraint pk_account primary key (id))
;

create table carrier (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_carrier primary key (id))
;

create table customer (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  billing_address           varchar(255),
  constraint pk_customer primary key (id))
;

create table plan (
  id                        bigint auto_increment not null,
  billing_period_in_days    bigint,
  flat_rate_per_billing_period double,
  data_rate_per_byte        double,
  num_bytes_until_overage   bigint,
  overage_data_rate_per_byte double,
  carrier_id                bigint,
  constraint pk_plan primary key (id))
;

create table plan_pool (
  id                        bigint auto_increment not null,
  display_name              varchar(255),
  plan_id                   bigint,
  is_unlimited              tinyint(1) default 0,
  is_default_pool           tinyint(1) default 0,
  max_bytes                 bigint,
  max_cards                 bigint,
  constraint pk_plan_pool primary key (id))
;

create table sim_card (
  sim_number                varchar(255) not null,
  display_name              varchar(255),
  pool_id                   bigint,
  account_id                bigint,
  constraint pk_sim_card primary key (sim_number))
;

create table sim_usage (
  usage_id                  bigint auto_increment not null,
  sim_card_sim_number       varchar(255),
  timestamp                 bigint,
  usage_in_bytes            bigint,
  constraint pk_sim_usage primary key (usage_id))
;

alter table account add constraint fk_account_customer_1 foreign key (customer_id) references customer (id) on delete restrict on update restrict;
create index ix_account_customer_1 on account (customer_id);
alter table plan add constraint fk_plan_carrier_2 foreign key (carrier_id) references carrier (id) on delete restrict on update restrict;
create index ix_plan_carrier_2 on plan (carrier_id);
alter table plan_pool add constraint fk_plan_pool_plan_3 foreign key (plan_id) references plan (id) on delete restrict on update restrict;
create index ix_plan_pool_plan_3 on plan_pool (plan_id);
alter table sim_card add constraint fk_sim_card_pool_4 foreign key (pool_id) references plan_pool (id) on delete restrict on update restrict;
create index ix_sim_card_pool_4 on sim_card (pool_id);
alter table sim_card add constraint fk_sim_card_account_5 foreign key (account_id) references account (id) on delete restrict on update restrict;
create index ix_sim_card_account_5 on sim_card (account_id);
alter table sim_usage add constraint fk_sim_usage_simCard_6 foreign key (sim_card_sim_number) references sim_card (sim_number) on delete restrict on update restrict;
create index ix_sim_usage_simCard_6 on sim_usage (sim_card_sim_number);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table carrier;

drop table customer;

drop table plan;

drop table plan_pool;

drop table sim_card;

drop table sim_usage;

SET FOREIGN_KEY_CHECKS=1;

