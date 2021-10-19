create table ov_user
(
    id          int auto_increment comment 'overtime-基础用户表'
        primary key,
    username    varchar(20)            not null comment '用户名，或者说用户昵称',
    password    varchar(100)           not null comment '用户的密码。应该是加密的',
    email       varchar(50) default '' not null comment '用户邮箱。为空则代表没有',
    phone       varchar(50) default '' not null comment '用户手机号，可能会携带区号之类的信息。为空则无',
    create_time datetime               not null comment '创建时间',
    status      int         default 0  not null comment '用户状态码。'
)
    comment 'Overtime- 基础用户表';

