create table ov_user
(
    id          int auto_increment comment 'ID'
        primary key,
    username    varchar(20)       not null comment '登录用户名。不可重复，只能是英文',
    password    varchar(50)       not null comment '登录密码。考虑加密',
    create_time datetime          not null comment '创建时间',
    status      smallint          null comment '状态码。-1：停用，0：正常
用户的过期状态在查询的时候进行检测与设置。',
    is_admin    tinyint default 0 not null comment '是否为管理员账号。0：否，1：是',
    constraint admin_user_username_uindex
        unique (username)
)
    comment '管理用户账号';

INSERT INTO overtime.ov_user (id, username, password, create_time, status, is_admin)
VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 0);
INSERT INTO overtime.ov_user (id, username, password, create_time, status, is_admin)
VALUES (2, 'admin2', 'admin', '2021-10-27 14:20:30', 0, 0);