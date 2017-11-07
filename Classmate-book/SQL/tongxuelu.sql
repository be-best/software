/*
Navicat MySQL Data Transfer

Source Server         : zws
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : tongxuelu

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-07 20:05:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classmate
-- ----------------------------
DROP TABLE IF EXISTS `classmate`;
CREATE TABLE `classmate` (
  `姓名` varchar(20) DEFAULT NULL,
  `家庭地址` varchar(30) DEFAULT NULL,
  `电话号码` varchar(20) NOT NULL,
  `微信` varchar(30) DEFAULT NULL,
  `邮箱` varchar(40) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `个性语言` varchar(50) DEFAULT '',
  PRIMARY KEY (`电话号码`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classmate
-- ----------------------------
INSERT INTO `classmate` VALUES ('李大四', '鸿杰假2', '12345', 'buycboi', '45674386831@qq,com', '374523872', '我也无敌了啊');
INSERT INTO `classmate` VALUES ('赵大六', '天津', '13438574389', 'dwyugu', '3746672@qq.com', '7342637', '无敌是多么寂寞');
INSERT INTO `classmate` VALUES ('张大三', '北京', '15263847263', 'zgdheyshi', '637384915@qq.com', '463857365', '无敌是多么寂寞');
INSERT INTO `classmate` VALUES ('刘大七', '重庆', '15923475823', 'dushsdub', '3462387326@qq.com', '274624323', '多么寂寞');
INSERT INTO `classmate` VALUES ('zws', '4234231', '32423', '342423', '123412', '123412', '213412');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', '12345');
INSERT INTO `user` VALUES ('213455', '12345');
DROP TRIGGER IF EXISTS `更改`;
DELIMITER ;;
CREATE TRIGGER `更改` BEFORE UPDATE ON `classmate` FOR EACH ROW BEGIN
	if old.电话号码 is null then SIGNAL SQLSTATE 'HY000' SET MESSAGE_TEXT = '手动抛出异常' ;
end if;
END
;;
DELIMITER ;
