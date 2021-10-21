create table admin_role
(
    id          int auto_increment
        primary key,
    name        varchar(20) not null comment '角色名称，不可重复',
    create_time datetime    not null comment '创建日期',
    constraint admin_role_name_uindex
        unique (name)
)
    comment '管理账号角色表';

INSERT INTO overtime.admin_role (id, name, create_time) VALUES (1, '超级管理员', '2021-10-21 17:17:27');
INSERT INTO overtime.admin_role (id, name, create_time) VALUES (2, '用户管理员', '2021-10-21 17:17:27');