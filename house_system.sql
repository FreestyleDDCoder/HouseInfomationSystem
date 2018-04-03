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

 Date: 03/04/2018 19:26:03
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
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
