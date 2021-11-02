create table compensate_type
(
    id                 int auto_increment
        primary key,
    name               varchar(20)       not null comment '补偿名称',
    unit               varchar(10)       not null comment '补偿单位',
    proportion         varchar(50)       not null comment '比例。指 1min * proportion = compensate. 即一分钟与当前补偿之间的比例.
以调休为例, 假设调休1分钟顶2分钟的加班, 则说明 2min加班 * proportion = 1调休, 则 proportion = 0.5.
',
    description        varchar(250)      not null comment '描述',
    type               tinyint default 0 not null comment '类型。TODO 暂未确定用途',
    create_time        datetime          not null comment '创建时间',
    last_modified_time datetime          not null comment '最后一次修改时间。初始应默认与 create_time 一致',
    user_id            int               not null comment '哪个用户使用的这个类型'
)
    comment '补偿的类型';

INSERT INTO overtime.compensate_type (id, name, unit, proportion, description, type, create_time, last_modified_time,
                                      user_id)
VALUES (1, '调休', '分钟', '1', '调休，一分钟加班抵一分钟调休', 0, '2021-10-12 13:09:25', '2021-10-12 13:09:29', 0);