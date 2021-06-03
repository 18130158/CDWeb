-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 03, 2021 lúc 08:46 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `catergory`
--

CREATE TABLE `catergory` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `catergory`
--

INSERT INTO `catergory` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `code`, `name`) VALUES
(1, NULL, NULL, NULL, NULL, 'ngon-tinh', 'ngôn tình'),
(2, NULL, NULL, NULL, NULL, 'gia-dinh', 'gia đình'),
(3, NULL, NULL, NULL, NULL, 'lang-mang', 'lãng mạng');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `catergory`
--
ALTER TABLE `catergory`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `CATEGORY_UK` (`code`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `catergory`
--
ALTER TABLE `catergory`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
