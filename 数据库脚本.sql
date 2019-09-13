/*
Navicat MySQL Data Transfer

Source Server         : local_test
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : test_db

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-02-15 01:00:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `BOOK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`BOOK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '书1');
INSERT INTO `books` VALUES ('2', '书2');

-- ----------------------------
-- Table structure for borrows
-- ----------------------------
DROP TABLE IF EXISTS `borrows`;
CREATE TABLE `borrows` (
  `BORROW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `BOOK_ID` int(11) NOT NULL,
  `RETURN_TIME` datetime DEFAULT NULL,
  `EXPIRE_TIME` datetime DEFAULT NULL,
  `STATE` int(1) NOT NULL DEFAULT '0',
  `lend_time` datetime NOT NULL,
  PRIMARY KEY (`BORROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrows
-- ----------------------------
INSERT INTO `borrows` VALUES ('8', '1', '2', null, null, '0', '2019-02-15 00:40:32');
INSERT INTO `borrows` VALUES ('9', '1', '1', null, null, '0', '2019-02-15 00:40:54');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_ID` int(11) NOT NULL,
  `COMMENT` varchar(2000) NOT NULL DEFAULT '' COMMENT '评论内容',
  `USER_ID` int(11) NOT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('5', '1', '123', '1', '2019-02-14 23:21:31', null);
INSERT INTO `comments` VALUES ('6', '1', '123', '1', '2019-02-14 23:41:15', null);

-- ----------------------------
-- Table structure for favorite_books
-- ----------------------------
DROP TABLE IF EXISTS `favorite_books`;
CREATE TABLE `favorite_books` (
  `FAVORITE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`FAVORITE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite_books
-- ----------------------------

-- ----------------------------
-- Table structure for favorite_comments
-- ----------------------------
DROP TABLE IF EXISTS `favorite_comments`;
CREATE TABLE `favorite_comments` (
  `FAVORITE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`FAVORITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite_comments
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL DEFAULT '',
  `PASSWORD` varchar(100) NOT NULL,
  `SCHOOL` varchar(100) DEFAULT NULL,
  `IMAGE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', 'beidu', 'http://image.baidu.com');
INSERT INTO `users` VALUES ('2', 'admin1', 'admin1', 'beidu', 'http://image.baidu.com');
