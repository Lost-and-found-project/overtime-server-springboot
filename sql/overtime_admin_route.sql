create table admin_route
(
    id          int auto_increment comment '路由ID'
        primary key,
    parent_id   int                    null comment '父路由ID。如果为顶层则为NULL',
    route       varchar(100)           not null comment '路由的路径。不可重复',
    create_time datetime               not null comment '创建时间',
    description varchar(50) default '' not null comment '备注说明信息',
    constraint admin_route_route_uindex
        unique (route),
    constraint admin_route_admin_route_id_fk
        foreign key (parent_id) references admin_route (id)
            on update cascade on delete cascade
)
    comment '管理权限中的对应路由';

INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (1, null, '/test', '2021-10-26 09:37:30', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (2, null, '/test2', '2021-10-26 09:37:39', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (3, 1, '/test/hello', '2021-10-26 09:38:15', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (4, 1, '/test/user', '2021-10-26 09:38:23', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (5, 2, '/test2/world', '2021-10-26 09:38:42', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (6, 2, '/test2/like', '2021-10-26 09:38:52', '');
INSERT INTO overtime.admin_route (id, parent_id, route, create_time, description) VALUES (7, null, '/test3', '2021-10-26 14:38:09', '第三个测试路由');