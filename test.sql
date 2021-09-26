/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.47-community : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `car_name` varchar(50) DEFAULT NULL,
  `car_type` varchar(20) DEFAULT NULL,
  `car_price` double DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`car_id`,`car_name`,`car_type`,`car_price`) values (1,'3.5V6','爱虎',538000),(2,'3.0AT','翼虎',278000),(3,'2012款3.5L精锐型天窗版','锐界',389800),(4,'2011款3.5Limited','Explorer探索者',838000),(5,'2011款锋潮1.5自动豪华型（三厢）','嘉年华',9900),(6,'2012款Sportback1.8T尊贵','奥迪A3',328000),(7,'S53.0TSportback2010款','奥迪A5',718000),(8,'2012款3.0OTFSIquattro','奥迪A7',958000),(9,'2012款3.0TFSIquattro（245kW)专享','奥迪Q7',1319000),(10,'2011款SRoadster2.0TFS','奥迪TT',708000),(11,'2011款120i敞篷轿跑车','宝马1系',368000),(12,'2012款335i','宝马3系',626000),(13,'2012款530i领先版旅行版','宝马5系',666600),(14,'650i硬顶轿跑','宝马6系',1848000),(15,'2011款750LixDrive','宝马7系',2118000),(16,'2011款A180','奔驰A级',278000),(17,'200K敞篷跑车时尚型','奔驰CLK',731000),(18,'2011款GL450尊贵型GrandEd','奔驰GL级',1598000),(19,'SL50008款','奔驰SL级',1988000),(20,'SLSAMG2011款','奔驰SLS AMG ',3628000),(21,'2011款2.4L豪华版','奥德赛',256800),(22,'2011款3.5AT旗舰版','歌诗图',428800),(23,'3.5AT','里程',400000),(24,'2.4L尊贵导航版','思铂睿',265800),(25,'2012款2.4ATEXNavi','雅阁',249700),(26,'3.6L旗舰版2010款','昂克雷',599000),(27,'2012款1.6T新锐运动版','英朗GT',187300),(28,'2012款1.6L自动时尚版','英朗XT',149900),(29,'2011款3.0XT旗舰版豪华商务车','GL8',388000),(30,'GS3.6豪华运动版','荣御',498000),(31,'3.6LV64MOTION舒适版','大众CC',505000),(32,'2011款高尔夫R2.0TSIDSG','高尔夫',394800),(33,'1.6AT2010款','甲壳虫',201600),(34,'2011款劲取1.6LAT实酷版','POLO',112800),(35,'1.8MT景畅型','桑塔纳',79800),(36,'GTBFIORANO06款','599',4928000),(37,'Scaglietti','612',5698000),(38,'Spider ','F430',4048000),(39,'4.3V8','California',3488000),(40,'2011款4.5L标准型','458Italia',3880000),(41,'2012款CTS3.0豪华运动版','CTS',429800),(42,'2011款66号公路纪念版3.0L精英版','SRX',469800),(43,'4.609款','XLR',1520000),(44,'6.0Hybrid2010款','凯雷德',1398000),(45,'2011款3.6L运动型','SLS赛威',638000),(46,'LP550-2标准版2010款','Gallardo',3480000),(47,'LP550-2ValentinoBalb','Gallardo',4280000),(48,'LP640Roadster','Murcielago',5980000),(49,'6.5LAT','Reventon',1500000),(50,'2011款LP700-4','Aventador',6488000),(51,'X86','法拉利',12000000),(52,'王者归来X713','兰博基尼',20000000);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `name` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`name`,`password`) values ('1','C4CA4238A0B923820DCC509A6F75849B'),('11','6512BD43D9CAA6E02C990B0A82652DCA'),('2','C81E728D9D4C2F636F067F89CC14862C'),('3','ECCBC87E4B5CE2FE28308FD9F2A7BAF3'),('4','A87FF679A2F3E71D9181A67B7542122C'),('5','E4DA3B7FBBCE2345D7772B0674A318D5'),('6','6'),('Alan','1231'),('lisi','111'),('lqx','202CB962AC59075B964B07152D234B70'),('zhangsan','123'),('兰老师','C4CA4238A0B923820DCC509A6F75849B'),('张三','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
