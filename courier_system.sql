-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2021 at 01:24 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `courier_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountID` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountID`, `username`, `password`, `phoneNumber`, `level`) VALUES
(1, 'Trong', '123', '09999999', 1),
(2, 'Vu', '1234', '088888888', 2),
(3, 'Thong', '123456', '066666666', 3),
(12, 'Tuan', '123123', '022222222', 3),
(13, 'Tu', '123', '012345678', 2),
(14, 'hau', '123', '0213445667', 2),
(15, 'tuan', '123', '021314566', 2);

-- --------------------------------------------------------

--
-- Table structure for table `admin_request`
--

CREATE TABLE `admin_request` (
  `adminRequestID` int(11) NOT NULL,
  `courierRequestID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `courier_request`
--

CREATE TABLE `courier_request` (
  `courierRequestID` int(11) NOT NULL,
  `usernameR` varchar(30) NOT NULL,
  `emailR` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `approxWeight` float NOT NULL,
  `destination` varchar(50) NOT NULL,
  `fromAddressR` varchar(50) NOT NULL,
  `phoneNumberR` varchar(11) NOT NULL,
  `shippingService` varchar(20) NOT NULL,
  `cost` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `currentLocation` varchar(50) NOT NULL,
  `personName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courier_request`
--

INSERT INTO `courier_request` (`courierRequestID`, `usernameR`, `emailR`, `description`, `approxWeight`, `destination`, `fromAddressR`, `phoneNumberR`, `shippingService`, `cost`, `status`, `currentLocation`, `personName`) VALUES
(3, 'Tuan', 'tuan@.com', 'book', 0.2, 'thu dau mot', 'phu my', '023222', 'PREMIUM(2days)', 240, 'Received', 'Thu dau mot', 'Vu');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `passwordC` varchar(30) NOT NULL,
  `emailC` varchar(30) NOT NULL,
  `dateOfBirthC` date NOT NULL,
  `genderC` varchar(8) NOT NULL,
  `addressC` varchar(50) NOT NULL,
  `phoneNumberC` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `customerName`, `passwordC`, `emailC`, `dateOfBirthC`, `genderC`, `addressC`, `phoneNumberC`) VALUES
(1, 'trítru', '123', '@.com', '2021-11-03', 'Male', '31', '131');

-- --------------------------------------------------------

--
-- Table structure for table `deliveryrequest`
--

CREATE TABLE `deliveryrequest` (
  `deliveryRequestID` int(11) NOT NULL,
  `adminRequestID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_person`
--

CREATE TABLE `delivery_person` (
  `deliveryPersonID` int(11) NOT NULL,
  `userNameP` varchar(30) NOT NULL,
  `passwordP` varchar(30) NOT NULL,
  `dateOfBirthP` date NOT NULL,
  `emailP` varchar(50) NOT NULL,
  `genderP` varchar(9) NOT NULL,
  `addressP` varchar(50) NOT NULL,
  `phoneNumberP` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `delivery_person`
--

INSERT INTO `delivery_person` (`deliveryPersonID`, `userNameP`, `passwordP`, `dateOfBirthP`, `emailP`, `genderP`, `addressP`, `phoneNumberP`) VALUES
(1, 'Thong', '123456', '2005-11-09', 'thong@.com', 'Female', 'Bình Dương', '066666666'),
(3, 'Tuan', '123123', '2007-11-09', 'Tuan@.com', 'Male', 'Binh Duong', '022222222'),
(5, 'Tu', '123', '2021-11-09', 'tu@.com', 'Male', 'binh duong', '012345678'),
(6, 'hau', '123', '2021-11-09', 'hau@.com', 'Male', 'Binh Duong', '0213445667'),
(7, 'tuan', '123', '2021-11-02', 'tuan@.com', 'Male', 'Binh Duong', '021314566');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountID`);

--
-- Indexes for table `admin_request`
--
ALTER TABLE `admin_request`
  ADD PRIMARY KEY (`adminRequestID`),
  ADD KEY `courierRequestID` (`courierRequestID`);

--
-- Indexes for table `courier_request`
--
ALTER TABLE `courier_request`
  ADD PRIMARY KEY (`courierRequestID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `delivery_person`
--
ALTER TABLE `delivery_person`
  ADD PRIMARY KEY (`deliveryPersonID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `admin_request`
--
ALTER TABLE `admin_request`
  MODIFY `adminRequestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `courier_request`
--
ALTER TABLE `courier_request`
  MODIFY `courierRequestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `delivery_person`
--
ALTER TABLE `delivery_person`
  MODIFY `deliveryPersonID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_request`
--
ALTER TABLE `admin_request`
  ADD CONSTRAINT `admin_request_ibfk_1` FOREIGN KEY (`courierRequestID`) REFERENCES `courier_request` (`courierRequestID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
