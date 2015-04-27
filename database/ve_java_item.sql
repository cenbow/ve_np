/*
Navicat MySQL Data Transfer

Source Server         : 192.168.62.197
Source Server Version : 50620
Source Host           : 192.168.62.197:3306
Source Database       : ve_java_item

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-03-20 16:29:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for atest
-- ----------------------------
DROP TABLE IF EXISTS `atest`;
CREATE TABLE `atest` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(64) DEFAULT NULL COMMENT '属性名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11632 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='全局属性表';

-- ----------------------------
-- Records of atest
-- ----------------------------
INSERT INTO `atest` VALUES ('1', '1');
INSERT INTO `atest` VALUES ('2', '2');
INSERT INTO `atest` VALUES ('3', '3');
INSERT INTO `atest` VALUES ('4', '4');

-- ----------------------------
-- Table structure for btest
-- ----------------------------
DROP TABLE IF EXISTS `btest`;
CREATE TABLE `btest` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `bb` varchar(64) DEFAULT NULL COMMENT '属性名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='全局属性表';

-- ----------------------------
-- Records of btest
-- ----------------------------
INSERT INTO `btest` VALUES ('2', 'b2');
INSERT INTO `btest` VALUES ('3', 'b3');
INSERT INTO `btest` VALUES ('5', 'b5');
INSERT INTO `btest` VALUES ('6', 'b6');

-- ----------------------------
-- Table structure for ctest
-- ----------------------------
DROP TABLE IF EXISTS `ctest`;
CREATE TABLE `ctest` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `cc` varchar(64) DEFAULT NULL COMMENT '属性名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='全局属性表';

-- ----------------------------
-- Records of ctest
-- ----------------------------
INSERT INTO `ctest` VALUES ('1', 'c1');
INSERT INTO `ctest` VALUES ('2', 'c2');
INSERT INTO `ctest` VALUES ('5', '5');

-- ----------------------------
-- Table structure for global_property
-- ----------------------------
DROP TABLE IF EXISTS `global_property`;
CREATE TABLE `global_property` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(64) NOT NULL COMMENT '属性名',
  `property_type` int(2) NOT NULL COMMENT '属性类型',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='全局属性表';

-- ----------------------------
-- Records of global_property
-- ----------------------------
INSERT INTO `global_property` VALUES ('1', '服饰', '1', '0', '2015-01-24 15:19:05', '2015-02-12 15:41:00');
INSERT INTO `global_property` VALUES ('2', '品牌222', '1', '0', '2015-01-24 15:20:13', '2015-02-28 19:45:40');
INSERT INTO `global_property` VALUES ('3', '颜色', '1', '0', '2015-01-24 15:17:22', '2015-02-28 18:41:37');
INSERT INTO `global_property` VALUES ('4', '尺寸', '1', '0', '2015-01-24 15:17:43', '2015-01-24 15:17:43');
INSERT INTO `global_property` VALUES ('5', '重量', '1', '0', '2015-01-24 15:17:48', '2015-01-24 15:17:48');
INSERT INTO `global_property` VALUES ('6', '重量11', '1', '0', '2015-02-12 15:40:23', '2015-02-12 15:40:23');
INSERT INTO `global_property` VALUES ('7', '重量11', '1', '0', '2015-02-28 18:31:41', '2015-02-28 18:31:41');
INSERT INTO `global_property` VALUES ('8', '重量11', '1', '0', '2015-02-28 18:32:22', '2015-02-28 18:32:22');
INSERT INTO `global_property` VALUES ('9', '重量11', '1', '0', '2015-02-28 18:32:40', '2015-02-28 18:32:40');
INSERT INTO `global_property` VALUES ('10', '重量11', '1', '0', '2015-02-28 18:33:49', '2015-02-28 18:33:49');

-- ----------------------------
-- Table structure for global_property_value
-- ----------------------------
DROP TABLE IF EXISTS `global_property_value`;
CREATE TABLE `global_property_value` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `global_property_id` bigint(10) NOT NULL COMMENT '全局属性表',
  `property_value` varchar(64) NOT NULL COMMENT '全局属性值',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='全局属性值域表';

-- ----------------------------
-- Records of global_property_value
-- ----------------------------
INSERT INTO `global_property_value` VALUES ('6', '4', '蓝色', '0', '2015-01-24 16:04:25', '2015-02-28 19:55:31');
INSERT INTO `global_property_value` VALUES ('7', '4', '大红色222', '0', '2015-01-24 16:13:26', '2015-02-28 20:05:26');
INSERT INTO `global_property_value` VALUES ('8', '4', '白色', '0', '2015-01-24 16:03:43', '2015-02-12 22:55:33');
INSERT INTO `global_property_value` VALUES ('9', '4', '绿色', '0', '2015-01-24 16:03:51', '2015-02-12 22:55:33');
INSERT INTO `global_property_value` VALUES ('10', '4', '咖啡色', '0', '2015-01-24 16:03:55', '2015-02-12 22:55:33');
INSERT INTO `global_property_value` VALUES ('11', '3', '紫色', '0', '2015-01-24 16:03:59', '2015-02-28 18:41:37');
INSERT INTO `global_property_value` VALUES ('12', '3', '紫色22', '0', '2015-02-12 20:00:51', '2015-02-28 18:41:37');
INSERT INTO `global_property_value` VALUES ('13', '3', '紫色22', '0', '2015-02-28 19:50:49', '2015-02-28 19:50:49');
INSERT INTO `global_property_value` VALUES ('14', '3', '紫色22', '0', '2015-02-28 19:53:32', '2015-02-28 19:53:32');
INSERT INTO `global_property_value` VALUES ('15', '3', '紫色22', '0', '2015-02-28 19:53:32', '2015-02-28 19:53:32');
INSERT INTO `global_property_value` VALUES ('16', '3', '紫色22', '0', '2015-02-28 19:53:46', '2015-02-28 19:53:46');
INSERT INTO `global_property_value` VALUES ('17', '3', '紫色22', '0', '2015-02-28 19:53:46', '2015-02-28 19:53:46');
INSERT INTO `global_property_value` VALUES ('18', '3', '紫色22', '0', '2015-02-28 19:53:57', '2015-02-28 19:53:57');
INSERT INTO `global_property_value` VALUES ('19', '3', '紫色22', '0', '2015-02-28 19:53:57', '2015-02-28 19:53:57');
INSERT INTO `global_property_value` VALUES ('20', '3', '紫色22', '0', '2015-02-28 19:58:24', '2015-02-28 19:58:24');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) NOT NULL COMMENT '商品名称',
  `item_brief_name` varchar(256) NOT NULL COMMENT '商品简称',
  `supplier_id` int(8) NOT NULL COMMENT '供应商ID',
  `item_brand_id` int(8) NOT NULL COMMENT '商品品牌ID',
  `brief_introduction` text COMMENT '商品简介',
  `item_type` int(2) NOT NULL COMMENT '商品类型：1代表实体商品，2代表虚拟商品',
  `icon_url` varchar(256) NOT NULL COMMENT '商品主图',
  `category_id` int(8) NOT NULL COMMENT '商品所属类目ID',
  `spu_id` int(16) DEFAULT NULL COMMENT '所关联的spu属性信息',
  `market_price` int(100) DEFAULT NULL COMMENT '市场价',
  `promotion_price` int(100) DEFAULT NULL COMMENT '促销价',
  `wireless_price` int(100) DEFAULT NULL COMMENT '无线价',
  `sale_begin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '售卖开始时间',
  `sale_end` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '售卖结束时间',
  `sale_min_num` int(10) DEFAULT '1' COMMENT '最小售卖数',
  `sale_max_num` int(10) DEFAULT NULL COMMENT '最大售卖数',
  `item_status` int(1) NOT NULL DEFAULT '0' COMMENT '商品状态',
  `audit_msg` varchar(100) DEFAULT '' COMMENT '审核信息，审核不通过的时候，需要填写',
  `audit_time` int(11) DEFAULT '0' COMMENT '审核时间',
  `audit_admin_id` int(10) DEFAULT '0' COMMENT '审核管理员id',
  `is_seller_post` int(1) NOT NULL DEFAULT '0' COMMENT '该商品是否在商家中心增加',
  `is_deleted` int(2) DEFAULT NULL COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8 COMMENT='商品表';

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '婴儿钢琴', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:08:24', '2015-01-26 17:08:24', null, null, '0', null, null, null, '1', '0', '2015-02-05 15:30:02', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('2', '婴儿玩具22', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:08:53', '2015-01-26 17:08:53', null, null, '0', null, null, null, '1', '0', '2015-01-29 23:02:29', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('3', '婴儿纸尿布', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:09:02', '2015-01-26 17:09:02', null, null, '0', null, null, null, '1', '0', '2015-02-05 15:30:03', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('4', '婴儿文具', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:09:07', '2015-01-26 17:09:07', null, null, '0', null, null, null, '1', '0', '2015-01-26 17:09:07', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('5', '婴儿乐器', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:09:13', '2015-01-26 17:09:13', null, null, '0', null, null, null, '1', '0', '2015-01-26 17:09:13', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('6', '婴儿奶粉', '商品简称', '3', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:10:43', '2015-01-26 17:10:43', null, null, '0', null, null, null, '1', '0', '2015-01-26 17:10:43', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('7', '婴儿毛巾', '商品简称', '3', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-01-26 17:10:55', '2015-01-26 17:10:55', null, null, '0', null, null, null, '1', '0', '2015-01-26 17:10:55', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('8', '婴儿毛巾111', '商品简称', '3', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-09 21:43:48', '2015-01-26 17:10:55', '1', null, '0', '', '0', '0', '1', '0', '2015-02-09 21:43:48', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('9', '婴儿毛巾111', '商品简称', '3', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-09 21:44:59', '2015-01-26 17:10:55', '1', null, '0', '', '0', '0', '1', '0', '2015-02-09 21:44:59', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('10', '婴儿毛巾111', '商品简称', '2', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-09 21:45:46', '2015-01-26 17:10:55', '1', null, '0', '', '0', '0', '1', '0', '2015-02-09 21:45:46', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('11', '婴儿毛巾222', '商品简称', '2', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-09 21:53:52', '2015-01-26 17:10:55', '1', null, '0', '', '0', '0', '1', '0', '2015-02-09 21:53:52', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('12', '婴儿毛巾222', '商品简称', '2', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-09 21:58:38', '2015-02-09 21:58:38', '1', null, '0', '', '0', '0', '1', '0', '2015-02-09 21:58:38', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('13', '大头', '商品简称', '2', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 13:57:12', '2015-02-10 13:57:12', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 13:57:12', '2015-03-01 00:23:49');
INSERT INTO `item` VALUES ('17', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:08:03', '2015-02-10 21:08:03', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:08:03', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('18', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:23:53', '2015-02-10 21:23:53', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:23:53', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('19', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:24:43', '2015-02-10 21:24:43', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:24:43', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('20', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:29:01', '2015-02-10 21:29:01', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:29:01', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('21', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:31:11', '2015-02-10 21:31:11', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:31:11', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('22', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-10 21:48:39', '2015-02-10 21:48:39', '1', null, '0', '', '0', '0', '1', '0', '2015-02-10 21:48:39', '2015-03-01 00:22:29');
INSERT INTO `item` VALUES ('24', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:00:18', '2015-02-28 23:00:18', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:00:18', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('25', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:01:47', '2015-02-28 23:01:47', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:01:47', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('26', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:07:35', '2015-02-28 23:07:35', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:07:35', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('27', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:08:14', '2015-02-28 23:08:14', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:08:14', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('28', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:10:04', '2015-02-28 23:10:04', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:10:04', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('31', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:18:04', '2015-02-28 23:18:04', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:18:04', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('32', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:19:18', '2015-02-28 23:19:18', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:19:18', '2015-03-01 00:19:00');
INSERT INTO `item` VALUES ('33', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-02-28 23:20:34', '2015-02-28 23:20:34', '1', null, '0', '', '0', '0', '1', '0', '2015-02-28 23:20:34', '2015-03-01 00:22:30');
INSERT INTO `item` VALUES ('36', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-03-01 00:21:33', '2015-03-01 00:21:33', '1', null, '0', '', '0', '0', '1', '0', '2015-03-01 00:21:33', '2015-03-01 00:21:33');
INSERT INTO `item` VALUES ('39', '婴儿毛巾444', '商品简称', '1', '1', '商品简介', '1', 'http://www.163.com/e.jpeg', '1', null, null, null, null, '2015-03-01 00:22:25', '2015-03-01 00:22:25', '1', null, '0', '', '0', '0', '1', '0', '2015-03-01 00:22:25', '2015-03-01 00:22:25');

-- ----------------------------
-- Table structure for item_brand
-- ----------------------------
DROP TABLE IF EXISTS `item_brand`;
CREATE TABLE `item_brand` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(200) NOT NULL COMMENT '中文名',
  `ename` varchar(100) DEFAULT '' COMMENT '英文名',
  `brand_status` tinyint(1) NOT NULL,
  `logo_url` varchar(255) DEFAULT '' COMMENT '品牌logo',
  `descs` text COMMENT '品牌描述',
  `country` varchar(200) DEFAULT NULL COMMENT '品牌所属国家',
  `country_icon` varchar(200) DEFAULT NULL COMMENT '国家icon',
  `build_time` varchar(200) DEFAULT NULL COMMENT '品牌创建年代',
  `initiator` varchar(200) DEFAULT NULL COMMENT '品牌创始人',
  `background` varchar(200) DEFAULT NULL COMMENT '品牌背景',
  `head_address` varchar(200) DEFAULT NULL COMMENT '总部地址',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `IDX_item_brand_ename` (`ename`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品品牌表';

-- ----------------------------
-- Records of item_brand
-- ----------------------------
INSERT INTO `item_brand` VALUES ('1', '法国', 'Fra', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, null, '0', '2015-02-03 22:06:40', '2015-02-03 22:06:40');
INSERT INTO `item_brand` VALUES ('2', '中国', 'China', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, null, '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('3', '多乐美', 'USA', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, null, '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('4', 'AK47', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('5', 'AK48', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('6', 'AK49', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('7', 'AK50', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('8', 'AK51', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('9', 'AK52', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('10', 'AK53', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:08:27', '2015-02-03 22:08:27');
INSERT INTO `item_brand` VALUES ('11', 'AK54', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-04 11:42:19', '2015-03-02 16:11:09');
INSERT INTO `item_brand` VALUES ('12', 'AK55', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('13', 'AK56', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('14', 'AK57', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-03 22:05:17', '2015-02-03 22:05:17');
INSERT INTO `item_brand` VALUES ('16', 'AK58888', 'India', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-04 11:42:59', '2015-03-02 16:11:10');
INSERT INTO `item_brand` VALUES ('33', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 16:15:38', '2015-02-27 16:15:38');
INSERT INTO `item_brand` VALUES ('37', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 19:52:14', '2015-02-27 19:52:14');
INSERT INTO `item_brand` VALUES ('38', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 19:57:20', '2015-02-27 19:57:20');
INSERT INTO `item_brand` VALUES ('39', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 20:44:34', '2015-02-27 20:44:34');
INSERT INTO `item_brand` VALUES ('40', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 20:46:00', '2015-02-27 20:46:00');
INSERT INTO `item_brand` VALUES ('41', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 20:46:48', '2015-02-27 20:46:48');
INSERT INTO `item_brand` VALUES ('42', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 20:47:52', '2015-02-27 20:47:52');
INSERT INTO `item_brand` VALUES ('43', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 21:36:41', '2015-02-27 21:36:41');
INSERT INTO `item_brand` VALUES ('44', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 21:37:11', '2015-02-27 21:37:11');
INSERT INTO `item_brand` VALUES ('45', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 21:37:22', '2015-02-27 21:37:22');
INSERT INTO `item_brand` VALUES ('46', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 21:37:45', '2015-02-27 21:37:45');
INSERT INTO `item_brand` VALUES ('47', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 21:39:48', '2015-02-27 21:39:48');
INSERT INTO `item_brand` VALUES ('48', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 22:03:24', '2015-02-27 22:03:24');
INSERT INTO `item_brand` VALUES ('49', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 22:03:51', '2015-02-27 22:03:51');
INSERT INTO `item_brand` VALUES ('50', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 22:04:14', '2015-02-27 22:04:14');
INSERT INTO `item_brand` VALUES ('51', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-27 22:05:43', '2015-02-27 22:05:43');
INSERT INTO `item_brand` VALUES ('52', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-28 11:00:39', '2015-02-28 11:00:39');
INSERT INTO `item_brand` VALUES ('53', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-28 11:00:52', '2015-02-28 11:00:52');
INSERT INTO `item_brand` VALUES ('54', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-02-28 11:01:10', '2015-02-28 11:01:10');
INSERT INTO `item_brand` VALUES ('55', 'AK65', 'CK', '0', 'http://www.163.com/a.jpg', null, null, null, null, null, null, null, '0', '0', '2015-03-02 16:11:09', '2015-03-02 16:11:09');

-- ----------------------------
-- Table structure for item_category
-- ----------------------------
DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) NOT NULL COMMENT '类目名称',
  `cate_level` int(2) NOT NULL COMMENT '类目层级',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `spu_id` int(11) DEFAULT NULL COMMENT '所关联的spu属性记录',
  `sort` int(8) DEFAULT NULL COMMENT '排序字段',
  `cate_status` int(1) NOT NULL DEFAULT '0' COMMENT '类目状态',
  `is_recommend` int(1) DEFAULT NULL COMMENT '是否推荐',
  `topid` int(11) NOT NULL COMMENT '顶级分类的ID',
  `is_deleted` int(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `sort` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=94 COMMENT='商品分类表';

-- ----------------------------
-- Records of item_category
-- ----------------------------
INSERT INTO `item_category` VALUES ('3', '玩具23333', '1', '0', null, '1', '0', '0', '1', '0', '2015-01-23 15:32:45', '2015-02-28 17:29:34');
INSERT INTO `item_category` VALUES ('4', '奶粉', '1', '0', null, '1', '0', '0', '1', '0', '2015-01-23 15:21:55', '2015-02-06 23:36:30');
INSERT INTO `item_category` VALUES ('5', '衣服', '1', '0', null, '1', '0', '0', '1', '0', '2015-01-23 15:22:35', '2015-01-23 15:22:35');
INSERT INTO `item_category` VALUES ('6', '生活用品', '1', '0', null, '1', '0', '0', '1', '0', '2015-01-23 15:22:56', '2015-01-23 15:22:56');
INSERT INTO `item_category` VALUES ('7', '学习用品', '1', '0', null, '1', '0', null, '1', '0', '2015-02-06 21:55:35', '2015-02-06 23:38:06');
INSERT INTO `item_category` VALUES ('8', '文具', '2', '7', null, '3', '0', null, '1', '0', '2015-02-06 21:56:21', '2015-02-06 21:56:21');
INSERT INTO `item_category` VALUES ('9', '玩具', '2', '7', null, '1', '0', null, '1', '0', '2015-02-06 22:23:50', '2015-02-06 22:23:50');
INSERT INTO `item_category` VALUES ('10', '书', '2', '7', null, '2', '0', null, '1', '0', '2015-02-06 22:24:02', '2015-02-06 22:24:02');
INSERT INTO `item_category` VALUES ('11', '书', '2', '0', null, '1', '0', null, '1', '0', '2015-02-28 16:57:21', '2015-02-28 16:57:21');
INSERT INTO `item_category` VALUES ('12', '书', '2', '0', null, '1', '0', null, '1', '0', '2015-02-28 16:57:36', '2015-02-28 16:57:36');
INSERT INTO `item_category` VALUES ('13', '书', '2', '0', null, '1', '0', null, '1', '0', '2015-02-28 16:58:14', '2015-02-28 16:58:14');
INSERT INTO `item_category` VALUES ('14', '书', '2', '0', null, '1', '0', null, '1', '0', '2015-02-28 17:01:18', '2015-02-28 17:07:30');

-- ----------------------------
-- Table structure for item_comment
-- ----------------------------
DROP TABLE IF EXISTS `item_comment`;
CREATE TABLE `item_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '评论者昵称',
  `item_id` bigint(11) NOT NULL COMMENT '商品ID',
  `order_id` bigint(11) NOT NULL COMMENT '订单ID',
  `seller_id` bigint(11) NOT NULL COMMENT '卖家ID',
  `title` varchar(255) DEFAULT NULL COMMENT '评论标题',
  `content` text NOT NULL COMMENT '评论内容',
  `score` int(10) DEFAULT '5' COMMENT '给商品打得分数',
  `imgs` varchar(2000) DEFAULT NULL COMMENT '晒图，用半角逗号分隔',
  `praise_num` int(10) DEFAULT '0' COMMENT '点赞数',
  `reply_time` date DEFAULT NULL COMMENT '回复时间',
  `reply_user_id` bigint(11) DEFAULT NULL COMMENT '回复者用户ID',
  `reply_content` text COMMENT '回复内容',
  `is_deleted` int(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `audit_status` int(2) NOT NULL DEFAULT '0' COMMENT '审核状态',
  PRIMARY KEY (`id`),
  KEY `deal_id` (`user_id`),
  KEY `is_buy` (`item_id`),
  KEY `is_effect` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1489 COMMENT='商品评论表';

-- ----------------------------
-- Records of item_comment
-- ----------------------------
INSERT INTO `item_comment` VALUES ('1', '1', 'oliver', '1', '3', '4', null, 'a', null, null, null, null, null, null, '0', '2015-02-04 11:11:16', '2015-01-30 20:18:55', '0');
INSERT INTO `item_comment` VALUES ('2', '1', 'oliver', '2', '3', '5', null, 'x', null, null, null, null, null, null, '1', '2015-02-04 11:12:49', '2015-03-02 16:11:40', '1');
INSERT INTO `item_comment` VALUES ('3', '1', 'oliver', '4', '3', '4', null, 'x', null, null, null, null, null, null, '0', '2015-02-04 11:14:36', '2015-01-20 16:22:02', '2');
INSERT INTO `item_comment` VALUES ('4', '1', 'oliver', '4', '3', '4', null, 'dddddd', null, null, null, null, null, null, '0', '2015-02-02 15:02:33', '2015-01-20 18:00:57', '2');
INSERT INTO `item_comment` VALUES ('5', '1', 'oliver', '5', '3', '4', null, ',.u', null, null, null, null, null, null, '0', '2015-02-02 15:02:35', '2015-01-20 18:05:17', '3');
INSERT INTO `item_comment` VALUES ('6', '1', 'hu', '2', '3', '4', null, 'iiiiii', null, null, null, null, null, null, '0', '2015-02-02 15:02:42', '2015-01-20 18:06:11', '3');
INSERT INTO `item_comment` VALUES ('7', '1', 'hu', '2', '3', '4', null, 'xxxx', null, null, null, null, null, null, '0', '2015-02-02 15:02:43', '2015-01-20 18:09:30', '2');
INSERT INTO `item_comment` VALUES ('8', '1', 'hu', '2', '3', '4', null, 'ooooo', null, null, null, null, null, null, '0', '2015-02-02 15:02:44', '2015-01-20 18:11:22', '2');
INSERT INTO `item_comment` VALUES ('9', '1', 'hu', '2', '3', '4', null, 'aaaaa', null, null, null, null, null, null, '0', '2015-02-02 15:02:45', '2015-01-20 18:13:02', '2');
INSERT INTO `item_comment` VALUES ('10', '1', 'hu', '2', '3', '4', null, 'dddd', null, null, null, null, null, null, '0', '2015-01-20 18:25:54', '2015-01-20 18:13:17', '0');
INSERT INTO `item_comment` VALUES ('11', '1', 'hu', '2', '3', '4', null, 'eeeee', null, null, null, null, null, null, '0', '2015-01-20 18:25:55', '2015-01-20 18:13:26', '0');
INSERT INTO `item_comment` VALUES ('12', '1', 'hu1111', '2', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-01-29 11:24:20', '2015-01-29 11:24:20', '0');
INSERT INTO `item_comment` VALUES ('13', '1', 'hu1', '2', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-02 14:39:45', '2015-02-02 14:39:45', '0');
INSERT INTO `item_comment` VALUES ('14', '1', 'hu2', '2', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-02 14:40:26', '2015-02-02 14:40:26', '0');
INSERT INTO `item_comment` VALUES ('15', '1', 'hu3', '4', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-04 11:14:34', '2015-02-02 14:58:49', '0');
INSERT INTO `item_comment` VALUES ('16', '1', 'hu4', '4', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-04 11:14:41', '2015-02-02 14:59:22', '0');
INSERT INTO `item_comment` VALUES ('17', '1', 'hu5', '4', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-04 11:14:35', '2015-02-04 11:07:38', '0');
INSERT INTO `item_comment` VALUES ('18', '1', 'hu5', '4', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-04 11:14:40', '2015-02-04 11:08:32', '0');
INSERT INTO `item_comment` VALUES ('19', '1', 'hu5', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-11 22:10:53', '2015-02-11 22:10:53', '0');
INSERT INTO `item_comment` VALUES ('20', '1', 'hu5', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-11 22:18:00', '2015-02-11 22:18:00', '0');
INSERT INTO `item_comment` VALUES ('21', '1', 'hu5', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-11 22:19:47', '2015-02-11 22:19:47', '0');
INSERT INTO `item_comment` VALUES ('22', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-11 22:22:41', '2015-02-11 22:22:41', '0');
INSERT INTO `item_comment` VALUES ('23', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-11 22:25:33', '2015-02-11 22:25:33', '0');
INSERT INTO `item_comment` VALUES ('24', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-12 14:01:53', '2015-02-12 14:01:53', '0');
INSERT INTO `item_comment` VALUES ('25', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-12 14:08:27', '2015-02-12 14:08:27', '0');
INSERT INTO `item_comment` VALUES ('26', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 15:18:03', '2015-02-27 15:18:03', '0');
INSERT INTO `item_comment` VALUES ('27', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:32:58', '2015-02-27 16:32:58', '0');
INSERT INTO `item_comment` VALUES ('28', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:34:38', '2015-02-27 16:34:38', '0');
INSERT INTO `item_comment` VALUES ('29', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:35:12', '2015-02-27 16:35:12', '0');
INSERT INTO `item_comment` VALUES ('30', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:35:32', '2015-02-27 16:35:32', '0');
INSERT INTO `item_comment` VALUES ('31', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:36:04', '2015-02-27 16:36:04', '0');
INSERT INTO `item_comment` VALUES ('32', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:37:07', '2015-02-27 16:37:07', '0');
INSERT INTO `item_comment` VALUES ('33', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 16:39:11', '2015-02-27 16:39:11', '0');
INSERT INTO `item_comment` VALUES ('34', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 20:02:40', '2015-02-27 20:02:40', '0');
INSERT INTO `item_comment` VALUES ('35', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 20:53:24', '2015-02-27 20:53:24', '0');
INSERT INTO `item_comment` VALUES ('36', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 20:54:15', '2015-02-27 20:54:15', '0');
INSERT INTO `item_comment` VALUES ('37', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-27 21:54:57', '2015-02-27 21:54:57', '0');
INSERT INTO `item_comment` VALUES ('38', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-02-28 11:01:32', '2015-02-28 11:01:32', '0');
INSERT INTO `item_comment` VALUES ('39', '1', 'hu6', '999', '3', '4', null, 'aaaaaaa', '5', null, '0', null, null, null, '0', '2015-03-02 16:11:40', '2015-03-02 16:11:40', '0');

-- ----------------------------
-- Table structure for item_extra_info
-- ----------------------------
DROP TABLE IF EXISTS `item_extra_info`;
CREATE TABLE `item_extra_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(8) NOT NULL COMMENT '供应商ID',
  `item_id` bigint(11) NOT NULL COMMENT '商品ID',
  `cart_type` int(1) NOT NULL COMMENT '购物车业务类型，0：不允许购物车，1：允许购物车',
  `level_limit` int(1) DEFAULT NULL COMMENT '会员等级购买限制',
  `comment_count` int(8) DEFAULT '0' COMMENT '评论数',
  `collect_count` int(8) DEFAULT '0' COMMENT '收藏数',
  `score` int(2) DEFAULT '0' COMMENT '商品评分，由所有买家的评价评分算得',
  `stock_num` int(8) DEFAULT '0' COMMENT '库存总量',
  `sold_num` int(8) DEFAULT '0' COMMENT '已售商品总量',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8 COMMENT='商品扩展信息表';

-- ----------------------------
-- Records of item_extra_info
-- ----------------------------
INSERT INTO `item_extra_info` VALUES ('1', '1', '1', '1', '1', null, '100', null, null, null, '0', '2015-01-27 23:02:48', '2015-02-28 22:07:16');
INSERT INTO `item_extra_info` VALUES ('2', '1', '1', '1', '1', null, '200', null, null, '11', '0', '2015-01-27 23:02:10', '2015-02-28 22:14:38');
INSERT INTO `item_extra_info` VALUES ('3', '1', '1', '1', '1', null, '300', null, null, null, '0', '2015-01-27 23:02:14', '2015-01-27 23:02:14');
INSERT INTO `item_extra_info` VALUES ('4', '1', '1', '1', '1', null, '500', null, null, '11', '0', '2015-01-27 23:06:15', '2015-01-27 23:06:15');
INSERT INTO `item_extra_info` VALUES ('5', '1', '1', '1', '1', null, '700', null, null, null, '0', '2015-01-27 23:02:29', '2015-01-27 23:02:29');
INSERT INTO `item_extra_info` VALUES ('6', '1', '1', '1', '1', null, '700', null, null, null, '0', '2015-02-28 20:13:27', '2015-02-28 20:13:27');
INSERT INTO `item_extra_info` VALUES ('7', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 21:53:24', '2015-02-28 21:53:24');
INSERT INTO `item_extra_info` VALUES ('8', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 21:54:03', '2015-02-28 21:54:03');
INSERT INTO `item_extra_info` VALUES ('9', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 21:57:18', '2015-02-28 21:57:18');
INSERT INTO `item_extra_info` VALUES ('10', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 21:57:42', '2015-02-28 21:57:42');
INSERT INTO `item_extra_info` VALUES ('11', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 21:58:04', '2015-02-28 21:58:04');
INSERT INTO `item_extra_info` VALUES ('12', '1', '1', '1', '1', '0', '700', '0', '0', '0', '0', '2015-02-28 22:08:23', '2015-02-28 22:08:23');

-- ----------------------------
-- Table structure for item_image
-- ----------------------------
DROP TABLE IF EXISTS `item_image`;
CREATE TABLE `item_image` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(10) NOT NULL COMMENT '商品ID',
  `supplier_id` bigint(10) NOT NULL COMMENT '供应商ID',
  `image_type` int(2) DEFAULT '0' COMMENT '图片类型：1代表商品主图，2代表商品属性图，3代表商品详情图',
  `image_name` varchar(100) DEFAULT NULL COMMENT '图片名称',
  `img_url` varchar(256) NOT NULL COMMENT '图片地址',
  `img_length_pixel` int(8) DEFAULT '0' COMMENT '图片象素长度',
  `img_width_pixel` int(8) DEFAULT '0' COMMENT '图片象素宽度',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品图片表';

-- ----------------------------
-- Records of item_image
-- ----------------------------
INSERT INTO `item_image` VALUES ('1', '1', '2', '2', '猫', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 19:48:01', '2015-01-27 19:48:01');
INSERT INTO `item_image` VALUES ('2', '1', '2', '2', '狼', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 19:48:01', '2015-01-27 19:48:01');
INSERT INTO `item_image` VALUES ('3', '1', '2', '2', '狗', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 15:52:42', '2015-01-27 15:52:42');
INSERT INTO `item_image` VALUES ('4', '1', '2', '2', '兔子', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 15:55:38', '2015-01-27 15:55:38');
INSERT INTO `item_image` VALUES ('5', '1', '2', '2', '牛', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 15:55:41', '2015-01-27 15:55:41');
INSERT INTO `item_image` VALUES ('6', '1', '2', '2', '羊', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 15:55:49', '2015-01-27 15:55:49');
INSERT INTO `item_image` VALUES ('7', '2', '2', '2', '猪', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 16:02:24', '2015-01-27 15:55:54');
INSERT INTO `item_image` VALUES ('8', '2', '2', '2', '狗', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 16:02:23', '2015-01-27 15:55:58');
INSERT INTO `item_image` VALUES ('9', '2', '2', '2', '虎', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 16:02:23', '2015-01-27 15:56:22');
INSERT INTO `item_image` VALUES ('10', '3', '1', '2', '虎1', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 16:56:35', '2015-02-10 17:31:30');
INSERT INTO `item_image` VALUES ('11', '3', '1', '2', '虎2', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-27 16:56:35', '2015-02-10 17:31:30');
INSERT INTO `item_image` VALUES ('12', '3', '1', '2', '狗1', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-30 11:56:14', '2015-02-10 17:31:11');
INSERT INTO `item_image` VALUES ('13', '3', '1', '2', '狗2', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-01-30 11:56:14', '2015-02-10 17:31:11');
INSERT INTO `item_image` VALUES ('14', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 17:59:44', '2015-02-10 17:59:44');
INSERT INTO `item_image` VALUES ('15', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 18:01:22', '2015-02-10 18:01:22');
INSERT INTO `item_image` VALUES ('16', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 18:02:05', '2015-02-10 18:02:05');
INSERT INTO `item_image` VALUES ('17', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 18:04:53', '2015-02-10 18:04:53');
INSERT INTO `item_image` VALUES ('18', '4', '1', '2', '狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 18:04:54', '2015-02-10 18:04:54');
INSERT INTO `item_image` VALUES ('19', '17', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:11:48', '2015-02-10 21:11:48');
INSERT INTO `item_image` VALUES ('20', '17', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:11:48', '2015-02-10 21:11:48');
INSERT INTO `item_image` VALUES ('21', '18', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:23:55', '2015-02-10 21:23:55');
INSERT INTO `item_image` VALUES ('22', '18', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:23:55', '2015-02-10 21:23:55');
INSERT INTO `item_image` VALUES ('23', '19', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:27:20', '2015-02-10 21:27:20');
INSERT INTO `item_image` VALUES ('24', '19', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:27:20', '2015-02-10 21:27:20');
INSERT INTO `item_image` VALUES ('25', '20', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:29:11', '2015-02-10 21:29:11');
INSERT INTO `item_image` VALUES ('26', '20', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:29:11', '2015-02-10 21:29:11');
INSERT INTO `item_image` VALUES ('27', '21', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:33:20', '2015-02-10 21:33:20');
INSERT INTO `item_image` VALUES ('28', '21', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:33:20', '2015-02-10 21:33:20');
INSERT INTO `item_image` VALUES ('29', '22', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:48:40', '2015-03-01 00:22:29');
INSERT INTO `item_image` VALUES ('30', '22', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-10 21:48:40', '2015-03-01 00:22:29');
INSERT INTO `item_image` VALUES ('31', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:22:02', '2015-02-28 22:22:02');
INSERT INTO `item_image` VALUES ('32', '4', '1', '2', '狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:22:02', '2015-02-28 22:22:02');
INSERT INTO `item_image` VALUES ('33', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:25:58', '2015-02-28 22:25:58');
INSERT INTO `item_image` VALUES ('34', '4', '1', '2', '狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:25:58', '2015-02-28 22:25:58');
INSERT INTO `item_image` VALUES ('35', '4', '1', '2', '狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:27:14', '2015-02-28 22:27:14');
INSERT INTO `item_image` VALUES ('36', '4', '1', '2', '狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 22:27:14', '2015-02-28 22:27:14');
INSERT INTO `item_image` VALUES ('37', '24', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19');
INSERT INTO `item_image` VALUES ('38', '24', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19');
INSERT INTO `item_image` VALUES ('39', '25', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:01:49', '2015-02-28 23:01:49');
INSERT INTO `item_image` VALUES ('40', '25', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:01:49', '2015-02-28 23:01:49');
INSERT INTO `item_image` VALUES ('41', '26', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:07:36', '2015-02-28 23:07:36');
INSERT INTO `item_image` VALUES ('42', '26', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:07:36', '2015-02-28 23:07:36');
INSERT INTO `item_image` VALUES ('43', '27', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:08:16', '2015-02-28 23:08:16');
INSERT INTO `item_image` VALUES ('44', '27', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:08:16', '2015-02-28 23:08:16');
INSERT INTO `item_image` VALUES ('45', '28', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05');
INSERT INTO `item_image` VALUES ('46', '28', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:10:06', '2015-02-28 23:10:06');
INSERT INTO `item_image` VALUES ('47', '31', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05');
INSERT INTO `item_image` VALUES ('48', '31', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:18:06', '2015-02-28 23:18:06');
INSERT INTO `item_image` VALUES ('49', '32', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:19:19', '2015-02-28 23:19:19');
INSERT INTO `item_image` VALUES ('50', '32', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:19:19', '2015-02-28 23:19:19');
INSERT INTO `item_image` VALUES ('51', '33', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35');
INSERT INTO `item_image` VALUES ('52', '33', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-02-28 23:20:36', '2015-02-28 23:20:36');
INSERT INTO `item_image` VALUES ('53', '36', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-03-01 00:21:34', '2015-03-01 00:21:34');
INSERT INTO `item_image` VALUES ('54', '36', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-03-01 00:21:34', '2015-03-01 00:21:34');
INSERT INTO `item_image` VALUES ('55', '39', '1', '2', '测试狗11', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-03-01 00:22:26', '2015-03-01 00:22:26');
INSERT INTO `item_image` VALUES ('56', '39', '1', '2', '测试狗22', 'http://www.163.com/a.jpeg', '0', '0', '0', '0', '2015-03-01 00:22:26', '2015-03-01 00:22:26');

-- ----------------------------
-- Table structure for item_property
-- ----------------------------
DROP TABLE IF EXISTS `item_property`;
CREATE TABLE `item_property` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(10) NOT NULL COMMENT '商品ID',
  `supplier_id` bigint(10) NOT NULL COMMENT '供应商ID',
  `property_type` int(2) DEFAULT '0' COMMENT '属性类型: 0：一般属性;1：关键属性;2:SKU属性',
  `key_name` varchar(100) NOT NULL COMMENT '属性名',
  `val` varchar(100) NOT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `is_deleted` int(2) NOT NULL COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品属性表';

-- ----------------------------
-- Records of item_property
-- ----------------------------
INSERT INTO `item_property` VALUES ('1', '1', '2', '0', '颜色', '灰色', '1', null, null, null, '0', '2015-01-23 18:32:29', '2015-01-23 18:32:29');
INSERT INTO `item_property` VALUES ('2', '1', '4', '0', '颜色', '蓝色', '1', null, null, null, '0', '2015-01-23 18:30:16', '2015-02-28 18:10:01');
INSERT INTO `item_property` VALUES ('3', '1', '1', '0', '颜色', '白色', '1', null, null, null, '0', '2015-01-23 19:32:23', '2015-01-23 18:30:33');
INSERT INTO `item_property` VALUES ('4', '1', '1', '0', '颜色', '红色', '1', null, null, null, '0', '2015-01-23 19:42:04', '2015-01-23 18:30:38');
INSERT INTO `item_property` VALUES ('5', '2', '2', '0', '颜色', '绿色', '1', null, null, null, '0', '2015-01-23 19:32:16', '2015-01-23 18:30:42');
INSERT INTO `item_property` VALUES ('6', '2', '2', '0', '颜色', '水蓝色333', '1', null, null, null, '0', '2015-01-23 19:32:17', '2015-02-28 18:25:12');
INSERT INTO `item_property` VALUES ('7', '2', '3', '0', '颜色', '天蓝色', '1', null, null, null, '0', '2015-01-23 19:32:22', '2015-01-23 18:30:50');
INSERT INTO `item_property` VALUES ('8', '2', '3', '0', '颜色', '紫色', '1', null, null, null, '0', '2015-01-23 19:32:21', '2015-01-23 18:30:57');
INSERT INTO `item_property` VALUES ('9', '1', '2', '0', '颜色', '紫色', '1', null, null, null, '0', '2015-02-09 09:27:11', '2015-02-09 09:27:11');
INSERT INTO `item_property` VALUES ('10', '1', '2', '0', '颜色', '紫色', '1', null, null, null, '0', '2015-02-09 09:27:56', '2015-02-09 09:27:56');
INSERT INTO `item_property` VALUES ('11', '1', '2', '0', '颜色', '红红色', '1', null, null, null, '0', '2015-02-09 10:02:20', '2015-02-09 10:02:20');
INSERT INTO `item_property` VALUES ('12', '1', '2', '0', '颜色', '红红11色', '1', '0', null, null, '0', '2015-02-09 14:25:11', '2015-02-09 14:25:11');
INSERT INTO `item_property` VALUES ('13', '1', '2', '0', '颜色', '红红22色', '1', '0', null, null, '0', '2015-02-09 14:55:49', '2015-02-09 14:55:49');
INSERT INTO `item_property` VALUES ('14', '1', '2', '0', '颜色', '红红33色', '1', '0', null, null, '0', '2015-02-10 11:59:15', '2015-02-10 11:59:15');
INSERT INTO `item_property` VALUES ('15', '1', '2', '0', '颜色', '红红33色', '1', '0', null, null, '0', '2015-02-28 18:04:16', '2015-02-28 18:04:16');
INSERT INTO `item_property` VALUES ('16', '1', '2', '0', '颜色', '红红33色', '1', '0', null, null, '0', '2015-02-28 18:05:00', '2015-02-28 18:05:00');
INSERT INTO `item_property` VALUES ('17', '1', '2', '0', '颜色', '红红33色', '1', '0', null, null, '0', '2015-02-28 18:07:31', '2015-02-28 18:07:31');
INSERT INTO `item_property` VALUES ('18', '1', '2', '0', '颜色', '红红33色', '1', '0', null, null, '0', '2015-02-28 18:08:00', '2015-02-28 18:08:00');

-- ----------------------------
-- Table structure for item_property_tmpl
-- ----------------------------
DROP TABLE IF EXISTS `item_property_tmpl`;
CREATE TABLE `item_property_tmpl` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `tmpl_name` varchar(64) NOT NULL COMMENT '模板名称',
  `owner_type` int(2) NOT NULL DEFAULT '1' COMMENT '模板属主类型：1代表系统模板，2代表用户模板',
  `owner_id` bigint(10) NOT NULL DEFAULT '0' COMMENT 'owner_type=1，则owner_id为0，如果owner_type=2，则owner_id为用户ID',
  `property_type` int(2) DEFAULT '0' COMMENT '属性类型: 0：一般属性;1：关键属性;2:SKU属性',
  `key_name` varchar(100) NOT NULL COMMENT '属性名',
  `val` varchar(100) NOT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `inherit_type` int(2) DEFAULT NULL COMMENT '继承类型：0不可继承，1可继承。继承的意思是下级类目是否可以继承父级类目的属性',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `category_id` int(10) NOT NULL COMMENT '所属类目ID',
  `is_deleted` int(2) NOT NULL COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品属性模板表';

-- ----------------------------
-- Records of item_property_tmpl
-- ----------------------------
INSERT INTO `item_property_tmpl` VALUES ('1', '服饰', '0', '0', '0', '颜色', '玫瑰色', '1', null, null, null, null, '1', '0', '2015-01-23 17:16:44', '2015-02-28 17:51:48');
INSERT INTO `item_property_tmpl` VALUES ('2', '服饰', '0', '0', '0', '颜色', '蓝色', '1', null, null, null, null, '1', '0', '2015-01-23 17:15:57', '2015-01-23 17:15:57');
INSERT INTO `item_property_tmpl` VALUES ('3', '服饰', '0', '0', '0', '颜色', '红色', '1', null, null, null, null, '1', '0', '2015-01-23 17:16:01', '2015-01-23 17:16:01');
INSERT INTO `item_property_tmpl` VALUES ('4', '服饰', '0', '0', '0', '颜色', '黑色', '1', null, null, null, null, '1', '0', '2015-01-23 17:16:05', '2015-01-23 17:16:05');
INSERT INTO `item_property_tmpl` VALUES ('5', '服饰', '0', '0', '0', '颜色', '白色', '1', null, null, null, null, '1', '0', '2015-01-23 17:16:09', '2015-01-23 17:16:09');
INSERT INTO `item_property_tmpl` VALUES ('6', '服饰', '0', '0', '0', '颜色', '水蓝色', '1', null, null, null, null, '1', '0', '2015-01-23 17:18:30', '2015-02-28 18:01:43');
INSERT INTO `item_property_tmpl` VALUES ('7', '服饰222', '1', '0', '0', '颜色', '天蓝色', '1', '0', null, null, null, '3', '0', '2015-02-07 15:46:14', '2015-02-07 15:46:14');
INSERT INTO `item_property_tmpl` VALUES ('8', '服饰222', '1', '0', '0', '颜色', '粉色', '1', '0', null, null, null, '3', '0', '2015-02-07 15:47:05', '2015-02-07 15:47:05');
INSERT INTO `item_property_tmpl` VALUES ('9', '服饰222', '1', '0', '0', '颜色', '天蓝色', '1', '0', null, null, null, '3', '0', '2015-02-07 16:14:41', '2015-02-07 16:14:41');
INSERT INTO `item_property_tmpl` VALUES ('10', '服饰222', '1', '0', '0', '颜色', '天蓝色', '1', '0', null, null, null, '3', '0', '2015-02-28 17:34:19', '2015-02-28 17:34:19');
INSERT INTO `item_property_tmpl` VALUES ('11', '服饰222', '1', '0', '0', '颜色', '天蓝色', '1', '0', null, null, null, '3', '0', '2015-02-28 17:37:41', '2015-02-28 17:37:41');
INSERT INTO `item_property_tmpl` VALUES ('12', '服饰222', '1', '0', '0', '颜色', '天蓝色', '1', '0', null, null, null, '3', '0', '2015-02-28 17:51:25', '2015-02-28 17:51:25');

-- ----------------------------
-- Table structure for item_sales_rel
-- ----------------------------
DROP TABLE IF EXISTS `item_sales_rel`;
CREATE TABLE `item_sales_rel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL COMMENT '商品ID',
  `sales_field_id` int(11) NOT NULL COMMENT '专场ID',
  `is_deleted` int(2) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='专题品牌表';

-- ----------------------------
-- Records of item_sales_rel
-- ----------------------------
INSERT INTO `item_sales_rel` VALUES ('1', '1', '1', '0', '2015-03-10 17:35:01', '2015-03-10 17:35:01');
INSERT INTO `item_sales_rel` VALUES ('2', '2', '1', '0', '2015-03-10 17:35:01', '2015-03-10 17:35:01');
INSERT INTO `item_sales_rel` VALUES ('3', '3', '1', '0', '2015-03-10 17:35:01', '2015-03-10 17:35:01');
INSERT INTO `item_sales_rel` VALUES ('4', '1', '2', '0', '2015-03-11 09:38:02', '2015-03-11 09:38:02');
INSERT INTO `item_sales_rel` VALUES ('5', '2', '2', '0', '2015-03-11 09:38:02', '2015-03-11 09:38:02');
INSERT INTO `item_sales_rel` VALUES ('6', '3', '2', '0', '2015-03-11 09:38:02', '2015-03-11 09:38:02');

-- ----------------------------
-- Table structure for item_sku
-- ----------------------------
DROP TABLE IF EXISTS `item_sku`;
CREATE TABLE `item_sku` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `code_value` varchar(500) DEFAULT NULL COMMENT 'sku代号，例如：红色-42码，sku名称为多个不同维度的sku属性的key按一定顺序拼装而成',
  `item_id` bigint(10) NOT NULL COMMENT '商品ID',
  `material_code` varchar(100) NOT NULL COMMENT '物料码',
  `bar_code` varchar(100) NOT NULL COMMENT '条码',
  `seller_id` bigint(10) NOT NULL,
  `market_price` int(100) DEFAULT NULL COMMENT '市场价',
  `promotion_price` int(100) DEFAULT NULL COMMENT '促销价',
  `wireless_price` int(100) DEFAULT NULL COMMENT '无线价',
  `stock_num` bigint(10) DEFAULT NULL COMMENT '库存量',
  `sold_num` bigint(10) DEFAULT NULL COMMENT '已售数量',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `sku_type` int(2) NOT NULL DEFAULT '0' COMMENT '0: 默认类型; 1:套装SKU类型',
  `supplier_type` int(2) NOT NULL DEFAULT '0' COMMENT '0;1;2;3;4;5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品销售属性表(sku表)';

-- ----------------------------
-- Records of item_sku
-- ----------------------------
INSERT INTO `item_sku` VALUES ('2', '红色-16寸-50克', '1', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '111', '0', '2015-02-06 16:42:18', '2015-01-21 18:09:54', '0', '0');
INSERT INTO `item_sku` VALUES ('3', '蓝蓝色2-红红色2-白白色-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-蓝蓝色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-红红色3-', '1', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-05 16:01:13', '2015-02-28 11:17:36', '0', '0');
INSERT INTO `item_sku` VALUES ('4', '蓝色-17寸-50克', '1', 'aaaaa', 'xxxxx', '1', '999', '100', '80', '1002', '1000', '0', '2015-02-06 13:54:13', '2015-02-28 16:51:43', '0', '0');
INSERT INTO `item_sku` VALUES ('5', '蓝色-17寸-100克', '1', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-21 18:09:00', '2015-01-21 18:09:00', '0', '0');
INSERT INTO `item_sku` VALUES ('6', '蓝色-10寸-100克', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-21 18:28:20', '2015-01-21 18:28:20', '0', '0');
INSERT INTO `item_sku` VALUES ('7', '红色-10寸-100克', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-21 18:28:28', '2015-01-21 18:28:28', '0', '0');
INSERT INTO `item_sku` VALUES ('8', '红色-10寸-50克', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-21 18:28:39', '2015-01-21 18:28:39', '0', '0');
INSERT INTO `item_sku` VALUES ('9', '红色-11寸-50克', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-21 19:43:05', '2015-01-21 19:43:05', '0', '0');
INSERT INTO `item_sku` VALUES ('10', '50g-红色-17码-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-01-29 23:12:27', '2015-01-29 23:12:27', '0', '0');
INSERT INTO `item_sku` VALUES ('12', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '100', '80', '1096', '1', '0', '2015-02-06 16:21:48', '2015-02-28 16:51:41', '0', '0');
INSERT INTO `item_sku` VALUES ('13', null, '17', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:08:35', '2015-02-10 21:08:35', '0', '0');
INSERT INTO `item_sku` VALUES ('14', null, '17', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:11:40', '2015-02-10 21:11:40', '0', '0');
INSERT INTO `item_sku` VALUES ('15', null, '18', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:23:54', '2015-02-10 21:23:54', '0', '0');
INSERT INTO `item_sku` VALUES ('16', null, '18', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:23:54', '2015-02-10 21:23:54', '0', '0');
INSERT INTO `item_sku` VALUES ('17', null, '19', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:24:44', '2015-02-10 21:26:16', '0', '0');
INSERT INTO `item_sku` VALUES ('18', null, '19', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:27:17', '2015-02-10 21:27:19', '0', '0');
INSERT INTO `item_sku` VALUES ('19', null, '20', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:29:02', '2015-02-10 21:29:09', '0', '0');
INSERT INTO `item_sku` VALUES ('20', null, '20', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:29:09', '2015-02-10 21:29:11', '0', '0');
INSERT INTO `item_sku` VALUES ('21', null, '21', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:31:11', '2015-02-10 21:33:18', '0', '0');
INSERT INTO `item_sku` VALUES ('22', null, '21', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:33:18', '2015-02-10 21:33:20', '0', '0');
INSERT INTO `item_sku` VALUES ('23', '16码-红色-', '22', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:48:39', '2015-03-01 00:22:29', '0', '0');
INSERT INTO `item_sku` VALUES ('24', '蓝色-', '22', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-10 21:48:40', '2015-03-01 00:22:29', '0', '0');
INSERT INTO `item_sku` VALUES ('26', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 11:57:33', '2015-02-27 11:57:33', '0', '0');
INSERT INTO `item_sku` VALUES ('27', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 11:58:29', '2015-02-27 11:58:29', '0', '0');
INSERT INTO `item_sku` VALUES ('28', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 12:01:29', '2015-02-27 12:01:30', '0', '0');
INSERT INTO `item_sku` VALUES ('29', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 12:03:45', '2015-02-27 12:03:46', '0', '0');
INSERT INTO `item_sku` VALUES ('30', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 13:45:34', '2015-02-27 13:45:35', '0', '0');
INSERT INTO `item_sku` VALUES ('31', '水蓝色-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 13:46:45', '2015-02-27 22:58:06', '0', '0');
INSERT INTO `item_sku` VALUES ('32', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 14:01:31', '2015-02-27 14:01:31', '0', '0');
INSERT INTO `item_sku` VALUES ('33', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 15:17:13', '2015-02-27 15:17:13', '0', '0');
INSERT INTO `item_sku` VALUES ('34', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 15:20:33', '2015-02-27 15:20:33', '0', '0');
INSERT INTO `item_sku` VALUES ('35', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-27 23:15:28', '2015-02-27 23:15:28', '0', '0');
INSERT INTO `item_sku` VALUES ('36', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 11:29:16', '2015-02-28 11:29:17', '0', '0');
INSERT INTO `item_sku` VALUES ('37', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 11:30:54', '2015-02-28 11:30:54', '0', '0');
INSERT INTO `item_sku` VALUES ('38', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 11:32:54', '2015-02-28 11:32:55', '0', '0');
INSERT INTO `item_sku` VALUES ('39', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 11:33:23', '2015-02-28 11:33:23', '0', '0');
INSERT INTO `item_sku` VALUES ('40', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 11:37:30', '2015-02-28 11:37:31', '0', '0');
INSERT INTO `item_sku` VALUES ('41', '水蓝色-99kg-XXL-', '2', 'aaaaa', 'xxxxx', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 16:51:36', '2015-02-28 16:51:36', '0', '0');
INSERT INTO `item_sku` VALUES ('43', '16码-红色-', '24', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:00:18', '2015-02-28 23:00:18', '0', '0');
INSERT INTO `item_sku` VALUES ('44', '蓝色-17码-', '24', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19', '0', '0');
INSERT INTO `item_sku` VALUES ('45', '16码-红色-', '25', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48', '0', '0');
INSERT INTO `item_sku` VALUES ('46', '蓝色-17码-', '25', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48', '0', '0');
INSERT INTO `item_sku` VALUES ('47', '16码-红色-', '26', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:07:35', '2015-02-28 23:07:35', '0', '0');
INSERT INTO `item_sku` VALUES ('48', '蓝色-17码-', '26', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:07:35', '2015-02-28 23:07:35', '0', '0');
INSERT INTO `item_sku` VALUES ('49', '16码-红色-', '27', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15', '0', '0');
INSERT INTO `item_sku` VALUES ('50', '蓝色-17码-', '27', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15', '0', '0');
INSERT INTO `item_sku` VALUES ('51', '16码-红色-', '28', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05', '0', '0');
INSERT INTO `item_sku` VALUES ('52', '蓝色-17码-', '28', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05', '0', '0');
INSERT INTO `item_sku` VALUES ('53', '16码-红色-', '31', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:18:04', '2015-02-28 23:18:05', '0', '0');
INSERT INTO `item_sku` VALUES ('54', '蓝色-17码-', '31', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05', '0', '0');
INSERT INTO `item_sku` VALUES ('55', '16码-红色-', '32', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:19:18', '2015-02-28 23:19:18', '0', '0');
INSERT INTO `item_sku` VALUES ('56', '蓝色-17码-', '32', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:19:18', '2015-02-28 23:19:18', '0', '0');
INSERT INTO `item_sku` VALUES ('57', '16码-红色-', '33', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:20:34', '2015-02-28 23:20:35', '0', '0');
INSERT INTO `item_sku` VALUES ('58', '蓝色-17码-', '33', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35', '0', '0');
INSERT INTO `item_sku` VALUES ('59', '16码-红色-', '36', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-03-01 00:21:33', '2015-03-01 00:21:33', '0', '0');
INSERT INTO `item_sku` VALUES ('60', '蓝色-17码-', '36', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-03-01 00:21:34', '2015-03-01 00:21:34', '0', '0');
INSERT INTO `item_sku` VALUES ('61', '16码-红色-', '39', 'aa', 'a', '1', '100', '90', '80', '1000', '1', '0', '2015-03-01 00:22:25', '2015-03-01 00:22:25', '0', '0');
INSERT INTO `item_sku` VALUES ('62', '蓝色-17码-', '39', 'bb', 'b', '1', '100', '90', '80', '1000', '1', '0', '2015-03-01 00:22:26', '2015-03-01 00:22:26', '0', '0');

-- ----------------------------
-- Table structure for sales_field
-- ----------------------------
DROP TABLE IF EXISTS `sales_field`;
CREATE TABLE `sales_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `division_id` int(6) NOT NULL DEFAULT '0' COMMENT '部门id',
  `field_name` varchar(255) NOT NULL,
  `field_en_name` varchar(255) DEFAULT NULL COMMENT '专场英文名字',
  `logo` varchar(255) NOT NULL COMMENT '专场logo',
  `banner_img` varchar(255) DEFAULT NULL COMMENT '首页横图',
  `sales_group_id` int(8) DEFAULT NULL COMMENT '所属专场组',
  `deal_category_id` int(8) DEFAULT NULL COMMENT '专场类目',
  `sales_brand_id` int(8) DEFAULT NULL COMMENT '专场品牌',
  `sex` varchar(10) DEFAULT '' COMMENT '性别.1,通用;2,男;3,女',
  `age` varchar(100) DEFAULT '' COMMENT '专题年龄段',
  `pc_background` varchar(255) DEFAULT NULL COMMENT 'PC背景',
  `pc_background_color` varchar(150) DEFAULT NULL COMMENT '背景色',
  `brief` text COMMENT '专场描述',
  `sale_info` varchar(255) DEFAULT NULL COMMENT '专场特价信息描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  `mobile_sort` int(11) DEFAULT NULL COMMENT '移动排序字段',
  `begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '专场开始时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '专场结束时间',
  `begin_show_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始显示时间',
  `is_show_banner` int(1) DEFAULT '1' COMMENT '是否显示banner',
  `pc_banner` varchar(255) DEFAULT NULL COMMENT 'PC banner大图',
  `is_show_itemlist` int(1) DEFAULT '1' COMMENT '是否显示商品列表',
  `has_right_navigate` int(1) DEFAULT '0' COMMENT '是否有右侧导航',
  `field_status` int(2) NOT NULL DEFAULT '0' COMMENT '状态：未开始/进行中/已下线',
  `is_deleted` int(2) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='专题品牌表';

-- ----------------------------
-- Records of sales_field
-- ----------------------------
INSERT INTO `sales_field` VALUES ('1', '0', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:49:57', '1', null, '1', '0', '0', '0', '2015-03-10 14:18:34', '2015-03-10 14:18:34');
INSERT INTO `sales_field` VALUES ('2', '0', 'aaaaaaaaaaxxxxxxxxx', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:49:59', '1', null, '1', '0', '0', '0', '2015-03-10 14:18:49', '2015-03-11 09:33:12');
INSERT INTO `sales_field` VALUES ('3', '0', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:50:02', '1', null, '1', '0', '0', '0', '2015-03-10 14:19:05', '2015-03-10 18:28:30');
INSERT INTO `sales_field` VALUES ('4', '0', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:50:04', '1', null, '1', '0', '0', '0', '2015-03-10 14:19:08', '2015-03-10 14:19:08');
INSERT INTO `sales_field` VALUES ('5', '1', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:50:06', '1', null, '1', '0', '0', '0', '2015-03-10 14:43:13', '2015-03-10 14:43:13');
INSERT INTO `sales_field` VALUES ('6', '1', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 14:50:08', '1', null, '1', '0', '0', '0', '2015-03-10 14:43:41', '2015-03-10 14:43:41');
INSERT INTO `sales_field` VALUES ('7', '1', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 18:27:05', '1', null, '1', '0', '0', '0', '2015-03-10 18:27:05', '2015-03-10 18:27:05');
INSERT INTO `sales_field` VALUES ('8', '1', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-10 18:27:44', '1', null, '1', '0', '0', '0', '2015-03-10 18:27:44', '2015-03-10 18:27:44');
INSERT INTO `sales_field` VALUES ('9', '1', '秋季专场3', 'aaaaa', 'www.163.com/u.jpg', null, null, null, null, '', '', null, null, null, null, '2', null, '2000-12-12 12:12:12', '2000-12-12 12:12:13', '2015-03-11 09:32:53', '1', null, '1', '0', '0', '0', '2015-03-11 09:32:53', '2015-03-11 09:32:53');

-- ----------------------------
-- Table structure for sku_property
-- ----------------------------
DROP TABLE IF EXISTS `sku_property`;
CREATE TABLE `sku_property` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(10) NOT NULL,
  `seller_id` bigint(10) NOT NULL,
  `key_name` varchar(100) DEFAULT NULL COMMENT '属性名',
  `val` varchar(100) DEFAULT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='sku属性表';

-- ----------------------------
-- Records of sku_property
-- ----------------------------
INSERT INTO `sku_property` VALUES ('1', '1', '2', '颜色', '黑色', '1', '2', null, null, '0', '2015-01-21 16:32:59', '2015-01-21 16:32:59');
INSERT INTO `sku_property` VALUES ('2', '1', '2', '颜色', '天蓝色', '1', '1', null, null, '0', '2015-01-30 21:37:25', '2015-01-30 21:37:25');
INSERT INTO `sku_property` VALUES ('3', '10', '2', '颜色', '红色', '1', '3', null, null, '0', '2015-02-05 15:44:06', '2015-02-04 16:50:06');
INSERT INTO `sku_property` VALUES ('4', '10', '2', '颜色', '白色', '1', '2', null, null, '0', '2015-02-04 18:04:15', '2015-01-21 16:37:09');
INSERT INTO `sku_property` VALUES ('5', '1', '2', '颜色', '玫瑰色', '1', '1', null, null, '0', '2015-01-21 16:37:19', '2015-01-21 16:37:19');
INSERT INTO `sku_property` VALUES ('6', '1', '2', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-01-21 16:37:43', '2015-01-21 16:37:43');
INSERT INTO `sku_property` VALUES ('7', '1', '2', '颜色', '水天一色', '1', '0', null, null, '0', '2015-01-29 16:46:22', '2015-01-29 16:46:22');
INSERT INTO `sku_property` VALUES ('8', '10', '1', '重量', '50g', '1', '1', null, null, '0', '2015-01-29 23:13:56', '2015-01-29 23:13:56');
INSERT INTO `sku_property` VALUES ('9', '10', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-01-29 23:14:01', '2015-01-29 23:14:01');
INSERT INTO `sku_property` VALUES ('10', '10', '1', '尺寸', '17码', '1', '3', null, null, '0', '2015-01-29 23:14:20', '2015-01-29 23:14:20');
INSERT INTO `sku_property` VALUES ('11', '5', '1', '颜色', '蓝蓝色', '1', '1', null, null, '0', '2015-02-05 15:44:05', '2015-02-05 15:32:48');
INSERT INTO `sku_property` VALUES ('51', '3', '1', '颜色', '蓝蓝色2', '1', '0', null, null, '0', '2015-02-05 16:01:13', '2015-02-05 16:01:13');
INSERT INTO `sku_property` VALUES ('52', '3', '1', '颜色', '红红色2', '1', '2', null, null, '0', '2015-02-05 16:01:13', '2015-02-05 16:01:13');
INSERT INTO `sku_property` VALUES ('53', '3', '1', '颜色', '白白色', '1', '4', null, null, '0', '2015-02-05 16:01:13', '2015-02-28 11:06:16');
INSERT INTO `sku_property` VALUES ('54', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-05 16:01:13', '2015-02-05 16:01:13');
INSERT INTO `sku_property` VALUES ('58', '12', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-05 15:20:54', '2015-02-05 15:20:54');
INSERT INTO `sku_property` VALUES ('59', '12', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-05 15:20:54', '2015-02-05 15:20:54');
INSERT INTO `sku_property` VALUES ('60', '12', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-05 15:20:54', '2015-02-05 15:20:54');
INSERT INTO `sku_property` VALUES ('61', '13', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:09:19', '2015-02-10 21:09:19');
INSERT INTO `sku_property` VALUES ('62', '13', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:09:19', '2015-02-10 21:09:19');
INSERT INTO `sku_property` VALUES ('63', '14', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:11:41', '2015-02-10 21:11:41');
INSERT INTO `sku_property` VALUES ('64', '14', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:11:41', '2015-02-10 21:11:41');
INSERT INTO `sku_property` VALUES ('65', '15', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:23:54', '2015-02-10 21:23:54');
INSERT INTO `sku_property` VALUES ('66', '15', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:23:54', '2015-02-10 21:23:54');
INSERT INTO `sku_property` VALUES ('67', '16', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:23:55', '2015-02-10 21:23:55');
INSERT INTO `sku_property` VALUES ('68', '16', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:23:55', '2015-02-10 21:23:55');
INSERT INTO `sku_property` VALUES ('69', '17', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:27:17', '2015-02-10 21:27:17');
INSERT INTO `sku_property` VALUES ('70', '17', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:27:17', '2015-02-10 21:27:17');
INSERT INTO `sku_property` VALUES ('71', '18', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:27:20', '2015-02-10 21:27:20');
INSERT INTO `sku_property` VALUES ('72', '18', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:27:20', '2015-02-10 21:27:20');
INSERT INTO `sku_property` VALUES ('73', '19', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:29:09', '2015-02-10 21:29:09');
INSERT INTO `sku_property` VALUES ('74', '19', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:29:09', '2015-02-10 21:29:09');
INSERT INTO `sku_property` VALUES ('75', '20', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:29:11', '2015-02-10 21:29:11');
INSERT INTO `sku_property` VALUES ('76', '20', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:29:11', '2015-02-10 21:29:11');
INSERT INTO `sku_property` VALUES ('77', '21', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:33:18', '2015-02-10 21:33:18');
INSERT INTO `sku_property` VALUES ('78', '21', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:33:18', '2015-02-10 21:33:18');
INSERT INTO `sku_property` VALUES ('79', '22', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:33:20', '2015-02-10 21:33:20');
INSERT INTO `sku_property` VALUES ('80', '22', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:33:20', '2015-02-10 21:33:20');
INSERT INTO `sku_property` VALUES ('81', '23', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-10 21:48:39', '2015-03-01 00:22:29');
INSERT INTO `sku_property` VALUES ('82', '23', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-10 21:48:39', '2015-03-01 00:22:29');
INSERT INTO `sku_property` VALUES ('83', '24', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-10 21:48:40', '2015-03-01 00:22:29');
INSERT INTO `sku_property` VALUES ('84', '24', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-10 21:48:40', '2015-03-01 00:22:29');
INSERT INTO `sku_property` VALUES ('85', '26', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 11:57:33', '2015-02-27 11:57:33');
INSERT INTO `sku_property` VALUES ('86', '26', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 11:57:33', '2015-02-27 11:57:33');
INSERT INTO `sku_property` VALUES ('87', '26', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 11:57:33', '2015-02-27 11:57:33');
INSERT INTO `sku_property` VALUES ('88', '27', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 11:58:29', '2015-02-27 11:58:29');
INSERT INTO `sku_property` VALUES ('89', '27', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 11:58:29', '2015-02-27 11:58:29');
INSERT INTO `sku_property` VALUES ('90', '27', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 11:58:29', '2015-02-27 11:58:29');
INSERT INTO `sku_property` VALUES ('91', '28', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 12:01:29', '2015-02-27 12:01:29');
INSERT INTO `sku_property` VALUES ('92', '28', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 12:01:29', '2015-02-27 12:01:29');
INSERT INTO `sku_property` VALUES ('93', '28', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 12:01:29', '2015-02-27 12:01:29');
INSERT INTO `sku_property` VALUES ('94', '29', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 12:03:45', '2015-02-27 12:03:45');
INSERT INTO `sku_property` VALUES ('95', '29', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 12:03:45', '2015-02-27 12:03:45');
INSERT INTO `sku_property` VALUES ('96', '29', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 12:03:45', '2015-02-27 12:03:45');
INSERT INTO `sku_property` VALUES ('97', '30', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 13:45:34', '2015-02-27 13:45:34');
INSERT INTO `sku_property` VALUES ('98', '30', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 13:45:34', '2015-02-27 13:45:34');
INSERT INTO `sku_property` VALUES ('99', '30', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 13:45:35', '2015-02-27 13:45:35');
INSERT INTO `sku_property` VALUES ('100', '999', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 13:46:45', '2015-02-27 22:58:06');
INSERT INTO `sku_property` VALUES ('101', '31', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 13:46:45', '2015-02-27 13:46:45');
INSERT INTO `sku_property` VALUES ('102', '31', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 13:46:46', '2015-02-27 13:46:46');
INSERT INTO `sku_property` VALUES ('103', '32', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 14:01:31', '2015-02-27 14:01:31');
INSERT INTO `sku_property` VALUES ('104', '32', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 14:01:31', '2015-02-27 14:01:31');
INSERT INTO `sku_property` VALUES ('105', '32', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 14:01:31', '2015-02-27 14:01:31');
INSERT INTO `sku_property` VALUES ('106', '33', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 15:17:13', '2015-02-27 15:17:13');
INSERT INTO `sku_property` VALUES ('107', '33', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 15:17:13', '2015-02-27 15:17:13');
INSERT INTO `sku_property` VALUES ('108', '33', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 15:17:13', '2015-02-27 15:17:13');
INSERT INTO `sku_property` VALUES ('109', '34', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 15:20:33', '2015-02-27 15:20:33');
INSERT INTO `sku_property` VALUES ('110', '34', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 15:20:33', '2015-02-27 15:20:33');
INSERT INTO `sku_property` VALUES ('111', '34', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 15:20:33', '2015-02-27 15:20:33');
INSERT INTO `sku_property` VALUES ('112', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 21:24:14', '2015-02-27 21:24:14');
INSERT INTO `sku_property` VALUES ('113', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 21:24:15', '2015-02-27 21:24:15');
INSERT INTO `sku_property` VALUES ('114', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:00:48', '2015-02-27 22:00:48');
INSERT INTO `sku_property` VALUES ('115', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:00:48', '2015-02-27 22:00:48');
INSERT INTO `sku_property` VALUES ('116', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:02:41', '2015-02-27 22:02:41');
INSERT INTO `sku_property` VALUES ('117', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:02:41', '2015-02-27 22:02:41');
INSERT INTO `sku_property` VALUES ('118', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:09:45', '2015-02-27 22:09:45');
INSERT INTO `sku_property` VALUES ('119', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:09:45', '2015-02-27 22:09:45');
INSERT INTO `sku_property` VALUES ('120', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:33:48', '2015-02-27 22:33:48');
INSERT INTO `sku_property` VALUES ('121', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:33:48', '2015-02-27 22:33:48');
INSERT INTO `sku_property` VALUES ('122', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:35:22', '2015-02-27 22:35:22');
INSERT INTO `sku_property` VALUES ('123', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:35:22', '2015-02-27 22:35:22');
INSERT INTO `sku_property` VALUES ('124', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:35:34', '2015-02-27 22:35:34');
INSERT INTO `sku_property` VALUES ('125', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:35:34', '2015-02-27 22:35:34');
INSERT INTO `sku_property` VALUES ('126', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:36:21', '2015-02-27 22:36:21');
INSERT INTO `sku_property` VALUES ('127', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:36:21', '2015-02-27 22:36:21');
INSERT INTO `sku_property` VALUES ('128', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:39:22', '2015-02-27 22:39:22');
INSERT INTO `sku_property` VALUES ('129', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:39:22', '2015-02-27 22:39:22');
INSERT INTO `sku_property` VALUES ('130', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:39:56', '2015-02-27 22:39:56');
INSERT INTO `sku_property` VALUES ('131', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:39:56', '2015-02-27 22:39:56');
INSERT INTO `sku_property` VALUES ('132', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:40:13', '2015-02-27 22:40:13');
INSERT INTO `sku_property` VALUES ('133', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:40:13', '2015-02-27 22:40:13');
INSERT INTO `sku_property` VALUES ('134', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:40:19', '2015-02-27 22:40:19');
INSERT INTO `sku_property` VALUES ('135', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:40:19', '2015-02-27 22:40:19');
INSERT INTO `sku_property` VALUES ('136', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:40:24', '2015-02-27 22:40:24');
INSERT INTO `sku_property` VALUES ('137', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:40:24', '2015-02-27 22:40:24');
INSERT INTO `sku_property` VALUES ('138', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:40:40', '2015-02-27 22:40:40');
INSERT INTO `sku_property` VALUES ('139', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:40:40', '2015-02-27 22:40:40');
INSERT INTO `sku_property` VALUES ('140', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:41:30', '2015-02-27 22:41:30');
INSERT INTO `sku_property` VALUES ('141', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:41:30', '2015-02-27 22:41:30');
INSERT INTO `sku_property` VALUES ('142', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:41:41', '2015-02-27 22:41:41');
INSERT INTO `sku_property` VALUES ('143', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:41:41', '2015-02-27 22:41:41');
INSERT INTO `sku_property` VALUES ('144', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:42:42', '2015-02-27 22:42:42');
INSERT INTO `sku_property` VALUES ('145', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:42:42', '2015-02-27 22:42:42');
INSERT INTO `sku_property` VALUES ('146', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:44:44', '2015-02-27 22:44:44');
INSERT INTO `sku_property` VALUES ('147', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:44:44', '2015-02-27 22:44:44');
INSERT INTO `sku_property` VALUES ('148', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:45:09', '2015-02-27 22:45:09');
INSERT INTO `sku_property` VALUES ('149', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:45:09', '2015-02-27 22:45:09');
INSERT INTO `sku_property` VALUES ('150', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:45:38', '2015-02-27 22:45:38');
INSERT INTO `sku_property` VALUES ('151', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:45:38', '2015-02-27 22:45:38');
INSERT INTO `sku_property` VALUES ('152', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:46:14', '2015-02-27 22:46:14');
INSERT INTO `sku_property` VALUES ('153', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:46:14', '2015-02-27 22:46:14');
INSERT INTO `sku_property` VALUES ('154', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:46:28', '2015-02-27 22:46:28');
INSERT INTO `sku_property` VALUES ('155', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:46:28', '2015-02-27 22:46:28');
INSERT INTO `sku_property` VALUES ('156', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:47:08', '2015-02-27 22:47:08');
INSERT INTO `sku_property` VALUES ('157', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:47:08', '2015-02-27 22:47:08');
INSERT INTO `sku_property` VALUES ('158', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 22:48:15', '2015-02-27 22:48:15');
INSERT INTO `sku_property` VALUES ('159', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 22:48:16', '2015-02-27 22:48:16');
INSERT INTO `sku_property` VALUES ('160', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-27 23:09:44', '2015-02-27 23:09:44');
INSERT INTO `sku_property` VALUES ('161', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-27 23:09:45', '2015-02-27 23:09:45');
INSERT INTO `sku_property` VALUES ('162', '35', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-27 23:15:28', '2015-02-27 23:15:28');
INSERT INTO `sku_property` VALUES ('163', '35', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-27 23:15:28', '2015-02-27 23:15:28');
INSERT INTO `sku_property` VALUES ('164', '35', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-27 23:15:28', '2015-02-27 23:15:28');
INSERT INTO `sku_property` VALUES ('165', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:05:22', '2015-02-28 11:05:22');
INSERT INTO `sku_property` VALUES ('166', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:05:22', '2015-02-28 11:05:22');
INSERT INTO `sku_property` VALUES ('167', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:06:13', '2015-02-28 11:06:13');
INSERT INTO `sku_property` VALUES ('168', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:06:13', '2015-02-28 11:06:13');
INSERT INTO `sku_property` VALUES ('169', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:08:20', '2015-02-28 11:08:20');
INSERT INTO `sku_property` VALUES ('170', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:08:20', '2015-02-28 11:08:20');
INSERT INTO `sku_property` VALUES ('171', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:08:49', '2015-02-28 11:08:49');
INSERT INTO `sku_property` VALUES ('172', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:08:49', '2015-02-28 11:08:49');
INSERT INTO `sku_property` VALUES ('173', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:09:12', '2015-02-28 11:09:12');
INSERT INTO `sku_property` VALUES ('174', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:09:12', '2015-02-28 11:09:12');
INSERT INTO `sku_property` VALUES ('175', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:09:25', '2015-02-28 11:09:25');
INSERT INTO `sku_property` VALUES ('176', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:09:25', '2015-02-28 11:09:25');
INSERT INTO `sku_property` VALUES ('177', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:10:31', '2015-02-28 11:10:31');
INSERT INTO `sku_property` VALUES ('178', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:10:31', '2015-02-28 11:10:31');
INSERT INTO `sku_property` VALUES ('179', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:11:02', '2015-02-28 11:11:02');
INSERT INTO `sku_property` VALUES ('180', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:11:02', '2015-02-28 11:11:02');
INSERT INTO `sku_property` VALUES ('181', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:11:24', '2015-02-28 11:11:24');
INSERT INTO `sku_property` VALUES ('182', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:11:24', '2015-02-28 11:11:24');
INSERT INTO `sku_property` VALUES ('183', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:14:57', '2015-02-28 11:14:57');
INSERT INTO `sku_property` VALUES ('184', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:14:57', '2015-02-28 11:14:57');
INSERT INTO `sku_property` VALUES ('185', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:15:38', '2015-02-28 11:15:38');
INSERT INTO `sku_property` VALUES ('186', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:15:38', '2015-02-28 11:15:38');
INSERT INTO `sku_property` VALUES ('187', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:16:45', '2015-02-28 11:16:45');
INSERT INTO `sku_property` VALUES ('188', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:16:45', '2015-02-28 11:16:45');
INSERT INTO `sku_property` VALUES ('189', '3', '1', '颜色', '蓝蓝色3', '1', '4', null, null, '0', '2015-02-28 11:17:35', '2015-02-28 11:17:35');
INSERT INTO `sku_property` VALUES ('190', '3', '1', '颜色', '红红色3', '1', '5', null, null, '0', '2015-02-28 11:17:35', '2015-02-28 11:17:35');
INSERT INTO `sku_property` VALUES ('191', '36', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 11:29:16', '2015-02-28 11:29:16');
INSERT INTO `sku_property` VALUES ('192', '36', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 11:29:16', '2015-02-28 11:29:16');
INSERT INTO `sku_property` VALUES ('193', '36', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 11:29:16', '2015-02-28 11:29:16');
INSERT INTO `sku_property` VALUES ('194', '37', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 11:30:54', '2015-02-28 11:30:54');
INSERT INTO `sku_property` VALUES ('195', '37', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 11:30:54', '2015-02-28 11:30:54');
INSERT INTO `sku_property` VALUES ('196', '37', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 11:30:54', '2015-02-28 11:30:54');
INSERT INTO `sku_property` VALUES ('197', '38', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 11:32:54', '2015-02-28 11:32:54');
INSERT INTO `sku_property` VALUES ('198', '38', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 11:32:55', '2015-02-28 11:32:55');
INSERT INTO `sku_property` VALUES ('199', '38', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 11:32:55', '2015-02-28 11:32:55');
INSERT INTO `sku_property` VALUES ('200', '39', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 11:33:23', '2015-02-28 11:33:23');
INSERT INTO `sku_property` VALUES ('201', '39', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 11:33:23', '2015-02-28 11:33:23');
INSERT INTO `sku_property` VALUES ('202', '39', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 11:33:23', '2015-02-28 11:33:23');
INSERT INTO `sku_property` VALUES ('203', '40', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 11:37:30', '2015-02-28 11:37:30');
INSERT INTO `sku_property` VALUES ('204', '40', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 11:37:31', '2015-02-28 11:37:31');
INSERT INTO `sku_property` VALUES ('205', '40', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 11:37:31', '2015-02-28 11:37:31');
INSERT INTO `sku_property` VALUES ('206', '41', '1', '重量', '99kg', '1', '2', null, null, '0', '2015-02-28 16:51:36', '2015-02-28 16:51:36');
INSERT INTO `sku_property` VALUES ('207', '41', '1', '尺寸', 'XXL', '1', '3', null, null, '0', '2015-02-28 16:51:36', '2015-02-28 16:51:36');
INSERT INTO `sku_property` VALUES ('208', '41', '1', '颜色', '水蓝色', '1', '1', null, null, '0', '2015-02-28 16:51:36', '2015-02-28 16:51:36');
INSERT INTO `sku_property` VALUES ('209', '43', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:00:18', '2015-02-28 23:00:18');
INSERT INTO `sku_property` VALUES ('210', '43', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19');
INSERT INTO `sku_property` VALUES ('211', '44', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19');
INSERT INTO `sku_property` VALUES ('212', '44', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:00:19', '2015-02-28 23:00:19');
INSERT INTO `sku_property` VALUES ('213', '45', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48');
INSERT INTO `sku_property` VALUES ('214', '45', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48');
INSERT INTO `sku_property` VALUES ('215', '46', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48');
INSERT INTO `sku_property` VALUES ('216', '46', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:01:48', '2015-02-28 23:01:48');
INSERT INTO `sku_property` VALUES ('217', '47', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:07:35', '2015-02-28 23:07:35');
INSERT INTO `sku_property` VALUES ('218', '47', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:07:35', '2015-02-28 23:07:35');
INSERT INTO `sku_property` VALUES ('219', '48', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:07:35', '2015-02-28 23:07:35');
INSERT INTO `sku_property` VALUES ('220', '48', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:07:36', '2015-02-28 23:07:36');
INSERT INTO `sku_property` VALUES ('221', '49', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15');
INSERT INTO `sku_property` VALUES ('222', '49', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15');
INSERT INTO `sku_property` VALUES ('223', '50', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15');
INSERT INTO `sku_property` VALUES ('224', '50', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:08:15', '2015-02-28 23:08:15');
INSERT INTO `sku_property` VALUES ('225', '51', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05');
INSERT INTO `sku_property` VALUES ('226', '51', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05');
INSERT INTO `sku_property` VALUES ('227', '52', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05');
INSERT INTO `sku_property` VALUES ('228', '52', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:10:05', '2015-02-28 23:10:05');
INSERT INTO `sku_property` VALUES ('229', '53', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05');
INSERT INTO `sku_property` VALUES ('230', '53', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05');
INSERT INTO `sku_property` VALUES ('231', '54', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05');
INSERT INTO `sku_property` VALUES ('232', '54', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:18:05', '2015-02-28 23:18:05');
INSERT INTO `sku_property` VALUES ('233', '55', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:19:18', '2015-02-28 23:19:18');
INSERT INTO `sku_property` VALUES ('234', '55', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:19:18', '2015-02-28 23:19:18');
INSERT INTO `sku_property` VALUES ('235', '56', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:19:18', '2015-02-28 23:19:18');
INSERT INTO `sku_property` VALUES ('236', '56', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:19:19', '2015-02-28 23:19:19');
INSERT INTO `sku_property` VALUES ('237', '57', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35');
INSERT INTO `sku_property` VALUES ('238', '57', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35');
INSERT INTO `sku_property` VALUES ('239', '58', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35');
INSERT INTO `sku_property` VALUES ('240', '58', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-02-28 23:20:35', '2015-02-28 23:20:35');
INSERT INTO `sku_property` VALUES ('241', '59', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-03-01 00:21:33', '2015-03-01 00:21:33');
INSERT INTO `sku_property` VALUES ('242', '59', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-03-01 00:21:33', '2015-03-01 00:21:33');
INSERT INTO `sku_property` VALUES ('243', '60', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-03-01 00:21:34', '2015-03-01 00:21:34');
INSERT INTO `sku_property` VALUES ('244', '60', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-03-01 00:21:34', '2015-03-01 00:21:34');
INSERT INTO `sku_property` VALUES ('245', '61', '1', '尺寸', '16码', '1', '1', null, null, '0', '2015-03-01 00:22:25', '2015-03-01 00:22:25');
INSERT INTO `sku_property` VALUES ('246', '61', '1', '颜色', '红色', '1', '2', null, null, '0', '2015-03-01 00:22:25', '2015-03-01 00:22:25');
INSERT INTO `sku_property` VALUES ('247', '62', '1', '颜色', '蓝色', '1', '1', null, null, '0', '2015-03-01 00:22:26', '2015-03-01 00:22:26');
INSERT INTO `sku_property` VALUES ('248', '62', '1', '尺寸', '17码', '1', '2', null, null, '0', '2015-03-01 00:22:26', '2015-03-01 00:22:26');

-- ----------------------------
-- Table structure for sku_property_tmpl
-- ----------------------------
DROP TABLE IF EXISTS `sku_property_tmpl`;
CREATE TABLE `sku_property_tmpl` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `owner_type` int(2) NOT NULL DEFAULT '1' COMMENT '模板属主类型：1代表系统模板，2代表用户模板',
  `owner_id` bigint(10) NOT NULL DEFAULT '0' COMMENT 'owner_type=1，则owner_id为0，如果owner_type=2，则owner_id为用户ID',
  `key_name` varchar(100) NOT NULL COMMENT '属性名',
  `val` varchar(100) NOT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `inherit_type` int(2) DEFAULT NULL COMMENT '继承类型：0不可继承，1可继承。继承的意思是下级类目是否可以继承父级类目的属性',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `category_id` int(10) NOT NULL COMMENT '所属类目ID',
  `is_deleted` int(2) NOT NULL COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='sku属性模板表';

-- ----------------------------
-- Records of sku_property_tmpl
-- ----------------------------
INSERT INTO `sku_property_tmpl` VALUES ('1', '0', '1', '颜色', '绿色', '1', null, null, null, null, '1', '0', '2015-02-04 13:59:36', '2015-01-22 10:49:11');
INSERT INTO `sku_property_tmpl` VALUES ('2', '0', '1', '颜色', '蓝色', '1', null, null, null, null, '1', '0', '2015-02-04 14:11:10', '2015-02-28 11:04:08');
INSERT INTO `sku_property_tmpl` VALUES ('3', '0', '1', '尺寸', 'XXX', '1', null, null, null, null, '4', '0', '2015-02-04 14:47:59', '2015-02-28 11:04:09');
INSERT INTO `sku_property_tmpl` VALUES ('4', '0', '1', '颜色', '白色', '1', null, null, null, null, '1', '0', '2015-02-04 13:58:59', '2015-01-21 15:12:07');
INSERT INTO `sku_property_tmpl` VALUES ('5', '0', '1', '颜色', '黑色', '1', null, null, null, null, '1', '0', '2015-02-04 13:59:00', '2015-01-21 15:12:12');
INSERT INTO `sku_property_tmpl` VALUES ('6', '0', '1', '颜色', '红天一色', '1', '0', null, null, null, '3', '0', '2015-02-04 13:59:00', '2015-01-29 16:24:32');
INSERT INTO `sku_property_tmpl` VALUES ('7', '0', '1', '颜色', '蓝白色', '1', '0', null, null, null, '3', '0', '2015-02-04 13:59:00', '2015-02-02 20:10:46');
INSERT INTO `sku_property_tmpl` VALUES ('8', '0', '1', '大衣尺寸', 'XL', '1', '0', null, null, null, '5', '0', '2015-02-04 13:59:00', '2015-02-04 13:57:36');
INSERT INTO `sku_property_tmpl` VALUES ('9', '0', '1', '大衣尺寸', 'XXL', '1', '0', null, null, null, '5', '0', '2015-02-04 13:59:01', '2015-02-04 13:57:55');
INSERT INTO `sku_property_tmpl` VALUES ('10', '0', '1', '大衣尺寸', 'S', '1', '0', null, null, null, '5', '0', '2015-02-04 13:59:01', '2015-02-04 13:58:00');
INSERT INTO `sku_property_tmpl` VALUES ('11', '0', '1', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-04 13:59:03', '2015-02-04 13:58:04');
INSERT INTO `sku_property_tmpl` VALUES ('12', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 16:54:26', '2015-02-27 16:54:26');
INSERT INTO `sku_property_tmpl` VALUES ('13', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 16:55:39', '2015-02-27 16:55:39');
INSERT INTO `sku_property_tmpl` VALUES ('14', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 16:57:13', '2015-02-27 16:57:13');
INSERT INTO `sku_property_tmpl` VALUES ('15', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 16:58:18', '2015-02-27 16:58:18');
INSERT INTO `sku_property_tmpl` VALUES ('16', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 16:59:10', '2015-02-27 16:59:10');
INSERT INTO `sku_property_tmpl` VALUES ('17', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:00:37', '2015-02-27 17:00:37');
INSERT INTO `sku_property_tmpl` VALUES ('18', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:01:32', '2015-02-27 17:01:32');
INSERT INTO `sku_property_tmpl` VALUES ('19', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:01:50', '2015-02-27 17:01:50');
INSERT INTO `sku_property_tmpl` VALUES ('20', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:02:07', '2015-02-27 17:02:07');
INSERT INTO `sku_property_tmpl` VALUES ('21', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:05:08', '2015-02-27 17:05:08');
INSERT INTO `sku_property_tmpl` VALUES ('22', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:06:47', '2015-02-27 17:06:47');
INSERT INTO `sku_property_tmpl` VALUES ('23', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 17:08:47', '2015-02-27 17:08:47');
INSERT INTO `sku_property_tmpl` VALUES ('24', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 20:11:01', '2015-02-27 20:11:01');
INSERT INTO `sku_property_tmpl` VALUES ('25', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 20:28:23', '2015-02-27 20:28:23');
INSERT INTO `sku_property_tmpl` VALUES ('26', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 20:34:05', '2015-02-27 20:34:05');
INSERT INTO `sku_property_tmpl` VALUES ('27', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 20:58:04', '2015-02-27 20:58:04');
INSERT INTO `sku_property_tmpl` VALUES ('28', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 21:57:13', '2015-02-27 21:57:13');
INSERT INTO `sku_property_tmpl` VALUES ('29', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-27 22:08:04', '2015-02-27 22:08:04');
INSERT INTO `sku_property_tmpl` VALUES ('30', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-28 11:02:15', '2015-02-28 11:02:15');
INSERT INTO `sku_property_tmpl` VALUES ('31', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-28 11:02:43', '2015-02-28 11:02:43');
INSERT INTO `sku_property_tmpl` VALUES ('32', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-28 11:03:16', '2015-02-28 11:03:16');
INSERT INTO `sku_property_tmpl` VALUES ('33', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-28 11:03:35', '2015-02-28 11:03:35');
INSERT INTO `sku_property_tmpl` VALUES ('34', '1', '0', '大衣尺寸', 'M', '1', '0', null, null, null, '5', '0', '2015-02-28 11:04:08', '2015-02-28 11:04:08');

-- ----------------------------
-- Table structure for spu_info
-- ----------------------------
DROP TABLE IF EXISTS `spu_info`;
CREATE TABLE `spu_info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `spu_name` varchar(100) DEFAULT NULL COMMENT 'spu属性名称',
  `create_type` int(2) DEFAULT NULL COMMENT '创建者类型',
  `create_id` bigint(10) DEFAULT NULL COMMENT '创建者用户ID',
  `spu_status` int(2) DEFAULT '0' COMMENT '状态：使用中/已停用',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='商品标准属性信息表';

-- ----------------------------
-- Records of spu_info
-- ----------------------------
INSERT INTO `spu_info` VALUES ('1', '服饰', '1', null, '0', '1', '2015-01-23 11:06:56', '2015-01-23 11:06:56');
INSERT INTO `spu_info` VALUES ('2', '鞋子', '1', null, '0', '0', '2015-01-23 11:08:55', '2015-01-23 11:08:55');
INSERT INTO `spu_info` VALUES ('3', '玩具', '1', null, '0', '0', '2015-01-23 11:03:18', '2015-01-23 11:03:18');
INSERT INTO `spu_info` VALUES ('4', '玩的', '1', null, '0', '0', '2015-01-23 11:03:26', '2015-01-23 11:03:26');
INSERT INTO `spu_info` VALUES ('5', '喝的', '1', null, '0', '0', '2015-01-23 11:03:37', '2015-01-23 11:03:37');

-- ----------------------------
-- Table structure for spu_property
-- ----------------------------
DROP TABLE IF EXISTS `spu_property`;
CREATE TABLE `spu_property` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(10) NOT NULL COMMENT '所属spu记录ID',
  `key_name` varchar(100) DEFAULT NULL COMMENT '属性名',
  `val` varchar(100) DEFAULT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='spu属性表';

-- ----------------------------
-- Records of spu_property
-- ----------------------------
INSERT INTO `spu_property` VALUES ('1', '1', '颜色', '水蓝色', '1', null, null, null, '1', '2015-01-22 11:36:05', '2015-01-22 11:36:05');
INSERT INTO `spu_property` VALUES ('2', '1', '颜色', '天蓝色', '1', null, null, null, '0', '2015-01-22 11:32:10', '2015-01-22 11:32:10');
INSERT INTO `spu_property` VALUES ('3', '1', '颜色', '绿色', '1', null, null, null, '0', '2015-01-22 11:32:21', '2015-01-22 11:32:21');
INSERT INTO `spu_property` VALUES ('4', '1', '颜色', '黄色', '1', null, null, null, '0', '2015-01-22 11:40:08', '2015-01-22 11:40:08');
INSERT INTO `spu_property` VALUES ('5', '1', '颜色', '黑色', '1', null, null, null, '0', '2015-01-22 11:32:31', '2015-01-22 11:32:31');
INSERT INTO `spu_property` VALUES ('6', '1', '颜色', '金色', '1', null, null, null, '0', '2015-01-22 11:32:42', '2015-01-22 11:32:42');

-- ----------------------------
-- Table structure for spu_property_tmpl
-- ----------------------------
DROP TABLE IF EXISTS `spu_property_tmpl`;
CREATE TABLE `spu_property_tmpl` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `owner_type` int(2) DEFAULT NULL COMMENT '模板属主类型：1代表系统模板，2代表用户模板',
  `owner_id` bigint(10) DEFAULT NULL COMMENT 'owner_type=1，则owner_id为0，如果owner_type=2，则owner_id为用户ID',
  `key_name` varchar(100) DEFAULT NULL COMMENT '属性名',
  `val` varchar(100) DEFAULT NULL COMMENT '属性值',
  `val_type` int(10) DEFAULT NULL COMMENT '属性值类型',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，如果该字段值相同，则按照属性key来排序',
  `inherit_type` int(2) DEFAULT NULL COMMENT '继承类型：0不可继承，1可继承。继承的意思是下级类目是否可以继承父级类目的属性',
  `biz_mark` bigint(10) DEFAULT NULL COMMENT '业务标志，例如是否包含图片等等',
  `img_url` varchar(100) DEFAULT NULL COMMENT '属性图',
  `category_id` int(10) DEFAULT NULL COMMENT '所属类目ID',
  `is_deleted` int(2) DEFAULT '0' COMMENT '删除标志',
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 COMMENT='spu属性模板表';

-- ----------------------------
-- Records of spu_property_tmpl
-- ----------------------------
INSERT INTO `spu_property_tmpl` VALUES ('6', '0', null, '颜色', '黑色', '1', null, null, null, null, '1', '1', '2015-01-22 10:51:31', '2015-01-22 10:51:31');
INSERT INTO `spu_property_tmpl` VALUES ('7', '0', null, '颜色', '水蓝色', '1', null, null, null, null, '1', '0', '2015-01-22 10:59:54', '2015-01-22 10:59:54');
INSERT INTO `spu_property_tmpl` VALUES ('8', '0', null, '颜色', '红色', '1', null, null, null, null, '1', '0', '2015-01-22 10:46:35', '2015-01-22 10:46:35');
INSERT INTO `spu_property_tmpl` VALUES ('9', '0', null, '颜色', '黑色', '1', null, null, null, null, '1', '0', '2015-01-22 10:46:44', '2015-01-22 10:46:44');
INSERT INTO `spu_property_tmpl` VALUES ('10', '0', null, '颜色', '天蓝色', '1', null, null, null, null, '1', '0', '2015-01-22 10:52:31', '2015-01-22 10:52:31');
INSERT INTO `spu_property_tmpl` VALUES ('11', '0', null, '颜色', '玫瑰色', '1', null, null, null, null, '1', '0', '2015-01-22 10:52:38', '2015-01-22 10:52:38');

-- ----------------------------
-- Procedure structure for procedure1
-- ----------------------------
DROP PROCEDURE IF EXISTS `procedure1`;
DELIMITER ;;
CREATE DEFINER=`zvecn`@`%` PROCEDURE `procedure1`()
BEGIN
begin  
declare i decimal (10)  default 0 ;
dd:
loop        
INSERT INTO atest (property_name) VALUE('a');
     set i = i+1;
   IF  MOD(i,20000)=0   THEN  COMMIT; end IF;
   if i= 1000000 then LEAVE dd;
    end if;
   end loop ;
end;
END
;;
DELIMITER ;
