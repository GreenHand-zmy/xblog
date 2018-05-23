/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.14-log : Database - xblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xblog` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `mto_channels` */

DROP TABLE IF EXISTS `mto_channels`;

CREATE TABLE `mto_channels` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '频道编号',
  `key` varchar(255) DEFAULT NULL COMMENT '频道标识',
  `name` varchar(255) DEFAULT NULL COMMENT '频道名',
  `status` int(11) DEFAULT NULL COMMENT '频道状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `mto_channels` */

insert  into `mto_channels`(`id`,`key`,`name`,`status`) values (1,'blog','博客',0),(2,'questions','问答',0),(3,'share','分享',0),(5,'xx','it',0),(6,'xxx','it',0),(8,'xxx','it',0),(9,'xxx','it',0);

/*Table structure for table `mto_comments` */

DROP TABLE IF EXISTS `mto_comments`;

CREATE TABLE `mto_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者编号',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `to_id` bigint(20) DEFAULT NULL COMMENT '评论的文章编号',
  `status` int(11) DEFAULT NULL COMMENT '评论状态',
  `created` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `mto_comments` */

insert  into `mto_comments`(`id`,`author_id`,`content`,`to_id`,`status`,`created`) values (1,6,'哇哇哇哇我',3,1,'2018-05-22 08:37:25'),(2,6,'asdasd',3,1,'2018-05-23 14:09:29');

/*Table structure for table `mto_posts` */

DROP TABLE IF EXISTS `mto_posts`;

CREATE TABLE `mto_posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者编号',
  `channel_id` bigint(20) DEFAULT NULL COMMENT '频道编号',
  `title` varchar(64) DEFAULT NULL COMMENT '文章标题',
  `content` text COMMENT '文章内容',
  `views` int(11) DEFAULT '0' COMMENT '文章阅读数',
  `comments` int(11) DEFAULT '0' COMMENT '评论数量',
  `favors` int(11) DEFAULT '0' COMMENT '喜欢数',
  `featured` int(11) DEFAULT '0' COMMENT '是否推荐',
  `status` int(11) DEFAULT '0' COMMENT '文章状态',
  `weight` int(11) DEFAULT NULL COMMENT '是否置顶',
  `created` datetime DEFAULT NULL COMMENT '文章产生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `mto_posts` */

insert  into `mto_posts`(`id`,`author_id`,`channel_id`,`title`,`content`,`views`,`comments`,`favors`,`featured`,`status`,`weight`,`created`) values (5,7,1,'asdasd','<p>asdasdad</p>',0,0,0,0,0,NULL,'2018-05-23 20:46:12'),(6,7,1,'asd','<p>阿斯达斯的</p>',0,0,0,0,0,NULL,NULL),(7,7,3,'傻逼zh','<p>阿斯达斯大所</p>',0,0,0,0,0,NULL,NULL);

/*Table structure for table `mto_users` */

DROP TABLE IF EXISTS `mto_users`;

CREATE TABLE `mto_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT '/assets/images/ava/default.png',
  `updated` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `mto_users` */

insert  into `mto_users`(`id`,`created`,`mobile`,`password`,`status`,`username`,`name`,`avatar`,`updated`,`gender`,`signature`,`last_login`) values (1,'2015-08-06 17:52:41',NULL,'1234',0,'久2','zh1','1','2018-05-21 16:11:47',0,'zmySB',NULL),(2,'2018-05-21 15:34:59',NULL,'123',NULL,'久','zh','/assets/images/ava/default.png',NULL,NULL,NULL,NULL),(4,'2018-05-21 16:15:30',NULL,'123',NULL,'久','zh','/assets/images/ava/default.png',NULL,NULL,NULL,NULL),(5,'2018-05-22 13:48:03',NULL,'123',NULL,'久23','zh','/assets/images/ava/default.png',NULL,NULL,NULL,NULL),(6,'2018-05-22 13:49:17',NULL,'123456',NULL,'a123456','端对端','/assets/images/ava/default.png','2018-05-23 10:14:38',NULL,'端对端',NULL),(7,'2018-05-22 16:17:46',NULL,'123',NULL,'admin','admin','/assets/images/ava/default.png',NULL,NULL,NULL,NULL),(8,'2018-05-23 15:10:23',NULL,'123456',NULL,'zmy123','傻逼叶振东','/assets/images/ava/default.png',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
