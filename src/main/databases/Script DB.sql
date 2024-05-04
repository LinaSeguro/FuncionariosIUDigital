CREATE DATABASE recursos_humanos_iudigital;
USE recursos_humanos_iudigital; 

-- Crear la tabla Funcionarios para almacenar información sobre el personal de la institución
CREATE TABLE Funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_identificacion VARCHAR(10) NOT NULL,
    numero_identificacion VARCHAR(20) NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    estado_civil VARCHAR(20) NOT NULL,
    sexo CHAR(1) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);

-- Crear la tabla Grupo_Familiar para almacenar información sobre el grupo familiar de cada funcionario
CREATE TABLE Grupo_Familiar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    parentesco VARCHAR(20) NOT NULL,
    edad INT NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);

-- Crear la tabla Informacion_Academica para almacenar información académica de los funcionarios
CREATE TABLE Informacion_Academica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT NOT NULL,
    universidad VARCHAR(100) NOT NULL,
    nivel_estudio VARCHAR(50) NOT NULL,
    titulo_estudio VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);

-- Poblado de las tablas 
INSERT INTO Funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES 
('CC', '12345678', 'Luis', 'Pérez', 'Casado', 'M', 'Calle 123', '1234567', '1990-01-01'), -- Luis Pérez
('TI', '987654321', 'Lina', 'Gómez', 'Soltero', 'F', 'Carrera 456', '7654321', '1985-05-15'), -- Lina Gómez
('CC', '456789123', 'Jorge', 'López', 'Casado', 'M', 'Avenida 789', '9876543', '1988-11-30'), -- Jorge López
('CC', '12561458', 'Justin', 'Durango', 'Soltero', 'M', 'Avenida 569', '2365897', '1989-06-25'), -- Justin Durango
('CE', '987654987', 'Laura', 'Martínez', 'Soltero', 'F', 'Avenida 567', '6543210', '1992-07-20'), -- Laura Martínez
('CC', '234567890', 'Carlos', 'Gómez', 'Soltero', 'M', 'Calle 789', '8765432', '1991-12-05'); -- Carlos Gómez

-- Muestra todos los funcionarios
SELECT * FROM Funcionarios;

-- Cambio el tipo de dato del numero_identificacion de int a varchar
ALTER TABLE Funcionarios MODIFY COLUMN numero_identificacion VARCHAR(20) NOT NULL;

-- Verifica todos los campos de la tabla y sus características 
DESCRIBE funcionarios;

-- Validando que el codigo de las consultas en netbeans este correcto. 
SELECT * FROM Funcionarios WHERE id =3 ;
SELECT * FROM Funcionarios;
DELETE FROM Funcionarios WHERE id = 6;
UPDATE Funcionarios 
SET tipo_identificacion = 'TI', 
    numero_identificacion = '987654321', 
    nombres = 'Lina', 
    apellidos = 'Gaviria', 
    estado_civil = 'Soltero', 
    sexo = 'F', 
    direccion = 'Carrera 456', 
    telefono = '7654321', 
    fecha_nacimiento = '1985-05-15' 
WHERE id = 2;
