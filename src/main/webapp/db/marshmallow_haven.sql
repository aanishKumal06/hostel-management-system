-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 04:50 PM
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
-- Database: `marshmallow_haven`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `application_id` int(11) NOT NULL,
  `duration_of_stay` varchar(50) NOT NULL,
  `expected_check_in` date NOT NULL,
  `check_out_date` date DEFAULT NULL,
  `special_requests` text DEFAULT NULL,
  `status` varchar(225) NOT NULL DEFAULT 'pending',
  `photo_url` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`application_id`, `duration_of_stay`, `expected_check_in`, `check_out_date`, `special_requests`, `status`, `photo_url`, `created_at`, `updated_at`) VALUES
(39, '6-months', '2025-05-20', '2025-05-31', 'dgdf', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-17 09:01:01', '2025-05-17 09:28:37'),
(40, '3-months', '2025-05-21', '2025-05-31', 'as', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-17 09:01:47', '2025-05-17 09:25:15'),
(41, '6-months', '2025-05-29', '2025-05-31', 'adas', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-17 09:29:31', '2025-05-17 10:21:59'),
(42, '1-month', '2025-05-27', '2025-06-25', 'as', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-17 10:25:44', '2025-05-17 10:26:38'),
(43, '6-months', '2025-06-02', '2025-06-07', 'asd', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-17 10:42:46', '2025-05-17 12:02:06'),
(44, '6-months', '2025-05-21', '2025-08-20', 'dgdf', 'checkout', 'Screenshot 2025-02-28 063737.png', '2025-05-18 13:34:12', '2025-05-19 08:01:15'),
(45, '3-months', '2025-08-22', NULL, 'gym and spa', 'rejected', 'Screenshot 2024-09-18 200723.png', '2025-05-19 07:18:47', '2025-05-19 07:52:02'),
(46, '6-months', '2025-05-20', '2025-07-04', 'kitchen, gas, stove', 'checkout', 'Screenshot 2024-09-18 200723.png', '2025-05-19 08:16:36', '2025-05-19 08:47:51'),
(47, '1-year', '2025-05-31', NULL, 'games', 'rejected', 'Screenshot 2024-09-29 204517.png', '2025-05-19 08:19:47', '2025-05-19 08:33:26'),
(48, '3-months', '2025-05-31', NULL, 'dgdf', 'rejected', 'Screenshot 2025-02-28 063737.png', '2025-05-20 17:00:30', '2025-05-20 17:03:17'),
(49, '6-months', '2025-05-24', NULL, 'adas', 'rejected', 'Screenshot 2025-02-28 063737.png', '2025-05-20 17:08:02', '2025-05-20 17:09:43');

-- --------------------------------------------------------

--
-- Table structure for table `application_user_room`
--

CREATE TABLE `application_user_room` (
  `application_user_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `application_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application_user_room`
--

INSERT INTO `application_user_room` (`application_user_id`, `user_id`, `room_id`, `application_id`) VALUES
(38, 3, 15, 40),
(40, 5, 14, 42),
(42, 1, 10, 44),
(43, 4, 13, 45),
(45, 8, 17, 47),
(46, 5, 12, 48),
(47, 5, 17, 49);

-- --------------------------------------------------------

--
-- Table structure for table `complaints`
--

CREATE TABLE `complaints` (
  `complaint_id` int(11) NOT NULL,
  `complaint_type` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `complaints`
--

INSERT INTO `complaints` (`complaint_id`, `complaint_type`, `description`, `created_at`, `updated_at`) VALUES
(11, 'Maintenance', 'The bathroom tap in Room  no 160 is leaking continuously, causing water to spill on the floor. This may lead to water wastage and slip hazards. Please arrange for urgent maintenance.', '2025-05-21 00:13:02', '2025-05-21 00:13:02'),
(12, 'Security', 'Last night, an unknown person was seen loitering near the hostel entrance after midnight. There was no security personnel present at that time. Kindly increase night-time security patrols.', '2025-05-21 00:13:15', '2025-05-21 00:13:15'),
(13, 'Other', 'There has been continuous loud noise coming from Room 108 late at night, including loud music and shouting. It disrupts sleep and creates an uncomfortable environment. Kindly take appropriate action to ensure peace and quiet during rest hours.', '2025-05-21 00:13:48', '2025-05-21 00:13:48'),
(14, 'Maintenance', 'ewrfhjklm;\'.', '2025-05-21 06:11:45', '2025-05-21 06:11:45'),
(15, 'Maintenance', 'Fridge and AC is not working', '2025-05-21 06:13:44', '2025-05-21 06:13:44'),
(16, 'Other', 'savdfbng', '2025-05-21 11:41:12', '2025-05-21 11:41:12'),
(17, 'Maintenance', 'sadfghj', '2025-05-21 11:41:19', '2025-05-21 11:41:19'),
(18, 'Security', 'dfsghj', '2025-05-21 11:41:24', '2025-05-21 11:41:24');

-- --------------------------------------------------------

--
-- Table structure for table `complaint_user_room`
--

CREATE TABLE `complaint_user_room` (
  `complaint_user_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `complaint_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `complaint_user_room`
--

INSERT INTO `complaint_user_room` (`complaint_user_id`, `user_id`, `complaint_id`) VALUES
(3, 1, 11),
(4, 1, 12),
(5, 1, 13),
(6, 1, 14),
(7, 1, 15),
(8, 1, 16),
(9, 1, 17),
(10, 1, 18);

-- --------------------------------------------------------

--
-- Table structure for table `emergency_contacts`
--

CREATE TABLE `emergency_contacts` (
  `emergency_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `relationship` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emergency_contacts`
--

INSERT INTO `emergency_contacts` (`emergency_id`, `name`, `relationship`, `phone_number`, `email`, `created_at`, `updated_at`) VALUES
(31, 'Jharana Grg', 'Sister', '9874561230', 'jharna@gmail.com', '2025-05-10 09:08:19', '2025-05-10 09:08:19'),
(32, 'Anish Kumal', 'Bro', '9801234567', 'anishkuma@gmail.com', '2025-05-11 06:26:56', '2025-05-11 06:26:56'),
(35, 'Jharana Gurung', 'Sister', '9874561230', 'jharana@gmail.com', '2025-05-17 10:25:44', '2025-05-17 10:25:44'),
(36, 'Durga Gurung', 'Mother', '9812346767', 'durgagrg@gmail.com', '2025-05-19 07:18:47', '2025-05-19 07:18:47'),
(37, 'Dhan Gurung', 'Father', '9843450089', 'dhangurung90@gmail.com', '2025-05-19 08:19:47', '2025-05-19 08:19:47');

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message` text DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`notice_id`, `title`, `message`, `type`, `created_at`, `updated_at`) VALUES
(12, 'Water supply', 'Water supply will be unavailable today from 5:00 PM to 9:00 AM tomorrow. Kindly store sufficient water in advance.', 'urgent', '2025-05-17 17:41:11', '2025-05-17 17:41:11'),
(13, 'Electrical maintenance', 'Electrical maintenance will take place in Block B on 20 May from 10:00 AM to 2:00 PM. Please avoid using high-power electrical appliances during this time.', 'maintenance', '2025-05-17 17:41:35', '2025-05-17 17:41:35'),
(17, 'Wifi Maintenance', 'sadfghjdfgnndfghmsafdfg', 'maintenance', '2025-05-21 10:40:58', '2025-05-21 10:40:58');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL,
  `room_number` varchar(10) NOT NULL,
  `room_type` varchar(255) NOT NULL,
  `room_description` text DEFAULT NULL,
  `room_facilities` text DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `current_occupancy` int(11) DEFAULT 0,
  `monthly_fee` int(11) NOT NULL,
  `is_available` tinyint(1) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `floor` varchar(110) NOT NULL,
  `room_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_number`, `room_type`, `room_description`, `room_facilities`, `capacity`, `current_occupancy`, `monthly_fee`, `is_available`, `image_url`, `created_at`, `updated_at`, `floor`, `room_status`) VALUES
(10, '103', 'Single Non-AC', 'fdsgd', 'TV, Refrigerator, Study Table, Wardrobe, Ceiling Fan, ', 1, 0, 182, 1, 'Room Single (3).jpg', '2025-05-01 10:05:54', '2025-05-20 17:05:26', '1st Floor', 'vacant'),
(12, '105', 'Double AC', 'dghfdg', 'TV, Refrigerator, Study Table, Attached Bathroom, WiFi,', 2, 0, 190, 1, 'Room Double (1).jpg', '2025-05-01 10:55:13', '2025-05-20 17:03:17', '2nd Floor', 'vacant'),
(13, '106', 'Single AC', 'single room', 'WiFi, TV, Refrigerator, Sofa, Attached Bathroom, Ceiling Fan,', 1, 0, 450, 1, 'Room Single (5).jpg', '2025-05-02 04:49:04', '2025-05-20 17:05:33', '2nd Floor', 'vacant'),
(14, '107', 'Single Non-AC', 'single room', 'WiFi, TV, Sofa, Study Table, Attached Bathroom, Ceiling Fan,', 1, 0, 500, 1, 'Room Single (6).jpg', '2025-05-02 04:49:36', '2025-05-18 09:18:31', '1st Floor', 'vacant'),
(15, '108', 'Single AC', 'single room with AC', 'WiFi, TV, Refrigerator, Attached Bathroom, Ceiling Fan,', 1, 1, 600, 0, 'Room Single (7).jpg', '2025-05-02 04:50:23', '2025-05-17 09:01:47', '2nd Floor', 'occupied'),
(16, '109', 'Single Non-AC', 'single room with no AC', 'WiFi, Refrigerator, Sofa, Attached Bathroom, Ceiling Fan,', 1, 0, 350, 1, 'Room Single (8).jpg', '2025-05-02 04:51:06', '2025-05-02 14:03:43', '1st Floor', 'vacant'),
(17, '110', 'Single AC', 'single room with AC', 'WiFi, TV, Refrigerator, Sofa, Study Table, Attached Bathroom, ', 1, 0, 420, 0, 'Room Single (9).jpg', '2025-05-02 04:51:46', '2025-05-20 17:09:43', '1st Floor', 'vacant'),
(19, '112', 'Single AC', 'Single room with AC', 'Sofa, Study Table, Attached Bathroom, Ceiling Fan,', 1, 0, 255, 1, 'Room Single (11).jpg', '2025-05-02 04:53:41', '2025-05-02 14:02:56', '1st Floor', 'vacant'),
(21, '114', 'Double Non-AC', 'Room with no double AC', 'TV, Sofa, Ceiling Fan, WiFi, Refrigerator, Study Table, ', 2, 0, 198, 1, 'Room Double (2).jpg', '2025-05-02 04:55:57', '2025-05-02 14:07:06', '1st Floor', 'vacant'),
(23, '116', 'Double Non-AC', 'Room with no double AC', 'WiFi, Sofa, Ceiling Fan, WiFi, Refrigerator, Study Table,', 2, 0, 205, 1, 'Room Double (4).jpg', '2025-05-02 04:57:20', '2025-05-02 14:07:41', '2nd Floor', 'vacant'),
(31, '124', 'Double Non-AC', 'Room with Non-AC', 'TV, Attached Bathroom, ', 2, 0, 175, 1, 'Room Double (12).jpg', '2025-05-02 05:04:11', '2025-05-18 09:18:58', '2nd Floor', 'maintenance');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `contact_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `profile_image_url` varchar(255) DEFAULT NULL,
  `role` varchar(50) DEFAULT 'customer',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `full_name`, `email`, `username`, `password`, `gender`, `date_of_birth`, `contact_number`, `address`, `profile_image_url`, `role`, `created_at`, `updated_at`) VALUES
(1, 'Sajina Gurung', 'sajinagrg1234@gmail.com', 'sajinagrg', 'WB8k0arJ4HTJyVSXmJMqFA==', 'Female', '2025-05-02', '9874561230', 'Lamjung', 'Screenshot 2024-09-18 200723.png', 'customer', '2025-04-19 14:23:59', '2025-05-21 00:54:09'),
(2, 'Anish Kumal', 'anishKumal098@gmail.com', 'anishkumal', 'D2ojJrorDzwG71KWk2MCSw==', 'male', NULL, NULL, NULL, NULL, 'admin', '2025-04-19 18:10:36', '2025-04-19 18:10:36'),
(3, 'Ayush Gurung', 'manojkumal1@outlook.com', 'grgayush', 'D2ojJrorDzwG71KWk2MCSw==', 'male', '2025-05-01', '9874561230', 'Lake', 'Screenshot 2024-09-18 200723.png', 'customer', '2025-04-20 04:19:27', '2025-05-17 09:01:47'),
(4, 'Soyana Gurung', 'jharanagrg@gmail.com', 'jharanagrg', 'D2ojJrorDzwG71KWk2MCSw==', 'female', '2002-09-01', '9812345678', 'Lamjung', 'Screenshot 2024-09-18 200723.png', 'customer', '2025-04-22 02:52:59', '2025-05-19 07:18:47'),
(5, 'Ayushree Gurung', 'ayushreegrg@gmail.com', 'ayushreegrg', 'mCQJULCnRgzVutBROhJ3Lg==', 'female', '2025-05-09', '9874561230', 'Lake', 'Screenshot 2025-02-28 063737.png', 'customer', '2025-05-02 06:14:17', '2025-05-20 17:08:02'),
(6, 'Rajani Shrestha', 'rajanistha567@gmail.com', 'rajanishrestha', 'TU9tpeeyDqooSSsVOz0+zA==', 'female', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:15:43', '2025-05-02 06:15:43'),
(7, 'Sunita Poudel', 'sunitapoudel12@gmail.com', 'sunitapoudel', '7mkvYVTV9UFm0ZiuLpCTlQ==', 'female', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:16:58', '2025-05-02 06:16:58'),
(8, 'Dipin Gurung', 'dipingrg11@gmail.com', 'dipingrg', 'HEDRkGRTC/DhmPD9DrXjEQ==', 'male', '2006-07-12', '9845285362', 'Ghandruk', 'Screenshot 2024-09-29 204517.png', 'customer', '2025-05-02 06:18:34', '2025-05-19 08:19:47'),
(9, 'Sujal Rimal', 'sujalrimal12@gmail.com', 'sujalrimal', '6im5y7fX6sEmy8aM9LxdgA==', 'male', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:20:55', '2025-05-02 06:20:55'),
(10, 'Soyana Rai', 'soyan1@gmail.com', 'soyana01', 'KAMX6NuDAWj+cgqXQwj3lA==', 'other', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:22:36', '2025-05-02 06:22:36'),
(11, 'Siwani Rana', 'siwani1@gmail.com', 'siwani09', '+dbvyKi7612J1YURiO3+FA==', 'other', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:24:21', '2025-05-02 06:24:21'),
(12, 'Suman Thapa', 'sumanthapa@gmail.com', 'suman34', '9pqQp3axu75FavxMSY1vjQ==', 'other', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:26:29', '2025-05-02 06:26:29'),
(13, 'Bishal Adhikari', 'adkbishal@gmail.com', 'bishal01', 'eLXCgmPXu3GC+xkRctVbcg==', 'other', NULL, NULL, NULL, NULL, 'customer', '2025-05-02 06:27:26', '2025-05-02 06:27:26');

-- --------------------------------------------------------

--
-- Table structure for table `user_associations`
--

CREATE TABLE `user_associations` (
  `association_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `notice_id` int(11) DEFAULT NULL,
  `emergency_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_associations`
--

INSERT INTO `user_associations` (`association_id`, `user_id`, `notice_id`, `emergency_id`) VALUES
(10, 1, NULL, 31),
(11, 3, NULL, 32),
(14, 5, NULL, 35),
(16, 11, 2, NULL),
(17, 12, 2, NULL),
(18, 13, 2, NULL),
(19, 14, 2, NULL),
(20, 15, 2, NULL),
(21, 16, 2, NULL),
(22, 4, NULL, 36),
(23, 8, NULL, 37),
(24, 17, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `wishlist_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `added_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`wishlist_id`, `user_id`, `room_id`, `added_at`) VALUES
(22, 2, 12, '2025-05-21 12:04:35'),
(27, 1, 10, '2025-05-21 12:54:54'),
(28, 1, 12, '2025-05-21 12:55:05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `application_user_room`
--
ALTER TABLE `application_user_room`
  ADD PRIMARY KEY (`application_user_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `application_id` (`application_id`);

--
-- Indexes for table `complaints`
--
ALTER TABLE `complaints`
  ADD PRIMARY KEY (`complaint_id`);

--
-- Indexes for table `complaint_user_room`
--
ALTER TABLE `complaint_user_room`
  ADD PRIMARY KEY (`complaint_user_id`),
  ADD KEY `complaint_id` (`complaint_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `emergency_contacts`
--
ALTER TABLE `emergency_contacts`
  ADD PRIMARY KEY (`emergency_id`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`notice_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD UNIQUE KEY `room_number` (`room_number`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_associations`
--
ALTER TABLE `user_associations`
  ADD PRIMARY KEY (`association_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `emergency_id` (`emergency_id`),
  ADD KEY `user_associations_ibfk_2` (`notice_id`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`wishlist_id`),
  ADD KEY `room_id` (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `application_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `application_user_room`
--
ALTER TABLE `application_user_room`
  MODIFY `application_user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `complaints`
--
ALTER TABLE `complaints`
  MODIFY `complaint_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `complaint_user_room`
--
ALTER TABLE `complaint_user_room`
  MODIFY `complaint_user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `emergency_contacts`
--
ALTER TABLE `emergency_contacts`
  MODIFY `emergency_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `notice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user_associations`
--
ALTER TABLE `user_associations`
  MODIFY `association_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `wishlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_user_room`
--
ALTER TABLE `application_user_room`
  ADD CONSTRAINT `application_user_room_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `application_user_room_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `application_user_room_ibfk_4` FOREIGN KEY (`application_id`) REFERENCES `applications` (`application_id`);

--
-- Constraints for table `complaint_user_room`
--
ALTER TABLE `complaint_user_room`
  ADD CONSTRAINT `complaint_user_room_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `complaint_user_room_ibfk_4` FOREIGN KEY (`complaint_id`) REFERENCES `complaints` (`complaint_id`),
  ADD CONSTRAINT `complaint_user_room_ibfk_5` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
