-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3307
-- Thời gian đã tạo: Th3 12, 2025 lúc 04:14 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlst`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chamcongngay`
--

CREATE TABLE `chamcongngay` (
  `IdChamCong` int(11) NOT NULL,
  `MaNv` varchar(50) NOT NULL,
  `datetime` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chamcongngay`
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
(96, 'NV008', '2024-05-06 00:00:00'),
(97, 'nv008', '2025-02-19 00:00:00'),
(98, 'nv009', '2025-02-19 00:00:00'),
(99, 'nv008', '2025-02-22 00:00:00'),
(100, 'nv009', '2025-02-22 00:00:00'),
(101, 'nv008', '2025-02-25 00:00:00'),
(102, 'nv008', '2025-03-12 00:00:00'),
(103, 'nv009', '2025-03-12 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `ChucVu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `hesoluong` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`ChucVu`, `hesoluong`) VALUES
('Admin', 0),
('Nhân viên bán hàng', 0.4),
('Nhân viên kho', 0.9),
('Quản lý', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuyenchuc`
--

CREATE TABLE `chuyenchuc` (
  `id` int(11) NOT NULL,
  `MaNv` varchar(50) NOT NULL,
  `chucVu` varchar(20) NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chuyenchuc`
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
(28, 'NV016', 'Quản lý', '2024-05-06 00:00:00'),
(29, 'NV016', 'Nhân viên kho', '2025-02-22 00:00:00'),
(30, 'NV017', 'Nhân viên bán hàng', '2025-02-22 00:00:00'),
(31, 'NV018', 'Nhân viên kho', '2025-02-22 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctpn`
--

CREATE TABLE `ctpn` (
  `MaPn` varchar(50) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `DonGiaPn` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTienCTPn` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctpn`
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
-- Cấu trúc bảng cho bảng `ctpx`
--

CREATE TABLE `ctpx` (
  `MaPx` varchar(50) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `DonGiaCTPX` double DEFAULT NULL,
  `SoLuong` int(10) NOT NULL,
  `ThanhTienCTPX` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctpx`
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
-- Cấu trúc bảng cho bảng `donxinnghi`
--

CREATE TABLE `donxinnghi` (
  `maDon` varchar(50) NOT NULL,
  `maNV` varchar(50) NOT NULL,
  `lyDo` text DEFAULT NULL,
  `ngayNghi` date DEFAULT NULL,
  `ngayNopDon` date DEFAULT NULL,
  `ngayDuyet` date DEFAULT NULL,
  `trangThai` enum('ChuaXuLy','DaDuyet','TuChoi') NOT NULL DEFAULT 'ChuaXuLy'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `donxinnghi`
--

INSERT INTO `donxinnghi` (`maDon`, `maNV`, `lyDo`, `ngayNghi`, `ngayNopDon`, `ngayDuyet`, `trangThai`) VALUES
('DXN001', 'nv009', 'bệnh', '2025-03-15', '2025-03-12', NULL, 'ChuaXuLy'),
('DXN002', 'nv008', 'thích', '2025-03-18', '2025-03-12', '2025-03-12', 'DaDuyet'),
('DXN003', 'nv008', 'thích', '2025-03-19', '2025-03-12', NULL, 'ChuaXuLy');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLoai` varchar(50) NOT NULL,
  `TenLoai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoai`, `TenLoai`) VALUES
('LOAI12', 'Giày'),
('LOAI13', 'Dép');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `MaNv` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `login`
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
('NV016', '111'),
('NV017', '111'),
('NV018', '111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `luongthang`
--

CREATE TABLE `luongthang` (
  `MaNv` varchar(50) NOT NULL,
  `tongluong` decimal(10,0) DEFAULT NULL,
  `chucVu` varchar(20) NOT NULL,
  `datetime` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `luongthang`
--

INSERT INTO `luongthang` (`MaNv`, `tongluong`, `chucVu`, `datetime`) VALUES
('NV008', 0, 'Nhân viên bán hàng', '2023-02-01'),
('NV008', 0, 'Nhân viên bán hàng', '2023-03-01'),
('NV008', 0, 'Nhân viên bán hàng', '2023-04-01'),
('NV008', 0, 'Nhân viên bán hàng', '2024-02-11'),
('NV008', 22200000, 'Nhân viên bán hàng', '2024-04-17'),
('NV008', 3000000, 'Nhân viên bán hàng', '2024-05-06'),
('NV009', 0, 'Nhân viên kho', '2023-02-01'),
('NV009', 0, 'Nhân viên kho', '2023-03-01'),
('NV009', 0, 'Nhân viên kho', '2023-04-01'),
('NV009', 0, 'Nhân viên kho', '2024-02-11'),
('NV009', 2700000, 'Nhân viên kho', '2024-04-17'),
('NV009', 6750000, 'Nhân viên kho', '2024-05-06'),
('NV011', 0, 'Nhân viên kho', '2023-02-01'),
('NV011', 0, 'Nhân viên kho', '2023-03-01'),
('NV011', 0, 'Nhân viên kho', '2023-04-01'),
('NV011', 0, 'Nhân viên kho', '2024-02-11'),
('NV011', 0, 'Nhân viên kho', '2024-04-20'),
('NV011', 0, 'Nhân viên kho', '2024-05-06'),
('NV012', 0, 'Nhân viên bán hàng', '2023-02-01'),
('NV012', 0, 'Nhân viên bán hàng', '2023-03-01'),
('NV012', 0, 'Nhân viên bán hàng', '2023-04-01'),
('NV012', 0, 'Nhân viên bán hàng', '2024-02-11'),
('NV012', 0, 'Nhân viên bán hàng', '2024-04-20'),
('NV012', 0, 'Nhân viên bán hàng', '2024-05-06'),
('NV013', 0, 'Nhân viên kho', '2023-02-01'),
('NV013', 0, 'Nhân viên kho', '2023-03-01'),
('NV013', 8100000, 'Nhân viên kho', '2023-04-01'),
('NV013', 0, 'Nhân viên kho', '2024-02-11'),
('NV013', 0, 'Nhân viên kho', '2024-04-20'),
('NV013', 0, 'Nhân viên kho', '2024-05-06'),
('NV014', 0, 'Nhân viên bán hàng', '2023-02-01'),
('NV014', 3600000, 'Nhân viên bán hàng', '2023-03-01'),
('NV014', 0, 'Nhân viên bán hàng', '2023-04-01'),
('NV014', 0, 'Nhân viên bán hàng', '2024-02-11'),
('NV014', 0, 'Nhân viên bán hàng', '2024-04-20'),
('NV014', 0, 'Nhân viên bán hàng', '2024-05-06'),
('NV015', 9450000, 'Nhân viên kho', '2023-02-01'),
('NV015', 0, 'Nhân viên kho', '2023-03-01'),
('NV015', 0, 'Nhân viên kho', '2023-04-01'),
('NV015', 8100000, 'Nhân viên kho', '2024-02-11'),
('NV015', 0, 'Nhân viên kho', '2024-04-20'),
('NV015', 0, 'Nhân viên kho', '2024-05-06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ncc`
--

CREATE TABLE `ncc` (
  `MaNCC` varchar(50) NOT NULL,
  `TenNCC` varchar(100) NOT NULL,
  `Sdt` varchar(11) NOT NULL,
  `DcNCC` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ncc`
--

INSERT INTO `ncc` (`MaNCC`, `TenNCC`, `Sdt`, `DcNCC`) VALUES
('NCC1', 'Công ty TNHH Puma 2', '12345678', '123 Đường A, Quận B, TP Hồ Chí Minh'),
('NCC10', 'Vans, Inc', '01234567', '147 Đường BB, Quận CC, TP Hải Phòng'),
('NCC11', 'NCC Test', '098', 'HCM'),
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
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNv` varchar(50) NOT NULL,
  `HoNv` varchar(10) NOT NULL,
  `TenNv` varchar(50) NOT NULL,
  `DiaChiNv` varchar(100) NOT NULL,
  `ChucVu` varchar(20) NOT NULL,
  `TrangThai` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
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
('NV016', 'Nguyễn', 'Xuân Duy', 'HCM', 'Nhân viên kho', 0),
('NV017', 'Hoàng', 'Dung', 'HCM', 'Nhân viên bán hàng', 1),
('NV018', 'BB', 'AA', 'HN', 'Nhân viên kho', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasx`
--

CREATE TABLE `nhasx` (
  `MaNSX` varchar(50) NOT NULL,
  `TenNSX` varchar(50) NOT NULL,
  `Sdt` varchar(11) NOT NULL,
  `DcNSX` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhasx`
--

INSERT INTO `nhasx` (`MaNSX`, `TenNSX`, `Sdt`, `DcNSX`) VALUES
('NSX1', 'Puma', '12345678', '123 Đường A, Quận B, TP Hồ Chí Minh'),
('NSX10', 'Vans', '01234567', '147 Đường BB, Quận CC, TP Hải Phòng'),
('NSX11', 'Duy', '0123', 'HCM'),
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
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPn` varchar(50) NOT NULL,
  `MaNv` varchar(50) NOT NULL,
  `NgayNhap` date NOT NULL,
  `ThanhTienPn` double NOT NULL,
  `MaNCC` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPn`, `MaNv`, `NgayNhap`, `ThanhTienPn`, `MaNCC`) VALUES
('PN001', 'NV009', '2024-04-22', 65000000, 'NCC10'),
('PN002', 'NV009', '2023-04-22', 10000000, 'NCC3'),
('PN003', 'NV009', '2023-06-20', 12500000, 'NCC5'),
('PN004', 'NV009', '2024-02-21', 5000000, 'NCC7'),
('PN005', 'NV009', '2024-05-06', 25000000, 'NCC2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPx` varchar(50) NOT NULL,
  `MaNv` varchar(50) NOT NULL,
  `NgayXuat` date NOT NULL,
  `TongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
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
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(50) NOT NULL,
  `MaNSX` varchar(50) NOT NULL,
  `MaLoai` varchar(50) NOT NULL,
  `TenSP` varchar(100) NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TrangThai` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `MaNSX`, `MaLoai`, `TenSP`, `DonGia`, `SoLuong`, `TrangThai`) VALUES
('SANPHAM001', 'NSX1', 'LOAI12', 'Sneaker 01', 2000000, 0, 1),
('SANPHAM002', 'NSX7', 'LOAI12', 'Sneaker 02', 1000000, 105, 1),
('SANPHAM003', 'NSX5', 'LOAI13', 'Dép thời trang 01', 1500000, 100, 1),
('SANPHAM004', 'NSX6', 'LOAI13', 'Dép thời trang 02', 500000, 210, 1),
('SANPHAM005', 'NSX7', 'LOAI12', 'Bata trắng', 5000000, 195, 1),
('SANPHAM006', 'NSX6', 'LOAI13', 'test', 200000, 9, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chamcongngay`
--
ALTER TABLE `chamcongngay`
  ADD PRIMARY KEY (`IdChamCong`),
  ADD UNIQUE KEY `MaNv` (`MaNv`,`datetime`);

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`ChucVu`);

--
-- Chỉ mục cho bảng `chuyenchuc`
--
ALTER TABLE `chuyenchuc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `MaNv` (`MaNv`),
  ADD KEY `chucVu` (`chucVu`);

--
-- Chỉ mục cho bảng `ctpn`
--
ALTER TABLE `ctpn`
  ADD PRIMARY KEY (`MaPn`,`MaSP`),
  ADD KEY `MaPn` (`MaPn`),
  ADD KEY `MaSach` (`MaSP`) USING BTREE;

--
-- Chỉ mục cho bảng `ctpx`
--
ALTER TABLE `ctpx`
  ADD PRIMARY KEY (`MaPx`,`MaSP`),
  ADD KEY `MaHd` (`MaPx`),
  ADD KEY `MaSach` (`MaSP`) USING BTREE;

--
-- Chỉ mục cho bảng `donxinnghi`
--
ALTER TABLE `donxinnghi`
  ADD PRIMARY KEY (`maDon`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`MaNv`);

--
-- Chỉ mục cho bảng `luongthang`
--
ALTER TABLE `luongthang`
  ADD PRIMARY KEY (`MaNv`,`datetime`),
  ADD KEY `chucVu` (`chucVu`);

--
-- Chỉ mục cho bảng `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNv`),
  ADD KEY `ChucVu` (`ChucVu`);

--
-- Chỉ mục cho bảng `nhasx`
--
ALTER TABLE `nhasx`
  ADD PRIMARY KEY (`MaNSX`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPn`),
  ADD KEY `pn1` (`MaNv`),
  ADD KEY `pn2` (`MaNCC`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPx`),
  ADD KEY `hd1` (`MaNv`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `s1` (`MaNSX`),
  ADD KEY `s3` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chamcongngay`
--
ALTER TABLE `chamcongngay`
  MODIFY `IdChamCong` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT cho bảng `chuyenchuc`
--
ALTER TABLE `chuyenchuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctpn`
--
ALTER TABLE `ctpn`
  ADD CONSTRAINT `ctpn1` FOREIGN KEY (`MaPn`) REFERENCES `phieunhap` (`MaPn`),
  ADD CONSTRAINT `ctpn2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Các ràng buộc cho bảng `ctpx`
--
ALTER TABLE `ctpx`
  ADD CONSTRAINT `cthd1` FOREIGN KEY (`MaPx`) REFERENCES `phieuxuat` (`MaPx`),
  ADD CONSTRAINT `cthd2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Các ràng buộc cho bảng `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`);

--
-- Các ràng buộc cho bảng `luongthang`
--
ALTER TABLE `luongthang`
  ADD CONSTRAINT `luongthang_ibfk_1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
  ADD CONSTRAINT `luongthang_ibfk_2` FOREIGN KEY (`chucVu`) REFERENCES `chucvu` (`ChucVu`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`ChucVu`) REFERENCES `chucvu` (`ChucVu`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `pn1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
  ADD CONSTRAINT `pn2` FOREIGN KEY (`MaNCC`) REFERENCES `ncc` (`MaNCC`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `hd1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `s1` FOREIGN KEY (`MaNSX`) REFERENCES `nhasx` (`MaNSX`),
  ADD CONSTRAINT `s3` FOREIGN KEY (`MaLoai`) REFERENCES `loaisanpham` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
