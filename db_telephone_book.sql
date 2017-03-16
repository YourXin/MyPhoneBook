/*
Navicat MySQL Data Transfer

Source Server         : BigBoss
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : db_telephone_book

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-11-03 23:12:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tel_info
-- ----------------------------
DROP TABLE IF EXISTS `tel_info`;
CREATE TABLE `tel_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(18) DEFAULT NULL,
  `tel_num` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tel_info
-- ----------------------------
INSERT INTO `tel_info` VALUES ('1', '刘鑫', '151614-156151,555');
INSERT INTO `tel_info` VALUES ('7', '线稿', '414214');
