/*
MySQL Data Transfer
Source Host: localhost
Source Database: olms
Target Host: localhost
Target Database: olms
Date: 7/1/2015 4:40:23 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for examiner
-- ----------------------------
DROP TABLE IF EXISTS `examiner`;
CREATE TABLE `examiner` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FullName` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `examiner` VALUES ('1', 'Mr David Backham', 'back@gmail.com', 'back');
