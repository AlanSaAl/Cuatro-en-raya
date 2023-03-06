## Pasos para probrar el backend
- Ejecutar el archivo docker-compose.yml para ejecutar el contenedo
que contendrá la BDD usando PostgreSQL
  - Puerto:5432
  - Usuario:user
  - Contraseña:root
- Se recomienda usar DBeaver como gestor de BDD
- Ejecutar el método main y revisar en la BDD la creación de Jugadores,
Juegos y Movimientos.
- También se implementa Swagger para la revisión de los métodos HTTP en la url:
  http://localhost:8080/swagger-ui/index.html#/