create table admin_route
(
    id          int auto_increment
        primary key,
    route       varchar(100) not null comment '路由的路径。不可重复',
    create_time datetime     not null,
    constraint admin_route_route_uindex
        unique (route)
)
    comment '管理权限中的对应路由';

