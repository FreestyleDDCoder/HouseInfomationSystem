/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : house_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 03/04/2018 19:37:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_login
-- ----------------------------
DROP TABLE IF EXISTS `admin_login`;
CREATE TABLE `admin_login`  (
  `admin_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_permission` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_id`(`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_login
-- ----------------------------
INSERT INTO `admin_login` VALUES ('001', '001', '1');
INSERT INTO `admin_login` VALUES ('002', '002', '2');
INSERT INTO `admin_login` VALUES ('003', '003', '3');
INSERT INTO `admin_login` VALUES ('004', '004', '4');

-- ----------------------------
-- Table structure for house_ remark
-- ----------------------------
DROP TABLE IF EXISTS `house_ remark`;
CREATE TABLE `house_ remark`  (
  `house_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_remark_time` datetime(0) NOT NULL,
  INDEX `house_id`(`house_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `house_ remark_ibfk_1` FOREIGN KEY (`house_id`) REFERENCES `house_information` (`house_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `house_ remark_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house_area
-- ----------------------------
DROP TABLE IF EXISTS `house_area`;
CREATE TABLE `house_area`  (
  `area_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `district` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`area_id`) USING BTREE,
  UNIQUE INDEX `area_id`(`area_id`, `district`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_area
-- ----------------------------
INSERT INTO `house_area` VALUES ('0001', '广东省', '深圳市', '南山区');
INSERT INTO `house_area` VALUES ('0002', '海南省', '海口市', '美兰区');
INSERT INTO `house_area` VALUES ('0003', '广东省', '广州市', '不知道区');
INSERT INTO `house_area` VALUES ('0004', '海南省', '澄迈县', '永发镇');

-- ----------------------------
-- Table structure for house_icon_url
-- ----------------------------
DROP TABLE IF EXISTS `house_icon_url`;
CREATE TABLE `house_icon_url`  (
  `house_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_icon_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  INDEX `house_id`(`house_id`) USING BTREE,
  CONSTRAINT `house_icon_url_ibfk_1` FOREIGN KEY (`house_id`) REFERENCES `house_information` (`house_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house_information
-- ----------------------------
DROP TABLE IF EXISTS `house_information`;
CREATE TABLE `house_information`  (
  `house_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_kinds` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_in_time` datetime(0) NOT NULL,
  PRIMARY KEY (`house_id`) USING BTREE,
  UNIQUE INDEX `house_id`(`house_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house_kinds
-- ----------------------------
DROP TABLE IF EXISTS `house_kinds`;
CREATE TABLE `house_kinds`  (
  `kinds_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `house_kinds` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`kinds_id`) USING BTREE,
  UNIQUE INDEX `kinds_id`(`kinds_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_kinds
-- ----------------------------
INSERT INTO `house_kinds` VALUES ('0001', '别墅');
INSERT INTO `house_kinds` VALUES ('0002', '商铺');
INSERT INTO `house_kinds` VALUES ('0003', '写字楼');
INSERT INTO `house_kinds` VALUES ('0004', '住宅');
INSERT INTO `house_kinds` VALUES ('0005', '公寓');
INSERT INTO `house_kinds` VALUES ('0007', '测试7');
INSERT INTO `house_kinds` VALUES ('0008', '新的测试0008');
INSERT INTO `house_kinds` VALUES ('0009', '测试0009');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `rank1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rank2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rankUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `adminPermission` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `menuid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('用户管理', '删除', 'includePage/UserManageDelete.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房地区管理', '增加', 'includePage/HouseAreaAdd.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房类型管理', '增加', 'includePage/HouseKindsAdd.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房价格管理', '价格管理', NULL, '1', '');
INSERT INTO `menu` VALUES ('楼房信息管理', '添加', '', '1', '');
INSERT INTO `menu` VALUES ('楼房信息管理', '删除', NULL, '1', '');
INSERT INTO `menu` VALUES ('楼房信息管理', '修改', NULL, '1', '');
INSERT INTO `menu` VALUES ('楼房信息管理', '查询', '', '1', '');
INSERT INTO `menu` VALUES ('用户管理', '查询', 'includePage/UserManageQuery.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房地区管理', '查询', 'servlet/HouseAreaQueryServlet', '1', '');
INSERT INTO `menu` VALUES ('楼房地区管理', '修改', 'includePage/HouseAreaUpdate.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房地区管理', '删除', 'includePage/HouseAreaDelete.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房类型管理', '查询', 'servlet/HouseKindsQueryServlet', '1', '');
INSERT INTO `menu` VALUES ('楼房类型管理', '修改', 'includePage/HouseKindsUpdate.jsp', '1', '');
INSERT INTO `menu` VALUES ('楼房类型管理', '删除', 'includePage/HouseKindsDelete.jsp', '1', '');
INSERT INTO `menu` VALUES ('站内消息', '推送消息', 'includePage/PushStationInformation.jsp', '1', '1001');
INSERT INTO `menu` VALUES ('站内消息', '历史消息', 'servlet/GetStationInformationServlet', '1', '1001');

-- ----------------------------
-- Table structure for station_information
-- ----------------------------
DROP TABLE IF EXISTS `station_information`;
CREATE TABLE `station_information`  (
  `admin_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `information_content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `push_time` datetime(0) NOT NULL,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `station_information_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin_login` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of station_information
-- ----------------------------
INSERT INTO `station_information` VALUES ('001', '你好呀', '2018-02-08 16:10:04');
INSERT INTO `station_information` VALUES ('001', '现在时间21:06', '2018-03-20 21:06:15');
INSERT INTO `station_information` VALUES ('001', '这是测试消息！', '2018-03-20 18:46:32');
INSERT INTO `station_information` VALUES ('001', '123213213', '2018-03-28 21:11:39');
INSERT INTO `station_information` VALUES ('001', '今天真的很开心哦。。。。。。。。所有的想法都得以实现了，还是蛮开心的。', '2018-03-29 23:25:58');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:23');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:28');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:32');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:35');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:39');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:43');
INSERT INTO `station_information` VALUES ('001', '测试消息！！！', '2018-03-29 23:26:46');
INSERT INTO `station_information` VALUES ('001', '问渠那得清如许，留取丹心照汗青！！！', '2018-04-01 21:14:48');
INSERT INTO `station_information` VALUES ('001', '今天楼盘价格优惠，最低只要2000一平米哦！！！。。。。愚人节快乐哈哈哈', '2018-04-01 21:15:49');
INSERT INTO `station_information` VALUES ('001', '这是4月3号的测试', '2018-04-03 18:51:10');

-- ----------------------------
-- Table structure for user_friends
-- ----------------------------
DROP TABLE IF EXISTS `user_friends`;
CREATE TABLE `user_friends`  (
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friend_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `add_time` datetime(0) DEFAULT NULL,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `friend_id`(`friend_id`) USING BTREE,
  CONSTRAINT `user_friends_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_friends_ibfk_2` FOREIGN KEY (`friend_id`) REFERENCES `user_login` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information`  (
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_mail` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `user_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户性别',
  `user_motto` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `user_icon_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像url',
  `user_vip` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员身份',
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('0001', '347558464@qq.com', 'm', '山有木兮木有枝，心悦君兮君不知！', NULL, 'n');
INSERT INTO `user_information` VALUES ('去快乐老家', 'liangzhanncu@163.com', 'm', '人生自古谁无死，留取丹心照汗青！', NULL, 'n');
INSERT INTO `user_information` VALUES ('美丽姑娘', '1337289015@qq.com', 'w', '美银只配强者拥有', NULL, 'y');

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('0001', '0001');
INSERT INTO `user_login` VALUES ('去快乐老家', '0002');
INSERT INTO `user_login` VALUES ('美丽姑娘', '0003');

SET FOREIGN_KEY_CHECKS = 1;
