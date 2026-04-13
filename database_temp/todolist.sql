-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 13, 2026 at 07:37 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `todolist`
--

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `note_id` bigint(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `note_title` varchar(255) DEFAULT NULL,
  `note_body` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `created_at`, `updated_at`) VALUES
(1, 'danny', 'danny', '2026-03-10 01:13:57', '2026-03-10 01:14:04'),
(2, 'danny1', '$2a$10$ri4WuLKFT7Jtoc2Fyy/l8uvN6Zn.cQct4SiHV/.t/8tOs7RLWV9HO', '2026-04-10 10:04:02', '2026-04-10 02:04:02'),
(3, 'danny0', '$2a$10$e2MmnpT1DjJMAh5iF548ceONMLiQC5P23IQ63rLg5RYOYajp0/WL6', '2026-04-10 10:06:55', '2026-04-10 02:06:55'),
(4, 'soyii', '$2a$10$oxCnUAXwc5nwNVFuEnHf0uDlbEq6k0l3i781QKpDddU2PFxjo/mTu', '2026-04-10 14:06:27', '2026-04-10 06:06:27'),
(5, 'dannybrens', '$2a$10$rBkC9F4RWwETEdrf6LDDVuoGBs5Lg9IOOTPFjsT2tfWjLP5Bj0Qbm', '2026-04-13 09:12:31', '2026-04-13 01:12:31'),
(6, 'danny2', '$2a$10$GSjXq3NuGRHAmnNpD8rGsesNOSRW3OCUsh4hpi8D5GvvP9gbVzPXO', '2026-04-13 09:40:42', '2026-04-13 01:40:42'),
(7, 'noela', '$2a$10$9NIeLdGCtPgjpv6UQQpUKeqLsJ4tEhUdZ20FSRVLyH6wwaljUSf2y', '2026-04-13 09:54:37', '2026-04-13 01:54:37');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`note_id`),
  ADD KEY `fk_user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `note_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
