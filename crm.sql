-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2020 a las 03:17:49
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idClientes` int(11) NOT NULL,
  `razonSocial` varchar(100) NOT NULL,
  `cuit` varchar(30) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idClientes`, `razonSocial`, `cuit`, `direccion`) VALUES
(1, 'Chevron', '20399109761', 'Madero 940 piso 2'),
(2, 'ACA', '20452163587', 'Juan Maria Campos 2705'),
(3, 'Sancor Seguros', '25388456321', 'Independencia 4071');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `idFacturas` int(11) NOT NULL,
  `cliente_f` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`idFacturas`, `cliente_f`, `tipo`, `monto`) VALUES
(1, 1, 'A', 250000),
(2, 1, 'A', 50000),
(3, 2, 'A', 200),
(4, 2, 'A', 2000),
(5, 3, 'A', 50000),
(6, 3, 'A', 25000),
(7, 3, 'A', 2500),
(8, 3, 'A', 250000),
(9, 1, 'A', 2500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `idPagos` int(11) NOT NULL,
  `factura` int(11) NOT NULL,
  `cliente_p` int(11) NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`idPagos`, `factura`, `cliente_p`, `monto`) VALUES
(1, 1, 1, 2000),
(2, 2, 1, 5000),
(3, 3, 2, 200),
(4, 4, 2, 2000),
(5, 5, 3, 50000),
(6, 6, 3, 25000),
(7, 7, 3, 2500),
(8, 8, 3, 250000),
(9, 9, 1, 500);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idClientes`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`idFacturas`),
  ADD KEY `cliente_f_idx` (`cliente_f`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`idPagos`),
  ADD KEY `cliente_p_idx` (`cliente_p`),
  ADD KEY `factura_idx` (`factura`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idClientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `idFacturas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `idPagos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `cliente_f` FOREIGN KEY (`cliente_f`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `cliente_p` FOREIGN KEY (`cliente_p`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura` FOREIGN KEY (`factura`) REFERENCES `facturas` (`idFacturas`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
