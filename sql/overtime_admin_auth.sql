create table admin_auth
(
    id          int auto_increment comment '权限ID'
        primary key,
    `key`       varchar(50) null comment '权限key，应该为全英文，不可重复',
    name        varchar(50) null comment '权限描述名称',
    create_time datetime    not null comment '创建时间'
)
    comment '管理账号中角色的权限';

INSERT INTO overtime.admin_auth (id, `key`, name, create_time)
VALUES (1, 'CREATE_ADMIN', '创建管理员', '2021-10-21 17:20:33');
INSERT INTO overtime.admin_auth (id, `key`, name, create_time)
VALUES (2, 'MODIFY_ADMIN', '操作管理员', '2021-10-21 17:20:56');
INSERT INTO overtime.admin_auth (id, `key`, name, create_time)
VALUES (3, 'QUERY_LOG', '查看操作日志', '2021-10-21 17:21:37');