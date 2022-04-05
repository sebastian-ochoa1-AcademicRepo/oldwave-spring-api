# Introducción
Este proyecto en Spring Boot 'oldwave-spring-api' fue realizado para la clase 'Desarrollo de aplicaciones empresariales' basado en dos apis de mercado libre. Una que retorna una lista de productos completa, mientras la otra retorna solo el detalle de este.

#Requisitos:
- Java 11 JDK o superior
- Gradle 7.4.2 o superior

#Modo de ejecución

Para ejecutar el programa corra el comando

    gradle bootRun

Para ejecutar las pruebas unitarias corra el comando

    gradle clean test --tests "co.com.edu.udea.oldwavespringapi.service.implement.ProductServiceImpTest"