-- Script para crear la base de datos y tabla de pedidos

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS restaurente_bd;

-- Usar la base de datos
USE restaurente_bd;

-- Crear la tabla pedido
CREATE TABLE IF NOT EXISTS pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pedido DATE NOT NULL,
    total_pagar DECIMAL(10, 2) NOT NULL
);