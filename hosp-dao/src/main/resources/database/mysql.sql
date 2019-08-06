drop database if exists `hospital`;
-- 创建数据库
create database  if not exists `hospital` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

use `hospital`;

-- 基础信息表

-- 项目表, 即医院信息表
drop table if exists `projects`;
create table if not exists `projects`(
                                       `id`   bigint unsigned not null primary key auto_increment comment '项目ID, 自增',
                                       `pro_number` varchar(10) not null unique comment '项目编号',
                                       `pro_name` varchar(20) not null default '' comment '项目名称',
                                       `contact_name` varchar(20) not null default '' comment '联系人姓名',
                                       `contact_phone` varchar(15) not null default '' comment '联系人电话',
                                       `contact_mobile` varchar(11) not null default '' comment '联系人手机',
                                       `pro_address` varchar(200) not null default '' comment '详细地址',
                                       `remark` varchar(100) not null default '' comment '描述',
                                       `create_time` datetime not null default current_timestamp comment '创建时间',
                                       `pro_state` tinyint(1) not null default 1 comment '状态， 0-不可用，1-可用，2-删除'
);


-- 建筑物信息

drop table if exists `structures`;

create table if not exists `structures`(
                                         `id` bigint unsigned not null primary key auto_increment comment '建筑物ID, 自增',
                                         `struct_number` varchar(32) not null unique comment '建筑物编号',
                                         `serial` int(1) not null  comment '序号',
                                         `struct_name` varchar(20) not null comment '建筑物名称',
                                         `remark` varchar(100) not null default '' comment '描述',
                                         `pro_id` bigint unsigned not null comment '所属项目ID',
                                         `pro_name` varchar(20) not null comment '所属项目名称',
                                         `struct_area` varchar(20) not null default '' comment '院区',
                                         `create_time` datetime not null default current_timestamp comment '创建时间'
);


-- 空间信息
drop table if exists `space_info`;
create table if not exists `space_info`(
                                         `id` bigint unsigned not null primary key auto_increment comment '空间ID， 自增',
                                         `space_code` varchar(32) not null unique comment '空间代码',
                                         `space_name` varchar(20) not null comment '空间名称——标题',
                                         `floor` varchar(10) not null comment '所属楼层',
                                         `won_group` varchar(10) not null default '' comment '所属分组',
                                         `role_id` bigint not null default 0 comment '角色',
                                         `role_name` varchar(20) not null default '' comment '角色名称',
                                         `pro_id` bigint unsigned not null comment '所属项目ID',
                                         `pro_name` varchar(20) not null comment '所属项目名称',
                                         `struct_id` bigint unsigned not null  comment '建筑物ID, 自增',
                                         `struct_name` varchar(20) not null comment '建筑物名称',
                                         `job_type` tinyint(1) not null default 0 comment '是否为自助任务点 0-不是，1-是',
                                         `end_type_id` bigint unsigned not null default 0 comment '终点类型',
                                         `end_type_name` varchar(20) not null default '' comment '终点类型名称',
                                         `batch_job_start` tinyint(1) not null default 0 comment '是否允许批量开始任务 0-否，1-是',
                                         `remark` varchar(100) not null default '' comment '描述信息'
);


-- 运转工具信息
drop table if exists `work_tools`;
create table if not exists `work_tools`(
                                         `id` bigint unsigned not null primary key auto_increment comment '运转工具ID,自增',
                                         `tool_code` varchar(32) not null comment '运转工具编号',
                                         `tool_name` varchar(20) not null comment '运转工具名称',
                                         `pro_id` bigint unsigned not null comment '所属项目ID',
                                         `pro_name` varchar(20) not null comment '所属项目名称'
);




-- 医护人员表

drop table if exists `medical_care`;
create table if not exists `medical_care`(
                                           `id` bigint unsigned not null primary key auto_increment comment '医护人员ID,自增',
                                           `medical_number` varchar(10) not null unique comment '医护人员编号',
                                           `medical_name` varchar(20) not null  comment '医护人员姓名',
                                           `mobile` varchar(11) not null unique comment '医护人员手机号',
                                           `telephone` varchar(15) not null default '' comment '联系电话',
                                           `medical_sex` binary(1) not null default 0 comment '性别 0-未知, 1-女,2-男',
                                           `space_id` bigint unsigned not null comment '空间ID',
                                           `space_code` varchar(10) not null unique comment '空间代码',
                                           `space_name` varchar(20) not null comment '空间名称——标题',
                                           `pro_id` bigint unsigned not null comment '所属项目ID',
                                           `pro_number` varchar(10) not null comment '所属项目物编号',
                                           `pro_name` varchar(20) not null comment '所属项目名称',
                                           `receive_msg` tinyint(1) not null default 0 comment '是否接收消息 0-不接收，1-接收',
                                           `state` tinyint(1) not null default 1 comment '状态 0-删除，1-可用，2-在线',
                                           `remark` varchar(100) not null default '' comment '备注'
);

-- 运送员信息表
drop table if exists `worker_info`;
create table if not exists `worker_info`(
                                          `id` bigint unsigned not null primary key auto_increment comment '用户详情ID 自增',
                                          `worker_number` varchar(10) not null comment '用户编号',
                                          `worker_name` varchar(20) not null comment '姓名',
                                          `id_card_no` varchar(18) not null unique comment '用户身份证号码',
                                          `birthday` date comment '出生日期',
                                          `sex` tinyint(1) not null default 0 comment '性别',
                                          `phone`  varchar(15) not null default '' comment '联系电话',
                                          `mobile` varchar(11) not null unique comment '运送员手机号',
                                          `urgent_name` varchar(20) not null default '' comment '紧急联系人',
                                          `urgent_phone` varchar(15) not null default '' comment '紧急联系方式',
                                          `join_time` datetime not null default current_timestamp comment  '入职时间',
                                          `job` varchar(10) not null default '' comment '岗位',
                                          `loop_time` int(2) not null default 0 comment '循环组循环时间（单位：分）',
                                          `pro_id` bigint unsigned not null comment '所属项目ID',
                                          `pro_number` varchar(10) not null comment '所属项目物编号',
                                          `pro_name` varchar(20) not null comment '所属项目名称',
                                          `struct_id` bigint unsigned not null  comment '责任建筑ID',
                                          `struct_number` varchar(10) not null unique comment '责任建筑编号',
                                          `struct_name` varchar(20) not null comment '责任建筑物名称',
                                          `province` varchar(10) not null default '' comment '省',
                                          `city` varchar(20) not null default '' comment '市',
                                          `address` varchar(100) not null default '' comment '详细地址',
                                          `personnel_number` varchar(10) comment '人事处编号',
                                          `remark` varchar(100) not null default '' comment '备注',
                                          `state` tinyint(1) not null  default 0 comment '状态 0-不可用，1-已激活，2-已删除,3-已离职'
);


-- 运送员数据信息表
drop table if exists `worker_task`;
create table if not exists `worker_task`(
                                          `id` bigint unsigned not null primary key auto_increment comment 'ID自增',
                                          `worker_id` bigint unsigned not null  unique comment '运送员ID',
                                          `current_position` varchar(10) not null default '' comment '当前位置',
                                          `last_login_time` datetime not null default current_timestamp comment '最后登录时间',
                                          `scan_time` datetime not null  default current_timestamp comment '扫描时间',
                                          `total_count` int(2) not null default 0 comment '总共处理任务数',
                                          `today_count` int(2) not null default 0 comment '今日处理任务数',
                                          `self_count` int(2) not null default 0 comment '自主任务数',
                                          `today_self_count` int(2) not null default  0 comment '今日自主数量'
);



-- 运送员操作日志
drop table if exists `worker_log`;
create table if not exists `worker_log`(
  `id` bigint unsigned not null primary key auto_increment comment 'ID，自增',
  `log_number` varchar(32) not null unique comment '日志ID',
  `worker_id` bigint unsigned not null comment '运送员ID',
  `worker_name` varchar(20) not null comment '运送员姓名',
  `task_id` bigint unsigned not null  default 0 comment '任务ID',
  `log_type` tinyint(1) not null comment '日志类型 0-登录, 1-扫码, 2-退出',
  `position` varchar(10) comment '扫码地点',
  `log_time` datetime not null default current_timestamp comment '创建时间'
);


-- 创建用户表
drop  table if exists `sys_users`;
create table if not exists `sys_users`(
                                        `id` bigint unsigned not null primary key  auto_increment comment '用户ID自增',
                                        `mobile` varchar(11) not null unique  comment '用户手机号，作为登录使用',
                                        `username` varchar(20) not null unique comment '用户名, 唯一,也可以作为登录使用',
                                        `password` varchar(60) not null comment '登录密码',
                                        `user_type` tinyint(1) not null comment '用户类型 0-医护人员, 1-运送人员',
                                        `state` tinyint(1) not null default 0 comment '状态 0-不可用, 1-可用，2-被锁'
);



-- 角色表
drop table if exists `sys_role`;
create table if not exists `sys_role`(
                                       `id` bigint unsigned not null primary key auto_increment comment '角色ID自增',
                                       `role_code` varchar(32) not null unique comment '角色编号',
                                       `role_name` varchar(20) not null unique comment '角色名称',
                                       `role_state` tinyint(1) not null default 1 comment '角色状态 0-不可用，1-可用',
                                       `create_time` datetime not null default current_timestamp comment '创建时间'
);


-- 用户角色表
drop table if exists `sys_users_role`;
create table if not exists `sys_users_role`(
                                             `id` bigint unsigned not null primary key auto_increment comment '角色ID自增',
                                             `sys_users_id` bigint not null comment '用户ID',
                                             `sys_role_id` bigint not null comment '角色ID'
);


-- 任务类型表
drop table if exists `task_type`;
create table if not exists `task_type`(
                                        `id` bigint unsigned not null primary key auto_increment comment '类型ID, 自增',
                                        `type_number` varchar(32) NOT NULL UNIQUE COMMENT '类型编号',
                                        `type_name` varchar(20) not null comment '类型名称',
                                        `parent_id` bigint unsigned  default 0 comment '父类型',
                                        `default_dest`  bigint unsigned comment '默认地址, 关联空间代码ID',
                                        `trans_time_code_id` bigint unsigned not null  comment '时间代码',
                                        `grade` tinyint(1) not null comment '等级',
                                        `urgent_time` int(2) not null default 0 comment '紧急提醒时间 (单位: 分)',
                                        `pro_id` bigint unsigned not null comment '所属项目ID',
                                        `pro_name` varchar(20) not null comment '所属项目名称',
                                        `create_time` datetime not null default current_timestamp comment '创建时间',
                                        `state` tinyint(1) not null default 1 comment '状态， 0-不可用，1-可以'
);

-- 任务信息
drop table if exists `transport_task`;
create table if not exists `transport_task`(
                                             `id` bigint unsigned not null primary key auto_increment comment '任务ID',
                                             `task_number` varchar(32) not null unique comment '任务编号',
                                             `task_name` varchar(30) not null comment '任务名称',
                                             `create_id` bigint unsigned not null comment '创建者ID',
                                             `create_name` varchar(20) not null comment '创建者姓名',
                                             `task_type_id` bigint unsigned not null comment '任务类型ID',
                                             `task_type_name` varchar(20) not null comment '任务类型名称',
                                             `set_out_place_id` bigint unsigned comment '出发地ID, 关联空间代码ID',
                                             `set_out_place_name` varchar(20) not null default '' comment '出发地',
                                             `destination_id` bigint unsigned comment '目的地ID, 关联空间信息ID',
                                             `destination_name` varchar(20) not null default '' comment '目的地名称',
                                             `create_time` datetime not null default current_timestamp comment '创建时间',
                                             `patient_number` varchar(32) not null default '' comment '病人信息编号',
                                             `plan_start_time` datetime  comment '计划开始时间',
                                             `finish_time` int(2) not null default 0 comment '预计完成用时',
                                             `book_time`   int(2) not null default 0 comment '预约时间',
                                             `priority` tinyint(1) not null default 0 comment '优先级 0-正常, 1-重要,2-紧急, 3-紧急重要',
                                             `tool_id` bigint unsigned comment '运转工具ID',
                                             `tool_name` varchar(20) not null  default '' comment '运转工具',
                                             `worker_id` bigint unsigned comment '运送员',
                                             `worker_name` varchar(20) not null default '' comment '运送员姓名',
                                             `actual_count` int(2) not null default 1 comment '实际运送数量',
                                             `state` tinyint(1) not null default 0 comment '任务状态， 0-未阅读, 1-未开始, 2-进行中,3-已完成,4-已取消',
                                             `cancel_reason` varchar(20) not null  default '' comment '取消原因',
                                             `delay_reason` varchar(20) not null default '' comment '延迟原因',
                                             `task_desc` varchar(100) not null default '' comment '任务描述',
                                             `task_remark` varchar(100) not null  default '' comment '任务备注',
                                             `pro_id` bigint unsigned not null comment '所属项目ID',
                                             `pro_number` varchar(10) not null comment '所属项目物编号',
                                             `pro_name` varchar(20) not null comment '所属项目名称',
                                             `get_type` tinyint(1) not null default 0 comment '任务分配类型 1-分配, 2-自主获取'
);

-- 病人信息表
drop table if exists `patient_info`;
create table if not exists `patient_info`(
                                           `id` bigint unsigned not null primary key auto_increment comment '任务ID',
                                           `task_id` bigint unique  not null unique comment '任务ID',
                                           `patient_number` varchar(32) not null unique comment '病人信息编号',
                                           `patient_name` varchar(20) not null default '' comment '患者',
                                           `bed_number` varchar(10) not null default '' comment '床位',
                                           `sex` tinyint(1) not null default 0 comment '病人性别 0-未指定,1-男, 2-女',
                                           `age` int(2) not null default 0 comment '患者年龄',
                                           `number` varchar(10)  not null  default '' comment '住院号'
);

-- 任务操作日志
drop table if exists `task_operation_record`;
create table if not exists `task_operation_record`(
                                                    `id` bigint unique not null primary key auto_increment comment 'ID, 自增',
                                                    `rec_number` varchar(32) not null unique comment '操作记录编号',
                                                    `task_id` bigint unsigned not null comment '任务编号',
                                                    `operation_id` bigint unsigned comment '操作人ID',
                                                    `operation_man` varchar(20) not null default '' comment '操作人',
                                                    `operation_time` datetime not null default current_timestamp comment '操作时间',
                                                    `remark` varchar(100) not null default '' comment '备注信息'
);


-- 运送时间代码
drop table if exists `transport_time_code`;
create table if not exists `transport_time_code`(
                                                  `id` bigint unsigned not null primary key auto_increment comment 'ID 自增',
                                                  `code_name` varchar(20) not null comment '名称',
                                                  `pro_id` bigint unsigned not null comment '所属项目ID',
                                                  `pro_number` varchar(10) not null comment '所属项目物编号',
                                                  `pro_name` varchar(20) not null comment '所属项目名称',
                                                  `effective_time` datetime not null default current_timestamp comment '生效日期',
                                                  `reserve_time` int(2) not null default 5 comment '预约时间(单位 分)',
                                                  `standard_time` int(2) not null default 10 comment '标准时间 (单位 分)',
                                                  `warn_time` int(2) not null default 5 comment '警告时间 (单位 分)',
                                                  `critical_time` int(2) not null default 1 comment '危急 (单位 分)'
);


-- ---------------字典信息区域----------------------

-- 取消原因
drop  table  if exists `cancel_reason`;
create table if not exists `cancel_reason`(
                                            `id` bigint unsigned not null primary key auto_increment comment 'ID 自增',
                                            `cancel_code` varchar(20) not null comment '编码',
                                            `cancel_name` varchar(20) not null comment '取消原因',
                                            `pro_id` bigint unsigned not null comment '所属项目ID',
                                            `pro_number` varchar(10) not null comment '所属项目物编号',
                                            `pro_name` varchar(20) not null comment '所属项目名称',
                                            `create_time` datetime not null default current_timestamp comment '创建时间'
);




-- 延迟原因
drop  table  if exists `delay_reason`;
create table if not exists `delay_reason`(
                                           `id` bigint unsigned not null primary key auto_increment comment 'ID 自增',
                                           `delay_code` varchar(20) not null comment '延迟编号',
                                           `delay_name` varchar(20) not null comment '延迟原因',
                                           `pro_id` bigint unsigned not null comment '所属项目ID',
                                           `pro_number` varchar(10) not null comment '所属项目物编号',
                                           `pro_name` varchar(20) not null comment '所属项目名称',
                                           `create_time` datetime not null default current_timestamp comment '创建时间'
);



-- 性别
drop table if exists `dict_sex`;
create table if not exists `dict_sex`(
                                       `id` bigint unsigned not null primary key auto_increment comment 'ID 自增',
                                       `sex_number` tinyint(1) not null comment '性别',
                                       `sex_name` char(10) not null comment '性别'
);


-- 状态
drop table if exists `dict_state`;
create table if not exists `dict_state`(
                                         `id` bigint unsigned not null primary key auto_increment comment 'ID 自增',
                                         `code` tinyint(1) unsigned not null unique comment '状态',
                                         `name` varchar(20) not null comment '状态'
);


-- 性别
insert into `dict_sex`(`sex_number`, `sex_name`) value (0, '未指定');
insert into `dict_sex`(`sex_number`, `sex_name`) value (1, '男');
insert into `dict_sex`(`sex_number`, `sex_name`) value (2, '女');

-- 状态
-- 0-未阅读, 1-未开始, 2-进行中,3-已完成,4-已取消
insert into `dict_state`(`code`, `name`) value (0, '未阅读');
insert into `dict_state`(`code`, `name`) value (1, '未开始');
insert into `dict_state`(`code`, `name`) value (2, '进行中');
insert into `dict_state`(`code`, `name`) value (3, '已完成');
insert into `dict_state`(`code`, `name`) value (4, '已取消');
insert into `dict_state`(`code`, `name`) value (5, '已延迟');




-- 运送工具
insert into `work_tools`(`tool_code`,`tool_name`, `pro_id`, `pro_number`, `pro_name`) value ('LY', '轮椅', 0, 'BJXH', '北京协和');
insert into `work_tools`(`tool_code`,`tool_name`, `pro_id`, `pro_number`, `pro_name`) value ('PBC', '平板床', 0, 'BJXH', '北京协和');


-- 延迟原因
insert into `delay_reason`(`delay_code`, `delay_name`, `pro_id`, `pro_number`, `pro_name`) value ('YYYH',	'预约延后', 0, 'BJXH', '北京协和');
insert into `delay_reason`(`delay_code`, `delay_name`, `pro_id`, `pro_number`, `pro_name`) value ('BRBZ',	'病人不在', 0, 'BJXH', '北京协和');
insert into `delay_reason`(`delay_code`, `delay_name`, `pro_id`, `pro_number`, `pro_name`) value ('CFWCW', '产房无床位', 0, 'BJXH', '北京协和');

-- 取消原因
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('WB', '误报', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('BRYYLSQX', '病人原因临时取消', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('WJYD', '无检验单', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('ZF', '重复', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('JYKWPYP', '检验科无培养瓶', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('CFCWML', '产房床位满了', 0, 'BJXH', '北京协和');
insert into `cancel_reason`(`cancel_code`, `cancel_name`, `pro_id`, `pro_number`, `pro_name`) value ('LSBHZ', '老师不会诊', 0, 'BJXH', '北京协和');




insert into sys_role(`role_code`, `role_name`) value ('ROOT', '超级管理员');
insert into sys_role(`role_code`, `role_name`) value ('ADMIN', '项目经理');
insert into sys_role(`role_code`, `role_name`) value ('MANAGER', '运送经理');
insert into sys_role(`role_code`, `role_name`) value ('USER', '运送员');

select * from sys_role;
select * from sys_users;
select * from sys_users_role;

insert into sys_users_role(`sys_users_id`, `sys_role_id`) value (1, 1);
insert into sys_users_role(`sys_users_id`, `sys_role_id`) value (1, 2);
insert into sys_users_role(`sys_users_id`, `sys_role_id`) value (1, 3);
insert into sys_users_role(`sys_users_id`, `sys_role_id`) value (1, 4);


select r.id, r.role_code, r.role_name, r.role_state, r.create_time from sys_users as u
                                                                          left join sys_users_role ur on u.id = ur.sys_users_id
                                                                          left join sys_role r on ur.sys_role_id = r.id
where u.id = 1;


select * from patient_info;


select * from space_info;

select  * from work_tools;

select * from task_type;

select * from space_info;