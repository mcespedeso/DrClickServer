-- Este script crea las tablas para almacenar las  autenticaciones oauth2 --

create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

create table oauth_client_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication bytea,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(255), authentication bytea
);

create table oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

insert into oauth_client_details (
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types, 
	access_token_validity, 
	refresh_token_validity, 
	autoapprove)
values ('client', 
		'$2a$10$Zf2d4V78s1LM6Q4IwrN4oOSRJTrHHfp1AvG3s4qguT7NSSdTCpkQ.',
		'bar,read,write',
		'password,authorization_code,refresh_token',
		36000,
		36000,
		'true'
);