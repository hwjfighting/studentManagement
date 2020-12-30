/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : db_student

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-12-30 10:54:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_admin`
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES ('1', 'admin', '1', '2018-03-17 14:24:09');

-- ----------------------------
-- Table structure for `s_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `s_attendance`;
CREATE TABLE `s_attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `attendance_date` varchar(12) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_attendance_foreign` (`student_id`),
  KEY `course_attendance_foreign` (`course_id`),
  CONSTRAINT `course_attendance_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_attendance_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_attendance
-- ----------------------------
INSERT INTO `s_attendance` VALUES ('1', '1', '1', '2018-05-17');
INSERT INTO `s_attendance` VALUES ('2', '1', '1', '2018-04-17');
INSERT INTO `s_attendance` VALUES ('3', '1', '4', '2018-04-17');
INSERT INTO `s_attendance` VALUES ('4', '1', '3', '2018-04-17');
INSERT INTO `s_attendance` VALUES ('5', '1', '1', '2018-04-18');
INSERT INTO `s_attendance` VALUES ('7', '1', '3', '2018-04-18');
INSERT INTO `s_attendance` VALUES ('8', '4', '1', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('12', '3', '1', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('15', '3', '4', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('16', '1', '1', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('17', '1', '4', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('18', '1', '3', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('19', '1', '2', '2018-04-19');
INSERT INTO `s_attendance` VALUES ('29', '7', '1', '2019-10-08');
INSERT INTO `s_attendance` VALUES ('39', '6', '2', '2019-10-08');

-- ----------------------------
-- Table structure for `s_class`
-- ----------------------------
DROP TABLE IF EXISTS `s_class`;
CREATE TABLE `s_class` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_class
-- ----------------------------
INSERT INTO `s_class` VALUES ('2', '软件一班', '这是软件一班。哈哈哈 嘻嘻嘻');
INSERT INTO `s_class` VALUES ('6', '的撒旦', '的撒旦呱呱呱');
INSERT INTO `s_class` VALUES ('7', '奋斗的公司的', '得得得得');
INSERT INTO `s_class` VALUES ('8', '通信', '呱呱呱');
INSERT INTO `s_class` VALUES ('12', '计算机', '啧啧啧啧啧啧');

-- ----------------------------
-- Table structure for `s_course`
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `teacher_id` int(5) NOT NULL,
  `max_student_num` int(3) NOT NULL,
  `info` varchar(512) DEFAULT NULL,
  `selected_num` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `teacher_foreign` (`teacher_id`),
  CONSTRAINT `teacher_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `s_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES ('1', '大学数学一', '5', '50', '数学课程，大数一', '7');
INSERT INTO `s_course` VALUES ('2', '大学英语', '4', '45', '大英3', '3');
INSERT INTO `s_course` VALUES ('3', '原子弹原理技术', '5', '66', '制造原子弹技术，很牛逼！', '3');
INSERT INTO `s_course` VALUES ('4', '软件工程', '3', '66', '666', '3');
INSERT INTO `s_course` VALUES ('5', '计算机原理', '4', '45', '计算机组成原理，非常重要。', '2');
INSERT INTO `s_course` VALUES ('6', '人工智能', '5', '2', '人工智能课程。', '2');
INSERT INTO `s_course` VALUES ('16', '数据结构', '3', '34', '辻谷耕史个人认购', '2');
INSERT INTO `s_course` VALUES ('17', 'java', '7', '52', '按时发顺丰深', '0');

-- ----------------------------
-- Table structure for `s_score`
-- ----------------------------
DROP TABLE IF EXISTS `s_score`;
CREATE TABLE `s_score` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_id` int(5) NOT NULL,
  `course_id` int(5) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_score_foreign` (`student_id`),
  KEY `course_id_score_foreign` (`course_id`),
  CONSTRAINT `course_id_score_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_score_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_score
-- ----------------------------
INSERT INTO `s_score` VALUES ('1', '1', '1', '78');
INSERT INTO `s_score` VALUES ('2', '1', '4', '88');
INSERT INTO `s_score` VALUES ('4', '1', '2', '78');
INSERT INTO `s_score` VALUES ('5', '1', '3', '98');
INSERT INTO `s_score` VALUES ('6', '1', '5', '78');
INSERT INTO `s_score` VALUES ('7', '3', '6', '89');
INSERT INTO `s_score` VALUES ('8', '3', '1', '68');
INSERT INTO `s_score` VALUES ('9', '4', '1', '87');
INSERT INTO `s_score` VALUES ('10', '3', '2', '78');
INSERT INTO `s_score` VALUES ('11', '4', '2', '56');
INSERT INTO `s_score` VALUES ('12', '3', '4', '56');
INSERT INTO `s_score` VALUES ('13', '4', '4', '77');
INSERT INTO `s_score` VALUES ('14', '3', '5', '67');
INSERT INTO `s_score` VALUES ('16', '9', '4', '88');

-- ----------------------------
-- Table structure for `s_selected_course`
-- ----------------------------
DROP TABLE IF EXISTS `s_selected_course`;
CREATE TABLE `s_selected_course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_id` int(5) DEFAULT NULL,
  `course_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_foreign` (`student_id`),
  KEY `course_foreign` (`course_id`),
  CONSTRAINT `course_foreign` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `student_foreign` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_selected_course
-- ----------------------------
INSERT INTO `s_selected_course` VALUES ('12', '1', '1');
INSERT INTO `s_selected_course` VALUES ('13', '1', '4');
INSERT INTO `s_selected_course` VALUES ('14', '4', '3');
INSERT INTO `s_selected_course` VALUES ('28', '8', '2');
INSERT INTO `s_selected_course` VALUES ('33', '3', '6');
INSERT INTO `s_selected_course` VALUES ('34', '7', '1');

-- ----------------------------
-- Table structure for `s_student`
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classId` int(5) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign` (`classId`),
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `s_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES ('1', '张三', '2', '1', '女');
INSERT INTO `s_student` VALUES ('3', '李四', '8', '123', '女');
INSERT INTO `s_student` VALUES ('4', '王麻字', '7', '123', '男');
INSERT INTO `s_student` VALUES ('6', '顾格格', '8', '852', '男');
INSERT INTO `s_student` VALUES ('7', '电饭锅', '2', 'sdf', '女');
INSERT INTO `s_student` VALUES ('8', '黄景瑜', '8', '456', '男');
INSERT INTO `s_student` VALUES ('9', '哈哈哈', '2', '123', '女');

-- ----------------------------
-- Table structure for `s_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `title` varchar(32) NOT NULL,
  `age` int(5) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
INSERT INTO `s_teacher` VALUES ('3', '张三', '男', '教授', '36', '1');
INSERT INTO `s_teacher` VALUES ('4', '李四', '女', '博导', '58', '222');
INSERT INTO `s_teacher` VALUES ('5', '王麻子', '女', '讲师', '28', '000000');
INSERT INTO `s_teacher` VALUES ('7', '师爷', '男', '博导', '36', '345');
