CREATE SEQUENCE medicos_id_seq;

CREATE TABLE medicos (
    id BIGINT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    documento VARCHAR(6) NOT NULL UNIQUE,
    especialidad VARCHAR(100) NOT NULL,
    calle VARCHAR(100) NOT NULL,
    distrito VARCHAR(100) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    ciudad VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Crear la función del trigger
CREATE OR REPLACE FUNCTION set_medicos_id() RETURNS TRIGGER AS $$
BEGIN
    NEW.id := nextval('medicos_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger
CREATE TRIGGER medicos_id_trigger
BEFORE INSERT ON medicos
FOR EACH ROW
EXECUTE FUNCTION set_medicos_id();
