CREATE SCHEMA IF NOT EXISTS `umg` DEFAULT CHARACTER SET utf8 ;
USE `umg` ;

CREATE TABLE IF NOT EXISTS alumnos(
    carnet_alumno INT NOT NULL AUTO_INCREMENT,
    nombre_alumno VARCHAR(45),
    direccion_alumno VARCHAR(45),
    telefono_alumno VARCHAR(45),
    email_alumno VARCHAR(20),
    estatus_alumno VARCHAR(1),
    PRIMARY KEY (carnet_alumno))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS maestros(
    codigo_maestro INT NOT NULL auto_increment,
    nombre_maestro VARCHAR(45),
    direccion_maestro VARCHAR(45),
    telefono_maestro VARCHAR(45),
    email_maestro VARCHAR(20),
    estatus_maestro VARCHAR(1),
    PRIMARY KEY (codigo_maestro))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS facultades(
	codigo_facultad INT NOT NULL auto_increment,
    nombre_facultad VARCHAR(45),
    estatus_facultad VARCHAR(1),
    PRIMARY KEY (codigo_facultad))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS carreras(
	codigo_carrera INT NOT NULL auto_increment,
    nombre_carrera VARCHAR(45),
    codigo_facultad INT NOT NULL,
    estatus_carrera VARCHAR(1),
    PRIMARY KEY (codigo_carrera),
    FOREIGN KEY (codigo_facultad) REFERENCES facultades(codigo_facultad))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS cursos(
    codigo_curso INT NOT NULL auto_increment,
    nombre_curso VARCHAR(45),
    estatus_curso VARCHAR(1),
    PRIMARY KEY (codigo_curso))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS secciones(
    codigo_seccion INT NOT NULL auto_increment,
    nombre_seccion VARCHAR(45),
    estatus_seccion VARCHAR(1),
    PRIMARY KEY (codigo_seccion))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS sedes(
    codigo_sede INT NOT NULL auto_increment,
    nombre_sede VARCHAR(45),
    estatus_sede VARCHAR(1),
    PRIMARY KEY (codigo_sede))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS aulas(
    codigo_aula INT NOT NULL auto_increment,
    nombre_aula VARCHAR(45),
    estatus_aula VARCHAR(1),
    PRIMARY KEY (codigo_aula))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS jornadas(
    codigo_jornada INT NOT NULL auto_increment,
    nombre_jornada VARCHAR(45),
    estatus_jornada VARCHAR(1),
    PRIMARY KEY (codigo_jornada))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS asignacioncursosalumnos(
    codigo_carrera INT NOT NULL,
    codigo_sede INT NOT NULL,
    codigo_jornada INT NOT NULL,
    codigo_seccion INT NOT NULL,
    codigo_aula INT NOT NULL,
    codigo_curso INT NOT NULL,
    carnet_alumno INT NOT NULL,
    nota_asignacioncursoalumnos FLOAT(10,2), 
    PRIMARY KEY (codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso, carnet_alumno),
    FOREIGN KEY (codigo_carrera) REFERENCES carreras(codigo_carrera),
    FOREIGN KEY (codigo_sede) REFERENCES sedes(codigo_sede),
    FOREIGN KEY (codigo_jornada) REFERENCES jornadas(codigo_jornada),
    FOREIGN KEY (codigo_seccion) REFERENCES secciones(codigo_seccion),
    FOREIGN KEY (codigo_aula) REFERENCES aulas(codigo_aula),
    FOREIGN KEY (codigo_curso) REFERENCES cursos(codigo_curso),
    FOREIGN KEY (carnet_alumno) REFERENCES alumnos(carnet_alumno))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS asignacioncursosmastros(
    codigo_carrera INT NOT NULL,
    codigo_sede INT NOT NULL,
    codigo_jornada INT NOT NULL,
    codigo_seccion INT NOT NULL,
    codigo_aula INT NOT NULL,
    codigo_curso INT NOT NULL,
    codigo_maestro INT NOT NULL,
    PRIMARY KEY (codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso),
    FOREIGN KEY (codigo_carrera) REFERENCES carreras(codigo_carrera),
    FOREIGN KEY (codigo_sede) REFERENCES sedes(codigo_sede),
    FOREIGN KEY (codigo_jornada) REFERENCES jornadas(codigo_jornada),
    FOREIGN KEY (codigo_seccion) REFERENCES secciones(codigo_seccion),
    FOREIGN KEY (codigo_aula) REFERENCES aulas(codigo_aula),
    FOREIGN KEY (codigo_curso) REFERENCES cursos(codigo_curso),
    FOREIGN KEY (codigo_maestro) REFERENCES maestros(codigo_maestro))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(60),
    password VARCHAR(25),
    PRIMARY KEY (ID_USUARIO))
ENGINE = INNODB CHARACTER SET = LATIN1;

INSERT INTO usuario
	(`username`,`password`)
    VALUES ('usuprueba','123456');

CREATE TABLE IF NOT EXISTS vendedor(
  id_vendedor int(11) NOT NULL,
  nombreVendedor varchar(60) NOT NULL,
  direVendedor varchar(25) NOT NULL,
  PRIMARY KEY (id_vendedor))
ENGINE = INNODB CHARACTER SET = LATIN1;

CREATE TABLE IF NOT EXISTS empleado(
  id_empleado int(11) NOT NULL,
  nombre_empleado varchar(60) NOT NULL,
  dire_empleado varchar(25) NOT NULL,
  PRIMARY KEY (id_empleado))
ENGINE = INNODB CHARACTER SET = LATIN1;