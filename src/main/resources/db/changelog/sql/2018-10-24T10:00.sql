-- Este script crea la tabla de usuario y usuario_x_role

-- Create Schema --
CREATE SCHEMA seguridad;

-- Schema: seguridad.usuario --
CREATE TABLE seguridad.usuario (
	  id_usuario  bigserial PRIMARY KEY,
	  usuario  character varying (30),
	  password  character varying (256),
	  activo boolean
);

CREATE TABLE seguridad.usuario_x_role (
	  id_usuario_x_role bigserial PRIMARY KEY,
	  id_usuario bigint,
	  role character varying (50)
);

--Credenciales por defecto (para desarrollo)
--user admin
--pass admin
INSERT INTO seguridad."usuario"(
	id_usuario, usuario, password, activo)
	VALUES (nextval('seguridad.usuario_id_usuario_seq'), 
	'admin', 
	'$2a$10$xWMkwqj3/ukE36LU7VI6yuGcPA5BtvzUSg2PoUzZIX.tYNEa8GS.K', 
	true);
	
--user_x_role table
insert into seguridad.usuario_x_role (id_usuario, role) 
select id_usuario, 'ADMIN' as role from seguridad.usuario where usuario = 'admin';