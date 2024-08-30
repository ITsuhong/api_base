create table project
(
    id          int auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    name        varchar(255)                       not null comment '项目名称'
);

create table environment
(
    id          int auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    name        varchar(255)                       not null comment '环境名称',
    user_id     int                                null comment '用户ID',
    user_name   varchar(255)                       null comment '用户姓名',
    project_id  int                                null comment '项目ID',
    constraint environment_ibfk_1
        foreign key (project_id) references project (id)
);

create index project_id
    on environment (project_id);

create table roles
(
    id          int auto_increment comment '权限id'
        primary key,
    name        varchar(50)                              not null comment '名字',
    description varchar(255)                             null comment '描述',
    create_time datetime(6) default CURRENT_TIMESTAMP(6) null comment '创建时间',
    update_time datetime(6) default CURRENT_TIMESTAMP(6) null on update CURRENT_TIMESTAMP(6) comment '更新时间',
    version     int                                      null comment '版本',
    creator     varchar(50)                              null comment '创建人'
);

create table admin_user
(
    id            int auto_increment comment '用户id'
        primary key,
    name          varchar(50)                               not null comment '用户姓名',
    account       varchar(255)                              not null comment '用户账户',
    password      varchar(255) default '123456'             not null comment '密码',
    administrator int          default 0                    null comment '是否是超级管理员',
    create_time   datetime(6)  default CURRENT_TIMESTAMP(6) null comment '创建时间',
    update_time   datetime(6)  default CURRENT_TIMESTAMP(6) null on update CURRENT_TIMESTAMP(6) comment '更新时间',
    version       int                                       null comment '版本',
    creator       varchar(50)                               null comment '创建人',
    role_id       int                                       null comment '身份',
    constraint admin_user_ibfk_1
        foreign key (role_id) references roles (id)
            on delete cascade
);

create index role_id
    on admin_user (role_id);

create table routes_module
(
    id          int auto_increment comment '路由表id'
        primary key,
    pid         int                                      not null comment '父级模块，为0时代表为第一级别',
    name        varchar(50)                              not null comment '模块名称',
    sort        int                                      not null comment '排序',
    path        varchar(50)                              not null comment '路径',
    description varchar(255)                             null comment '描述',
    create_time datetime(6) default CURRENT_TIMESTAMP(6) null comment '创建时间',
    update_time datetime(6) default CURRENT_TIMESTAMP(6) null on update CURRENT_TIMESTAMP(6) comment '更新时间',
    version     int                                      null comment '版本',
    creator     varchar(50)                              null comment '创建人'
);

create table role_routes
(
    roles_id         int not null comment '权限ID',
    routes_module_id int not null comment '路由模块ID',
    id               int auto_increment
        primary key,
    constraint role_routes_ibfk_1
        foreign key (roles_id) references roles (id)
            on delete cascade,
    constraint role_routes_ibfk_2
        foreign key (routes_module_id) references routes_module (id)
            on delete cascade
);

create index roles_id
    on role_routes (roles_id);

create index routes_module_id
    on role_routes (routes_module_id);

create table variable
(
    id             int auto_increment
        primary key,
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time    datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    name           varchar(255)                       not null comment '变量名称',
    value          varchar(255)                       not null comment '变量值',
    description    varchar(255)                       null comment '描述',
    environment_id int                                null comment '环境ID',
    constraint variable_ibfk_1
        foreign key (environment_id) references environment (id)
);

create index environment_id
    on variable (environment_id);

