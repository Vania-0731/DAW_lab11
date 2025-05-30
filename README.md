# Proyecto: CRUD de Alumnos con Spring Boot + MongoDB

Este proyecto es una aplicación web básica para la **gestión de alumnos**, desarrollada con **Spring Boot**, **MongoDB** y **Thymeleaf**. Permite crear, editar, listar, buscar y eliminar alumnos desde una interfaz web.

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3
- MongoDB
- Thymeleaf (plantillas HTML)
- Bootstrap 4 (para el diseño)
- Maven

---

## 🧾 Requisitos previos

1. Tener instalado **Java 17 o superior**
2. Tener instalado **Maven**
3. Tener instalado y funcionando **MongoDB**
4. (Opcional) Usar un entorno como IntelliJ IDEA o Eclipse

---

## 🛠️ Instalación

### Paso 1: Clonar el repositorio

```bash
git clone https://github.com/Vania-0731/DAW_lab11.git
cd DAW_lab11
```

### Paso 2: Configura tu base de datos MongoDB

Asegúrate de que MongoDB esté en ejecución en tu máquina local, y de que exista una **base de datos llamada `escuela`**. No necesitas crear colecciones manualmente, se crearán automáticamente cuando uses la app.

Puedes iniciar MongoDB con Docker (opcional):
```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

---

### Paso 3: Configurar el `application.properties`

Ubicado en `src/main/resources/application.properties`, debe incluir lo siguiente:

```properties
spring.data.mongodb.database=escuela
server.port=8087
```

---

### Paso 4: Ejecutar el proyecto

Puedes correr el proyecto desde tu IDE o desde la línea de comandos:

```bash
mvn spring-boot:run
```

O si ya fue compilado:

```bash
java -jar target/DAW_lab11-0.0.1-SNAPSHOT.jar
```

---

## 📎 Acceso a la aplicación

Una vez en ejecución, accede a:

➡️ [http://localhost:8087/alumnos/listar](http://localhost:8087/alumnos/listar)

---

## 📝 Funcionalidades

- Listar todos los alumnos
- Crear nuevo alumno
- Editar alumno existente
- Eliminar alumno
- Buscar alumnos por nombre (funcionalidad incluida)

---

## 📂 Estructura del proyecto

```
src
 └── main
     ├── java
     │   └── com.tecsup.demo
     │       ├── controladores
     │       ├── modelo.daos
     │       ├── modelo.documentos
     │       └── servicios
     └── resources
         ├── templates
         │   └── alumnos
         └── application.properties
```

---

## ✏️ Autor

- Vania Sifuentes 
- TECSUP - Diseño y Desarrollo de Software  
- [Repositorio del proyecto](https://github.com/Vania-0731/DAW_lab11)

---

## 📌 Notas adicionales

- El proyecto crea automáticamente las colecciones en MongoDB.
- La aplicación corre en el puerto `8087`. Si quieres cambiarlo, modifica el `application.properties`.
- Si necesitas importar datos de prueba, puedes usar MongoDB Compass o `mongoimport`.
