CREATE DATABASE mini_dish_db;

CREATE USER mini_dish_db_manager WITH PASSWORD '123456';

GRANT CONNECT ON DATABASE mini_dish_db TO mini_dish_db_manager;

\c mini_dish_db

GRANT USAGE ON SCHEMA public TO mini_dish_db_manager;

GRANT CREATE ON SCHEMA public TO mini_dish_db_manager;

GRANT SELECT, INSERT, DELETE, UPDATE ON ALL TABLES IN SCHEMA public TO mini_dish_db_manager;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO mini_dish_db_manager;