CREATE DATABASE hospital;

USE bd_agenda;

create table personas(
  cod_hospital integer,
  dni integer primary key,
  apellidos varchar(50),
  funcion varchar(30),
  salario integer,
  localidad varchar(20)
);

insert into personas values (1,12345678,'García Hernández, Eladio','CONSERJE',1200,'LORCA');
insert into personas values (1,87654321,'Fuentes Bermejo, Carlos','DIRECTOR',2000,'MURCIA');
insert into personas values (2,55544433,'González Marín, Alicia','CONSERJE',1200,'MURCIA');
insert into personas values (1,66655544,'Castillo Montes, Pedro','MEDICO',1700,'MURCIA');
insert into personas values (2,22233322,'Tristán García, Ana','MEDICO',1900,'MURCIA');
insert into personas values (3,55544411,'Ruiz Hernández, Caridad','MEDICO',1900,'LORCA');
insert into personas values (3,99988333,'Serrano Díaz, Alejandro','DIRECTOR',2400,'CARTAGENA');
insert into personas values (4,33222111,'Mesa del Castillo, Juan','MEDICO',2200,'LORCA');
insert into personas values (2,22233333,'Martínez Molina, Andrés','MEDICO',1600,'CARTAGENA');
insert into personas values (4,55544412,'Jiménez Jiménez, Dolores','CONSERJE',1200,'MURCIA');
insert into personas values (4,22233311,'Martínez Molina, Gloria','MEDICO',1600,'MURCIA');

-- 1) Mostrar todos los datos de todas las personas.

SELECT * 
FROM personas;

-- 2) Obtén el DNI, apellidos y función de todas las personas.

SELECT dni, apellidos, funcion 
FROM personas;

-- 3) Mostrar los apellidos de las personas que vivan en LORCA.

SELECT apellidos 
FROM personas 
WHERE localidad = 'lorca';

-- 4) Mostrar los apellidos de las personas que vivan en MURCIA o LORCA

SELECT apellidos 
FROM personas 
WHERE localidad = 'lorca' OR localidad = 'murcia'; SELECT apellidos
FROM personas
WHERE localidad IN ('lorca', 'murcia');

-- 5) Seleccionar los datos de aquellas personas que vivan en MURCIA y tengan un salario superior a los 1500 euros.

SELECT * 
FROM personas 
WHERE localidad = 'murcia' AND salario > 1500;

-- 6) Mostrar los datos de las personas que vivan en MURCIA, tengan un salario superior a los 1500 euros y sean DIRECTORES.

SELECT * 
FROM personas 
WHERE localidad = 'murcia' 
  AND salario > 1500 
  AND funcion = 'director';
  
-- 7) Mostrar los datos de las personas cuya función sea MÉDICO ordenados por apellidos descendentemente.

SELECT * 
FROM personas 
WHERE funcion = 'medico' 
ORDER BY apellidos DESC;

-- 8) Mostrar los datos de todas las localidades que hay en la tabla personas sin repeticiones (debes empear la cláusula DISTINCT)

SELECT DISTINCT localidad 
FROM personas;

-- 9) Mostrar los datos de las personas que tengan un salario superior a 1500 euros y sean médicos. Ordenar la salida por salario descendentemente.

SELECT * 
FROM personas 
WHERE salario > 1500 AND funcion = 'medico' 
ORDER BY salario DESC;

-- 10) Seleccionar aquellas personas cuyo apellido comience por M.

SELECT apellidos 
FROM personas 
WHERE apellidos LIKE 'M%';

-- 11) Mostrar los datos de las personas que tengan una M en el apellido y cuya función sea CONSERJE

SELECT apellidos, funcion 
FROM personas 
WHERE apellidos LIKE '%M%' AND funcion = 'conserje';

-- 12) Mostrar aquellas personas que tengan un salario entre 1500 y 2000 euros.

SELECT * 
FROM personas 
WHERE salario BETWEEN 1500 AND 2000; SELECT apellidos, salario
FROM personas
WHERE salario >= 1500 AND salario <= 2000;

-- 13) Seleccionar los datos de aquellas personas cuya función sea MÉDICO o DIRECTOR (utilizar el operador IN)

SELECT * 
FROM personas 
WHERE funcion IN ('medico', 'director');

-- 14) Obtener los datos de aquellas personas cuya función no sea CONSERJE (utilizar el operador NOT IN) y tengan un salario superior a los 1500 euros, ordenados por apellido descendentemente.

SELECT * 
FROM personas 
WHERE funcion NOT IN ('conserje') AND salario > 1500 
ORDER BY apellidos DESC; SELECT *
FROM personas
WHERE funcion <> 'conserje' AND salario > 1500
ORDER BY apellidos DESC;

-- 15) Mostrar los datos de las personas que sean de MURCIA o CARTAGENA y que pertenezcan al hospital número 1.

SELECT * 
FROM personas 
WHERE localidad IN ('murcia', 'cartagena') 
  AND cod_hospital = 1;
  
-- 16) Obtén los apellidos en mayúsculas de las personas que trabajen en el hospital número 1.

SELECT upper(apellidos) apellidos
FROM personas 
WHERE cod_hospital = 1;

-- 17) Con una consulta devuelve los apellidos de todas las personas. Al lado debe aparecer la longitud de cada apellido.

SELECT apellidos, length(apellidos) largo 
FROM personas;

-- 18) Obtener los apellidos y localidad en minúscula de todas aquellas personas que no trabajen en el hospital número 1.

SELECT apellidos, lower(localidad) localidad 
FROM personas 
WHERE cod_hospital <> 1;

-- 19) Obtener los datos de las personas que trabajen en los hospitales 1 ó 2 y tengan un salario superior a 1500 euros.

SELECT * 
FROM personas 
WHERE cod_hospital IN (1, 2) 
  AND salario > 1500;
  
-- 20) Visualizar los datos de aquellas personas que no trabajen en el hospital número 2 y que sean de MURCIA.

SELECT * 
FROM personas 
WHERE cod_hospital <> 2 AND localidad = 'murcia';