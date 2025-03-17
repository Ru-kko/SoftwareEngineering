# Proyecto Parcial Corte 1 - Jose Sebastian Vera

## Descripción
Una aplicación web desarrollada con **Servlets** y **JSP**, inspirada en la **arquitectura hexagonal**, aunque no implementada en su totalidad.

La aplicación permite gestionar reservas a través de dos páginas:
- **reservations.jsp**: Lista todas las reservas y permite eliminarlas.
- **index.jsp**: Permite agregar nuevas reservas.

El sistema utiliza un servicio en memoria basado en **HashMap** como base de datos simulada.

## Requerimientos

### Requisitos previos
Para ejecutar la aplicación localmente o en Docker, se requieren:
- **JDK 17**
- **Apache Tomcat 8.x o 9.x** (Debido al uso de **javax**)
- **Maven** (para la compilación)

### Estructura del Proyecto
```
src/main
├── java
│   └── com/parcial/parcial1
│       ├── application
│       │   ├── inputports
│       │   │   └── ReservationService.java
│       │   └── services
│       │       └── InMemoryReservationService.java
│       ├── domain
│       │   ├── OfficeType.java
│       │   └── Reservation.java
│       └── infra/servlets
│           ├── DeleteServlet.java
│           └── ReservationServlet.java
└── webapp
    ├── index.jsp
    ├── reservations.jsp
    └── WEB-INF/web.xml
```


## Despliegue

### Despliegue con Docker
El proyecto ya incluye un **Dockerfile**, por lo que solo es necesario ejecutar los siguientes comandos:

1. **Construir la imagen:**
```bash
docker build -t parcial1-app .
```
2. **Ejecutar el contenedor:**
```bash
docker run -p 8080:8080 parcial1-app
```
3. **Acceder a la aplicación:**
- Página principal: [http://localhost:8080](http://localhost:8080)
- Lista de reservas: [http://localhost:8080/reservations.jsp](http://localhost:8080/reservations.jsp)

### Despliegue local con Tomcat
1. **Compilar el proyecto:**
```bash
mvn clean package
```
2. **Copiar el archivo WAR al directorio de Tomcat:**
```bash
cp target/Parcial1-1.0-SNAPSHOT.war <ruta_tomcat>/webapps/ROOT.war
```
3. **Iniciar Tomcat:**
```bash
<ruta_tomcat>/bin/catalina.sh run
```

4. **Acceder a la aplicación en:** [http://localhost:8080](http://localhost:8080)

## Funcionamiento de la Aplicación

### Servlets
- **ReservationServlet.java**: Maneja la lógica para agregar nuevas reservas.
- **DeleteServlet.java**: Se encarga de eliminar reservas existentes.

### Servicio en Memoria
- **InMemoryReservationService.java**: Implementa una base de datos en memoria usando **HashMap**.

## Notas
- El código está escrito en inglés.
- Se recomienda usar **Tomcat 8.x o 9.x** debido a la dependencia de **javax**.
- La aplicación es completamente funcional en Docker, sin necesidad de instalar dependencias adicionales.

---

**Autor:** Jose Sebastian Vera
