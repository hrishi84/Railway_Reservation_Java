-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Login`
--

DROP TABLE IF EXISTS `Login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Login` (
  `User_name` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`User_name`),
  CONSTRAINT `fk3` FOREIGN KEY (`User_name`) REFERENCES `user` (`User_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login`
--

LOCK TABLES `Login` WRITE;
/*!40000 ALTER TABLE `Login` DISABLE KEYS */;
INSERT INTO `Login` VALUES ('kk','kk');
/*!40000 ALTER TABLE `Login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Passenger`
--

DROP TABLE IF EXISTS `Passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Passenger` (
  `Pnr` bigint(10) NOT NULL AUTO_INCREMENT,
  `User_name` varchar(45) NOT NULL,
  `Age` int(11) NOT NULL,
  `p_name` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Source` varchar(45) NOT NULL,
  `Destination` varchar(45) NOT NULL,
  `Train_no` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`Pnr`),
  KEY `fk2_idx` (`User_name`),
  KEY `fk3_idx` (`Train_no`),
  CONSTRAINT `fk2` FOREIGN KEY (`User_name`) REFERENCES `user` (`User_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk4` FOREIGN KEY (`Train_no`) REFERENCES `Train` (`Train_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Passenger`
--

LOCK TABLES `Passenger` WRITE;
/*!40000 ALTER TABLE `Passenger` DISABLE KEYS */;
/*!40000 ALTER TABLE `Passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Passenger_bkp`
--

DROP TABLE IF EXISTS `Passenger_bkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Passenger_bkp` (
  `Pnr` bigint(10) NOT NULL,
  `User_name` varchar(45) NOT NULL,
  `Age` int(11) NOT NULL,
  `p_name` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Source` varchar(45) NOT NULL,
  `Destination` varchar(45) NOT NULL,
  `Train_no` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`Pnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Passenger_bkp`
--

LOCK TABLES `Passenger_bkp` WRITE;
/*!40000 ALTER TABLE `Passenger_bkp` DISABLE KEYS */;
/*!40000 ALTER TABLE `Passenger_bkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Station`
--

DROP TABLE IF EXISTS `Station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Station` (
  `Train_no` bigint(10) NOT NULL,
  `Mumbai` tinyint(1) NOT NULL,
  `Ahmdebad` tinyint(1) DEFAULT NULL,
  `Jaipur` tinyint(1) DEFAULT NULL,
  `Delhi` tinyint(1) DEFAULT NULL,
  `End` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Train_no`),
  CONSTRAINT `fk1` FOREIGN KEY (`Train_no`) REFERENCES `Train` (`Train_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Station`
--

LOCK TABLES `Station` WRITE;
/*!40000 ALTER TABLE `Station` DISABLE KEYS */;
INSERT INTO `Station` VALUES (1021,1,0,1,1,'Delhi'),(1233,0,0,1,1,'Jaipur'),(1678,1,1,1,0,'Jaipur'),(2335,1,0,0,1,'Mumbai'),(4513,1,1,1,1,'Delhi'),(4566,0,1,1,0,'Jaipur'),(5677,0,1,1,1,'Delhi'),(5785,0,1,0,1,'Ahemdabad'),(6245,1,1,1,0,'Mumbai'),(9815,0,1,1,0,'Ahemdabad');
/*!40000 ALTER TABLE `Station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Train`
--

DROP TABLE IF EXISTS `Train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Train` (
  `Train_no` bigint(10) NOT NULL,
  `Train_name` varchar(45) NOT NULL,
  `Source` varchar(45) NOT NULL,
  `Destination` varchar(45) NOT NULL,
  `Monday` int(11) DEFAULT '600',
  `Tuesday` int(11) DEFAULT '600',
  `Wednesday` int(11) DEFAULT '600',
  `Cost` int(11) DEFAULT '500',
  PRIMARY KEY (`Train_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Train`
--

LOCK TABLES `Train` WRITE;
/*!40000 ALTER TABLE `Train` DISABLE KEYS */;
INSERT INTO `Train` VALUES (1021,'Duronto','Mumbai','Delhi',593,600,600,650),(1233,'Rajkalyan Express','Delhi','Jaipur',600,600,600,800),(1678,'Kalyani Express','Mumbai','Jaipur',600,597,600,800),(2335,'Nizauddin Express','Delhi','Mumbai',600,600,600,600),(4513,'Rajdhani Express','Mumbai','Delhi',600,600,600,1000),(4566,'Nazi Express','Ahmdebad','Jaipur',600,600,600,700),(5677,'Krishna Express','Ahmdebad','Delhi',600,600,600,699),(5785,'Gujarat Mail','Delhi','Ahmdebad',600,600,600,990),(6245,'Rawal Express','Jaipur','Mumbai',600,600,600,720),(9815,'Fazal','Jaipur','Ahmdebad',600,600,600,640);
/*!40000 ALTER TABLE `Train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_name` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Contact` bigint(10) NOT NULL,
  `Age` int(10) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  PRIMARY KEY (`User_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('kk','ii','us','usa',57,18,'Male');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-04 20:58:55
