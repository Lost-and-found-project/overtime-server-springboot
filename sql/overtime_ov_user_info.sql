create table ov_user_info
(
    id          int auto_increment comment 'overtime-基础用户表'
        primary key,
    email       varchar(50) default '' not null comment '用户邮箱。为空则代表没有',
    phone       varchar(50) default '' not null comment '用户手机号，可能会携带区号之类的信息。为空则无',
    create_time datetime               not null comment '创建时间',
    status      int         default 0  not null comment '用户状态码。',
    user_id     int                    not null comment '此用户信息关联的用户',
    constraint ov_user_info_user_id_uindex
        unique (user_id),
    constraint ov_user_info_admin_user_id_fk
        foreign key (user_id) references ov_user (id)
            on update cascade on delete cascade
)
    comment 'Overtime- 用户基本信息表';

