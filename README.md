# Documentación API - Sistema de Seguros

Este proyecto implementa una API REST para el cálculo de liquidaciones de seguros, utilizando Spring Boot y Swagger para la documentación y pruebas interactivas de la API.

## Iniciar el Proyecto

Para iniciar el proyecto, ejecuta:

```bash
mvn spring-boot:run
```

o puede ser corrido con intellij idea, sts u otro IDE para java con spring

Una vez iniciado, la aplicación estará disponible en http://localhost:8080.

Documentación API con Swagger UI
Puedes acceder a la documentación interactiva de la API y probar los endpoints directamente a través de Swagger UI en la siguiente URL:

http://localhost:8080/swagger.html

## Endpoints Disponibles
Obtener Todos los Asegurados
GET /api/v1/asegurado - Retorna una lista de todos los asegurados registrados en el sistema.
Calcular Liquidación
POST /api/v1/asegurado/calcularLiquidacion - Calcula la liquidación basada en el valor asegurado y los amparos aplicables para un usuario específico.

## Ejemplo de solicitud:
```json
{
"tipoIdentificacion": "CC",
"nroIdentificacion": "32263665",
"valorAsegurado": 9982660
}
```
## Respuesta:
La respuesta incluirá un reporte detallado de la liquidación calculada o un mensaje de error si la solicitud no cumple con los requisitos especificados.

Configuración y Dependencias
El proyecto está configurado para correr en el puerto 8080 y utiliza MySQL como sistema de gestión de base de datos. Las dependencias principales incluyen Spring Boot Starter Web, Spring Boot Starter Data JPA, MySQL Connector Java, y SpringDoc OpenAPI UI para la documentación de la API.

## Estructura del Proyecto

El código fuente está organizado en paquetes que separan los controladores, modelos, servicios y repositorios, siguiendo las mejores prácticas de desarrollo con Spring Boot.


## Estructura del Proyecto

El código fuente está organizado en paquetes que separan los controladores, modelos, servicios y repositorios, siguiendo las mejores prácticas de desarrollo con Spring Boot.

src
└── main
├── java
│ └── com
│ └── example
│ └── seguros_prueba_tecnica_linktic
│ ├── controllers
│ ├── models
│ │ └── DTO
│ ├── repositories
│ └── services
└── resources
└── application.properties

## Archivo `application.properties`

La configuración de la aplicación, incluyendo la conexión a la base de datos y la configuración de Swagger, se define en el archivo `application.properties`.

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3307/segurosdb
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/swagger.html
```

```json
{
    "creador":"sergio Ayala",
    "rol":"ingeniero de desarrollo",
    "fecha":"25/02/24"
}
