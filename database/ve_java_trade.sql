/*
Navicat MySQL Data Transfer

Source Server         : 192.168.62.197
Source Server Version : 50620
Source Host           : 192.168.62.197:3306
Source Database       : ve_java_trade

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-03-20 16:30:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for delivery_notice
-- ----------------------------
DROP TABLE IF EXISTS `delivery_notice`;
CREATE TABLE `delivery_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `express_no` varchar(64) DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `is_arrival` tinyint(4) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `order_item_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `memo` varchar(128) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `express` varchar(128) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_notice
-- ----------------------------
INSERT INTO `delivery_notice` VALUES ('1', '1111111', '2015-02-27 16:28:22', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('2', '1111111', '2015-02-27 16:30:29', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('3', '1111111', '2015-02-27 16:43:42', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('4', '1111111', '2015-02-27 16:46:05', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('5', '1111111', '2015-02-27 16:53:39', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('6', '1111111', '2015-02-27 17:00:41', '0', null, '3', '11', null, null, null, 'sf', null);
INSERT INTO `delivery_notice` VALUES ('7', '1111111', '2015-02-27 17:01:27', '0', null, '3', '11', null, null, null, 'sf', null);

-- ----------------------------
-- Table structure for delivery_return
-- ----------------------------
DROP TABLE IF EXISTS `delivery_return`;
CREATE TABLE `delivery_return` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `express_no` varchar(32) DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_item_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `memo` varchar(256) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `return_user` varchar(64) DEFAULT NULL,
  `return_phone` varchar(64) DEFAULT NULL,
  `return_address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_return
-- ----------------------------

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `order_sn` varchar(32) DEFAULT NULL COMMENT '订单号',
  `item_id` bigint(20) DEFAULT NULL,
  `item_sku_id` bigint(20) DEFAULT NULL,
  `unit_price` bigint(20) DEFAULT NULL COMMENT '单价',
  `number` int(11) DEFAULT NULL,
  `total_price` bigint(20) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL COMMENT '配送方式',
  `delivery_status` tinyint(4) DEFAULT NULL,
  `item_name` varchar(256) DEFAULT NULL,
  `return_money` bigint(20) DEFAULT NULL,
  `return_total_money` bigint(20) DEFAULT NULL,
  `return_point` int(11) DEFAULT NULL,
  `return_total_point` int(11) DEFAULT NULL,
  `return_score` int(11) DEFAULT NULL,
  `return_total_score` int(11) DEFAULT NULL,
  `buy_type` tinyint(4) DEFAULT NULL COMMENT '购买类型',
  `pay_status` tinyint(4) DEFAULT NULL,
  `is_cod` tinyint(4) DEFAULT NULL,
  `is_gift` tinyint(4) DEFAULT NULL,
  `supplier_type` int(11) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `barcode` varchar(128) DEFAULT NULL COMMENT '商品条码',
  `return_status` tinyint(4) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `coupon_discount` bigint(20) DEFAULT NULL,
  `promotion_discount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1', '11', 'william', '10', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:40:02', '2015-03-05 13:40:07', '3', '2');
INSERT INTO `order_item` VALUES ('2', '11', 'william', '10', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:42:10', '2015-03-05 13:42:15', '3', '2');
INSERT INTO `order_item` VALUES ('3', '11', 'william', '128', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:40:02', '2015-03-05 13:40:07', '3', '2');
INSERT INTO `order_item` VALUES ('4', '11', 'william', '128', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:42:10', '2015-03-05 13:42:15', '3', '2');
INSERT INTO `order_item` VALUES ('5', '11', 'william', '129', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:40:02', '2015-03-05 13:40:07', '3', '2');
INSERT INTO `order_item` VALUES ('6', '11', 'william', '129', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:42:10', '2015-03-05 13:42:15', '3', '2');
INSERT INTO `order_item` VALUES ('7', '11', 'william', '130', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:40:02', '2015-03-05 13:40:07', '3', '2');
INSERT INTO `order_item` VALUES ('8', '11', 'william', '130', '1150303000066', '12', '21', '10', '2', '20', '1', '0', 'apple', '10', '20', null, null, null, null, null, '0', '0', '0', '1', '11', null, null, '2015-03-05 13:42:10', '2015-03-05 13:42:15', '3', '2');
INSERT INTO `order_item` VALUES ('9', '11', null, '131', '1150305000001', '23', '141', '5999', '1', '5999', '1', '0', 'sumsang 手机', null, null, null, null, null, null, null, '0', null, '0', '2', null, null, null, null, null, null, null);
INSERT INTO `order_item` VALUES ('10', '11', null, '131', '1150305000001', '23', '131', '0', '1', '0', '1', '0', '[赠品1]', null, null, null, null, null, null, null, '0', null, '1', null, '13', null, null, '2015-03-05 17:56:54', '2015-03-05 17:56:54', null, null);
INSERT INTO `order_item` VALUES ('11', '11', null, '132', '1150311000001', '131', '1311', '2299', '2', '4598', '1', '0', '魅族手机 [白色]', null, null, null, null, null, null, null, '0', null, '0', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for order_log
-- ----------------------------
DROP TABLE IF EXISTS `order_log`;
CREATE TABLE `order_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_info` varchar(128) DEFAULT NULL,
  `time_log` date DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `log_admin` bigint(20) DEFAULT NULL,
  `log_type` tinyint(4) DEFAULT NULL,
  `operator` varchar(128) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `not_show_to_user` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_log
-- ----------------------------

-- ----------------------------
-- Table structure for order_notice
-- ----------------------------
DROP TABLE IF EXISTS `order_notice`;
CREATE TABLE `order_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `express_sn` varchar(150) NOT NULL COMMENT '快递单号',
  `express_id` int(11) NOT NULL COMMENT '快递公司ID',
  `delivery_time` datetime NOT NULL COMMENT '配送时间',
  `arrival_time` datetime NOT NULL COMMENT '收货时间',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `remark` text COMMENT '备注',
  `deleted` tinyint(1) NOT NULL COMMENT '0正常/1已删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_notice
-- ----------------------------

-- ----------------------------
-- Table structure for order_return
-- ----------------------------
DROP TABLE IF EXISTS `order_return`;
CREATE TABLE `order_return` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `express_sn` varchar(150) NOT NULL COMMENT '快递单号',
  `express_id` int(11) NOT NULL COMMENT '快递公司ID',
  `delivery_time` datetime NOT NULL COMMENT '退货时间',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `remark` text COMMENT '备注',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `return_user` varchar(50) NOT NULL COMMENT '退回人姓名',
  `return_phone` varchar(11) NOT NULL COMMENT '退回人电话',
  `return_address` varchar(255) NOT NULL COMMENT '退回人地址',
  `deleted` tinyint(1) NOT NULL COMMENT '0正常/1已删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_return
-- ----------------------------

-- ----------------------------
-- Table structure for order_seq
-- ----------------------------
DROP TABLE IF EXISTS `order_seq`;
CREATE TABLE `order_seq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date NOT NULL COMMENT '订单天',
  `seq` int(11) NOT NULL COMMENT '订单按天流水',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_seq
-- ----------------------------
INSERT INTO `order_seq` VALUES ('1', '2015-03-02', '399', '2015-03-03 12:00:27', '2015-03-03 13:38:52');
INSERT INTO `order_seq` VALUES ('9', '2015-03-03', '72', '2015-03-03 13:41:28', '2015-03-03 21:35:25');
INSERT INTO `order_seq` VALUES ('10', '2015-03-04', '5', '2015-03-04 12:00:05', '2015-03-04 15:04:54');
INSERT INTO `order_seq` VALUES ('11', '2015-03-05', '1', '2015-03-05 17:54:51', '2015-03-05 17:54:51');
INSERT INTO `order_seq` VALUES ('12', '2015-03-11', '1', '2015-03-11 11:22:45', '2015-03-11 11:22:45');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL COMMENT '接口名称',
  `is_active` tinyint(1) NOT NULL,
  `online_pay` tinyint(1) NOT NULL COMMENT '在线支付',
  `fee_amount` bigint(20) NOT NULL COMMENT '手续费',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `description` text NOT NULL COMMENT '描述',
  `total_amount` bigint(20) NOT NULL COMMENT '收款总额',
  `config` text NOT NULL COMMENT '配置信息',
  `logo` varchar(255) NOT NULL COMMENT '图标',
  `sort` int(11) NOT NULL,
  `fee_type` tinyint(1) NOT NULL COMMENT '手续费类型 0定额 1比率',
  `is_pc` tinyint(1) NOT NULL DEFAULT '0' COMMENT '支持pc端',
  `is_wap` tinyint(1) NOT NULL DEFAULT '0' COMMENT '支持wap端',
  `is_app` tinyint(1) NOT NULL DEFAULT '0' COMMENT '支持app端',
  `is_delete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='已经安装的支付接口表';

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', 'Alipay', '1', '1', '1', '支付宝', '支付宝支付', '10000000', 'abcdj', 'abcd', '10', '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for payment_notice
-- ----------------------------
DROP TABLE IF EXISTS `payment_notice`;
CREATE TABLE `payment_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trade_no` varchar(64) DEFAULT NULL,
  `time_pay` date DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL,
  `is_paid` tinyint(4) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `payment_id` int(4) DEFAULT NULL,
  `bank_code` varchar(128) DEFAULT NULL,
  `money` bigint(20) DEFAULT NULL,
  `out_trade_no` varchar(256) DEFAULT NULL,
  `gmt_created` date DEFAULT NULL,
  `gmt_modified` date DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_notice
-- ----------------------------
INSERT INTO `payment_notice` VALUES ('1', '111111', '2015-03-05', '10', '222', '1', '11', 'william', '21', null, '1000', null, '2015-02-27', '2015-03-05', '0', '11');
INSERT INTO `payment_notice` VALUES ('2', null, null, '36', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('3', null, null, '37', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('4', null, null, '38', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('5', null, null, '39', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('6', null, null, '40', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('7', null, null, '41', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('8', null, null, '42', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('9', null, null, '43', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('10', null, null, '44', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('11', null, null, '45', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('12', null, null, '50', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('13', null, null, '51', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('14', '1150303000005', null, '52', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('15', '1150303000006', null, '53', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('16', '1150303000007', null, '54', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('17', '1150303000008', null, '55', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('18', '1150303000009', null, '56', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('19', '1150303000010', null, '57', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('20', '1150303000011', null, '58', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('21', '1150303000013', null, '59', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('22', '1150303000013', null, '60', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('23', '1150303000014', null, '61', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('24', '1150303000015', null, '62', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('25', '1150303000016', null, '63', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('26', '1150303000017', null, '64', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('27', '1150303000018', null, '65', null, '0', '11', null, '1', null, '1750', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('28', '1150303000019', null, '66', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('29', '1150303000020', null, '67', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('30', '1150303000021', null, '68', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('31', '1150303000022', null, '69', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('32', '1150303000023', null, '70', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('33', '1150303000024', null, '71', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('34', '1150303000025', null, '72', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('35', '1150303000026', null, '73', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('36', '1150303000027', null, '74', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('37', '1150303000028', null, '75', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('38', '1150303000029', null, '76', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('39', '1150303000030', null, '77', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('40', '1150303000031', null, '78', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('41', '1150303000032', null, '79', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('42', '1150303000033', null, '80', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('43', '1150303000034', null, '81', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('44', '1150303000035', null, '82', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('45', '1150303000036', null, '83', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('46', '1150303000037', null, '84', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('47', '1150303000038', null, '85', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('48', '1150303000039', null, '86', null, '0', '111', null, '1', null, '2340', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('49', '1150303000040', null, '87', null, '0', '111', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('50', '1150303000041', null, '88', null, '0', '111', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('51', '1150303000042', null, '89', null, '0', '111', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('52', '1150303000043', null, '90', null, '0', '111', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('53', '1150303000044', null, '91', null, '0', '111', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('54', '1150303000045', null, '92', null, '0', '211', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('55', '1150303000046', null, '93', null, '0', '211', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('56', '1150303000047', null, '94', null, '0', '211', null, '1', null, '0', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('57', '1150303000048', null, '95', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('58', '1150303000049', null, '96', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('59', '1150303000050', null, '97', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('60', '1150303000051', null, '98', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('61', '1150303000052', null, '99', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('62', '1150303000053', null, '100', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('63', '1150303000054', null, '101', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('64', '1150303000055', null, '102', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('65', '1150303000056', null, '103', null, '0', '211', null, '1', null, '108', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('66', '1150303000057', null, '104', null, '0', '211', null, '1', null, '11968', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('67', '1150303000058', null, '105', null, '0', '211', null, '1', null, '11968', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('68', '1150303000059', null, '106', null, '0', '211', null, '1', null, '17967', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('69', '1150303000060', null, '107', null, '0', '211', null, '1', null, '17967', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('70', '1150303000061', null, '108', null, '0', '211', null, '1', null, '17967', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('71', '1150303000062', null, '109', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('72', '1150303000063', null, '110', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('73', '1150303000064', null, '111', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('74', '1150303000065', null, '112', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('75', '1150303000066', null, '113', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('76', '1150303000067', null, '114', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('77', '1150303000068', null, '115', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('78', '1150303000069', null, '116', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('79', '1150303000070', null, '117', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('80', '1150303000071', null, '118', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('81', '1150303000072', null, '119', null, '0', '211', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('82', '1150304000001', null, '120', null, '0', '11', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('83', '1150304000002', null, '121', null, '0', '11', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('84', '1150304000003', null, '122', null, '0', '11', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('85', '1150304000004', null, '123', null, '0', '11', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('86', '1150304000005', null, '124', null, '0', '11', null, '1', null, '6107', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('87', '1150305000001', null, '131', null, '0', '11', null, '1', null, '5939', null, null, null, '0', null);
INSERT INTO `payment_notice` VALUES ('88', '1150311000001', null, '132', null, '0', '11', null, '1', null, '9196', null, null, null, '0', null);

-- ----------------------------
-- Table structure for return_order
-- ----------------------------
DROP TABLE IF EXISTS `return_order`;
CREATE TABLE `return_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(32) DEFAULT NULL,
  `return_money` bigint(20) DEFAULT NULL,
  `return_status` tinyint(4) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return_order
-- ----------------------------

-- ----------------------------
-- Table structure for return_order_item
-- ----------------------------
DROP TABLE IF EXISTS `return_order_item`;
CREATE TABLE `return_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `return_order_id` bigint(20) DEFAULT NULL,
  `item_sku_id` bigint(20) DEFAULT NULL,
  `item_name` varchar(256) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `return_money` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `is_returned` tinyint(4) DEFAULT NULL,
  `return_reason` varchar(256) DEFAULT NULL,
  `return_attach` varchar(256) DEFAULT NULL,
  `return_desc` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return_order_item
-- ----------------------------
INSERT INTO `return_order_item` VALUES ('37', '41', '111', '苹果手机', '11', '0', '1', '2015-02-27 11:23:49', '2015-02-27 11:23:49', '0', '0', 'reason', 'attach', 'DESC');
INSERT INTO `return_order_item` VALUES ('38', '41', '112', 'samsung手机', '11', '100', '3', '2015-02-27 11:23:49', '2015-02-27 11:23:49', '0', '0', 'reason2', 'attach2', 'DESC2');

-- ----------------------------
-- Table structure for seller_order
-- ----------------------------
DROP TABLE IF EXISTS `seller_order`;
CREATE TABLE `seller_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(32) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `pay_status` tinyint(4) DEFAULT NULL,
  `total_amount` bigint(20) DEFAULT NULL COMMENT '总价格',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '支付金额',
  `delivery_status` tinyint(4) DEFAULT NULL COMMENT '支付状态',
  `order_status` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `refund_amount` bigint(20) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `address_id` bigint(11) DEFAULT NULL,
  `tel` varchar(64) DEFAULT NULL,
  `mobile` varchar(64) DEFAULT NULL,
  `consignee` varchar(64) DEFAULT NULL,
  `item_total_price` bigint(20) DEFAULT NULL,
  `discount_price` bigint(20) DEFAULT NULL,
  `delivery_fee` bigint(20) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL,
  `payment_id` tinyint(4) DEFAULT NULL COMMENT '支付方式',
  `payment_fee` bigint(20) DEFAULT NULL COMMENT '支付手续费',
  `return_total_money` bigint(20) DEFAULT NULL,
  `after_sale` tinyint(4) DEFAULT NULL,
  `refund_money` bigint(20) DEFAULT NULL,
  `bank_code` varchar(128) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `refund_status` tinyint(4) DEFAULT NULL,
  `retake_status` tinyint(4) DEFAULT NULL,
  `coupon_mobile` varchar(64) DEFAULT NULL,
  `is_cod` tinyint(4) DEFAULT NULL,
  `invoice_status` tinyint(4) DEFAULT NULL,
  `invoice_class` tinyint(4) DEFAULT NULL COMMENT '发票分类',
  `invoice_type` tinyint(4) DEFAULT NULL,
  `invoice_title` varchar(128) DEFAULT NULL,
  `coupon_discount` bigint(20) DEFAULT NULL COMMENT '订单优惠券优惠额',
  `promotion_discount` bigint(20) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `user_memo` varchar(256) DEFAULT NULL,
  `seller_memo` varchar(256) DEFAULT NULL,
  `admin_memo` varchar(256) DEFAULT NULL,
  `extra_status` tinyint(4) DEFAULT NULL COMMENT '订单额外状态',
  `source` tinyint(4) DEFAULT NULL,
  `need_invoice` tinyint(1) DEFAULT NULL COMMENT '需要发票',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_order
-- ----------------------------
INSERT INTO `seller_order` VALUES ('10', '1150303000065', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:30:15', '2015-03-03 21:30:15', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('113', '1150303000066', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:32:12', '2015-03-03 21:32:12', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('114', '1150303000067', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:33:00', '2015-03-03 21:33:00', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('115', '1150303000068', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:33:34', '2015-03-03 21:33:34', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('116', '1150303000069', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:34:08', '2015-03-03 21:34:08', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('117', '1150303000070', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:36:31', '2015-03-03 21:36:31', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('118', '1150303000071', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:36:52', '2015-03-03 21:36:52', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('119', '1150303000072', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:37:31', '2015-03-03 21:37:31', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('120', '1150304000001', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 12:02:10', '2015-03-04 12:02:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('121', '1150304000002', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 13:58:19', '2015-03-04 13:58:19', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('122', '1150304000003', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 13:59:10', '2015-03-04 13:59:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('123', '1150304000004', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 15:06:10', '2015-03-04 15:06:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('124', '1150304000005', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 15:06:59', '2015-03-04 15:06:59', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('127', '1150303000066_01', null, null, '1', null, '30', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `seller_order` VALUES ('128', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `seller_order` VALUES ('129', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `seller_order` VALUES ('130', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `seller_order` VALUES ('131', '1150305000001', '1', '11', '1', '0', '5999', '5939', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '18', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-05 17:56:54', '2015-03-05 17:56:54', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `seller_order` VALUES ('132', '1150311000001', '1', '11', '1', '0', '9196', '9196', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '18', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '0', '0', '2015-03-11 11:24:46', '2015-03-11 11:24:46', '1', '0', 'userMemo', null, null, null, '3', null);

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `item_sku_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `sub_name` varchar(256) DEFAULT NULL,
  `session_id` varchar(32) DEFAULT NULL,
  `origin_price` bigint(20) DEFAULT NULL,
  `unit_price` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `total_price` bigint(20) DEFAULT NULL,
  `save_price` bigint(20) DEFAULT NULL,
  `total_save` bigint(20) DEFAULT NULL,
  `return_money` bigint(20) DEFAULT NULL,
  `return_total_money` bigint(20) DEFAULT NULL,
  `return_score` int(11) DEFAULT NULL,
  `return_total_score` int(11) DEFAULT NULL,
  `return_point` int(11) DEFAULT NULL,
  `return_total_point` int(11) DEFAULT NULL,
  `is_gift` tinyint(4) DEFAULT NULL,
  `source` tinyint(4) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1264 DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for trade_sys_param
-- ----------------------------
DROP TABLE IF EXISTS `trade_sys_param`;
CREATE TABLE `trade_sys_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key` varchar(128) DEFAULT NULL COMMENT '参数键',
  `value` varchar(256) DEFAULT NULL COMMENT '参数值',
  `type` varchar(64) DEFAULT NULL COMMENT '类型',
  `desc` varchar(256) DEFAULT NULL COMMENT '参数描述',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_sys_param
-- ----------------------------

-- ----------------------------
-- Table structure for user_cart
-- ----------------------------
DROP TABLE IF EXISTS `user_cart`;
CREATE TABLE `user_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `item_sku_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `sub_name` varchar(256) DEFAULT NULL,
  `session_id` varchar(32) DEFAULT NULL,
  `origin_price` bigint(20) DEFAULT NULL,
  `unit_price` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `total_price` bigint(20) DEFAULT NULL,
  `save_price` bigint(20) DEFAULT NULL,
  `total_save` bigint(20) DEFAULT NULL,
  `return_money` bigint(20) DEFAULT NULL,
  `return_total_money` bigint(20) DEFAULT NULL,
  `return_score` int(11) DEFAULT NULL,
  `return_total_score` int(11) DEFAULT NULL,
  `return_point` int(11) DEFAULT NULL,
  `return_total_point` int(11) DEFAULT NULL,
  `is_gift` tinyint(4) DEFAULT NULL,
  `source` tinyint(4) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of user_cart
-- ----------------------------
INSERT INTO `user_cart` VALUES ('152', 'iphone [黑色-L]', '1111', '11', '10', '111', 'iphone', 'abcd', '6999', '5999', '1', '5999', '1000', '1000', null, null, null, null, null, null, '0', '1', '2015-03-09 21:33:51', '2015-03-10 10:24:51');
INSERT INTO `user_cart` VALUES ('153', 'samsung [绿色]', '1611', '16', '10', '161', 'samsung', 'abcd', '5999', '4499', '3', '13497', '1500', '4500', null, null, null, null, null, null, '0', '1', '2015-03-09 21:35:27', '2015-03-10 10:26:15');
INSERT INTO `user_cart` VALUES ('154', '魅族手机 [白色]', '1311', '13', '10', '131', '魅族手机', 'abcd', '2999', '2299', '5', '11495', '700', '3500', null, null, null, null, null, null, '0', '1', '2015-03-09 21:24:42', '2015-03-09 21:24:42');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(32) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `pay_status` tinyint(4) DEFAULT NULL,
  `total_amount` bigint(20) DEFAULT NULL COMMENT '总价格',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '支付金额',
  `delivery_status` tinyint(4) DEFAULT NULL COMMENT '支付状态',
  `order_status` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `refund_amount` bigint(20) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `address_id` bigint(11) DEFAULT NULL,
  `tel` varchar(64) DEFAULT NULL,
  `mobile` varchar(64) DEFAULT NULL,
  `consignee` varchar(64) DEFAULT NULL,
  `item_total_price` bigint(20) DEFAULT NULL,
  `discount_price` bigint(20) DEFAULT NULL,
  `delivery_fee` bigint(20) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL,
  `payment_id` tinyint(4) DEFAULT NULL COMMENT '支付方式',
  `payment_fee` bigint(20) DEFAULT NULL COMMENT '支付手续费',
  `return_total_money` bigint(20) DEFAULT NULL,
  `after_sale` tinyint(4) DEFAULT NULL,
  `refund_money` bigint(20) DEFAULT NULL,
  `bank_code` varchar(128) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `refund_status` tinyint(4) DEFAULT NULL,
  `retake_status` tinyint(4) DEFAULT NULL,
  `coupon_mobile` varchar(64) DEFAULT NULL,
  `is_cod` tinyint(4) DEFAULT NULL,
  `invoice_status` tinyint(4) DEFAULT NULL,
  `invoice_class` tinyint(4) DEFAULT NULL COMMENT '发票分类',
  `invoice_type` tinyint(4) DEFAULT NULL,
  `invoice_title` varchar(128) DEFAULT NULL,
  `coupon_discount` bigint(20) DEFAULT NULL COMMENT '订单优惠券优惠额',
  `promotion_discount` bigint(20) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `user_memo` varchar(256) DEFAULT NULL,
  `seller_memo` varchar(256) DEFAULT NULL,
  `admin_memo` varchar(256) DEFAULT NULL,
  `extra_status` tinyint(4) DEFAULT NULL COMMENT '订单额外状态',
  `source` tinyint(4) DEFAULT NULL,
  `need_invoice` tinyint(1) DEFAULT NULL COMMENT '需要发票',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_order
-- ----------------------------
INSERT INTO `user_order` VALUES ('1', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('2', null, null, '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, '2015-02-28 11:57:21', null, null, '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('3', null, null, '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, '2015-02-25 11:57:25', null, null, '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('4', null, null, '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, '2015-02-27 12:00:28', null, null, '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('5', null, null, '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, '2015-02-26 11:57:32', null, null, '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('6', null, null, '1111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('7', null, null, '1111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('10', '1150303000066', '1', '11', '1', '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:32:12', '2015-03-03 21:32:12', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('20', null, null, '21', '101', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, null, null, '1', '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('30', null, null, '31', '102', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wiliam', null, null, null, null, null, null, null, null, null, null, null, null, '1', '0', null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('114', '1150303000067', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:33:00', '2015-03-03 21:33:00', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('115', '1150303000068', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:33:34', '2015-03-03 21:33:34', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('116', '1150303000069', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:34:08', '2015-03-03 21:34:08', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('117', '1150303000070', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:36:31', '2015-03-03 21:36:31', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('118', '1150303000071', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:36:52', '2015-03-03 21:36:52', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('119', '1150303000072', '1', '211', null, '0', '6167', '6107', '0', '0', null, null, '121', '54875665', '15000138722', 'cwr', null, '0', '10', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-03 21:37:31', '2015-03-03 21:37:31', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('120', '1150304000001', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 12:02:10', '2015-03-04 12:02:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('121', '1150304000002', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 13:58:19', '2015-03-04 13:58:19', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('122', '1150304000003', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 13:59:10', '2015-03-04 13:59:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('123', '1150304000004', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 15:06:10', '2015-03-04 15:06:10', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('124', '1150304000005', '1', '11', null, '0', '6167', '6107', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '0', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-04 15:06:59', '2015-03-04 15:06:59', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('127', '1150303000066_01', null, null, '1', null, '30', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('128', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('129', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('130', '1150303000066_01', null, null, '1', null, '40', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '6', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_order` VALUES ('131', '1150305000001', '1', '11', '1', '0', '5999', '5939', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '18', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '50', '10', '2015-03-05 17:56:54', '2015-03-05 17:56:54', '1', '0', 'userMemo', null, null, null, '3', null);
INSERT INTO `user_order` VALUES ('132', '1150311000001', '1', '11', '1', '0', '9196', '9196', '0', '0', null, null, '11', '54875665', '15000138722', 'cwr', null, '0', '18', null, '1', null, null, null, null, null, null, null, null, null, '0', null, null, null, null, '0', '0', '2015-03-11 11:24:46', '2015-03-11 11:24:46', '1', '0', 'userMemo', null, null, null, '3', null);
