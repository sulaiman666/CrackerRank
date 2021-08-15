-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2021 at 01:15 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `androidujianhackerrank`
--

-- --------------------------------------------------------

--
-- Table structure for table `ujian`
--

CREATE TABLE `ujian` (
  `id` bigint(20) NOT NULL,
  `difficulty_soal` varchar(255) DEFAULT NULL,
  `isi_soal` varchar(1000) DEFAULT NULL,
  `jawaban_soal` varchar(255) DEFAULT NULL,
  `kategori_soal` varchar(255) DEFAULT NULL,
  `nama_soal` varchar(1000) DEFAULT NULL,
  `solved` bit(1) NOT NULL DEFAULT b'0',
  `submission_token` varchar(255) DEFAULT NULL,
  `template_jawaban` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ujian`
--

INSERT INTO `ujian` (`id`, `difficulty_soal`, `isi_soal`, `jawaban_soal`, `kategori_soal`, `nama_soal`, `solved`, `submission_token`, `template_jawaban`) VALUES
(1, 'Easy', '<b>Task</b><br /><br />In this challenge, you must read <b>3</b> integers from stdin and then print them to stdout. Each integer must be printed on a new line. To make the problem a little easier, a portion of the code is provided for you in the editor below.<br /><br /><b>Input Format</b><br /><br />There are <b>3</b> lines of input, and each line contains a single integer.<br /><br /><b>Sample Input</b><br /><br />42<br />100<br />125<br /><br /><b>Sample Output</b><br /><br />42<br />100<br />125<br />', '42\\n100\\n125\\n', 'Basic Java', 'Java Stdin and Stdout I', b'0', NULL, 'aW1wb3J0IGphdmEudXRpbC4qOwoKcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFNjYW5uZXIgc2NhbiA9IG5ldyBTY2FubmVyKFN5c3RlbS5pbik7CiAgICAgICAgZm9yIChpbnQgaSA9IDA7IGkgPCAzOyBpKyspewogICAgICAgICAgICAvL1dyaXRlIGNvZGUgaGVyZQogICAgICAgIH0KICAgIH0KfQ=='),
(2, 'Easy', '<b>Task</b><br /><br />Welcome to the world of Java! In this challenge, we practice printing to stdout.<br /><br />The code stubs in your editor declare a Solution class and a main method. Complete the main method by copying the two lines of code below and pasting them inside the body of your main method.<br /><br />System.out.println(\"Hello, World.\");<br />System.out.println(\"Hello, Java.\");<br /><br /><b>Input Format</b><br /><br />There is no input for this challenge.<br /><br /><b>Output Format</b><br /><br />You must print two lines of output:<br /><br />1. Print Hello, World. on the first line.<br />2. Print Hello, Java. on the second line.<br /><br /><b>Sample Output</b><br /><br />Hello, World.<br />Hello, Java.<br />', 'Hello, World.\\nHello, Java.\\n', 'Basic Java', 'Welcome to Java!', b'0', NULL, 'cHVibGljIGNsYXNzIE1haW57CiAgICBwdWJsaWMgc3RhdGljIHZvaWQgbWFpbihTdHJpbmdbXSBhcmdzKSB7CiAgICAgICAgLyogRW50ZXIgeW91ciBjb2RlIGhlcmUuIFByaW50IG91dHB1dCB0byBTVERPVVQuIFlvdXIgY2xhc3Mgc2hvdWxkIGJlIG5hbWVkIFNvbHV0aW9uLiAqLwogICAgfQp9');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ujian`
--
ALTER TABLE `ujian`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ujian`
--
ALTER TABLE `ujian`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
