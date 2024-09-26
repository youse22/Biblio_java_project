-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 26, 2024 at 05:46 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteque_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `adherant`
--

DROP TABLE IF EXISTS `adherant`;
CREATE TABLE IF NOT EXISTS `adherant` (
  `id_e` int NOT NULL AUTO_INCREMENT,
  `cin` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `first_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `adresse` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `faculte` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `vacation` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `niveau` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `statut` enum('visible','hidden') COLLATE utf8mb4_general_ci DEFAULT 'visible',
  PRIMARY KEY (`id_e`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adherant`
--

INSERT INTO `adherant` (`id_e`, `cin`, `last_name`, `first_name`, `phone`, `adresse`, `faculte`, `vacation`, `niveau`, `statut`) VALUES
(1, '45678900788', 'Youse', 'Lord', '32321445', 'Delmas 19', 'fsi', 'soir', 'l3', 'visible'),
(45, 'cjhmckcck', 'gxgnxxgnj', 'chjffhjhjvh', 'vhvhvhvhm', 'xgnxgnng', 'cgbcbmcgc', 'hjmmhhmh', 'xgnjggggt', 'hidden'),
(46, '12121212', 'ilay', 'llamy', '12121212', 'Delmas', 'fsi', 'median', 'l4', 'visible'),
(47, 'CIN002', 'JOSEPH', 'Jean', '+5091234567', 'Port-au-Prince', 'FSE', 'Apres-midi', 'L3', 'visible'),
(48, 'CIN003', 'DUPONT', 'Pierre', '+5099876543', 'Cap-Haïtien', 'FSS', 'Matin', 'L2', 'visible'),
(49, 'CIN004', 'DUMONT', 'Anna', '+5092345678', 'Les Cayes', 'FSA', 'Apres-midi', 'L1', 'visible'),
(50, 'CIN005', 'BAPTISTE', 'David', '+5093456789', 'Jacmel', 'FST', 'Matin', 'L4', 'visible'),
(51, '32323232323', 'yh', 'llamy', '3142425424', 'delmas', 'fsi', 'soir', 'l3', 'visible'),
(52, '343433434', 'ytu', 'tuy', '45456765', 'delmas', 'fdi', 'median', 'l5', 'visible'),
(53, '2424242424', 'elie', 'lia', '2121212', 'pv', 'fld', 'soir', 'l3', 'visible');

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

DROP TABLE IF EXISTS `livres`;
CREATE TABLE IF NOT EXISTS `livres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `auteur` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `edition` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `nbreExemp` int NOT NULL,
  `status` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `etat` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `statut` enum('visible','hidden') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'visible',
  `isbn` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `annee` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `livres`
--

INSERT INTO `livres` (`id`, `titre`, `auteur`, `edition`, `nbreExemp`, `status`, `etat`, `statut`, `isbn`, `annee`) VALUES
(1, 'Le Petit Prince', 'Antoine de Saint-Exupéry', '1ère', 5, 'Disponible', 'Neuf', 'visible', NULL, 0),
(2, '1984', 'George Orwell', '1ère', 3, 'Disponible', 'Bon état', 'visible', NULL, 0),
(3, 'Fahrenheit 451', 'Ray Bradbury', '1ère', 2, 'Emprunté', 'Bon état', 'visible', NULL, 0),
(4, 'Le Meilleur des Mondes', 'Aldous Huxley', '1ère', 4, 'Disponible', 'Neuf', 'visible', NULL, 0),
(5, 'La Peste', 'Albert Camus', '1ère', 1, 'Emprunté', 'Moyen', 'visible', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `prets`
--

DROP TABLE IF EXISTS `prets`;
CREATE TABLE IF NOT EXISTS `prets` (
  `id` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `id_etu` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `id_liv` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `datePret` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `dateRemise` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(250) COLLATE utf8mb4_general_ci NOT NULL,
  `statut` enum('visible','hidden') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'visible'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prets`
--

INSERT INTO `prets` (`id`, `id_etu`, `id_liv`, `datePret`, `dateRemise`, `description`, `statut`) VALUES
('PRE002', 'Etu-002', 'LIV003', '2024-09-05', '2024-09-20', 'Prêt pour un projet de recherchebkhbljbljb', 'hidden'),
('PRE003', 'Etu-003', 'LIV002', '2024-09-10', '2024-09-25', 'Prêt pour étude', ''),
('PRE005', 'Etu-002', 'LIV005', '2024-09-15', '2024-09-30', 'Prêt pour un essai', ''),
('', '', '', '26/09/2024', '27/09/2024', 'Livre prete pou li anpil bagay', 'visible'),
('', '', '', '26/09/2024', '27/09/2024', 'Livre prete pou li anpil bagay', 'visible'),
('', '', '', '26/09/2024', '27/09/2024', 'Livre prete pou li anpil bagay', 'visible'),
('', 'bb', 'hhh', '26/09/2024', '27/09/2024', 'vjk,k', 'visible');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
