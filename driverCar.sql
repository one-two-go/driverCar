/*
Navicat MySQL Data Transfer

Source Server         :  mylocal
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-11-25 11:32:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `trademark` varchar(32) DEFAULT NULL,
  `rent` decimal(10,2) DEFAULT NULL,
  `car_type` varchar(2) DEFAULT NULL,
  `pic_url` varchar(256) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `drtiverypte` (`car_type`),
  CONSTRAINT `drtiverypte` FOREIGN KEY (`car_type`) REFERENCES `t_driver_type` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO t_car VALUES ('1', '奥迪A6 2019款豪华致雅款', '奥迪', '600.00', 'C2', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('2', '卡罗拉1.8L E-CVT先锋版', '丰田', '200.00', 'C1', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('3', '朗逸1.5L 手动风尚版', '大众', '160.00', 'C1', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('4', '帕萨特2019款 280TSI 商务版', '大众', '300.00', 'C2', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('5', '丰田考斯特15座首长版', '丰田', '1200.00', 'B1', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('6', '宇通客车45座', '宇通', '4000.00', 'A1', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('7', '本田梦翼摩托', '本田', '200.00', 'E', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('8', '福克斯2019款1.5L 手动锋跃型', '福特', '120.00', 'C1', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('9', '传祺GA4', '广汽', '100.00', 'C2', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('10', '宝来2019款自动时尚型', '大众', '120.00', 'C2', null, '2019-11-26 10:10:02');
INSERT INTO t_car VALUES ('11', '三蹦子', '雅迪', '1.00', 'C4', null, '2019-11-27 10:53:23');
INSERT INTO t_car VALUES ('12', '拖拉机', '奥托', '2.00', 'C3', null, '2019-11-01 10:53:27');
INSERT INTO t_car VALUES ('13', '大众车', '大众', '20.00', 'C4', '20191125/65441271-d431-4eff-a875-49b97925c5e8.jpg', '2019-11-25 11:29:41');

-- ----------------------------
-- Table structure for `t_driver`
-- ----------------------------
DROP TABLE IF EXISTS `t_driver`;
CREATE TABLE `t_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `driver_license` varchar(255) DEFAULT NULL,
  `driver_type` varchar(2) NOT NULL,
  `issued` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `code` (`driver_type`),
  CONSTRAINT `code` FOREIGN KEY (`driver_type`) REFERENCES `t_driver_type` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_driver
-- ----------------------------
INSERT INTO t_driver VALUES ('1', 'zhangsna', '12345678', '123456', '220104189709082345', 'A1', null, '2019-11-25 10:16:50');
INSERT INTO t_driver VALUES ('2', 'anyuhang', '12345678', '123456', '220104189709082345', 'C3', null, '2019-11-25 10:26:41');

-- ----------------------------
-- Table structure for `t_driver_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_driver_type`;
CREATE TABLE `t_driver_type` (
  `code` varchar(2) NOT NULL DEFAULT '',
  `name` varchar(10) DEFAULT NULL,
  `include` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_driver_type
-- ----------------------------
INSERT INTO t_driver_type VALUES ('A1', '大型载客汽车', 'A3,B1,B2,C1,C2,C3,C4,M');
INSERT INTO t_driver_type VALUES ('A2', '牵引车', 'B1,B2,C1,C2,C3,C4,M');
INSERT INTO t_driver_type VALUES ('A3', '城市公交车', 'C1,C2,C3,C4');
INSERT INTO t_driver_type VALUES ('B1', '中型客车', 'C1,C2,C3,C4,M');
INSERT INTO t_driver_type VALUES ('B2', '大型货车', 'C1,C2,C3,C4,M');
INSERT INTO t_driver_type VALUES ('C1', '小型汽车', 'C2,C3,C4');
INSERT INTO t_driver_type VALUES ('C2', '小型自动挡汽车', '');
INSERT INTO t_driver_type VALUES ('C3', '低速载货汽车', 'C4');
INSERT INTO t_driver_type VALUES ('C4', '三轮汽车', '');
INSERT INTO t_driver_type VALUES ('D', '普通三轮摩托车', 'E,F');
INSERT INTO t_driver_type VALUES ('E', '普通二轮摩托车', 'F');
