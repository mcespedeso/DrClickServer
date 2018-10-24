-- Ejecute esto con psql -U tuUsuario -f create_database.sql
CREATE USER "drclick" WITH ENCRYPTED PASSWORD 'drclick';
ALTER ROLE "drclick" WITH createdb;
CREATE database "drclick";
ALTER DATABASE drclick OWNER TO drclick;