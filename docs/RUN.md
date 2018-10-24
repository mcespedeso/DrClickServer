## Ejecutar el servidor 
El servidor DrClick utiliza un sistema de compilación basado en Maven y liquibase para la evolución de la base de datos. También utiliza Spring Boot para ejecutar el WAR compilado con un servidor Tomcat integrado.

## Pre-requisitos

* Maven 3.3.9 or mayor
* Java 8
* PostgreSQL 9.5 or mayor

## Configuración básica

Estos son pasos que solo necesitará realizar la primera vez que lo haga
configurando el servidor.

### Paso 0, hacer fork del repositorio original

```shell
https://github.com/SOLUMED/DrClickServer
```

### Paso 1, clonar el repo desde tu usuario

```shell
https://github.com/tu_usuario/DrClickServer
```
### Paso 2, crear la base de datos

Ejecutar con psql el script:

```shell
psql -U YOUR_USER_HERE -f src/main/resources/db/create_database.sql
```

También puedes copiar y pegar el siguiente fragmento de código en tu cliente PSQL favorito:

```
CREATE USER "drclick" WITH ENCRYPTED PASSWORD 'drclick';
ALTER ROLE "drclick" WITH createdb;
CREATE database "drclick";
ALTER DATABASE drclick OWNER TO drclick;
       
```

Esto generará la base de datos inicial, y a partir de este punto cualquier cambio relacionado con la base de datos será a través de [Liquibase] (LIQUIBASE.md).

Liquibase se ejecuta automáticamente durante el inicio del servidor y actualiza la base de datos (si es necesario).

### Paso 2, compilar la aplicación

Desde el directorio de DrClick, ejecutar:

```shell
mvn clean package
```

### Paso 3, ejecutas la aplicación

Iniciar el servidor:

```shell
java -jar target/*.war
```

Y eso es todo, su servidor se iniciará de forma predeterminada en http://localhost:8080

## ¿Qué sigue?

En desarrollo