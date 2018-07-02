-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2018 a las 17:34:48
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `planificacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `idAsignatura` varchar(6) NOT NULL,
  `asignatura` varchar(100) NOT NULL,
  `horasTeoricas` int(2) NOT NULL,
  `horasPracticas` int(2) NOT NULL,
  `numeroUnidades` int(2) NOT NULL,
  `nombrePdf` varchar(500) NOT NULL,
  `descripcionPdf` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodologia`
--

CREATE TABLE `metodologia` (
  `idMetodologia` varchar(3) NOT NULL,
  `metodologia` varchar(500) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodologiaasignatura`
--

CREATE TABLE `metodologiaasignatura` (
  `idMetodologia` varchar(3) NOT NULL,
  `idAsignatura` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subunidad`
--

CREATE TABLE `subunidad` (
  `idSubUnidad` varchar(3) NOT NULL,
  `nombre` varchar(500) NOT NULL,
  `nombrePdf` varchar(500) NOT NULL,
  `pdfSubUnidad` longblob NOT NULL,
  `idUnidad` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

CREATE TABLE `unidad` (
  `idUnidad` varchar(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `numeroUnidad` int(2) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `idAsignatura` varchar(6) NOT NULL,
  `nombrePdf` varchar(500) NOT NULL,
  `pdfUnidad` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` varchar(4) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `edad` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `usuario`, `password`, `nombre`, `apellido`, `edad`) VALUES
('aa1', 'admin', '123', 'absjasj', 'sajksjaksj', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioasignatura`
--

CREATE TABLE `usuarioasignatura` (
  `idUsuario` varchar(4) NOT NULL,
  `idAsignatura` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`idAsignatura`);

--
-- Indices de la tabla `metodologia`
--
ALTER TABLE `metodologia`
  ADD PRIMARY KEY (`idMetodologia`);

--
-- Indices de la tabla `metodologiaasignatura`
--
ALTER TABLE `metodologiaasignatura`
  ADD PRIMARY KEY (`idMetodologia`,`idAsignatura`),
  ADD KEY `idMetodologia` (`idMetodologia`),
  ADD KEY `idAsignatura` (`idAsignatura`),
  ADD KEY `idMetodologia_2` (`idMetodologia`);

--
-- Indices de la tabla `subunidad`
--
ALTER TABLE `subunidad`
  ADD PRIMARY KEY (`idSubUnidad`),
  ADD KEY `idUnidad` (`idUnidad`);

--
-- Indices de la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD PRIMARY KEY (`idUnidad`),
  ADD KEY `idAsignatura` (`idAsignatura`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `usuarioasignatura`
--
ALTER TABLE `usuarioasignatura`
  ADD PRIMARY KEY (`idUsuario`,`idAsignatura`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idAsignatura` (`idAsignatura`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `metodologiaasignatura`
--
ALTER TABLE `metodologiaasignatura`
  ADD CONSTRAINT `metodologiaasignatura_ibfk_1` FOREIGN KEY (`idMetodologia`) REFERENCES `metodologia` (`idMetodologia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `metodologiaasignatura_ibfk_2` FOREIGN KEY (`idAsignatura`) REFERENCES `asignatura` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `subunidad`
--
ALTER TABLE `subunidad`
  ADD CONSTRAINT `subunidad_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD CONSTRAINT `unidad_ibfk_1` FOREIGN KEY (`idAsignatura`) REFERENCES `asignatura` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarioasignatura`
--
ALTER TABLE `usuarioasignatura`
  ADD CONSTRAINT `usuarioasignatura_ibfk_1` FOREIGN KEY (`idAsignatura`) REFERENCES `asignatura` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuarioasignatura_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
