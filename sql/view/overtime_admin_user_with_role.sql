create definer = root@localhost view admin_user_with_role as
select `overtime`.`au`.`id`          AS `id`,
       `overtime`.`au`.`username`    AS `username`,
       `overtime`.`au`.`password`    AS `password`,
       `overtime`.`au`.`create_time` AS `create_time`,
       `overtime`.`au`.`status`      AS `status`,
       `ar`.`id`                     AS `role_id`,
       `ar`.`name`                   AS `role_name`,
       `ar`.`create_time`            AS `role_create_time`
from (`overtime`.`admin_user_with_role_id` `au`
         left join `overtime`.`admin_role` `ar` on ((`overtime`.`au`.`role_id` = `ar`.`id`)));

-- comment on column admin_user_with_role.id not supported: ID

-- comment on column admin_user_with_role.username not supported: 登录用户名。不可重复，只能是英文

-- comment on column admin_user_with_role.password not supported: 登录密码。考虑加密

-- comment on column admin_user_with_role.create_time not supported: 创建时间

-- comment on column admin_user_with_role.status not supported: 状态码。-1：停用，0：正常
用户的过期状态在查询的时候进行检测与设置。

-- comment on column admin_user_with_role.role_id not supported: 角色ID

-- comment on column admin_user_with_role.role_name not supported: 角色名称，不可重复

-- comment on column admin_user_with_role.role_create_time not supported: 创建日期

INSERT INTO overtime.admin_user_with_role (id, username, password, create_time, status, role_id, role_name, role_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 1, '超级管理员', '2021-10-21 17:17:27');
INSERT INTO overtime.admin_user_with_role (id, username, password, create_time, status, role_id, role_name, role_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 2, '用户管理员', '2021-10-21 17:17:27');