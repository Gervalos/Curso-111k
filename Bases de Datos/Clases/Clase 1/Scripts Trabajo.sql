-- 1 - Crear Base de Datos
CREATE DATABASE DB111k;

-- 2 - Crear Tabla en la Base de datos -- No es AUTO_INCREMET por el DNI
CREATE TABLE Alumnos (
	Dni INTEGER UNSIGNED UNIQUE NOT NULL PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    Telefono VARCHAR(20) DEFAULT 0,
    Email VARCHAR(50) NOT NULL UNIQUE,
    FechaNac DATE NOT NULL,
    Recibido TINYINT
);

-- 3 - desc
DESC Alumnos;

-- 4 - Poblar la tabla
USE DB111K;
INSERT INTO Alumnos (
	Dni,
    Nombre,
    Apellido,
    Telefono,
    Email,
    FechaNac,
    Recibido
) 
VALUES 
	(36943968,'German','Avalos','2216274332','gervalos@gmail.com','1992-07-05', 0),
    (39510730,'Federico Javier','Margueliche','2221413811','fede_fjm@hotmail.com','1995-06-26',1),
    (39191621,'Facundo','Da Rocha','2223422323','facundodarocha@gmail.com','1995-12-1',0),
    (39470655,'Gonzalo Javier','Pavon','2223674434','9.japa.06@gmail.com','1996-12-06',1),
    (39898710,'Facundo','Sanchez','2223433197','facu.ruso@gmail.com','1997-02-27',0),
    (40111220,'Cristian Amilcar','Torancio','2214007078','cristiantorancio97@gmail.com','1997-02-26',1),
    (40548974,'Julian Ezequiel','Torancio','2223679079','julian_cejas@yahoo.com','1997-12-01',0),
    (38452019,'Julian Gabriel','Gomez','2215921225','gjulian220397@gmail.com','1997-03-22',1),
    (40602405,'Bautista','Pucacco','1167690378','bautistapucacco@gmail.com','1997-04-10',0)
;

-- 5 - Obtener todos los datos de la tabla Alumnos
SELECT * FROM Alumnos;

-- 6 - Obtener tuplas DNI < 40 millones

SELECT * FROM Alumnos WHERE Dni < 40000000;

-- 7 - Anterior pero ordenadas

SELECT * FROM Alumnos WHERE DNI < 40000000
ORDER BY Dni;

-- 8 - Cambiar DNI

UPDATE Alumnos 
SET Dni = 36943969 
WHERE Nombre = 'German';

-- 9 - Seleccionar entre Fechas

SELECT * FROM Alumnos WHERE (FechaNac < '1997-12-31' AND FechaNac > '1996-01-01');

-- 10 - Listar tuplas donde no se hayan recibido

SELECT Nombre, Apellido FROM Alumnos WHERE Recibido = 0;

-- 11 - Listar recibidos

SELECT * FROM Alumnos WHERE Recibido = 1;

-- 12 - Eliminar recibidos

DELETE FROM Alumnos WHERE Recibido = 1;

-- 13 - Eliminar tabla

DROP TABLE Alumnos;

-- 4 - Eliminar base de datos

DROP DATABASE DB111K;
