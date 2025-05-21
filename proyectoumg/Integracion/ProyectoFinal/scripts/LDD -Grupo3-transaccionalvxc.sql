-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2025 a las 19:31:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sig2k25`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccionalvxc`
--

CREATE TABLE `transaccionalvxc` (
  `no_factura` int(11) NOT NULL,
  `no_venta` varchar(8) NOT NULL,
  `id_vendedor` int(11) DEFAULT NULL,
  `nombre_cliente` varchar(60) DEFAULT NULL,
  `apellido_cliente` varchar(60) DEFAULT NULL,
  `proCodigo` int(11) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `proPrecios` double(60,2) DEFAULT NULL,
  `saldo_actual` decimal(12,2) DEFAULT NULL,
  `proNombre` varchar(60) DEFAULT NULL,
  `dias_credito` int(11) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `precio_producto` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `transaccionalvxc`
--

INSERT INTO `transaccionalvxc` (`no_factura`, `no_venta`, `id_vendedor`, `nombre_cliente`, `apellido_cliente`, `proCodigo`, `cantidad`, `proPrecios`, `saldo_actual`, `proNombre`, `dias_credito`, `total`, `precio_producto`) VALUES
(3, '27', 3, 'Vicoromar', 'gomez', 10, 2, 106.00, 2500.00, 'ElPepe', 10, 2712.00, NULL),
(3, '46', 3, 'Vicoromar', 'gomez', 20, 2, 200.00, 2500.00, 'Disco Duro', 10, 2900.00, NULL),
(13, '328', 1, 'Vicoromar', 'gomez', 10, 2, 106.00, 2500.00, 'ElPepe', 10, 2712.00, NULL),
(14, '328', 1, 'Vicoromar', 'gomez', 20, 2, 200.00, 2500.00, 'Disco Duro', 10, 2900.00, NULL),
(15, '', 1, 'Vicoromar', 'gomez', 20, 3, 200.00, 2500.00, 'Disco Duro', 10, 3100.00, NULL),
(16, '081', 3, 'Carlos', 'Calderon', 20, 2, 200.00, 20.00, 'Disco Duro', 20, 420.00, NULL),
(17, '081', 3, 'Carlos', 'Calderon', 10, 2, 106.00, 20.00, 'ElPepe', 20, 232.00, NULL),
(18, '', 3, 'Vicoromar', 'gomez', 20, 1, 200.00, 2500.00, 'Disco Duro', 10, 2700.00, NULL),
(19, '578', 3, 'Vicoromar', 'gomez', 20, 3, 200.00, 2500.00, 'Disco Duro', 10, 3100.00, NULL),
(20, '578', 3, 'Vicoromar', 'gomez', 10, 3, 106.00, 2500.00, 'ElPepe', 10, 2818.00, NULL),
(21, '598', 3, 'Carlos', 'Calderon', 10, 3, 106.00, 20.00, 'ElPepe', 20, 338.00, NULL),
(22, '320', 3, 'Vicoromar', 'gomez', 20, 6, 200.00, 2500.00, 'Disco Duro', 10, 3700.00, NULL),
(23, '13', 3, 'Carlos', 'Calderon', 10, 10, 106.00, 20.00, 'ElPepe', 20, 1080.00, NULL),
(24, '95', 3, 'Carlos', 'Calderon', 20, 2, 200.00, 20.00, 'Disco Duro', 20, 420.00, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `transaccionalvxc`
--
ALTER TABLE `transaccionalvxc`
  ADD PRIMARY KEY (`no_factura`,`no_venta`),
  ADD KEY `id_vendedor` (`id_vendedor`),
  ADD KEY `proCodigo` (`proCodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
