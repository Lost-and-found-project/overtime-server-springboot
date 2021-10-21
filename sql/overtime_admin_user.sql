create table admin_user
(
    id          int auto_increment
        primary key,
    username    varchar(20) not null,
    password    varchar(50) not null,
    create_time datetime    not null comment '创建时间',
    status      smallint    null comment '状态码。-1：停用，0：正常
用户的过期状态在查询的时候进行检测与设置。',
    constraint admin_user_username_uindex
        unique (username)
)
    comment '管理用户账号';

INSERT INTO overtime.admin_user (id, username, password, create_time, status) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0);