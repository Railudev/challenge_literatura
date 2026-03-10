# challenge_literatura
Alura Latam challenge de literatura

## Descripción
Aplicación Maven que utiliza la API de Gutendex para consultar libros y autores, almacenando datos en PostgreSQL.

Funcionalidades:
- Consultar libros con título, autor, idioma y número de descargas.
- Consultar autores con nombre, fecha de nacimiento y fecha de defunción.
- Buscar libros y mostrar una lista.
- Filtrar libros por idioma.
- Filtrar autores por año en que estaban vivos.

## Requisitos
- Java 17
- Maven
- PostgreSQL

## Configuración
1. Crear base de datos en PostgreSQL llamada `literatura`.
2. Actualizar `src/main/resources/application.properties` con tus credenciales de DB.

## Ejecutar
```bash
mvn spring-boot:run
```

## Endpoints
- GET /books: Lista todos los libros
- GET /books/search?query=...: Busca libros en Gutendex y guarda
- GET /books/language/{lang}: Filtra libros por idioma
- GET /books/author-alive/{year}: Libros de autores vivos en ese año
- GET /authors: Lista todos los autores
- GET /authors/alive/{year}: Autores vivos en ese año
