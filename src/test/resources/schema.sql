create table parent (
  id character(32) not null primary key,
  name varchar(255) not null
);

create table child (
  id character(32) not null primary key,
  name varchar(255) not null,
  parent_id character(32) not null
);

create index fk_child_1_idx on child(parent_id);
alter table child add constraint fk_child_1 foreign key(parent_id) references parent(id) on delete cascade;
