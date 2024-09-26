-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2024 at 10:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bibliotheque_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `adherant`
--

CREATE TABLE `adherant` (
  `id_e` varchar(10) NOT NULL,
  `cin` varchar(12) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `facultet` varchar(150) NOT NULL,
  `vacation` varchar(10) NOT NULL,
  `niveau` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

CREATE TABLE `livres` (
  `id` varchar(10) NOT NULL,
  `titre` varchar(200) NOT NULL,
  `auteur` varchar(120) NOT NULL,
  `edition` varchar(25) NOT NULL,
  `nbreExemp` int(11) NOT NULL,
  `status` varchar(25) NOT NULL,
  `etat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prets`
--

CREATE TABLE `prets` (
  `id` varchar(10) NOT NULL,
  `id_etu` varchar(10) NOT NULL,
  `id_liv` varchar(10) NOT NULL,
  `datePret` varchar(15) NOT NULL,
  `dateRemise` varchar(15) NOT NULL,
  `description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
