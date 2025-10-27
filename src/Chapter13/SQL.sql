-- SQL: 创建数据库、表并插入示例数据
CREATE DATABASE IF NOT EXISTS sample CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE sample;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name, email) VALUES
  ('Alice', 'alice@example.com'),
  ('Bob', 'bob@example.com')
ON DUPLICATE KEY UPDATE name = VALUES(name);

CREATE DATABASE IF NOT EXISTS airline CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

