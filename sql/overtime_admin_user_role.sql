create table admin_user_role
(
    user_id int not null comment '用户ID',
    role_id int not null comment '角色ID',
    constraint admin_user_role_user_id_role_id_uindex
        unique (user_id, role_id),
    constraint admin_user_role_admin_role_id_fk
        foreign key (role_id) references admin_role (id)
            on update cascade on delete cascade,
    constraint admin_user_role_admin_user_id_fk
        foreign key (user_id) references ov_user (id)
            on update cascade on delete cascade
)
    comment '用户-角色中间表';

INSERT INTO overtime.admin_user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO overtime.admin_user_role (user_id, role_id)
VALUES (1, 2);