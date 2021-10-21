create table admin_role_auth
(
    role_id int not null,
    auth_id int not null,
    constraint admin_role_auth_role_id_auth_id_uindex
        unique (role_id, auth_id),
    constraint admin_role_auth_admin_auth_id_fk
        foreign key (auth_id) references admin_auth (id)
            on update cascade on delete cascade,
    constraint admin_role_auth_admin_role_id_fk
        foreign key (role_id) references admin_role (id)
            on update cascade on delete cascade
)
    comment '角色-权限中间表';

INSERT INTO overtime.admin_role_auth (role_id, auth_id) VALUES (1, 1);
INSERT INTO overtime.admin_role_auth (role_id, auth_id) VALUES (1, 2);
INSERT INTO overtime.admin_role_auth (role_id, auth_id) VALUES (1, 3);
INSERT INTO overtime.admin_role_auth (role_id, auth_id) VALUES (2, 3);