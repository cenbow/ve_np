/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.20-log : Database - ve_java_market
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ve_java_market` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ve_java_market`;

/*Table structure for table `activity_coupon` */

DROP TABLE IF EXISTS `activity_coupon`;

CREATE TABLE `activity_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `activity_id` bigint(20) NOT NULL COMMENT '关联的营销活动ID',
  `supplied_user_id` bigint(20) NOT NULL COMMENT '活动提供者ID',
  `coupon_code` varchar(20) DEFAULT NULL COMMENT '优惠券代码',
  `scope` tinyint(1) NOT NULL COMMENT '使用范围(1.线上，2.先下)',
  `total_count` bigint(20) NOT NULL COMMENT '总数量',
  `granted_count` bigint(20) NOT NULL COMMENT '已发放数量',
  `status` tinyint(1) NOT NULL COMMENT '0.未推送1.已推送',
  `deleted` tinyint(1) NOT NULL COMMENT '0正常/1已删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1258554 DEFAULT CHARSET=utf8 COMMENT='营销活动优惠券表';

/*Table structure for table `activity_granted_coupon` */

DROP TABLE IF EXISTS `activity_granted_coupon`;

CREATE TABLE `activity_granted_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券id',
  `activity_id` bigint(20) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `grantor_user_id` bigint(20) NOT NULL COMMENT '营销活动券授予者ID',
  `receiver_user_id` bigint(20) NOT NULL COMMENT '营销活动券接受者ID',
  `status` tinyint(4) NOT NULL COMMENT '营销活动券状态：未使用0/冻结中1/已使用2',
  `deleted` tinyint(1) NOT NULL COMMENT '0正常/1已删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='已被发放的营销活动券';

/*Table structure for table `activity_received_coupon` */

DROP TABLE IF EXISTS `activity_received_coupon`;

CREATE TABLE `activity_received_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券id',
  `activity_id` bigint(20) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `receiver_user_id` bigint(20) NOT NULL COMMENT '营销活动券接受者ID',
  `grantor_user_id` bigint(20) NOT NULL COMMENT '营销活动券授予者ID',
  `status` tinyint(4) NOT NULL COMMENT '营销活动券状态：未使用0/冻结中1/已使用',
  `deleted` tinyint(1) NOT NULL COMMENT '0正常/1已删除',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='已被领用的营销活动券';

/*Table structure for table `market_activity` */

DROP TABLE IF EXISTS `market_activity`;

CREATE TABLE `market_activity` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `act_code` varchar(32) DEFAULT NULL COMMENT '活动编码 tool_code+id',
  `act_name` varchar(32) NOT NULL COMMENT '活动名称',
  `start_time` datetime NOT NULL COMMENT '活动开始时间',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  `coupon_flag` tinyint(2) NOT NULL COMMENT '是否用券0是1否',
  `coupon_type` tinyint(2) DEFAULT NULL COMMENT '券类型0有码券，1无码券',
  `repellent_flag` tinyint(2) NOT NULL COMMENT '是否排他0是1否',
  `tool_id` bigint(15) NOT NULL COMMENT '营销工具id',
  `creator_type` tinyint(2) NOT NULL COMMENT '活动创建者类型：1卖家2运营',
  `creator_user_id` bigint(15) NOT NULL COMMENT '活动创建者ID',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0.初始状态1.审核中2.审核通过3.审核未通过4.失效',
  `delete_flag` tinyint(2) NOT NULL DEFAULT '1' COMMENT '0是1否',
  `platform` int(9) NOT NULL DEFAULT '3' COMMENT '平台环境 pc:001 移动:010 默认 001|010即3',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='营销活动表';

/*Table structure for table `market_audit_track` */

DROP TABLE IF EXISTS `market_audit_track`;

CREATE TABLE `market_audit_track` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `recorded_id` bigint(15) NOT NULL COMMENT '被记录者的id',
  `recorded_type` tinyint(2) NOT NULL COMMENT '被记录类型1.工具2.活动',
  `audit_type` tinyint(2) NOT NULL COMMENT '审核类型1.申请，2审核',
  `operator_id` bigint(15) NOT NULL COMMENT '操作者id',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='申请审核记录表';

/*Table structure for table `market_module` */

DROP TABLE IF EXISTS `market_module`;

CREATE TABLE `market_module` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `module_code` varchar(32) NOT NULL COMMENT '组件编码',
  `module_type` tinyint(2) NOT NULL COMMENT '组件类型1资源组件2条件组件3动作组件',
  `module_name` varchar(32) NOT NULL COMMENT '组件名称',
  `impl_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '实现类型1.javabean2.xml3.json4.param',
  `impl_content` varchar(512) NOT NULL COMMENT '实现内容',
  `prov_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '组件提供者类型1内部(默认)2外部',
  `prov_appcode` varchar(32) NOT NULL COMMENT '组件提供方的appcode',
  `prov_user_id` bigint(15) NOT NULL COMMENT '组件提供者的user_id',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='营销组件表';

/*Table structure for table `market_param_instance` */

DROP TABLE IF EXISTS `market_param_instance`;

CREATE TABLE `market_param_instance` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `owner_type` tinyint(2) NOT NULL COMMENT '参数属主类型1.工具参数2.活动参数',
  `owner_id` bigint(15) NOT NULL COMMENT '参数属主id',
  `param_name` varchar(32) NOT NULL COMMENT '参数名称',
  `param_value` varchar(32) NOT NULL COMMENT '参数值',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='营销实参表';

/*Table structure for table `market_param_template` */

DROP TABLE IF EXISTS `market_param_template`;

CREATE TABLE `market_param_template` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `owner_type` tinyint(2) NOT NULL COMMENT '参数属主类型1.工具参数2.活动参数',
  `owner_id` bigint(15) NOT NULL COMMENT '参数属主id',
  `param_name` varchar(32) NOT NULL COMMENT '参数名称',
  `disp_name` varchar(32) NOT NULL COMMENT '页面显示名称',
  `value_type` tinyint(2) NOT NULL COMMENT '值类型1.数值型2字符串型',
  `description` varchar(128) DEFAULT NULL COMMENT '参数简介',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='营销形参表';

/*Table structure for table `market_scope` */

DROP TABLE IF EXISTS `market_scope`;

CREATE TABLE `market_scope` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `act_id` bigint(15) NOT NULL COMMENT '活动id',
  `clude_type` tinyint(2) NOT NULL COMMENT '0.包含 1.不包含',
  `market_type` tinyint(2) NOT NULL COMMENT '0.全场 1.专场 2.单品',
  `clude_id` bigint(15) DEFAULT NULL COMMENT '包含或者不包含的专场id或者商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='营销活动范围';

/*Table structure for table `market_tool` */

DROP TABLE IF EXISTS `market_tool`;

CREATE TABLE `market_tool` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `tool_code` varchar(32) NOT NULL COMMENT '工具编码',
  `tool_name` varchar(32) NOT NULL COMMENT '工具名称',
  `impl_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '实现类型1.javabean2.xml3.json4.param',
  `impl_content` varchar(512) NOT NULL COMMENT '实现内容',
  `prov_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '工具提供者类型1内部(默认)2外部',
  `prov_appcode` varchar(32) NOT NULL COMMENT '工具提供方的appcode',
  `prov_user_id` bigint(15) NOT NULL COMMENT '工具提供者的user_id',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '工具状态0.初始状态1.审核中2.审核通过3.审核未通过',
  `delete_flag` tinyint(2) NOT NULL COMMENT '是否删除0是1否',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='营销工具表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
