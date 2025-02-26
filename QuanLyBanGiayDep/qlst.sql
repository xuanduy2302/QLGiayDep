-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 14, 2024 at 01:46 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlst`
--

-- --------------------------------------------------------

--
-- Table structure for table `chamcongngay`
--

DROP TABLE IF EXISTS `chamcongngay`;
CREATE TABLE IF NOT EXISTS `chamcongngay` (
  `IdChamCong` int(11) NOT NULL AUTO_INCREMENT,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`IdChamCong`),
  UNIQUE KEY `MaNv` (`MaNv`,`datetime`)
) ENGINE=MyISAM AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `chamcongngay`
--

INSERT INTO `chamcongngay` (`IdChamCong`, `MaNv`, `datetime`) VALUES
(14, 'NV007', '2024-04-08 00:00:00'),
(15, 'NV007', '2024-04-09 00:00:00'),
(16, 'NV007', '2024-04-16 00:00:00'),
(17, 'NV008', '2024-04-01 00:00:00'),
(18, 'NV008', '2024-04-02 00:00:00'),
(19, 'NV008', '2024-04-03 00:00:00'),
(20, 'NV008', '2024-04-04 00:00:00'),
(21, 'NV008', '2024-04-05 00:00:00'),
(22, 'NV008', '2024-04-06 00:00:00'),
(23, 'NV008', '2024-04-07 00:00:00'),
(24, 'NV008', '2024-04-08 00:00:00'),
(25, 'NV008', '2024-04-09 00:00:00'),
(26, 'NV008', '2024-04-10 00:00:00'),
(27, 'NV008', '2024-04-11 00:00:00'),
(28, 'NV008', '2024-04-12 00:00:00'),
(29, 'NV008', '2024-04-13 00:00:00'),
(30, 'NV008', '2024-04-14 00:00:00'),
(31, 'NV008', '2024-04-15 00:00:00'),
(32, 'NV008', '2024-04-16 00:00:00'),
(33, 'NV008', '2024-04-17 00:00:00'),
(64, 'NV015', '2024-02-18 00:00:00'),
(63, 'NV015', '2024-02-19 00:00:00'),
(38, 'NV008', '2024-04-19 00:00:00'),
(37, 'NV009', '2024-04-16 00:00:00'),
(62, 'NV015', '2023-02-09 00:00:00'),
(61, 'NV015', '2023-02-08 00:00:00'),
(60, 'NV015', '2023-02-07 00:00:00'),
(59, 'NV015', '2023-02-06 00:00:00'),
(58, 'NV015', '2023-02-05 00:00:00'),
(57, 'NV015', '2023-02-04 00:00:00'),
(56, 'NV015', '2023-02-02 00:00:00'),
(55, 'NV015', '2023-02-01 00:00:00'),
(65, 'NV015', '2024-02-17 00:00:00'),
(66, 'NV015', '2024-02-16 00:00:00'),
(67, 'NV015', '2024-02-15 00:00:00'),
(68, 'NV015', '2024-02-20 00:00:00'),
(69, 'NV014', '2023-03-01 00:00:00'),
(70, 'NV014', '2023-03-02 00:00:00'),
(71, 'NV014', '2023-03-04 00:00:00'),
(72, 'NV014', '2023-03-05 00:00:00'),
(73, 'NV014', '2023-03-06 00:00:00'),
(74, 'NV014', '2023-03-07 00:00:00'),
(75, 'NV014', '2023-03-08 00:00:00'),
(92, 'NV008', '2024-04-27 00:00:00'),
(91, 'NV008', '2024-04-23 00:00:00'),
(90, 'NV009', '2024-04-23 00:00:00'),
(89, 'NV009', '2024-04-22 00:00:00'),
(88, 'NV008', '2024-04-22 00:00:00'),
(81, 'NV013', '2023-04-01 00:00:00'),
(82, 'NV013', '2023-04-02 00:00:00'),
(83, 'NV013', '2023-04-04 00:00:00'),
(84, 'NV013', '2023-04-05 00:00:00'),
(85, 'NV013', '2023-04-06 00:00:00'),
(86, 'NV013', '2023-04-07 00:00:00'),
(87, 'NV013', '2023-04-08 00:00:00'),
(93, 'NV008', '2024-05-05 00:00:00'),
(94, 'NV009', '2024-05-05 00:00:00'),
(95, 'NV009', '2024-05-06 00:00:00'),
(96, 'NV008', '2024-05-06 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
CREATE TABLE IF NOT EXISTS `chucvu` (
  `ChucVu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `hesoluong` double DEFAULT NULL,
  PRIMARY KEY (`ChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`ChucVu`, `hesoluong`) VALUES
('Admin', 0),
('Nhân viên bán hàng', 0.4),
('Nhân viên kho', 0.9),
('Quản lý', 0);

-- --------------------------------------------------------

--
-- Table structure for table `chuyenchuc`
--

DROP TABLE IF EXISTS `chuyenchuc`;
CREATE TABLE IF NOT EXISTS `chuyenchuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `chucVu` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `MaNv` (`MaNv`),
  KEY `chucVu` (`chucVu`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `chuyenchuc`
--

INSERT INTO `chuyenchuc` (`id`, `MaNv`, `chucVu`, `datetime`) VALUES
(1, 'NV008', 'Nhân viên kho', '2024-03-15 10:00:00'),
(21, 'NV008', 'Nhân viên bán hàng', '2024-05-05 00:00:00'),
(22, 'NV009', 'Nhân viên kho', '2024-05-05 00:00:00'),
(20, 'NV007', 'Quản lý', '2024-05-05 00:00:00'),
(5, 'NV009', 'Nhân viên kho', '2024-03-14 00:00:00'),
(6, 'NV010', 'Nhân viên kho', '2024-03-14 00:00:00'),
(7, 'NV011', 'Nhân viên kho', '2024-03-14 00:00:00'),
(8, 'NV012', 'Nhân viên bán hàng', '2024-03-14 00:00:00'),
(9, 'NV013', 'Nhân viên kho', '2023-04-01 01:01:01'),
(10, 'NV014', 'Nhân viên bán hàng', '2023-03-01 00:00:00'),
(12, 'NV015', 'Nhân viên kho', '2023-02-01 01:01:01'),
(19, 'NV008', 'Nhân viên bán hàng', '2024-04-17 00:00:00'),
(23, 'NV010', 'Nhân viên kho', '2024-05-05 00:00:00'),
(24, 'NV011', 'Nhân viên kho', '2024-05-05 00:00:00'),
(25, 'NV012', 'Nhân viên bán hàng', '2024-05-05 00:00:00'),
(26, 'NV013', 'Nhân viên kho', '2024-05-05 00:00:00'),
(27, 'NV014', 'Nhân viên bán hàng', '2024-05-05 00:00:00'),
(28, 'NV016', 'Quản lý', '2024-05-06 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `ctpn`
--

DROP TABLE IF EXISTS `ctpn`;
CREATE TABLE IF NOT EXISTS `ctpn` (
  `MaPn` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGiaPn` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTienCTPn` double NOT NULL,
  PRIMARY KEY (`MaPn`,`MaSP`),
  KEY `MaPn` (`MaPn`),
  KEY `MaSach` (`MaSP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ctpn`
--

INSERT INTO `ctpn` (`MaPn`, `MaSP`, `DonGiaPn`, `SoLuong`, `ThanhTienCTPn`) VALUES
('PN001', 'SANPHAM001', 2000000, 10, 20000000),
('PN001', 'SANPHAM005', 5000000, 9, 45000000),
('PN002', 'SANPHAM002', 1000000, 10, 10000000),
('PN003', 'SANPHAM003', 1500000, 5, 7500000),
('PN003', 'SANPHAM004', 500000, 10, 5000000),
('PN004', 'SANPHAM005', 5000000, 1, 5000000),
('PN005', 'SANPHAM001', 2000000, 10, 20000000),
('PN005', 'SANPHAM002', 1000000, 5, 5000000);

-- --------------------------------------------------------

--
-- Table structure for table `ctpx`
--

DROP TABLE IF EXISTS `ctpx`;
CREATE TABLE IF NOT EXISTS `ctpx` (
  `MaPx` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGiaCTPX` double DEFAULT NULL,
  `SoLuong` int(10) NOT NULL,
  `ThanhTienCTPX` double DEFAULT NULL,
  PRIMARY KEY (`MaPx`,`MaSP`),
  KEY `MaHd` (`MaPx`),
  KEY `MaSach` (`MaSP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ctpx`
--

INSERT INTO `ctpx` (`MaPx`, `MaSP`, `DonGiaCTPX`, `SoLuong`, `ThanhTienCTPX`) VALUES
('PX001', 'SANPHAM001', 2000000, 10, 20000000),
('PX002', 'SANPHAM002', 1000000, 10, 10000000),
('PX003', 'SANPHAM003', 1500000, 5, 7500000),
('PX004', 'SANPHAM005', 5000000, 10, 50000000),
('PX005', 'SANPHAM005', 5000000, 5, 25000000),
('PX006', 'SANPHAM001', 2000000, 110, 220000000);

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

DROP TABLE IF EXISTS `loaisanpham`;
CREATE TABLE IF NOT EXISTS `loaisanpham` (
  `MaLoai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenLoai` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoai`, `TenLoai`) VALUES
('LOAI12', 'Giày'),
('LOAI13', 'Dép');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`MaNv`, `Password`) VALUES
('NV006', '111'),
('NV007', '111'),
('NV008', '111'),
('NV009', '111'),
('NV010', '111'),
('NV011', '111'),
('NV012', '111'),
('NV013', '111'),
('NV014', '111'),
('NV015', '111'),
('NV016', '111');

-- --------------------------------------------------------

--
-- Table structure for table `luongthang`
--

DROP TABLE IF EXISTS `luongthang`;
CREATE TABLE IF NOT EXISTS `luongthang` (
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongluong` decimal(10,0) DEFAULT NULL,
  `chucVu` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datetime` date NOT NULL,
  PRIMARY KEY (`MaNv`,`datetime`),
  KEY `chucVu` (`chucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `luongthang`
--

INSERT INTO `luongthang` (`MaNv`, `tongluong`, `chucVu`, `datetime`) VALUES
('NV008', '0', 'Nhân viên bán hàng', '2023-02-01'),
('NV008', '0', 'Nhân viên bán hàng', '2023-03-01'),
('NV008', '0', 'Nhân viên bán hàng', '2023-04-01'),
('NV008', '0', 'Nhân viên bán hàng', '2024-02-11'),
('NV008', '22200000', 'Nhân viên bán hàng', '2024-04-17'),
('NV008', '3000000', 'Nhân viên bán hàng', '2024-05-06'),
('NV009', '0', 'Nhân viên kho', '2023-02-01'),
('NV009', '0', 'Nhân viên kho', '2023-03-01'),
('NV009', '0', 'Nhân viên kho', '2023-04-01'),
('NV009', '0', 'Nhân viên kho', '2024-02-11'),
('NV009', '2700000', 'Nhân viên kho', '2024-04-17'),
('NV009', '6750000', 'Nhân viên kho', '2024-05-06'),
('NV011', '0', 'Nhân viên kho', '2023-02-01'),
('NV011', '0', 'Nhân viên kho', '2023-03-01'),
('NV011', '0', 'Nhân viên kho', '2023-04-01'),
('NV011', '0', 'Nhân viên kho', '2024-02-11'),
('NV011', '0', 'Nhân viên kho', '2024-04-20'),
('NV011', '0', 'Nhân viên kho', '2024-05-06'),
('NV012', '0', 'Nhân viên bán hàng', '2023-02-01'),
('NV012', '0', 'Nhân viên bán hàng', '2023-03-01'),
('NV012', '0', 'Nhân viên bán hàng', '2023-04-01'),
('NV012', '0', 'Nhân viên bán hàng', '2024-02-11'),
('NV012', '0', 'Nhân viên bán hàng', '2024-04-20'),
('NV012', '0', 'Nhân viên bán hàng', '2024-05-06'),
('NV013', '0', 'Nhân viên kho', '2023-02-01'),
('NV013', '0', 'Nhân viên kho', '2023-03-01'),
('NV013', '8100000', 'Nhân viên kho', '2023-04-01'),
('NV013', '0', 'Nhân viên kho', '2024-02-11'),
('NV013', '0', 'Nhân viên kho', '2024-04-20'),
('NV013', '0', 'Nhân viên kho', '2024-05-06'),
('NV014', '0', 'Nhân viên bán hàng', '2023-02-01'),
('NV014', '3600000', 'Nhân viên bán hàng', '2023-03-01'),
('NV014', '0', 'Nhân viên bán hàng', '2023-04-01'),
('NV014', '0', 'Nhân viên bán hàng', '2024-02-11'),
('NV014', '0', 'Nhân viên bán hàng', '2024-04-20'),
('NV014', '0', 'Nhân viên bán hàng', '2024-05-06'),
('NV015', '9450000', 'Nhân viên kho', '2023-02-01'),
('NV015', '0', 'Nhân viên kho', '2023-03-01'),
('NV015', '0', 'Nhân viên kho', '2023-04-01'),
('NV015', '8100000', 'Nhân viên kho', '2024-02-11'),
('NV015', '0', 'Nhân viên kho', '2024-04-20'),
('NV015', '0', 'Nhân viên kho', '2024-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

DROP TABLE IF EXISTS `ncc`;
CREATE TABLE IF NOT EXISTS `ncc` (
  `MaNCC` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNCC` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DcNCC` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ncc`
--

INSERT INTO `ncc` (`MaNCC`, `TenNCC`, `Sdt`, `DcNCC`) VALUES
('NCC1', 'Công ty TNHH Puma 2', '12345678', '123 Đường A, Quận B, TP Hồ Chí Minh'),
('NCC10', 'Vans, Inc', '01234567', '147 Đường BB, Quận CC, TP Hải Phòng'),
('NCC2', 'Công ty Adidas Việt Nam', '23456789', '456 Đường D, Quận E, TP Hà Nội'),
('NCC3', 'Nike Việt Nam', '34567890', '789 Đường G, Quận H, TP Đà Nẵng'),
('NCC4', 'Reebok International Ltd', '45678901', '321 Đường J, Quận K, TP Cần Thơ'),
('NCC5', 'Under Armour Việt Nam', '56789012', '654 Đường M, Quận N, TP Huế'),
('NCC6', 'New Balance Athletics, Inc', '67890123', '987 Đường P, Quận Q, TP Vũng Tàu'),
('NCC7', 'Asics Corporation', '78901234', '135 Đường S, Quận T, TP Nha Trang'),
('NCC8', 'Skechers USA, Inc', '89012345', '246 Đường V, Quận W, TP Đà Lạt'),
('NCC9', 'Converse Inc', '90123456', '369 Đường Y, Quận Z, TP Phú Quốc');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HoNv` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChiNv` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ChucVu` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TrangThai` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaNv`),
  KEY `ChucVu` (`ChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNv`, `HoNv`, `TenNv`, `DiaChiNv`, `ChucVu`, `TrangThai`) VALUES
('NV006', 'Love', 'In The Morning', 'Long An', 'Admin', 1),
('NV007', 'Nguyễn', 'Thị Yêu Anh Thư', 'Bình Định', 'Quản lý', 1),
('NV008', 'Lê', 'Thị Ngọc Mai', 'TPHCM', 'Nhân viên bán hàng', 1),
('NV009', 'Võ', 'Huyền', 'TPHCM', 'Nhân viên kho', 1),
('NV010', 'Trần', 'Nguyễn Thiên An', 'TPHCM', 'Nhân viên kho', 0),
('NV011', 'Lê 2', 'Văn Quyết', '190/4 su van hanh', 'Nhân viên bán hàng', 1),
('NV012', 'Lê', 'Công Phượng', 'hai phong', 'Nhân viên bán hàng', 1),
('NV013', 'Trịnh', 'Trần Phương Tuấn', 'Nam Định', 'Nhân viên kho', 1),
('NV014', 'Vũ', 'Đinh Trọng Thắng', 'su van hanh', 'Nhân viên bán hàng', 1),
('NV015', 'Trương', 'Mỹ Lan', 'that next place', 'Nhân viên kho', 1),
('NV016', 'ree', 'Test', 'aaa', 'Quản lý', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhasx`
--

DROP TABLE IF EXISTS `nhasx`;
CREATE TABLE IF NOT EXISTS `nhasx` (
  `MaNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DcNSX` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNSX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhasx`
--

INSERT INTO `nhasx` (`MaNSX`, `TenNSX`, `Sdt`, `DcNSX`) VALUES
('NSX1', 'Puma', '12345678', '123 Đường A, Quận B, TP Hồ Chí Minh'),
('NSX10', 'Vans', '01234567', '147 Đường BB, Quận CC, TP Hải Phòng'),
('NSX2', 'Adidas', '23456789', '456 Đường D, Quận E, TP Hà Nội'),
('NSX3', 'Nike', '34567890', '789 Đường G, Quận H, TP Đà Nẵng'),
('NSX4', 'Reebok', '45678901', '321 Đường J, Quận K, TP Cần Thơ'),
('NSX5', 'Under Armour', '56789012', '654 Đường M, Quận N, TP Huế'),
('NSX6', 'New Balance', '67890123', '987 Đường P, Quận Q, TP Vũng Tàu'),
('NSX7', 'Asics', '78901234', '135 Đường S, Quận T, TP Nha Trang'),
('NSX8', 'Skechers', '89012345', '246 Đường V, Quận W, TP Đà Lạt'),
('NSX9', 'Converse', '90123456', '369 Đường Y, Quận Z, TP Phú Quốc');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `MaPn` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `ThanhTienPn` double NOT NULL,
  `MaNCC` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MaPn`),
  KEY `pn1` (`MaNv`),
  KEY `pn2` (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPn`, `MaNv`, `NgayNhap`, `ThanhTienPn`, `MaNCC`) VALUES
('PN001', 'NV009', '2024-04-22', 65000000, 'NCC1'),
('PN002', 'NV009', '2023-04-22', 10000000, 'NCC3'),
('PN003', 'NV009', '2023-06-20', 12500000, 'NCC5'),
('PN004', 'NV009', '2024-02-21', 5000000, 'NCC7'),
('PN005', 'NV009', '2024-05-06', 25000000, 'NCC2');

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

DROP TABLE IF EXISTS `phieuxuat`;
CREATE TABLE IF NOT EXISTS `phieuxuat` (
  `MaPx` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayXuat` date NOT NULL,
  `TongTien` double NOT NULL,
  PRIMARY KEY (`MaPx`),
  KEY `hd1` (`MaNv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPx`, `MaNv`, `NgayXuat`, `TongTien`) VALUES
('PX001', 'NV008', '2024-04-22', 20000000),
('PX002', 'NV008', '2023-04-04', 10000000),
('PX003', 'NV008', '2024-02-21', 7500000),
('PX004', 'NV008', '2023-01-01', 50000000),
('PX005', 'NV008', '2024-03-28', 25000000),
('PX006', 'NV008', '2024-05-06', 220000000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TrangThai` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaSP`),
  KEY `s1` (`MaNSX`),
  KEY `s3` (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `MaNSX`, `MaLoai`, `TenSP`, `DonGia`, `SoLuong`, `TrangThai`) VALUES
('SANPHAM001', 'NSX1', 'LOAI12', 'Sneaker 01', 2000000, 0, 1),
('SANPHAM002', 'NSX7', 'LOAI12', 'Sneaker 02', 1000000, 105, 1),
('SANPHAM003', 'NSX5', 'LOAI13', 'Dép thời trang 01', 1500000, 100, 1),
('SANPHAM004', 'NSX6', 'LOAI13', 'Dép thời trang 02', 500000, 210, 1),
('SANPHAM005', 'NSX7', 'LOAI12', 'Bata trắng', 5000000, 195, 1),
('SANPHAM006', 'NSX6', 'LOAI13', 'test', 200000, 9, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctpn`
--
ALTER TABLE `ctpn`
  ADD CONSTRAINT `ctpn1` FOREIGN KEY (`MaPn`) REFERENCES `phieunhap` (`MaPn`),
  ADD CONSTRAINT `ctpn2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `ctpx`
--
ALTER TABLE `ctpx`
  ADD CONSTRAINT `cthd1` FOREIGN KEY (`MaPx`) REFERENCES `phieuxuat` (`MaPx`),
  ADD CONSTRAINT `cthd2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`);

--
-- Constraints for table `luongthang`
--
ALTER TABLE `luongthang`
  ADD CONSTRAINT `luongthang_ibfk_1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
  ADD CONSTRAINT `luongthang_ibfk_2` FOREIGN KEY (`chucVu`) REFERENCES `chucvu` (`ChucVu`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`ChucVu`) REFERENCES `chucvu` (`ChucVu`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `pn1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
  ADD CONSTRAINT `pn2` FOREIGN KEY (`MaNCC`) REFERENCES `ncc` (`MaNCC`);

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `hd1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `s1` FOREIGN KEY (`MaNSX`) REFERENCES `nhasx` (`MaNSX`),
  ADD CONSTRAINT `s3` FOREIGN KEY (`MaLoai`) REFERENCES `loaisanpham` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
