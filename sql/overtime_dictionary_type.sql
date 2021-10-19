create table dictionary_type
(
    id          int auto_increment comment '字典类型ID'
        primary key,
    name        varchar(20)             not null comment '字典类型的名称',
    description varchar(200) default '' not null comment '对此类型的简要描述'
)
    comment '字典-数据类型';

