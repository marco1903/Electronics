-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5277
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for electronics n.v.
CREATE DATABASE IF NOT EXISTS `electronics n.v.` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `electronics n.v.`;

-- Dumping structure for table electronics n.v..facturen
CREATE TABLE IF NOT EXISTS `facturen` (
  `FactuurNummer` int(25) NOT NULL AUTO_INCREMENT,
  `ProductNaam` varchar(50) NOT NULL,
  `TotaalBedrag` int(20) NOT NULL,
  `KlantID` int(10) NOT NULL,
  `ProductID` int(10) NOT NULL,
  PRIMARY KEY (`FactuurNummer`),
  KEY `KlantID` (`KlantID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `KlantID` FOREIGN KEY (`KlantID`) REFERENCES `klanten` (`KlantID`),
  CONSTRAINT `ProductID` FOREIGN KEY (`ProductID`) REFERENCES `producten` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table electronics n.v..facturen: ~0 rows (approximately)
DELETE FROM `facturen`;
/*!40000 ALTER TABLE `facturen` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturen` ENABLE KEYS */;

-- Dumping structure for table electronics n.v..klanten
CREATE TABLE IF NOT EXISTS `klanten` (
  `KlantID` int(10) NOT NULL AUTO_INCREMENT,
  `Voornaam` varchar(15) NOT NULL,
  `Achternaam` varchar(15) NOT NULL,
  `Adres` varchar(50) NOT NULL,
  `IDnummer` varchar(11) NOT NULL,
  `Telefoonnummer` varchar(11) NOT NULL,
  PRIMARY KEY (`KlantID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table electronics n.v..klanten: ~1 rows (approximately)
DELETE FROM `klanten`;
/*!40000 ALTER TABLE `klanten` DISABLE KEYS */;
INSERT INTO `klanten` (`KlantID`, `Voornaam`, `Achternaam`, `Adres`, `IDnummer`, `Telefoonnummer`) VALUES
	(1, 'Marco', 'Abas', 'Annie Beckstraat 3', 'FF007781M', '8592121');
/*!40000 ALTER TABLE `klanten` ENABLE KEYS */;

-- Dumping structure for table electronics n.v..producten
CREATE TABLE IF NOT EXISTS `producten` (
  `ProductID` int(10) NOT NULL AUTO_INCREMENT,
  `Naam` varchar(50) NOT NULL,
  `Leverancier` varchar(50) NOT NULL,
  `VoorraadStatus` varchar(50) NOT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table electronics n.v..producten: ~0 rows (approximately)
DELETE FROM `producten`;
/*!40000 ALTER TABLE `producten` DISABLE KEYS */;
/*!40000 ALTER TABLE `producten` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
