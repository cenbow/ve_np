/*
Navicat MySQL Data Transfer

Source Server         : 192.168.62.197
Source Server Version : 50620
Source Host           : 192.168.62.197:3306
Source Database       : ve_java_user

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-03-20 16:30:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for supplier_company
-- ----------------------------
DROP TABLE IF EXISTS `supplier_company`;
CREATE TABLE `supplier_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商所属公司ID',
  `name` varchar(100) NOT NULL COMMENT '供应商所属公司名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier_company
-- ----------------------------
INSERT INTO `supplier_company` VALUES ('1', '杭州公司', '1');
INSERT INTO `supplier_company` VALUES ('2', '宁波公司', '2');
INSERT INTO `supplier_company` VALUES ('5', '北京公司', '3');
INSERT INTO `supplier_company` VALUES ('6', '纽约公司', '7');
INSERT INTO `supplier_company` VALUES ('7', '绍兴公司', '6');
INSERT INTO `supplier_company` VALUES ('8', '飞机公司', '10');

-- ----------------------------
-- Table structure for supplier_extra_info
-- ----------------------------
DROP TABLE IF EXISTS `supplier_extra_info`;
CREATE TABLE `supplier_extra_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `show_name` varchar(30) DEFAULT NULL COMMENT '页面显示名',
  `supplier_name` varchar(30) NOT NULL COMMENT '供应商全称，注意与供应商名称区分开来',
  `is_default` tinyint(4) DEFAULT '0' COMMENT '默认供应商',
  `address` varchar(100) DEFAULT NULL COMMENT '退货地址',
  `tel` varchar(30) NOT NULL COMMENT '电话',
  `zip` varchar(30) DEFAULT NULL COMMENT '邮编',
  `division_id` tinyint(4) DEFAULT NULL COMMENT '部门id',
  `contact_name` varchar(30) NOT NULL COMMENT '退货联系人',
  `contact_position` varchar(30) NOT NULL COMMENT '联系人职位',
  `contact_idcard` varchar(30) NOT NULL COMMENT '联系人身份证',
  `contact_mobile` varchar(30) NOT NULL COMMENT '联系人电话',
  `contact_qq` varchar(30) NOT NULL COMMENT '联系人qq',
  `contact_email` varchar(30) NOT NULL COMMENT '联系人邮箱',
  `type` tinyint(4) DEFAULT '0' COMMENT '供应商类型(0普通类型，1海外直邮，2保税直邮)',
  `buy_limit` tinyint(4) DEFAULT NULL COMMENT '购买限制，例如海外直邮限制数量，包税直邮\r\n\r\n限制金额500元',
  `storage_delivery_id` tinyint(4) DEFAULT NULL COMMENT '发货仓',
  `license_no` varchar(30) NOT NULL COMMENT '营业执照注册号',
  `license_begin` int(11) NOT NULL COMMENT '营业执照开始时间',
  `license_end` int(11) NOT NULL COMMENT '营业执照结束时间',
  `license_addr` varchar(100) NOT NULL COMMENT '营业执照所在地',
  `reg_capital` int(10) NOT NULL COMMENT '注册资金',
  `bus_scope` varchar(200) NOT NULL COMMENT '经营范围',
  `legal_person_name` varchar(18) NOT NULL COMMENT '法人名字',
  `contact_address` varchar(100) DEFAULT NULL COMMENT '联系人地址',
  `fax` varchar(30) DEFAULT NULL COMMENT '传真',
  `website` varchar(64) DEFAULT NULL COMMENT '公司网址',
  `brands` varchar(128) NOT NULL COMMENT '旗下母婴品牌/代理',
  `tmall_website` varchar(128) DEFAULT NULL COMMENT '淘宝/天猫店网址',
  `license_scan_img` varchar(128) NOT NULL COMMENT '营业执照扫描件',
  `org_scan_img` varchar(128) NOT NULL COMMENT '组织机构代码证扫描件',
  `tax_scan_img` varchar(128) NOT NULL COMMENT '税务登记证件扫描件(国税或者地税)',
  `idcard_front_img` varchar(128) NOT NULL COMMENT '法人身份证正面',
  `idcard_reverse_img` varchar(128) NOT NULL COMMENT '法人身份证反面',
  `auth_status` tinyint(4) DEFAULT '0' COMMENT '审核状态 0-默认 1-忽略 2-退回修改 3-通\r\n\r\n过',
  `remark` text COMMENT '审核备注',
  `is_capital` tinyint(4) DEFAULT '0' COMMENT '是否交了保证金',
  `guarantee_capital` bigint(20) DEFAULT '0' COMMENT '已收保证金',
  `recruiter_id` bigint(20) DEFAULT NULL COMMENT '招商人员id',
  `company` int(11) DEFAULT NULL COMMENT '所属公司id',
  `straight_point` bigint(20) DEFAULT '0' COMMENT '直发扣点',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除状态：0正常/1删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier_extra_info
-- ----------------------------
INSERT INTO `supplier_extra_info` VALUES ('1', '19', '什么公1司', '这是个大公司2', '0', '杭州市4', '13459786524', null, null, '大神1', '大老板1', '362324199110235719', '13589765981', '7420019281', '41325451@qq.com', '0', null, null, 'fds32145sd4f5sd1', '20140203', '20150304', '华星时代广场1', '1100', 'fdsafsda', '程序员1', '文三路2', null, null, '大王纸尿裤1', null, 'www.baidu.com1', 'www.baidu.com1', 'www.ve.cn', 'http://www.ve.cn', 'http://www.ve.cn', '0', null, '0', '0', null, null, '0', '0', '2015-02-27 19:43:43', '2015-02-27 19:43:43');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `img_url` varchar(255) DEFAULT NULL,
  `integral` bigint(20) DEFAULT '0' COMMENT '用户积分值',
  `experience` bigint(20) DEFAULT '0' COMMENT '用户经验值',
  `phone_no` varchar(255) DEFAULT NULL COMMENT '座机号码',
  `m_phone_no` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `status` tinyint(4) DEFAULT '0' COMMENT '用户状态：正常:0/冻结:1',
  `feature_mark` bigint(20) DEFAULT '1000' COMMENT '特征标记，以二进制位的方式来使用',
  `role` tinyint(4) DEFAULT '0' COMMENT '角色 普通买家角色:0/供应商:1',
  `recommender_id` bigint(20) DEFAULT NULL COMMENT '推荐人ID',
  `inviter_id` bigint(20) DEFAULT NULL COMMENT '邀请人ID',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '逻辑删除标识 未删除:0/已删除:1/回收站:2',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yezhenglei', 'zl123456', null, null, null, null, '18668017860', '742001918@qq.com', '1', null, null, null, null, '0', null, '2015-01-24 16:21:13');
INSERT INTO `user` VALUES ('6', 'yezhenglei1', 'fsd123456', null, '0', '0', null, '18668017861', '742001928@qq.com', '0', '1000', '0', null, null, '0', null, '2015-02-10 10:17:26');
INSERT INTO `user` VALUES ('7', 'yezhenglei2', 'fsd123456fd', null, '0', '0', null, null, '123fdsfd@qq.com', '1', '1000', '0', null, null, '0', null, null);
INSERT INTO `user` VALUES ('8', 'yezhenglei3', 'fsd1d23456fd', null, '0', '0', null, null, '123fdsfdd@qq.com', '1', '1000', '0', null, null, '0', null, null);
INSERT INTO `user` VALUES ('9', 'yezhenglei4', 'fsd1d23456fdd', null, '0', '0', null, null, '123fddsfdd@qq.com', '1', '1000', '0', null, null, '0', '2015-01-19 11:31:27', '2015-02-09 20:15:46');
INSERT INTO `user` VALUES ('10', '13429697712', 'dfsd1d23456fdd', null, '999', '0', null, '13429697712', null, '0', '1000', '0', null, null, '0', '2015-01-19 11:58:18', '2015-01-19 11:58:18');
INSERT INTO `user` VALUES ('11', '我爱睡觉', 'np523568', null, '10008', '0', null, '13569874512', null, '0', '1000', '1', null, null, '0', '2015-01-20 13:46:48', '2015-01-20 13:46:47');
INSERT INTO `user` VALUES ('12', '我爱睡觉2', 'np5235682', null, '0', '0', null, '13569874511', null, '0', '1000', '0', null, null, '0', '2015-01-20 13:50:23', '2015-01-30 19:25:11');
INSERT INTO `user` VALUES ('13', '我爱睡觉3', 'np52356822', null, '0', '0', null, '13569874516', null, '0', '1000', '0', null, null, '1', '2015-01-20 13:55:17', '2015-02-10 09:51:32');
INSERT INTO `user` VALUES ('14', '我爱睡觉4', 'np5356822', null, '0', '0', null, '13769874516', null, '0', '1000', '0', null, null, '0', '2015-01-20 13:56:42', '2015-02-09 17:05:00');
INSERT INTO `user` VALUES ('15', '我爱睡觉5', 'np53f56822', null, '0', '0', null, '13769874116', '1ddsfdd@qq.com', '0', '1000', '0', null, null, '0', '2015-01-21 21:02:30', '2015-01-21 21:02:30');
INSERT INTO `user` VALUES ('16', '我爱睡觉6', 'np536f56822', null, '0', '0', null, '13769574116', '1dds6fdd@qq.com', '0', '1000', '0', null, null, '0', '2015-01-22 19:42:43', '2015-01-22 19:42:43');
INSERT INTO `user` VALUES ('17', '我爱睡觉7', 'np5566822', null, '0', '0', null, '13769575116', '1dddd@qq.com', '0', '1000', '0', null, null, '0', '2015-01-24 15:34:35', '2015-01-24 15:34:35');
INSERT INTO `user` VALUES ('18', '我爱睡觉8', 'np65566822', null, '0', '0', null, '13760575116', '1dqddd@qq.com', '0', '1000', '0', null, null, '0', '2015-01-24 15:37:28', '2015-01-24 15:37:28');
INSERT INTO `user` VALUES ('19', '我爱睡觉9', 'np655622', null, '0', '0', null, '13761575116', '1dqdd@qq.com', '0', '1000', '1', null, null, '0', '2015-01-27 19:53:45', '2015-01-27 19:53:45');
INSERT INTO `user` VALUES ('26', '唯一特卖邮箱公司', 'ye123456', null, '0', '0', null, null, '413545@qq.com', '0', '1000', '0', null, null, '0', '2015-01-27 20:11:59', '2015-01-27 20:11:59');
INSERT INTO `user` VALUES ('27', '我爱睡觉10', 'np6575e622', null, '0', '0', null, '15762575116', '2dq7ded@qq.com', '0', '1000', '0', null, null, '0', '2015-01-30 10:23:40', '2015-01-30 10:23:40');
INSERT INTO `user` VALUES ('28', '我爱睡觉12', 'np6575e6d22', null, '0', '0', null, '15262575116', '2dq7d3ed@qq.com', '0', '1000', '0', null, null, '0', '2015-01-30 14:49:49', '2015-01-30 14:49:49');
INSERT INTO `user` VALUES ('29', '我爱睡觉13', 'np6575e6d22', null, '0', '0', null, '15162575116', '2dq7d3e3d@qq.com', '0', '1000', '0', null, null, '0', '2015-02-06 13:46:48', '2015-02-06 13:46:48');
INSERT INTO `user` VALUES ('30', '我爱睡觉14', 'np26575e6d22', 'www.google.com', '0', '0', null, '18668017862', '742001948@qq.com', '0', '1000', '1', '26', '27', '0', '2015-02-09 15:54:17', '2015-02-28 14:04:52');
INSERT INTO `user` VALUES ('31', '我爱睡觉15', 'np26575ed6d22', null, '0', '0', null, '13262575116', '2dq7dd323d@qq.com', '0', '1000', '0', '26', '27', '0', '2015-02-11 18:03:56', '2015-02-11 18:03:56');
INSERT INTO `user` VALUES ('36', '我爱睡觉19', 'xxyyzz123', null, '0', '0', null, null, '742001368@qq.com', '0', '1000', '0', null, null, '0', '2015-02-11 20:24:13', '2015-02-11 20:24:13');
INSERT INTO `user` VALUES ('38', '我爱睡觉111', 'np2675e6d22', null, '888', '888', null, '13162575176', '2dq7d33d@qq.com', '0', '1000', '1', '26', '27', '0', '2015-02-27 16:21:22', '2015-02-27 16:21:22');
INSERT INTO `user` VALUES ('39', '我爱睡觉112', 'np2675e6d22', 'http://www.baidu.com', '888', '888', null, '15162575176', '2ddq7d33d@qq.com', '0', '1000', '1', '26', '27', '0', '2015-02-27 17:03:36', '2015-02-27 17:03:36');
INSERT INTO `user` VALUES ('40', 'æç±ç¡è§1010', 'fds4254534', null, '0', '0', null, '15279156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:07:27', '2015-03-04 11:07:27');
INSERT INTO `user` VALUES ('41', 'æç±ç¡è§010', 'fds4254534', null, '0', '0', null, '15179156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:10:02', '2015-03-04 11:10:02');
INSERT INTO `user` VALUES ('42', 'æç±ç¡è§0100', 'fds4254534', null, '0', '0', null, '15379156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:10:42', '2015-03-04 11:10:42');
INSERT INTO `user` VALUES ('43', 'æç±ç¡è§00', 'fds4254534', null, '0', '0', null, '15479156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:12:29', '2015-03-04 11:12:29');
INSERT INTO `user` VALUES ('44', 'æç±ç¡è§11', 'fds4254534', null, '0', '0', null, '15579156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:13:51', '2015-03-04 11:13:51');
INSERT INTO `user` VALUES ('45', 'æç±ç¡è§101', 'fds4254534', null, '0', '0', null, '15679156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:21:44', '2015-03-04 11:21:44');
INSERT INTO `user` VALUES ('46', 'æç±ç¡101', 'fds4254534', null, '0', '0', null, '15779156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:30:47', '2015-03-04 11:30:47');
INSERT INTO `user` VALUES ('47', 'æç±101', 'fds4254534', null, '0', '0', null, '15879156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:40:08', '2015-03-04 11:40:08');
INSERT INTO `user` VALUES ('48', 'æ1011', 'fds4254534', null, '0', '0', null, '15979156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:45:36', '2015-03-04 11:45:36');
INSERT INTO `user` VALUES ('49', 'æè°1011', 'fds4254534', null, '0', '0', null, '15079156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 11:50:41', '2015-03-04 11:50:41');
INSERT INTO `user` VALUES ('50', 'æè°j1011', 'fds4254534', null, '0', '0', null, '13079156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 12:36:57', '2015-03-04 12:36:57');
INSERT INTO `user` VALUES ('51', 'ÎÒË­L1011', 'fds4254534', null, '0', '0', null, '13179156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 12:37:46', '2015-03-04 12:37:46');
INSERT INTO `user` VALUES ('52', 'æè°k1011', 'fds4254534', null, '0', '0', null, '13379156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 12:42:13', '2015-03-04 12:42:13');
INSERT INTO `user` VALUES ('53', 'æè°p1011', 'fds4254534', null, '0', '0', null, '13879156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 13:41:03', '2015-03-04 13:41:03');
INSERT INTO `user` VALUES ('54', 'æè°x1011', 'fds4254534', null, '0', '0', null, '13819156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 13:54:07', '2015-03-04 13:54:07');
INSERT INTO `user` VALUES ('55', 'æè°m1011', 'fds4254534', null, '0', '0', null, '13849156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 14:33:05', '2015-03-04 14:33:05');
INSERT INTO `user` VALUES ('56', 'æè°n1011', 'fds4254534', null, '0', '0', null, '13859156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 14:34:22', '2015-03-04 14:34:22');
INSERT INTO `user` VALUES ('57', 'æp1011', 'fds4254534', null, '0', '0', null, '13869156572', null, '0', '1000', '0', null, null, '0', '2015-03-04 14:57:20', '2015-03-04 14:57:20');
INSERT INTO `user` VALUES ('58', '我rr1011', 'fds4254534', null, '0', '0', null, '13879256572', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:10:37', '2015-03-04 15:10:37');
INSERT INTO `user` VALUES ('59', '我日1011', 'fds4254534', null, '0', '0', null, '13879256562', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:12:37', '2015-03-04 15:12:37');
INSERT INTO `user` VALUES ('60', '我日日11', 'fds4254534', null, '0', '0', null, '13870256562', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:14:40', '2015-03-04 15:14:40');
INSERT INTO `user` VALUES ('61', '日日11', 'fds4254534', null, '0', '0', null, '13870253562', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:16:21', '2015-03-04 15:16:21');
INSERT INTO `user` VALUES ('62', '日发11', 'fds4254534', null, '0', '0', null, '13870253552', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:16:57', '2015-03-04 15:16:57');
INSERT INTO `user` VALUES ('63', '日发否11', 'fds4254534', null, '0', '0', null, '13870253551', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:18:30', '2015-03-04 15:18:30');
INSERT INTO `user` VALUES ('64', '日否11', 'fds4254534', null, '0', '0', null, '15870253551', null, '0', '1000', '0', null, null, '0', '2015-03-04 15:18:52', '2015-03-04 15:18:52');
INSERT INTO `user` VALUES ('65', '日否否11', 'fds4254534', null, '0', '0', null, '15830253551', null, '0', '1000', '0', null, null, '0', '2015-03-04 17:17:29', '2015-03-04 17:17:29');
INSERT INTO `user` VALUES ('66', '否否11', 'fds4254534', null, '0', '0', null, '15831253551', null, '0', '1000', '0', null, null, '0', '2015-03-04 17:21:14', '2015-03-04 17:21:14');
INSERT INTO `user` VALUES ('67', '否否101', 'fds4254534', null, '0', '0', null, '15831053551', null, '0', '1000', '0', null, null, '0', '2015-03-04 17:22:03', '2015-03-04 17:22:03');
INSERT INTO `user` VALUES ('68', '否否f101', 'fds4254534', null, '0', '0', null, '15831053521', null, '0', '1000', '0', null, null, '0', '2015-03-10 11:50:26', '2015-03-10 11:50:26');

-- ----------------------------
-- Table structure for user_auth_info
-- ----------------------------
DROP TABLE IF EXISTS `user_auth_info`;
CREATE TABLE `user_auth_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `real_name` varchar(20) NOT NULL COMMENT '用户的真实姓名',
  `idcard_no` varchar(20) NOT NULL COMMENT '身份证号码',
  `idcard_front_img` varchar(200) NOT NULL COMMENT '身份证正面照',
  `idcard_reverse_img` varchar(200) NOT NULL COMMENT '身份证反面照',
  `status` tinyint(4) DEFAULT '0' COMMENT '审核中/审核通过/审核失败,默认审核中',
  `remark` text COMMENT '审核备注',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_auth_info
-- ----------------------------
INSERT INTO `user_auth_info` VALUES ('1', '30', '大大神', '362324199110235719', 'http://society.huanqiu.com/photonew/2015-01/2760449.html', 'http://g.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=f450e5c46e224f4a57cc20536fcaa460/ac4bd11373f082021c0402dd48fbfbedaa641bb9.jpg', '2', 'sb一律不通过', '0', '2015-02-10 17:09:06', '2015-02-10 17:43:25');

-- ----------------------------
-- Table structure for user_baby_info
-- ----------------------------
DROP TABLE IF EXISTS `user_baby_info`;
CREATE TABLE `user_baby_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `baby_name` varchar(50) NOT NULL,
  `baby_status` tinyint(4) DEFAULT NULL COMMENT '宝贝状态：已出生/未出生',
  `baby_sex` tinyint(4) DEFAULT NULL,
  `baby_birthday` int(11) DEFAULT NULL,
  `expected_childbirth_date` int(11) DEFAULT NULL,
  `is_default` tinyint(4) DEFAULT '0',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_baby_info
-- ----------------------------
INSERT INTO `user_baby_info` VALUES ('1', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 17:47:48', '2015-02-10 17:47:48');
INSERT INTO `user_baby_info` VALUES ('2', '30', '飞机飞啊飞', '0', '0', '20160606', '20150606', '0', '1', '2015-02-10 18:09:19', '2015-03-05 14:59:47');
INSERT INTO `user_baby_info` VALUES ('3', '30', '小飞机飞不停', null, null, null, null, '0', '1', '2015-02-10 18:09:37', '2015-02-27 11:23:29');
INSERT INTO `user_baby_info` VALUES ('4', '30', '小飞机飞不停', null, null, null, null, '0', '1', '2015-02-10 18:09:40', '2015-02-27 11:43:00');
INSERT INTO `user_baby_info` VALUES ('5', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 18:09:43', '2015-02-10 18:09:43');
INSERT INTO `user_baby_info` VALUES ('6', '30', '飞机飞啊飞', '0', '0', '20160606', '20150606', '1', '0', '2015-02-10 18:09:47', '2015-02-27 12:03:39');
INSERT INTO `user_baby_info` VALUES ('7', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 18:09:53', '2015-02-10 18:09:53');
INSERT INTO `user_baby_info` VALUES ('8', '30', '小飞机飞不停', null, null, null, null, '0', '1', '2015-02-10 18:09:56', '2015-03-05 15:38:36');
INSERT INTO `user_baby_info` VALUES ('9', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 18:10:11', '2015-02-10 18:10:11');
INSERT INTO `user_baby_info` VALUES ('10', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 18:10:18', '2015-02-10 18:10:18');
INSERT INTO `user_baby_info` VALUES ('11', '30', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-10 18:10:27', '2015-02-10 18:10:27');
INSERT INTO `user_baby_info` VALUES ('12', '31', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-27 10:55:55', '2015-02-27 10:55:55');
INSERT INTO `user_baby_info` VALUES ('13', '31', '小飞机飞不停', null, null, null, null, '0', '0', '2015-02-27 10:59:35', '2015-02-27 11:00:05');
INSERT INTO `user_baby_info` VALUES ('14', '31', '小飞机飞不停', null, null, null, null, '1', '0', '2015-02-27 11:00:05', '2015-02-27 11:00:05');
INSERT INTO `user_baby_info` VALUES ('15', '31', '小飞机飞不停', '1', '0', '20150505', '20150505', '0', '0', '2015-02-28 10:05:28', '2015-02-28 10:05:28');

-- ----------------------------
-- Table structure for user_consignee_info
-- ----------------------------
DROP TABLE IF EXISTS `user_consignee_info`;
CREATE TABLE `user_consignee_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `country` int(11) NOT NULL COMMENT '国家',
  `province` int(11) NOT NULL COMMENT '省',
  `city` int(11) NOT NULL COMMENT '城市',
  `area` int(11) NOT NULL COMMENT '区/县',
  `town` int(11) DEFAULT NULL COMMENT '乡镇',
  `address` varchar(255) NOT NULL COMMENT '详细地址',
  `phone_no` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `mobile_no` varchar(20) NOT NULL COMMENT '手机号码',
  `zip` varchar(10) DEFAULT NULL COMMENT '邮编',
  `consignee` varchar(50) NOT NULL COMMENT '收货人',
  `is_default` tinyint(4) DEFAULT '0' COMMENT '是否默认收货人',
  `remark` varchar(255) DEFAULT NULL COMMENT '收货地址备注',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_consignee_info
-- ----------------------------
INSERT INTO `user_consignee_info` VALUES ('1', '11', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '金刚葫芦娃', '0', '一个藤上8个挂', '2015-01-23 19:46:29', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('2', '11', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '金刚葫芦娃', '0', '一个藤上8个挂', '2015-01-24 10:22:38', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('3', '11', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '金刚葫芦娃', '0', '一个藤上8个挂', '2015-01-24 10:22:49', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('4', '11', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '金刚葫芦娃', '0', '一个藤上8个挂', '2015-01-24 10:23:02', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('5', '11', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '金刚葫芦娃', '0', '一个藤上8个挂', '2015-01-24 10:23:05', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('6', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205', null, '13569874562', null, '老大', '0', '一个藤上7个瓜', '2015-01-28 16:06:58', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('8', '12', '1', '3', '4', '4', null, '文三路华星时代广场1206', null, '13569874562', null, '老三', '0', '一个藤上7个瓜', '2015-01-28 16:54:01', '2015-02-10 16:05:25', '1');
INSERT INTO `user_consignee_info` VALUES ('9', '12', '1', '3', '4', '4', null, '文三路华星时代广场1206', null, '13569874562', null, '老三', '0', '一个藤上7个瓜', '2015-01-28 16:54:28', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('10', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-01-30 15:19:21', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('11', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 15:23:52', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('12', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '1', '一个藤上7个瓜', '2015-02-10 16:39:08', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('13', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 16:43:16', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('14', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:05:30', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('15', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:05:39', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('16', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:06:43', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('17', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:06:49', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('18', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:06:52', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('19', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:06:56', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('20', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:06:59', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('21', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:07:33', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('22', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:07:37', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('23', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:07:41', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('24', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:07:55', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('25', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:08:00', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('26', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:08:05', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('27', '12', '1', '3', '4', '4', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-10 18:08:12', '2015-03-05 16:08:42', '0');
INSERT INTO `user_consignee_info` VALUES ('28', '11', '5', '3', '7', '8', null, '文三路华星时代广场1205-1206', null, '13569874562', null, '老五', '0', '一个藤上7个瓜', '2015-02-26 15:08:56', '2015-02-27 19:34:16', '0');
INSERT INTO `user_consignee_info` VALUES ('29', '11', '5', '3', '7', '8', '9', '文三路华星时代广场1205-1206', '0793-5888888', '13569874562', '334513', '老五', '1', '一个藤上7个瓜', '2015-02-27 19:34:17', '2015-02-27 19:34:17', '0');

-- ----------------------------
-- Table structure for user_extra_info
-- ----------------------------
DROP TABLE IF EXISTS `user_extra_info`;
CREATE TABLE `user_extra_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `country` int(11) DEFAULT NULL COMMENT '国家',
  `province` int(11) DEFAULT NULL COMMENT '省代号',
  `city` int(11) DEFAULT NULL COMMENT '市代号',
  `area` int(11) DEFAULT NULL COMMENT '区/县代号',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` int(11) DEFAULT NULL COMMENT '用户生日',
  `height` int(11) DEFAULT NULL COMMENT '用户身高(精确到cm)',
  `weight` int(11) DEFAULT NULL COMMENT '用户体重(精确到g)',
  `profession` varchar(100) DEFAULT NULL COMMENT '用户职业',
  `alipay_id` varchar(100) DEFAULT NULL COMMENT '支付宝账号',
  `taobao_id` varchar(100) DEFAULT NULL COMMENT '淘宝账号',
  `weibo_id` varchar(100) DEFAULT NULL COMMENT '微博账号',
  `weibo_token` varchar(100) DEFAULT NULL COMMENT '微博令牌',
  `sync_weibo_mark` tinyint(4) DEFAULT NULL,
  `qq_id` varchar(100) DEFAULT NULL COMMENT 'qq号',
  `sync_qq_mark` tinyint(4) DEFAULT NULL,
  `auth_type` int(11) DEFAULT NULL COMMENT '第三方登陆类型',
  `open_id` varchar(100) DEFAULT NULL COMMENT '第三方登陆的openid',
  `source_type` varchar(100) DEFAULT NULL COMMENT '用户从哪个应用市场下载的app',
  `utm_medium` varchar(100) DEFAULT NULL COMMENT '用户从哪个平台被邀请',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_extra_info
-- ----------------------------
INSERT INTO `user_extra_info` VALUES ('1', '30', null, null, null, null, '杭州市文三路', '0', null, null, null, null, '1f2sd', null, null, null, null, null, null, null, null, null, null, '0', '2015-02-11 14:21:28', '2015-02-11 16:24:59');
INSERT INTO `user_extra_info` VALUES ('2', '36', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '123454867534135', null, null, '0', '2015-02-11 20:24:13', '2015-02-11 20:24:13');
INSERT INTO `user_extra_info` VALUES ('4', '38', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '豌豆荚', 'sina', '0', '2015-02-27 16:21:22', '2015-02-27 16:21:22');

-- ----------------------------
-- Table structure for user_extra_property
-- ----------------------------
DROP TABLE IF EXISTS `user_extra_property`;
CREATE TABLE `user_extra_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `property_name` varchar(255) DEFAULT NULL,
  `property_value` varchar(255) DEFAULT NULL,
  `value_type` tinyint(4) DEFAULT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_extra_property
-- ----------------------------

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '组名称',
  `group_no` int(11) NOT NULL COMMENT '组等级号',
  `max_integral` bigint(20) NOT NULL COMMENT '最高积分',
  `min_integral` bigint(20) NOT NULL COMMENT '最低积分',
  `discount` int(5) DEFAULT '100' COMMENT '折扣',
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('16', '英勇黄铜', '1', '300', '0', '85', '2015-02-10 20:14:19', '2015-02-11 11:33:02');
INSERT INTO `user_group` VALUES ('17', '不屈白银', '2', '1000', '300', '80', '2015-02-10 20:14:38', '2015-02-11 11:33:02');
