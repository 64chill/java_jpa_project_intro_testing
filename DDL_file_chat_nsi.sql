-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 23, 2020 at 05:19 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat_nsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `ACCOUNT`
--

CREATE TABLE `ACCOUNT` (
  `idAccount` int(11) NOT NULL,
  `active` tinyint(1) DEFAULT '0',
  `pwd` varchar(255) DEFAULT NULL,
  `uemail` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `CHAT`
--

CREATE TABLE `CHAT` (
  `idChat` int(11) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `active` tinyint(1) DEFAULT '0',
  `date` date DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `postedBy` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `CHATROOM`
--

CREATE TABLE `CHATROOM` (
  `idChat` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `crddesc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `CHATTING`
--

CREATE TABLE `CHATTING` (
  `idChatting` int(11) NOT NULL,
  `idAccount` int(11) DEFAULT NULL,
  `idChat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DIRECTCHAT`
--

CREATE TABLE `DIRECTCHAT` (
  `idChat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SEQUENCE`
--

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SUBGROUPS`
--

CREATE TABLE `SUBGROUPS` (
  `id` int(11) NOT NULL,
  `subname` varchar(255) DEFAULT NULL,
  `idChat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ACCOUNT`
--
ALTER TABLE `ACCOUNT`
  ADD PRIMARY KEY (`idAccount`);

--
-- Indexes for table `CHAT`
--
ALTER TABLE `CHAT`
  ADD PRIMARY KEY (`idChat`);

--
-- Indexes for table `CHATROOM`
--
ALTER TABLE `CHATROOM`
  ADD PRIMARY KEY (`idChat`);

--
-- Indexes for table `CHATTING`
--
ALTER TABLE `CHATTING`
  ADD PRIMARY KEY (`idChatting`),
  ADD KEY `FK_CHATTING_idAccount` (`idAccount`),
  ADD KEY `FK_CHATTING_idChat` (`idChat`);

--
-- Indexes for table `DIRECTCHAT`
--
ALTER TABLE `DIRECTCHAT`
  ADD PRIMARY KEY (`idChat`);

--
-- Indexes for table `SEQUENCE`
--
ALTER TABLE `SEQUENCE`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indexes for table `SUBGROUPS`
--
ALTER TABLE `SUBGROUPS`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_SUBGROUPS_idChat` (`idChat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CHATROOM`
--
ALTER TABLE `CHATROOM`
  ADD CONSTRAINT `FK_CHATROOM_idChat` FOREIGN KEY (`idChat`) REFERENCES `CHAT` (`idChat`);

--
-- Constraints for table `CHATTING`
--
ALTER TABLE `CHATTING`
  ADD CONSTRAINT `FK_CHATTING_idAccount` FOREIGN KEY (`idAccount`) REFERENCES `ACCOUNT` (`idAccount`),
  ADD CONSTRAINT `FK_CHATTING_idChat` FOREIGN KEY (`idChat`) REFERENCES `CHAT` (`idChat`);

--
-- Constraints for table `DIRECTCHAT`
--
ALTER TABLE `DIRECTCHAT`
  ADD CONSTRAINT `FK_DIRECTCHAT_idChat` FOREIGN KEY (`idChat`) REFERENCES `CHAT` (`idChat`);

--
-- Constraints for table `SUBGROUPS`
--
ALTER TABLE `SUBGROUPS`
  ADD CONSTRAINT `FK_SUBGROUPS_idChat` FOREIGN KEY (`idChat`) REFERENCES `CHAT` (`idChat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
