/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : zoucai

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-11-02 16:08:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zoucai_event
-- ----------------------------
DROP TABLE IF EXISTS `zoucai_event`;
CREATE TABLE `zoucai_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `eventDate` date DEFAULT NULL COMMENT '赛事日期',
  `eventNumber` varchar(50) DEFAULT '' COMMENT '赛事编号',
  `league` varchar(50) DEFAULT '' COMMENT '联赛',
  `homeTeam` varchar(100) DEFAULT '' COMMENT '主队',
  `visitingTeam` varchar(100) DEFAULT '' COMMENT '客队',
  `homFalfScore` int(10) DEFAULT '0' COMMENT '主队半场比分',
  `visitingFalfScore` int(10) DEFAULT '0' COMMENT '客队半场比分',
  `homeScore` int(10) DEFAULT '0' COMMENT '主队全场比分',
  `visitingScore` int(10) DEFAULT '0' COMMENT '客队全场比分',
  `winningOdds` bigint(20) DEFAULT '0' COMMENT '胜赔率 *100后的结果',
  `negativeOdds` bigint(20) DEFAULT '0' COMMENT '负赔率',
  `flatOdds` bigint(20) DEFAULT '0' COMMENT '平赔率',
  `gameOver` int(10) DEFAULT '0' COMMENT '比赛状态 ： 0 待开始 10比赛中 20比赛结束',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_eventNumber` (`eventNumber`,`eventDate`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=94679 DEFAULT CHARSET=utf8 COMMENT='赛事';

CREATE TABLE `dual_colore_ball` (
  `id` bigint(50) NOT NULL,
  `eventDate` date DEFAULT NULL COMMENT '开奖日期',
  `eventNum` varchar(200) DEFAULT NULL COMMENT '编号',
  `redBall1` varchar(255) DEFAULT NULL COMMENT '红球1',
  `redBall2` varchar(255) DEFAULT NULL COMMENT '红球2',
  `redBall3` varchar(255) DEFAULT NULL COMMENT '红球3',
  `redBall4` varchar(255) DEFAULT NULL COMMENT '红球4',
  `redBall5` varchar(255) DEFAULT NULL COMMENT '红球5',
  `redBall6` varchar(255) DEFAULT NULL COMMENT '红球6',
  `blueBall1` varchar(255) DEFAULT NULL COMMENT '蓝色球',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='双色球';

CREATE TABLE `super_lotto` (
  `id` bigint(50) NOT NULL,
  `eventDate` date DEFAULT NULL,
  `eventNum` varchar(200) DEFAULT NULL COMMENT '编号',
  `redBall1` varchar(255) DEFAULT NULL COMMENT '红球1',
  `redBall2` varchar(255) DEFAULT NULL COMMENT '红球2',
  `redBall3` varchar(255) DEFAULT NULL COMMENT '红球3',
  `redBall4` varchar(255) DEFAULT NULL COMMENT '红球4',
  `redBall5` varchar(255) DEFAULT NULL COMMENT '红球5',
  `blueBall1` varchar(255) DEFAULT NULL COMMENT '蓝色球1',
  `blueBall2` varchar(255) DEFAULT NULL COMMENT '蓝色球2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大乐透';

CREATE TABLE `eleven_selected_five` (
  `id` bigint(50) NOT NULL,
  `eventDate` date DEFAULT NULL,
  `eventNum` varchar(200) DEFAULT NULL COMMENT '编号',
  `ball1` varchar(255) DEFAULT NULL COMMENT '球1',
  `ball2` varchar(255) DEFAULT NULL COMMENT '球2',
  `ball3` varchar(255) DEFAULT NULL COMMENT '球3',
  `ball4` varchar(255) DEFAULT NULL COMMENT '球4',
  `ball5` varchar(255) DEFAULT NULL COMMENT '球5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='11选5';

