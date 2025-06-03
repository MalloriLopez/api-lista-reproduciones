# Backend - Listas de Reproducción 🎵

Servicios REST para la gestión de listas de reproducción y canciones.  
Permite crear, consultar, buscar y eliminar listas de reproducción musicales mediante una API segura y robusta.

---

## 🚀 Tecnologías principales

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **Spring Security**
- **Base de datos H2 (runtime/in-memory)**
- **Maven**
- **Lombok**

---

## 📦 Requisitos previos

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- (Opcional) Frontend Angular corriendo en [http://localhost:4200](http://localhost:4200)  
  > **Importante:** Asegúrate de tener el backend corriendo antes de usar el frontend.

---

## 🛠 Instalación

```bash
git clone https://github.com/MalloriLopez/api-lista-reproduciones.git
```
```
cd api-lista-reproduciones
```

##  🛠 Construcción

Para construir el proyecto (compilar y descargar dependencias):

```bash
mvn clean install
```

## ⚙️ Ejecución

Para iniciar el servidor localmente:

```bash
mvn spring-boot:run
```

## 🖥️ La aplicación corre en:

Backend Java + Spring Boot:
 [http://localhost:8080](http://localhost:8080) 


## 🔑 Autenticación

La aplicación utiliza autenticación básica HTTP.

Credenciales por defecto:

- Usuario: usuarioTest

- Contraseña: password

Estas credenciales deben estar configuradas igual en el frontend para consumir los servicios.


## ✨ Características principales


- Crear listas de reproducción:
Endpoint para añadir nuevas listas con múltiples canciones.

- Buscar listas por nombre:
Consulta rápida de listas usando el nombre exacto.

- Ver todas las listas:
Recupera todas las listas de reproducción registradas.

- Ver detalles de una lista:
Obtiene descripción y canciones asociadas a una lista.

- Eliminar listas:
Borra una lista específica por su nombre.

- Persistencia en base de datos en memoria (H2):
Perfecto para desarrollo, testing y despliegue rápido.

- Pruebas unitarias con MockMvc y Mockito:
Todas las operaciones principales están cubiertas.

- Seguridad integrada:
Todos los endpoints requieren autenticación.


## 📖 Documentación de la API

| Método | Endpoint          | Descripción                           |
| ------ | ----------------- | ------------------------------------- |
| POST   | `/lists`          | Crear una nueva lista de reproducción |
| GET    | `/lists`          | Ver todas las listas de reproducción  |
| GET    | `/lists/{nombre}` | Ver una lista específica por nombre   |
| DELETE | `/lists/{nombre}` | Eliminar una lista por nombre         |

Nota (se adjunta coleccion de postman)

## 🧑‍💻 Autor

Mallori Lopez
- GitHub: [http://github.com/MalloriLopez) 
