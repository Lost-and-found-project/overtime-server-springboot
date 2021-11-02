create definer = root@localhost view admin_user_with_role_id as
select `au`.`id`          AS `id`,
       `au`.`username`    AS `username`,
       `au`.`password`    AS `password`,
       `au`.`create_time` AS `create_time`,
       `au`.`status`      AS `status`,
       `aur`.`role_id`    AS `role_id`
from (`overtime`.`admin_user` `au`
         left join `overtime`.`admin_user_role` `aur` on ((`au`.`id` = `aur`.`user_id`)));

-- comment on column admin_user_with_role_id.id not supported: ID

-- comment on column admin_user_with_role_id.username not supported: 登录用户名。不可重复，只能是英文

-- comment on column admin_user_with_role_id.password not supported: 登录密码。考虑加密

-- comment on column admin_user_with_role_id.create_time not supported: 创建时间

-- comment on column admin_user_with_role_id.status not supported: 状态码。-1：停用，0：正常
用户的过期状态在查询的时候进行检测与设置。

-- comment on column admin_user_with_role_id.role_id not supported: 角色ID

INSERT INTO overtime.admin_user_with_role_id (id, username, password, create_time, status, role_id)
VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 1);
INSERT INTO overtime.admin_user_with_role_id (id, username, password, create_time, status, role_id)
VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 2);