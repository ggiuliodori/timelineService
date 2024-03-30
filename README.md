# timelineService
El Servicio de Línea de Tiempo es una aplicación basada en Spring Boot que proporciona funcionalidades para obtener la línea de tiempo de un usuario. Permite a los usuarios recuperar una lista de tweets de los usuarios que siguen.

Funcionalidades

Obtener Línea de Tiempo: Los usuarios pueden enviar solicitudes GET para obtener la línea de tiempo de un usuario específico proporcionando su ID. La línea de tiempo incluye los tweets de los usuarios a los que sigue.

## Requisitos Previos

Asegúrate de tener instalado Java 17 en tu sistema. Puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

## Configuración

Antes de ejecutar el servicio, asegúrate de configurar las propiedades necesarias en el archivo `application.properties`

baseUserUr=http://localhost:8081
baseTweetUrl=http://localhost:8082

## Crear imagen docker

```
docker build -t timeline_service:latest .
```

## Ejecución

```dtd
./gradlew bootRun
```
