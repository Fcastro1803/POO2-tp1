-- Script para crear la base de datos y tabla de inscripciones

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS concursos_db;

-- Usar la base de datos
USE concursos_db;

-- Crear la tabla inscripciones
CREATE TABLE IF NOT EXISTS inscripciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_participante INT NOT NULL,
    id_concurso INT NOT NULL,
    fecha_inscripcion DATE NOT NULL
);