CREATE DATABASE IF NOT EXISTS SegurosDB;
USE SegurosDB;

CREATE TABLE Amparos (
    id_amparo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Primas (
    id_prima INT AUTO_INCREMENT PRIMARY KEY,
    codigo_amparo INT NOT NULL,
    edad_minima INT NOT NULL,
    edad_maxima INT NOT NULL,
    porcentaje_prima FLOAT NOT NULL,
    FOREIGN KEY (codigo_amparo) REFERENCES Amparos(id_amparo)
);

CREATE TABLE Asegurados (
    id_asegurado INT AUTO_INCREMENT PRIMARY KEY,
    tipo_identificacion VARCHAR(20) NOT NULL,
    numero_identificacion VARCHAR(20) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    id_amparo INT,
    id_prima INT,
    FOREIGN KEY (id_amparo) REFERENCES Amparos(id_amparo),
    FOREIGN KEY (id_prima) REFERENCES Primas(id_prima)
);

CREATE TABLE AseguradosAmparos (
    id_asegurado_amparo INT AUTO_INCREMENT PRIMARY KEY,
    id_asegurado INT NOT NULL,
    id_amparo INT NOT NULL,
    FOREIGN KEY (id_asegurado) REFERENCES Asegurados(id_asegurado),
    FOREIGN KEY (id_amparo) REFERENCES Amparos(id_amparo)
);

INSERT INTO Amparos (id_amparo, nombre) VALUES
(1, 'Muerte accidental'),
(2, 'Desmembración'),
(3, 'Auxilio funerario'),
(4, 'Renta vitalicia');

INSERT INTO Primas (codigo_amparo, edad_minima, edad_maxima, porcentaje_prima) VALUES
(1,18, 45, 0.02304),
(1,46, 75, 0.02012),
(2,18, 50, 0.1809),
(2,51, 70, 0.16043),
(3,18, 60, 0.14123),
(3,61, 70, 0.1545),
(4,18, 50, 0.12123),
(4,51, 70, 0.1345);

INSERT INTO Asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES
('CC', '94984121', 'Alvarez Alvarez', 'Maria', 'Masculino', '1970-09-21'),
('CE', '70751472', 'Martinez Martinez', 'Pedro', 'Masculino', '1986-05-13'),
('CE', '95166013', 'Gomez Gomez', 'Laura', 'Femenino', '1964-09-20'),
('CE', '53099848', 'Ruiz Ruiz', 'Juan', 'Femenino', '1985-01-26'),
('CC', '75680762', 'Sanchez Sanchez', 'Ana', 'Masculino', '1970-08-11'),
('CE', '99081441', 'Garcia Garcia', 'Luis', 'Masculino', '1998-06-11'),
('CC', '32263665', 'Diaz Diaz', 'Jose', 'Masculino', '1994-09-12'),
('CE', '55422067', 'Gomez Gomez', 'Laura', 'Femenino', '1962-01-15'),
('CE', '15412325', 'Alvarez Alvarez', 'Luis', 'Femenino', '1964-11-09'),
('CE', '65958312', 'Gomez Gomez', 'Juan', 'Masculino', '1981-09-09'),
('CE', '62525049', 'Fernandez Fernandez', 'Ana', 'Femenino', '1983-07-10'),
('CE', '22085068', 'Martinez Martinez', 'Juan', 'Masculino', '1997-12-05'),
('CE', '18342749', 'Alvarez Alvarez', 'Carlos', 'Femenino', '1972-05-15'),
('CC', '12898678', 'Fernandez Fernandez', 'Carlos', 'Femenino', '1987-12-06'),
('CC', '17182295', 'Martinez Martinez', 'Paula', 'Femenino', '1950-10-14'),
('CE', '47995120', 'Sanchez Sanchez', 'Pedro', 'Femenino', '1978-10-05'),
('CE', '61029852', 'Ruiz Ruiz', 'Juan', 'Masculino', '1985-06-22'),
('CC', '75694004', 'Garcia Garcia', 'Carmen', 'Masculino', '1966-04-22'),
('CE', '10182678', 'Fernandez Fernandez', 'Jose', 'Femenino', '1951-09-19'),
('CC', '99826607', 'Diaz Diaz', 'Jose', 'Femenino', '1979-07-26');

INSERT INTO AseguradosAmparos (id_asegurado, id_amparo) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(3,1),
(3,2),
(4,2),
(4,1),
(4,3),
(5,3),
(5,4),
(5,1),
(6,2),
(6,1),
(7,1),
(8,2),
(8,1),
(10,1),
(10,2),
(10,3),
(10,4),
(11,3),
(12,3),
(12,2),
(13,4),
(14,1),
(14,4),
(15,4),
(15,1),
(15,2),
(15,3),
(16,3),
(17,3),
(17,4),
(18,4),
(18,2),
(19,1);


