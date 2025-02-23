CREATE SCHEMA IF NOT EXISTS `didactica` DEFAULT CHARACTER SET utf8 ;
USE `didactica` ;
CREATE TABLE IF NOT EXISTS persona (
id_persona INT AUTO_INCREMENT,
nombre VARCHAR(60),
apellido VARCHAR(20),
email VARCHAR(25),
telefono VARCHAR(25),
PRIMARY KEY (id_persona)
) ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;
CREATE TABLE IF NOT EXISTS bitacora (
  id_bitacora INT NOT NULL AUTO_INCREMENT,
  accion VARCHAR(60) NOT NULL,
  PRIMARY KEY (id_bitacora) )
ENGINE = InnoDB CHARACTER SET = latin1;

SELECT * FROM persona;
CREATE TABLE IF NOT EXISTS vendedor (
  id_vendedor INT NOT NULL AUTO_INCREMENT,
  nombreVendedor VARCHAR(60) NOT NULL,
  direVendedor VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_vendedor) )
ENGINE = InnoDB CHARACTER SET = latin1;
CREATE TABLE IF NOT EXISTS empleado (
  id_empleado INT NOT NULL AUTO_INCREMENT,
  nombre_empleado VARCHAR(60) NOT NULL,
  dire_empleado VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_empleado) )
ENGINE = InnoDB CHARACTER SET = latin1;
