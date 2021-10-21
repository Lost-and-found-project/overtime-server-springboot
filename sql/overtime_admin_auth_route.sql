create table admin_auth_route
(
    auth_id  int not null,
    route_id int not null,
    constraint admin_auth_route_auth_id_route_id_uindex
        unique (auth_id, route_id),
    constraint admin_auth_route_admin_auth_id_fk
        foreign key (auth_id) references admin_auth (id)
            on update cascade on delete cascade,
    constraint admin_auth_route_admin_route_id_fk
        foreign key (route_id) references admin_route (id)
            on update cascade on delete cascade
)
    comment '权限-路由中间表';

