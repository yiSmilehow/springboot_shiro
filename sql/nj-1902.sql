/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.56 : Database - nj-1902
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nj-1902` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nj-1902`;

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(150) DEFAULT NULL,
  `val` varchar(150) DEFAULT NULL,
  `sortnum` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `resources` */

insert  into `resources`(`id`,`key`,`val`,`sortnum`,`status`) values (1,'/login.jsp','anon',1,1),(2,'/users/login','anon',2,1),(3,'/css/**','anon',3,1),(4,'/images/**','anon',4,1),(5,'/js/**','anon',5,1),(6,'/login/exit','logout',6,1),(7,'/student.jsp','roles[stu]',7,1),(8,'/teacher.jsp','roles[tea]',8,1),(9,'/list.jsp','roles[stu,tea]',9,1),(10,'/list','roles[stu,tea]',10,1),(11,'/student','roles[stu]',11,1),(12,'/teacher','roles[tea]',12,1),(13,'/**','authc',999,1);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rname` varchar(150) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(150) DEFAULT NULL COMMENT '角色备注',
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`id`,`rname`,`remark`,`status`) values (1,'stu','学生角色',1),(2,'tea','老师角色',1),(3,'admin','管理员角色',1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `remark` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`name`,`status`,`remark`) values (1,'admin','41b0ad59e03a297141b642875e39fbd2','管理员',1,'管理员的账号'),(2,'xiaoming','acaf1678de0a58a88d870278fd7d3d92','小明',1,'小明的账号'),(3,'teacher','0cd8cdf450e8a76f922c5e2194ebd13a','老师',1,'老师的账号');

/*Table structure for table `users_roles` */

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `users_roles` */

insert  into `users_roles`(`id`,`uid`,`rid`,`status`) values (1,1,3,1),(2,2,1,1),(3,3,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
