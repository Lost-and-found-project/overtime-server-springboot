SELECT
    au.id au_id,
    au.username au_username,
    au.password au_password,
    au.create_time au_create_time,
    au.status au_status,

    ar.id ar_id,
    ar.name ar_name,
    ar.create_time ar_create_time,

    aa.id aa_id,
    aa.`key` aa_key,
    aa.name aa_name,
    aa.create_time aa_create_time,

    a.id a_id,
    a.route a_route,
    a.create_time a_create_time

FROM admin_user au
    LEFT JOIN admin_user_role aur on au.id = aur.user_id
    LEFT JOIN admin_role ar on aur.role_id = ar.id
    LEFT JOIN admin_role_auth ara on ar.id = ara.role_id
    LEFT JOIN admin_auth aa on ara.auth_id = aa.id
    LEFT JOIN admin_auth_route aar on aa.id = aar.auth_id
    LEFT JOIN admin_route a on aar.route_id = a.id;



SELECT aa.*, ar.* FROM admin_auth aa
    LEFT JOIN admin_auth_route aar on aa.id = aar.auth_id
    LEFT JOIN admin_route ar on aar.route_id = ar.id