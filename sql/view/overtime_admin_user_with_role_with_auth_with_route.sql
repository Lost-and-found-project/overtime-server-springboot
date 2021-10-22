create definer = root@localhost view admin_user_with_role_with_auth_with_route as
select `overtime`.`au`.`id`          AS `id`,
       `overtime`.`au`.`username`    AS `username`,
       `overtime`.`au`.`password`    AS `password`,
       `overtime`.`au`.`create_time` AS `create_time`,
       `overtime`.`au`.`status`      AS `status`,
       `ar`.`id`                     AS `role_id`,
       `ar`.`name`                   AS `role_name`,
       `ar`.`create_time`            AS `role_create_time`,
       `aa`.`id`                     AS `auth_id`,
       `aa`.`key`                    AS `auth_key`,
       `aa`.`name`                   AS `auth_name`,
       `aa`.`create_time`            AS `auth_create_time`,
       `ar2`.`id`                    AS `route_id`,
       `ar2`.`route`                 AS `route`,
       `ar2`.`create_time`           AS `route_create_time`
from (((`overtime`.`admin_user_with_role_id_with_auth_id_with_route_id` `au` left join `overtime`.`admin_role` `ar` on ((`overtime`.`au`.`role_id` = `ar`.`id`))) left join `overtime`.`admin_auth` `aa` on ((`overtime`.`au`.`auth_id` = `aa`.`id`)))
         left join `overtime`.`admin_route` `ar2` on ((`overtime`.`au`.`route_id` = `ar2`.`id`)));

-- comment on column admin_user_with_role_with_auth_with_route.id not supported: ID

-- comment on column admin_user_with_role_with_auth_with_route.username not supported: 登录用户名。不可重复，只能是英文

-- comment on column admin_user_with_role_with_auth_with_route.password not supported: 登录密码。考虑加密

-- comment on column admin_user_with_role_with_auth_with_route.create_time not supported: 创建时间

-- comment on column admin_user_with_role_with_auth_with_route.status not supported: 状态码。-1：停用，0：正常
用户的过期状态在查询的时候进行检测与设置。

-- comment on column admin_user_with_role_with_auth_with_route.role_id not supported: 角色ID

-- comment on column admin_user_with_role_with_auth_with_route.role_name not supported: 角色名称，不可重复

-- comment on column admin_user_with_role_with_auth_with_route.role_create_time not supported: 创建日期

-- comment on column admin_user_with_role_with_auth_with_route.auth_id not supported: 权限ID

-- comment on column admin_user_with_role_with_auth_with_route.auth_key not supported: 权限key，应该为全英文，不可重复

-- comment on column admin_user_with_role_with_auth_with_route.auth_name not supported: 权限描述名称

-- comment on column admin_user_with_role_with_auth_with_route.auth_create_time not supported: 创建时间

-- comment on column admin_user_with_role_with_auth_with_route.route_id not supported: 路由ID

-- comment on column admin_user_with_role_with_auth_with_route.route not supported: 路由的路径。不可重复

-- comment on column admin_user_with_role_with_auth_with_route.route_create_time not supported: 创建时间

INSERT INTO overtime.admin_user_with_role_with_auth_with_route (id, username, password, create_time, status, role_id, role_name, role_create_time, auth_id, auth_key, auth_name, auth_create_time, route_id, route, route_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 1, '超级管理员', '2021-10-21 17:17:27', 1, 'CREATE_ADMIN', '创建管理员', '2021-10-21 17:20:33', null, null, null);
INSERT INTO overtime.admin_user_with_role_with_auth_with_route (id, username, password, create_time, status, role_id, role_name, role_create_time, auth_id, auth_key, auth_name, auth_create_time, route_id, route, route_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 1, '超级管理员', '2021-10-21 17:17:27', 2, 'MODIFY_ADMIN', '操作管理员', '2021-10-21 17:20:56', null, null, null);
INSERT INTO overtime.admin_user_with_role_with_auth_with_route (id, username, password, create_time, status, role_id, role_name, role_create_time, auth_id, auth_key, auth_name, auth_create_time, route_id, route, route_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 1, '超级管理员', '2021-10-21 17:17:27', 3, 'QUERY_LOG', '查看操作日志', '2021-10-21 17:21:37', null, null, null);
INSERT INTO overtime.admin_user_with_role_with_auth_with_route (id, username, password, create_time, status, role_id, role_name, role_create_time, auth_id, auth_key, auth_name, auth_create_time, route_id, route, route_create_time) VALUES (1, 'admin', 'admin', '2021-10-21 17:17:02', 0, 2, '用户管理员', '2021-10-21 17:17:27', 3, 'QUERY_LOG', '查看操作日志', '2021-10-21 17:21:37', null, null, null);