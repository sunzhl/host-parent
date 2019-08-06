/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2019-08-03 21:41:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cancel_reason
-- ----------------------------
DROP TABLE IF EXISTS `cancel_reason`;
CREATE TABLE `cancel_reason` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 自增',
  `cancel_code` varchar(34) NOT NULL COMMENT '编码',
  `cancel_name` varchar(20) NOT NULL COMMENT '取消原因',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `modify_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `modify_name` varchar(20) NOT NULL DEFAULT '' COMMENT '修改人姓名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cancel_reason
-- ----------------------------
INSERT INTO `cancel_reason` VALUES ('1', 'WB', '误报', '1', '空军总医院', '0', '0', '', '2019-07-25 19:14:24');
INSERT INTO `cancel_reason` VALUES ('2', 'BRYYLSQX', '病人原因临时取消', '1', '空军总医院', '0', '0', '', '2019-07-25 19:24:44');
INSERT INTO `cancel_reason` VALUES ('8', 'CHONGFU', '重复', '1', '空军总医院', '0', '1', '张三', '2019-07-25 20:38:18');
INSERT INTO `cancel_reason` VALUES ('9', 'WJYD', '无检验单', '1', '空军总医院', '0', '0', '', '2019-07-25 20:48:40');
INSERT INTO `cancel_reason` VALUES ('10', '11111', '测试11', '1', '空军总医院', '0', '1', '张三', '2019-07-30 20:14:01');

-- ----------------------------
-- Table structure for circle_points
-- ----------------------------
DROP TABLE IF EXISTS `circle_points`;
CREATE TABLE `circle_points` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目ID, 自增',
  `circle_id` bigint(20) unsigned NOT NULL COMMENT '循环ID',
  `space_id` bigint(20) unsigned NOT NULL COMMENT '循环点ID',
  `space_name` varchar(20) NOT NULL COMMENT '循环点姓名',
  `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可用 0-可用，1-不可用',
  `selected` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否选中 0-未选中，1-选中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `circle_id_idx` (`circle_id`,`space_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of circle_points
-- ----------------------------
INSERT INTO `circle_points` VALUES ('1', '1', '1', '特一', '0', '0');
INSERT INTO `circle_points` VALUES ('2', '1', '2', '特二', '0', '0');
INSERT INTO `circle_points` VALUES ('3', '1', '3', '特三', '0', '0');
INSERT INTO `circle_points` VALUES ('4', '2', '1', '特一', '0', '0');
INSERT INTO `circle_points` VALUES ('5', '2', '5', '儿科', '0', '0');
INSERT INTO `circle_points` VALUES ('6', '3', '5', '骨科一室', '0', '0');
INSERT INTO `circle_points` VALUES ('7', '3', '2', '小儿内科', '0', '0');
INSERT INTO `circle_points` VALUES ('8', '3', '1', '儿外科专家', '0', '0');

-- ----------------------------
-- Table structure for circle_setting
-- ----------------------------
DROP TABLE IF EXISTS `circle_setting`;
CREATE TABLE `circle_setting` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目ID, 自增',
  `worker_id` bigint(20) unsigned NOT NULL COMMENT '所属人员',
  `worker_name` varchar(20) NOT NULL COMMENT '所属人员姓名',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `finish_count` int(2) NOT NULL DEFAULT '0' COMMENT '循环次数',
  `finish_time` int(2) NOT NULL DEFAULT '0' COMMENT '循环时间',
  `space_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '空间代码ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除,1-删除',
  `modify_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '修改者Id',
  `modify_name` varchar(20) NOT NULL DEFAULT '' COMMENT '修改者姓名',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of circle_setting
-- ----------------------------
INSERT INTO `circle_setting` VALUES ('1', '1', '张三', '1', '空军总医院', '1', '0', '0', '0', '0', '', '2019-08-02 21:30:00');
INSERT INTO `circle_setting` VALUES ('2', '2', '里斯', '1', '空军总医院', '0', '60', '0', '0', '0', '', '2019-08-02 21:30:24');
INSERT INTO `circle_setting` VALUES ('3', '6', '操操', '1', '空军总医院', '0', '10', '0', '1', '1', '张三', '2019-08-03 20:25:20');

-- ----------------------------
-- Table structure for delay_reason
-- ----------------------------
DROP TABLE IF EXISTS `delay_reason`;
CREATE TABLE `delay_reason` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 自增',
  `delay_code` varchar(34) NOT NULL COMMENT '延迟编号',
  `delay_name` varchar(20) NOT NULL COMMENT '延迟原因',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `modify_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '修改人ID',
  `modify_name` varchar(20) NOT NULL DEFAULT '' COMMENT '修改人姓名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delay_reason
-- ----------------------------
INSERT INTO `delay_reason` VALUES ('1', '0001', '医师不在', '0', '1', '空军总医院', '0', '', '2019-07-25 18:24:31');
INSERT INTO `delay_reason` VALUES ('2', 'BRBZ', '病人不在', '1', '1', '空军总医院', '1', '张三', '2019-07-26 09:11:47');
INSERT INTO `delay_reason` VALUES ('3', 'YYYH', '预约延后', '0', '1', '空军总医院', '1', '张三', '2019-07-26 09:18:07');

-- ----------------------------
-- Table structure for dict_sex
-- ----------------------------
DROP TABLE IF EXISTS `dict_sex`;
CREATE TABLE `dict_sex` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 自增',
  `sex_number` tinyint(1) NOT NULL COMMENT '性别',
  `sex_name` char(10) NOT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict_sex
-- ----------------------------
INSERT INTO `dict_sex` VALUES ('1', '0', '未指定');
INSERT INTO `dict_sex` VALUES ('2', '1', '男');
INSERT INTO `dict_sex` VALUES ('3', '2', '女');

-- ----------------------------
-- Table structure for dict_state
-- ----------------------------
DROP TABLE IF EXISTS `dict_state`;
CREATE TABLE `dict_state` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 自增',
  `code` tinyint(1) unsigned NOT NULL COMMENT '状态',
  `name` varchar(20) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict_state
-- ----------------------------
INSERT INTO `dict_state` VALUES ('1', '0', '未阅读');
INSERT INTO `dict_state` VALUES ('2', '1', '未开始');
INSERT INTO `dict_state` VALUES ('3', '2', '进行中');
INSERT INTO `dict_state` VALUES ('4', '3', '已完成');
INSERT INTO `dict_state` VALUES ('5', '4', '已取消');
INSERT INTO `dict_state` VALUES ('6', '5', '已延迟');

-- ----------------------------
-- Table structure for medical_care
-- ----------------------------
DROP TABLE IF EXISTS `medical_care`;
CREATE TABLE `medical_care` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '医护人员ID,自增',
  `user_id` bigint(20) NOT NULL,
  `medical_number` varchar(10) NOT NULL COMMENT '医护人员编号',
  `medical_name` varchar(20) NOT NULL COMMENT '医护人员姓名',
  `mobile` varchar(11) NOT NULL COMMENT '医护人员手机号',
  `telephone` varchar(15) NOT NULL DEFAULT '' COMMENT '联系电话',
  `medical_sex` binary(1) NOT NULL DEFAULT '0' COMMENT '性别 0-未知, 1-女,2-男',
  `space_id` bigint(20) unsigned NOT NULL COMMENT '空间ID',
  `space_name` varchar(20) NOT NULL COMMENT '空间名称——标题',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `receive_msg` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否接收消息 0-不接收，1-接收',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 0-删除，1-可用，2-在线',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `medical_number` (`medical_number`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medical_care
-- ----------------------------
INSERT INTO `medical_care` VALUES ('1', '5', '01ndbcni', '医护人员', '12311111111', '', 0x31, '1', '儿外科专家', '1', '空军总医院', '0', '1', '专家', '0');
INSERT INTO `medical_care` VALUES ('2', '10', '01loxhqz', '111', '11111', '', 0x31, '4', '耳鼻喉', '1', '空军总医院', '1', '1', '1111', '1');

-- ----------------------------
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `task_id` bigint(20) NOT NULL COMMENT '任务ID',
  `patient_number` varchar(32) NOT NULL COMMENT '病人信息编号',
  `patient_name` varchar(20) NOT NULL DEFAULT '' COMMENT '患者',
  `bed_number` varchar(10) NOT NULL DEFAULT '' COMMENT '床位',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '病人性别 0-未指定,1-男, 2-女',
  `age` int(2) NOT NULL DEFAULT '0' COMMENT '患者年龄',
  `number` varchar(10) NOT NULL DEFAULT '' COMMENT '住院号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `task_id` (`task_id`),
  UNIQUE KEY `patient_number` (`patient_number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient_info
-- ----------------------------
INSERT INTO `patient_info` VALUES ('1', '2', '2e57bb11f69345fd99a0e4b09f208528', '11', '111', '1', '11', '111');
INSERT INTO `patient_info` VALUES ('2', '3', '0e600c1efefe4ea7bf96a3bd1a869f31', '张三', '12-01', '0', '12', '11111');
INSERT INTO `patient_info` VALUES ('3', '4', 'fba5bf19f6984260a4dc18709c33ef63', '1', '10-09', '1', '1', '00001');
INSERT INTO `patient_info` VALUES ('4', '5', '39057ffcbc5c4843997bc721b95d13d6', '22', '22', '0', '22', '0009');
INSERT INTO `patient_info` VALUES ('5', '7', 'd1e49501c1d74fde9f9c89feb0a1c7da', '尼古拉斯赵四', '21-20', '1', '20', '0003');
INSERT INTO `patient_info` VALUES ('6', '6', 'cb317d2fc69b4941ac1d422d15b815d2', '操操', '10-01', '1', '100', '0002');

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目ID, 自增',
  `pro_number` varchar(34) NOT NULL COMMENT '项目编号',
  `pro_name` varchar(20) NOT NULL DEFAULT '' COMMENT '项目名称',
  `contact_name` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人姓名',
  `contact_phone` varchar(15) NOT NULL DEFAULT '' COMMENT '联系人电话',
  `contact_mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '联系人手机',
  `pro_address` varchar(200) NOT NULL DEFAULT '' COMMENT '详细地址',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pro_state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态， 0-不可用，1-可用，2-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pro_number` (`pro_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES ('1', '00001', '空军总医院', '', '', '', '', '', '2019-07-31 16:03:47', '1');

-- ----------------------------
-- Table structure for project_user
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) unsigned NOT NULL,
  `pro_id` bigint(10) unsigned NOT NULL,
  `pro_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_user
-- ----------------------------
INSERT INTO `project_user` VALUES ('1', '1', '1', '空军总医院');

-- ----------------------------
-- Table structure for space_info
-- ----------------------------
DROP TABLE IF EXISTS `space_info`;
CREATE TABLE `space_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '空间ID， 自增',
  `space_code` varchar(32) NOT NULL COMMENT '空间代码',
  `space_name` varchar(20) NOT NULL COMMENT '空间名称——标题',
  `floor` varchar(10) NOT NULL COMMENT '所属楼层',
  `won_group` varchar(10) NOT NULL DEFAULT '' COMMENT '所属分组',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `struct_id` bigint(20) unsigned NOT NULL COMMENT '建筑物ID, 自增',
  `struct_name` varchar(20) NOT NULL COMMENT '建筑物名称',
  `job_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为自助任务点 0-不是，1-是',
  `end_type_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '终点类型',
  `end_type_name` varchar(20) NOT NULL DEFAULT '' COMMENT '终点类型名称',
  `batch_job_start` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否允许批量开始任务 0-否，1-是',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '描述信息',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-删除',
  `modify_id` binary(10) DEFAULT NULL COMMENT '修改对象Id',
  `modify_name` varchar(20) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `space_code` (`space_code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space_info
-- ----------------------------
INSERT INTO `space_info` VALUES ('1', 'e81adf8226864d6cacd1d3f7c1c60518', '儿外科专家', '2', '3', '2', '受益科室', '1', '空军总医院', '2', '门诊楼', '0', '0', '', '1', '专家门诊', '0', 0x31000000000000000000, '张三', '2019-07-31 08:28:23');
INSERT INTO `space_info` VALUES ('2', '3dc7f17fc90846ff95dd3f1141fe29a3', '小儿内科', '1', '', '2', '受益科室', '1', '空军总医院', '2', '门诊楼', '1', '0', '', '1', '小儿内科专家', '0', 0x31000000000000000000, '张三', '2019-07-31 08:19:54');
INSERT INTO `space_info` VALUES ('3', '2f790d5a603d4d4e828088beffd559d6', '测试', '1', '11', '2', '受益科室', '1', '空军总医院', '2', '门诊楼', '1', '0', '', '1', '11', '1', 0x31000000000000000000, '张三', '2019-07-31 08:02:24');
INSERT INTO `space_info` VALUES ('4', '57069e0525b84addba8cdc395cc95cd0', '耳鼻喉', '13', '11', '3', '检查科室', '1', '空军总医院', '2', '门诊楼', '1', '0', '', '1', '专家门诊', '0', 0x31000000000000000000, '张三', '2019-07-31 08:33:16');
INSERT INTO `space_info` VALUES ('5', '80d38135d5b84cc6a1f4ce3fe17dee1d', '骨科一室', '1', '8', '2', '受益科室', '1', '空军总医院', '2', '门诊楼', '0', '0', '', '1', '专家', '0', 0x31000000000000000000, '张三', '2019-07-31 08:33:52');
INSERT INTO `space_info` VALUES ('6', '91ce950206dc4c9c8cd8b94e3267522c', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:41:03');
INSERT INTO `space_info` VALUES ('7', 'facac690d157402db70172383ff78531', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('8', 'adbc824ef3444600871a40955d685d23', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('9', '78ec7e51d9384427b8a02e0d96398daf', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('10', '88e0512bd3cc4cbf9d83631c41693b9c', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('11', '1b1f09df522c40cba290a73c7fd22875', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:41:15');
INSERT INTO `space_info` VALUES ('12', '27cba89f51034ac1b7b1424b91b9289b', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('13', '44b71538ecc644f2a7a64a4365007da3', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:33');
INSERT INTO `space_info` VALUES ('14', '54382b3ea4d84138a26cc83ca94af073', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:41:12');
INSERT INTO `space_info` VALUES ('15', '2293499be81b47d693fe1223c168f846', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:41:18');
INSERT INTO `space_info` VALUES ('16', '20729df7508b49009a8f54ccee5bf326', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '0', 0x31000000000000000000, '张三', '2019-07-31 16:37:34');
INSERT INTO `space_info` VALUES ('17', 'c1070af4033a499aaafde378c9490950', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:41:08');
INSERT INTO `space_info` VALUES ('18', '256d0b513259405a888564aacbef921d', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:40:58');
INSERT INTO `space_info` VALUES ('19', 'f7e2c43335e24ed59ab853067b2c850b', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:40:55');
INSERT INTO `space_info` VALUES ('20', '8330729141ec47cf89535e435766a5bc', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:40:50');
INSERT INTO `space_info` VALUES ('21', '9ae9bb0b55684f78a8725e76e45acfed', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:40:47');
INSERT INTO `space_info` VALUES ('22', '2ae5f8e0c3e9415e936f7d1166a82a32', '111', '11', '11', '2', '受益科室', '1', '空军总医院', '5', '门诊楼', '1', '0', '', '1', '111', '1', 0x31000000000000000000, '张三', '2019-07-31 18:40:43');

-- ----------------------------
-- Table structure for structures
-- ----------------------------
DROP TABLE IF EXISTS `structures`;
CREATE TABLE `structures` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '建筑物ID, 自增',
  `struct_number` varchar(32) NOT NULL COMMENT '建筑物编号',
  `serial` int(1) NOT NULL COMMENT '序号',
  `struct_name` varchar(20) NOT NULL COMMENT '建筑物名称',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `struct_area` varchar(20) NOT NULL DEFAULT '' COMMENT '院区',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `modify_id` bigint(20) DEFAULT NULL COMMENT '修改ID',
  `modify_name` varchar(20) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `struct_number` (`struct_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of structures
-- ----------------------------
INSERT INTO `structures` VALUES ('1', '7e8d59c6c5d542989339919b6a898984', '1', '儿科楼', '儿科楼', '1', '空军总医院', '儿科', '2019-07-20 11:30:34', '0', null, null, null);
INSERT INTO `structures` VALUES ('2', 'ed8c4a35339548fabbafb6e008aa8933', '1', '门诊楼', '门诊楼', '1', '空军总医院', '儿科', '2019-07-20 11:30:58', '0', null, null, null);
INSERT INTO `structures` VALUES ('3', '7a6fa24445ce4d7a99fd032172e1d4ec', '1', '测试', '11', '1', '空军总医院', 'ces', '2019-07-31 09:23:01', '1', null, null, null);
INSERT INTO `structures` VALUES ('4', '30d694fdf9104267b8056779590491e7', '12', '门诊楼', '门诊楼', '1', '空军总医院', '儿科幼儿', '2019-07-31 15:51:43', '0', '1', '张三', '2019-07-31 15:55:28');
INSERT INTO `structures` VALUES ('5', '6588e3d58f0a40beab0f2093c38b09ad', '10', '门诊楼', '门诊楼', '1', '空军总医院', '儿科', '2019-07-31 15:52:25', '1', '1', '张三', '2019-07-31 15:55:14');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID自增',
  `role_code` varchar(32) NOT NULL COMMENT '角色编号',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `role_state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '角色状态 0-不可用，1-可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code` (`role_code`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROOT', '超级管理员', '1', '2019-07-20 11:06:26');
INSERT INTO `sys_role` VALUES ('2', 'ADMIN', '项目经理', '1', '2019-07-20 11:06:26');
INSERT INTO `sys_role` VALUES ('3', 'MANAGER', '运送经理', '1', '2019-07-20 11:06:26');
INSERT INTO `sys_role` VALUES ('4', 'USER', '运送员', '1', '2019-07-20 11:06:26');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID自增',
  `mobile` varchar(11) NOT NULL COMMENT '用户手机号，作为登录使用',
  `username` varchar(20) NOT NULL COMMENT '用户名, 唯一,也可以作为登录使用',
  `password` varchar(60) NOT NULL COMMENT '登录密码',
  `user_type` tinyint(1) NOT NULL COMMENT '用户类型 0-医护人员, 1-运送人员',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0-不可用, 1-可用，2-被锁',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '18512345678', '123456', '$2a$10$tHCbAmJw6ZyjpZx9CKzTF.oX23mYNAVGaZOj0af28pN.77iUbO5Q2', '0', '1');
INSERT INTO `sys_users` VALUES ('5', '12311111111', '01ndbcni', '$2a$10$6IAfR4Ddz3TI7jqQ0og7euAdrgjE6HZzNEjQzNy33uDmQ5eanZZbq', '0', '0');
INSERT INTO `sys_users` VALUES ('8', '12311111112', 'lisi', '$2a$10$tMvptxzEl.nbRqblMiWmQ.NyUgnlH1VijCJQL82JTG8sOaHf4HC5O', '1', '1');
INSERT INTO `sys_users` VALUES ('9', '12400000000', 'wangu', '$2a$10$aQFDHDIdkefkpsBh6mLvtOBnyKgRI447mygpywvw03p5JOkwZheI.', '1', '0');
INSERT INTO `sys_users` VALUES ('10', '11111', '01loxhqz', '$2a$10$knZqP.PSYOSor95q/wFNo.Kvqd.zmfau2q2lSWGBA2kqe5DezniaK', '0', '0');
INSERT INTO `sys_users` VALUES ('11', '11111111111', '111111', '$2a$10$XjHaIOkHSHktoNwVZIcH/.ZWy9gEUf.ofOEdOcEqeOPD5GxQqrxbW', '1', '0');
INSERT INTO `sys_users` VALUES ('13', '18512345671', '185', '$2a$10$n9UOaRZVnNYFPpwH/BMGhumN.NnejG6GeaaHZ2zZrt3NQigISA7j.', '1', '0');

-- ----------------------------
-- Table structure for sys_users_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_role`;
CREATE TABLE `sys_users_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID自增',
  `sys_users_id` bigint(20) NOT NULL COMMENT '用户ID',
  `sys_role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_role
-- ----------------------------
INSERT INTO `sys_users_role` VALUES ('1', '1', '1');
INSERT INTO `sys_users_role` VALUES ('2', '1', '2');
INSERT INTO `sys_users_role` VALUES ('3', '1', '3');
INSERT INTO `sys_users_role` VALUES ('4', '1', '4');
INSERT INTO `sys_users_role` VALUES ('5', '8', '4');

-- ----------------------------
-- Table structure for task_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `task_operation_record`;
CREATE TABLE `task_operation_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID, 自增',
  `rec_number` varchar(32) NOT NULL COMMENT '操作记录编号',
  `task_id` bigint(20) unsigned NOT NULL COMMENT '任务编号',
  `operation_id` bigint(20) unsigned DEFAULT NULL COMMENT '操作人ID',
  `operation_man` varchar(20) NOT NULL DEFAULT '' COMMENT '操作人',
  `operation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `rec_number` (`rec_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_operation_record
-- ----------------------------
INSERT INTO `task_operation_record` VALUES ('1', 'e6b4c059087a4c168d8b45ef18555c0d', '6', '1', '张三', '2019-07-28 19:51:51', '分派任务');
INSERT INTO `task_operation_record` VALUES ('2', 'e4f55c0cd7c3430fb33ab751f9247937', '6', '1', '张三', '2019-07-28 19:58:04', '修改任务');
INSERT INTO `task_operation_record` VALUES ('3', '8fd3c5de78144c7f9555c998b5b45042', '5', '1', '张三', '2019-07-28 19:59:41', '修改任务');
INSERT INTO `task_operation_record` VALUES ('4', 'a0fe1be8a08148c6924283d7d97e9c97', '5', '1', '张三', '2019-07-28 20:01:53', '修改任务');
INSERT INTO `task_operation_record` VALUES ('5', '218af362b31e43e8b06b6e79bd7f107a', '5', '1', '张三', '2019-07-28 20:07:34', '分派任务');
INSERT INTO `task_operation_record` VALUES ('6', 'f6215e1c7c764a23adcf96cf610c6937', '4', '1', '张三', '2019-07-28 20:08:14', '修改任务');
INSERT INTO `task_operation_record` VALUES ('7', '0fac14965c744eb0bdf65cab6ac728b4', '4', '1', '张三', '2019-07-28 20:08:15', '修改任务');
INSERT INTO `task_operation_record` VALUES ('8', '40e23b2a88c14370bd76bc114f9f2165', '5', '1', '张三', '2019-07-28 20:32:58', '延迟任务');
INSERT INTO `task_operation_record` VALUES ('9', '0c954edb3f07456f9861f99df6fdf79c', '6', '1', '张三', '2019-07-28 20:33:17', '取消任务');
INSERT INTO `task_operation_record` VALUES ('10', '2ae47303cffb499fa3b7c947f18caa01', '6', '1', '张三', '2019-07-28 20:33:17', '取消任务');
INSERT INTO `task_operation_record` VALUES ('11', 'b0a63393757a455c9460aa1ecb8b31fe', '5', '1', '张三', '2019-07-28 20:35:01', '取消任务');
INSERT INTO `task_operation_record` VALUES ('12', '2fd1cbbb90e8415ba3962aa0dfac0387', '5', '1', '张三', '2019-07-28 20:35:01', '取消任务');
INSERT INTO `task_operation_record` VALUES ('13', 'f15eefcd7d2741d6abd4abb8bf0937cd', '5', '1', '张三', '2019-07-28 20:35:01', '取消任务');
INSERT INTO `task_operation_record` VALUES ('14', 'e8b51191736d486b8e6b0d66b37b0725', '5', '1', '张三', '2019-07-28 20:35:01', '取消任务');
INSERT INTO `task_operation_record` VALUES ('15', 'cf3cac5442f844dbbb94b301e4a06744', '7', '1', '张三', '2019-07-28 20:38:31', '取消任务');
INSERT INTO `task_operation_record` VALUES ('16', '51cee33d21a84567a184d1ea77b5cf33', '8', '1', '张三', '2019-07-29 18:17:02', '创建任务');

-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '类型ID, 自增',
  `type_number` varchar(32) NOT NULL COMMENT '类型编号',
  `type_name` varchar(20) NOT NULL COMMENT '类型名称',
  `parent_id` bigint(20) unsigned DEFAULT '0' COMMENT '父类型',
  `default_dest_name` varchar(20) DEFAULT NULL,
  `default_dest` bigint(20) unsigned DEFAULT NULL COMMENT '默认地址, 关联空间代码ID',
  `trans_time_code_id` bigint(20) unsigned NOT NULL COMMENT '时间代码',
  `grade` tinyint(1) NOT NULL COMMENT '等级',
  `urgent_time` int(2) NOT NULL DEFAULT '0' COMMENT '紧急提醒时间 (单位: 分)',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态， 0-不可用，1-可以',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `modify_id` bigint(20) unsigned DEFAULT NULL,
  `modify_name` varchar(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_number` (`type_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_type
-- ----------------------------
INSERT INTO `task_type` VALUES ('1', 'c6cf21aa550c4ede939b7ace7a7d77ac', '单据', '0', '小儿内科', '2', '1', '1', '1', '1', '空军总医院', '2019-07-20 11:34:32', '0', '0', null, null, null);
INSERT INTO `task_type` VALUES ('2', '6ac64bb2bfc047278a4b5d5edc294deb', '1111', '0', '111', '10', '1', '1', '22', '1', '空军总医院', '2019-07-20 11:34:53', '0', '1', '1', '张三', '2019-07-31 17:36:51');
INSERT INTO `task_type` VALUES ('3', '56e9c2a9406b4a4ea4a7aa0b877c2d3b', '化验单', '0', '耳鼻喉', '4', '0', '1', '10', '1', '空军总医院', '2019-07-31 17:39:42', '1', '0', '1', '张三', '2019-07-31 17:39:42');
INSERT INTO `task_type` VALUES ('4', '15f599d26ff041178b317e6170d5e74a', 'aaa', '0', '骨科一室', '5', '1', '1', '11', '1', '空军总医院', '2019-08-01 21:18:33', '1', '0', '1', '张三', '2019-08-01 21:18:33');

-- ----------------------------
-- Table structure for transport_task
-- ----------------------------
DROP TABLE IF EXISTS `transport_task`;
CREATE TABLE `transport_task` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `task_number` varchar(32) NOT NULL COMMENT '任务编号',
  `task_name` varchar(30) NOT NULL COMMENT '任务名称',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者ID',
  `create_name` varchar(20) NOT NULL COMMENT '创建者姓名',
  `task_type_id` bigint(20) unsigned NOT NULL COMMENT '任务类型ID',
  `task_type_name` varchar(20) NOT NULL COMMENT '任务类型名称',
  `set_out_place_id` bigint(20) unsigned DEFAULT NULL COMMENT '出发地ID, 关联空间代码ID',
  `set_out_place_name` varchar(20) NOT NULL DEFAULT '' COMMENT '出发地',
  `destination_id` bigint(20) unsigned DEFAULT NULL COMMENT '目的地ID, 关联空间信息ID',
  `destination_name` varchar(20) NOT NULL DEFAULT '' COMMENT '目的地名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `patient_number` varchar(32) NOT NULL DEFAULT '' COMMENT '病人信息编号',
  `plan_start_time` datetime DEFAULT NULL COMMENT '计划开始时间',
  `finish_time` int(2) NOT NULL DEFAULT '0' COMMENT '预计完成用时',
  `book_time` int(2) NOT NULL DEFAULT '0' COMMENT '预约时间',
  `priority` tinyint(1) NOT NULL DEFAULT '0' COMMENT '优先级 0-正常, 1-重要,2-紧急, 3-紧急重要',
  `tool_id` bigint(20) unsigned DEFAULT NULL COMMENT '运转工具ID',
  `tool_name` varchar(20) NOT NULL DEFAULT '' COMMENT '运转工具',
  `worker_id` bigint(20) unsigned DEFAULT NULL COMMENT '运送员',
  `worker_name` varchar(20) NOT NULL DEFAULT '' COMMENT '运送员姓名',
  `actual_count` int(2) NOT NULL DEFAULT '1' COMMENT '实际运送数量',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '任务状态，0-未分配,1-未查阅,2-未开始,3-进行中,4-未结束,5-已完成,6-已取消',
  `cancel_reason` varchar(20) NOT NULL DEFAULT '' COMMENT '取消原因',
  `delay_reason` varchar(20) NOT NULL DEFAULT '' COMMENT '延迟原因',
  `task_desc` varchar(100) NOT NULL DEFAULT '' COMMENT '任务描述',
  `task_remark` varchar(100) NOT NULL DEFAULT '' COMMENT '任务备注',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_number` varchar(10) NOT NULL COMMENT '所属项目物编号',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `get_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '任务分配类型 1-分配, 2-自主获取',
  PRIMARY KEY (`id`),
  UNIQUE KEY `task_number` (`task_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transport_task
-- ----------------------------
INSERT INTO `transport_task` VALUES ('1', 'd35a98f5b01c4c01bd93f1b280d4a398', '', '1', '张三', '2', '化验单', null, '', null, '', '2019-07-24 15:00:27', '', '2019-07-24 02:07:57', '1', '1', '1', null, '', '4', '顽固', '1', '6', '--请选择--', '预约延后', '', '', '1', '0000000000', '医院', '0');
INSERT INTO `transport_task` VALUES ('2', 'f12e2189fc7b4e68a5349150a2347ea9', '', '1', '张三', '1', '单据', '2', '小儿内科', '1', '小儿外科', '2019-07-24 15:12:49', '2e57bb11f69345fd99a0e4b09f208528', '2019-07-24 03:07:08', '1', '1', '1', null, '--请选择--', '4', '顽固', '1', '6', '误报', '', '111', '', '1', '0000000000', '医院', '0');
INSERT INTO `transport_task` VALUES ('3', '6d618dd0bc6b420dab13682b156d6fac', '', '1', '张三', '2', '化验单', '1', '小儿外科', '2', '小儿内科', '2019-07-26 15:25:56', '0e600c1efefe4ea7bf96a3bd1a869f31', '2019-07-26 07:07:43', '0', '10', '1', '2', '轮椅1', '3', '里斯', '1', '0', '', '', '22', '', '1', '0000000000', '空军总医院', '0');
INSERT INTO `transport_task` VALUES ('4', 'c84138d1230a4ce09e3aeba1b7127899', '', '1', '张三', '1', '单据', '2', '小儿内科', '1', '小儿外科', '2019-07-26 17:09:28', 'fba5bf19f6984260a4dc18709c33ef63', '2019-07-28 19:22:00', '1', '10', '1', '4', '测试3', '4', '顽固', '1', '1', '', '医师不在', '测试', '', '1', '0000000000', '空军总医院', '0');
INSERT INTO `transport_task` VALUES ('5', '5674fec391e44ba58444269966031e73', '', '1', '张三', '1', '单据', '2', '小儿内科', '1', '小儿外科', '2019-07-26 18:17:15', '39057ffcbc5c4843997bc721b95d13d6', '2019-07-28 19:22:00', '1', '10', '1', '4', '测试3', '4', '顽固', '1', '6', '无检验单', '预约延后', '测试', '', '1', '0000000000', '空军总医院', '1');
INSERT INTO `transport_task` VALUES ('6', '15939e01f299411f95199e1e9f91c813', '', '1', '张三', '2', '化验单', '2', '小儿内科', '1', '小儿外科', '2019-07-27 16:19:03', 'cb317d2fc69b4941ac1d422d15b815d2', '2019-07-28 19:30:17', '0', '10', '1', '2', '轮椅1', '1', '张三', '1', '6', '病人原因临时取消', '', '测试', '', '1', '0000000000', '空军总医院', '1');
INSERT INTO `transport_task` VALUES ('7', '533b1c6dfb5e4a129f030bfd781a2514', '', '1', '张三', '1', '单据', '2', '小儿内科', '1', '小儿外科', '2019-07-28 19:23:42', 'd1e49501c1d74fde9f9c89feb0a1c7da', '2019-07-28 19:22:00', '1', '10', '1', '2', '轮椅1', '1', '张三', '1', '6', '无检验单', '', '测试', '', '1', '0000000000', '空军总医院', '0');
INSERT INTO `transport_task` VALUES ('8', '6faf48a476474d51ab7450a5c5783f08', '', '1', '张三', '1', '单据', '2', '小儿内科', '1', '小儿外科', '2019-07-29 18:17:02', '', '2019-07-29 18:17:00', '10', '10', '1', '2', '轮椅1', null, '', '1', '0', '', '', '', '', '1', '0000000000', '空军总医院', '0');

-- ----------------------------
-- Table structure for transport_time_code
-- ----------------------------
DROP TABLE IF EXISTS `transport_time_code`;
CREATE TABLE `transport_time_code` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 自增',
  `time_code` varchar(20) NOT NULL DEFAULT '',
  `code_name` varchar(20) NOT NULL COMMENT '名称',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `effective_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生效日期',
  `reserve_time` int(2) NOT NULL DEFAULT '5' COMMENT '预约时间(单位 分)',
  `standard_time` int(2) NOT NULL DEFAULT '10' COMMENT '标准时间 (单位 分)',
  `warn_time` int(2) NOT NULL DEFAULT '5' COMMENT '警告时间 (单位 分)',
  `critical_time` int(2) NOT NULL DEFAULT '1' COMMENT '危急 (单位 分)',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除，1-删除',
  `modify_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改者ID',
  `modify_name` varchar(20) NOT NULL DEFAULT '' COMMENT '修改者姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `time_code_idx` (`time_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transport_time_code
-- ----------------------------
INSERT INTO `transport_time_code` VALUES ('1', 'SJ', '时间', '1', '空军总医院', '2019-08-02 04:38:16', '10', '15', '10', '5', '0', '1', '张三', '2019-08-01 20:38:36');
INSERT INTO `transport_time_code` VALUES ('2', 'CS', '测试', '1', '空军总医院', '2019-08-02 04:44:36', '11', '1', '1', '1', '1', '1', '张三', '2019-08-01 20:48:45');

-- ----------------------------
-- Table structure for worker_info
-- ----------------------------
DROP TABLE IF EXISTS `worker_info`;
CREATE TABLE `worker_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户详情ID 自增',
  `user_id` bigint(20) unsigned NOT NULL,
  `worker_number` varchar(10) NOT NULL COMMENT '用户编号',
  `worker_name` varchar(20) NOT NULL COMMENT '姓名',
  `id_card_no` varchar(18) NOT NULL COMMENT '用户身份证号码',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别',
  `phone` varchar(15) NOT NULL DEFAULT '' COMMENT '联系电话',
  `mobile` varchar(11) NOT NULL COMMENT '运送员手机号',
  `urgent_name` varchar(20) NOT NULL DEFAULT '' COMMENT '紧急联系人',
  `urgent_phone` varchar(15) NOT NULL DEFAULT '' COMMENT '紧急联系方式',
  `join_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  `worker_group` bigint(20) unsigned DEFAULT NULL,
  `job` varchar(10) NOT NULL DEFAULT '' COMMENT '岗位',
  `loop_time` int(2) NOT NULL DEFAULT '0' COMMENT '循环组循环时间（单位：分）',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  `struct_id` bigint(20) unsigned NOT NULL COMMENT '责任建筑ID',
  `struct_name` varchar(20) NOT NULL COMMENT '责任建筑物名称',
  `province` varchar(10) NOT NULL DEFAULT '' COMMENT '省',
  `city` varchar(20) NOT NULL DEFAULT '' COMMENT '市',
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT '详细地址',
  `personnel_number` varchar(10) DEFAULT NULL COMMENT '人事处编号',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0-离岗，1-在岗，2-已离职',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_card_no` (`id_card_no`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker_info
-- ----------------------------
INSERT INTO `worker_info` VALUES ('1', '1', '123456', '张三', '1234567890', '2019-07-01', '0', '', '18512345678', '', '', '2019-07-20 11:17:44', '1', '', '0', '1', '空军总医院', '1', '11', '', '', '', null, '', '1', '0');
INSERT INTO `worker_info` VALUES ('3', '8', 'lisi', '里斯', '12345678901', '1984-08-08', '0', '', '12311111112', '', '', '2019-07-24 08:00:00', '2', '按不出', '0', '1', '空军总医院', '2', '门诊楼', '河北', '保定', '四十四好', '00001', '', '2', '0');
INSERT INTO `worker_info` VALUES ('4', '9', 'wangu', '顽固', '0987654431', '1997-07-15', '0', '0393-00000000', '12400000000', '', '0393-00000001', '2019-07-24 14:54:34', '1', '运送员', '0', '1', '空军总医院', '2', '门诊楼', '河南', '濮阳', '范县颜村铺', '1110', '', '0', '0');
INSERT INTO `worker_info` VALUES ('5', '11', '111111', '11111', '11111111111009', '2019-08-22', '0', '', '11111111111', '', '', '2019-08-08 08:00:00', '2', '', '0', '1', '空军总医院', '2', '门诊楼', '', '', '', '', '', '0', '1');
INSERT INTO `worker_info` VALUES ('6', '13', '185', '操操', '1211a1312121', '2019-08-01', '0', '', '18512345671', '', '', '2019-08-01 08:00:00', '1', '', '0', '1', '空军总医院', '2', '门诊楼', '', '', '', '11111', '', '0', '0');

-- ----------------------------
-- Table structure for worker_log
-- ----------------------------
DROP TABLE IF EXISTS `worker_log`;
CREATE TABLE `worker_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，自增',
  `log_number` varchar(32) NOT NULL COMMENT '日志ID',
  `worker_id` bigint(20) unsigned NOT NULL COMMENT '运送员ID',
  `worker_name` varchar(20) NOT NULL COMMENT '运送员姓名',
  `task_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '任务ID',
  `log_type` tinyint(1) NOT NULL COMMENT '日志类型 0-登录, 1-扫码, 2-退出',
  `position` varchar(10) DEFAULT NULL COMMENT '扫码地点',
  `log_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `log_number` (`log_number`),
  KEY `log_time` (`log_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for worker_task
-- ----------------------------
DROP TABLE IF EXISTS `worker_task`;
CREATE TABLE `worker_task` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `worker_id` bigint(20) unsigned NOT NULL COMMENT '运送员ID',
  `current_position` varchar(10) NOT NULL DEFAULT '' COMMENT '当前位置',
  `last_login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `scan_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '扫描时间',
  `total_count` int(2) NOT NULL DEFAULT '0' COMMENT '总共处理任务数',
  `today_count` int(2) NOT NULL DEFAULT '0' COMMENT '今日处理任务数',
  `self_count` int(2) NOT NULL DEFAULT '0' COMMENT '自主任务数',
  `today_self_count` int(2) NOT NULL DEFAULT '0' COMMENT '今日自主数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `worker_id` (`worker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker_task
-- ----------------------------
INSERT INTO `worker_task` VALUES ('1', '1', '儿科一室', '2019-08-03 20:34:23', '2019-07-24 14:42:22', '3', '0', '0', '0');
INSERT INTO `worker_task` VALUES ('2', '4', '', '2019-07-24 14:54:34', '2019-07-24 14:54:34', '1', '0', '0', '0');
INSERT INTO `worker_task` VALUES ('3', '5', '', '2019-08-01 15:45:45', '2019-08-01 15:45:45', '0', '0', '0', '0');
INSERT INTO `worker_task` VALUES ('4', '6', '', '2019-08-03 20:06:18', '2019-08-03 20:06:18', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for work_tools
-- ----------------------------
DROP TABLE IF EXISTS `work_tools`;
CREATE TABLE `work_tools` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '运转工具ID,自增',
  `tool_code` varchar(32) NOT NULL COMMENT '运转工具编号',
  `tool_name` varchar(20) NOT NULL COMMENT '运转工具名称',
  `pro_id` bigint(20) unsigned NOT NULL COMMENT '所属项目ID',
  `pro_name` varchar(20) NOT NULL COMMENT '所属项目名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_tools
-- ----------------------------
INSERT INTO `work_tools` VALUES ('2', '001', '轮椅1', '1', '空军总医院');
INSERT INTO `work_tools` VALUES ('4', '111', '测试3', '1', '空军总医院');
