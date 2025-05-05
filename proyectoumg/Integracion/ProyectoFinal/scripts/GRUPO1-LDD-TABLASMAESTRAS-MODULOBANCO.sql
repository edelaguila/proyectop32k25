
CREATE TABLE banco (
    id_banco INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,     
    sede VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    email VARCHAR(100),
    status VARCHAR(20) NOT NULL DEFAULT 'activo'
);  

CREATE TABLE tipo_cuenta (
    id_tipo_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    tipo_cuenta VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'activo'
);

CREATE TABLE tipo_operacion_bancaria (
    id_tipo_operacion INT AUTO_INCREMENT PRIMARY KEY,
    tipo_operacion VARCHAR(50) NOT NULL,
    descripcion TEXT DEFAULT NULL
);
CREATE TABLE tipo_moneda (
    id_tipo_moneda INT AUTO_INCREMENT PRIMARY KEY,
    tipo_moneda VARCHAR(5) NOT NULL,
    tasa_cambio_usd DECIMAL(15, 2) NOT NULL DEFAULT 0.00
);
CREATE TABLE tasas_cambio_diario (
    id_tasa_cambio_diario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    valor_promedio_dia DECIMAL(10, 2),
    fecha_hora DATETIME
);

CREATE TABLE tipo_pago (
    id_tipo_pago INT AUTO_INCREMENT PRIMARY KEY,
    tipo_pago VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'activo'
);