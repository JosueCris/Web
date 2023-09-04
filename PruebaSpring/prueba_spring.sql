USE prueba;

CREATE TABLE persona (
	idPersona INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(20),
    ApPaterno VARCHAR(20),
    ApMaterno VARCHAR(20),
    FechaNac DATE,
    PRIMARY KEY(idPersona)
);

INSERT INTO persona (Fecha_Nac, Ap_Materno, Ap_Paterno, Nombre) VALUES
('2000-06-24', 'Huerta', 'Tellez', 'Josue');

SELECT * FROM persona;