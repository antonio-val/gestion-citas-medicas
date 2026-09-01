# API Gestion citas medicas

RESTful API para la gestión de citas médicas desarrollada con Spring Boot 4 y Java 21.

## Funcionalidades principales:
* Registro y actualización de pacientes.   
* Creación y actualización de citas, incluyendo su finalización.

## Stack tecnológico:
* Java 21
* Spring Boot 4.0 (Spring Web, Spring Data JPA, Validation)
* PostgreSQL

## Decisiones de diseño:
* Estructura package-by-feature: para evitar la futura aglomeración de clases, se utiliza para el proyecto una estructura package-by-feature.
* Clean Code: se siguen los principios de Clean Code.
* Soporte de internacionalización: los textos están en español e inglés y, para cada idioma, centralizado en un archivo.
* Identificadores públicos: para evitar la vulnerabilidad IDOR (Insecure Direct Object References).
* Borrado lógico (soft delete): para preservar la integridad referencial de las citas.
* Privacidad de datos sensibles (DNI): la búsqueda por DNI se realiza enviando el DNI en el Request-Body para evitar su exposición en los logs de URLs de otras máquinas.

## Limitaciones actuales
* Ausencia de autenticación y autorización: por simplicidad para la demo, la API es de libre acceso.
* Ausencia del derecho al olvido: actualmente, si el paciente se da de baja y usa su derecho al olvido, no se puede realizar. Haría falta un mecanismo de anonimación.
* Ausencia de pruebas automatizadas: debido a esto no se puede garantizar la calidad del producto en futuros cambios.
* Formato del código mejorable: automatizar las reglas de formateado deseadas (autoformatter).

## Endopoints principales de la API

### Pacientes (`/api/v1/patients`)

| Método | Endpoint | Descripción | Estado HTTP |
| --- | --- | --- | --- |
| `POST` | `/api/v1/patients` | Registrar un nuevo paciente | `201 Created` (+ Header `Location` [ ] |
| `POST` | `/api/v1/patients/search` | Buscar paciente por DNI (requiere `nationalIdNumber`) | `200 OK` [ ] |
| `GET` | `/api/v1/patients` | Obtener los datos de todos los pacientes | `200 OK` [ ] |
| `PUT` | `/api/v1/patients/{publicId}` | Actualizar de forma completa un paciente | `200 OK` [ ] |
| `PATCH` | `/api/v1/patients/{publicId}` | Actualizar de forma parcial un paciente | `200 OK` [ ] |
| `DELETE` | `/api/v1/patients/{publicId}` | Borrar de forma lógica (soft delete) un paciente | `204 No Content` [ ] |

### Citas médicas (`/api/v1/appointments`)

| Método | Endpoint | Descripción | Estado HTTP |
| --- | --- | --- | --- |
| `POST` | `/api/v1/appointments` | Registrar una nueva cita | `201 Created` (+ Header `Location` [ ] |
| `POST` | `/api/v1/appointments/search` | Obtener las citas de un paciente usando su DNI (requiere `nationalIdNumber`) | `200 OK` [ ] |
| `GET` | `/api/v1/appointments` | Obtener los datos de todas citas | `200 OK` [ ] |
| `PATCH` | `/api/v1/appointments/{publicId}/complete` | Completar cita | `200 OK` [ ] |
| `PATCH` | `/api/v1/appointments/{publicId}/cancel` | Cancelar cita | `200 OK` [ ] |
| `PATCH` | `/api/v1/appointments/{publicId}` | Actualizar de forma parcial una cita | `200 OK` [ ] |
