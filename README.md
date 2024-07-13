# ForoHub.Alura_Foro-de-dudas-en-cursos 🗂️​
Versión final -1.0- del cuarto challenge desarrollado en el proceso de formación con Alura LATAM & Oracle Next Education.

## DESCRIPCIÓN
ForoHub, se desarrolló en el lenguaje de programación Java 17 como base, usando distintas dependencias como Maven, Spring Boot,
Spring Data, Spring WEB, Spring Security y MySQL. Esta API simula el funcionamiento de un foro de preguntas y respuestas, como 
el utilizado en Alura Latam, donde estudiantes, profesores y moderadores pueden colaborar y aprender juntos. Nuestro objetivo 
es replicar el proceso de gestión de un foro a nivel de backend, abordando cómo se almacena la información, cómo se relacionan
los temas con las respuestas y cómo se gestionan los usuarios y sus interacciones. La aplicación se desarrolla como parte del 
proceso de formación en Alura & Oracle Next Education. Con su desarrollo se busca aplicar los conocimientos adquiridos en el 
ámbito de la programación y formación como Backend.

### Requisitos establecidos para el desarrollo del proyecto
☑️​ Implementar una API REST con rutas siguiendo las mejores prácticas del modelo REST.<br>
☑️​​ Realizar validaciones según las reglas de negocio.<br>
☑️​​ Implementar una base de datos relacional para la persistencia de la información.<br>
☑️​​ Proveer un servicio de autenticación y autorización para restringir el acceso a la información.<br>

### Funcionalidades del proyecto
✅​ Crear un nuevo tema. <br>
✅​ Mostrar todos los temas creados. <br>
✅​ Mostrar un tema específico. <br>
✅​ Actualizar un tema. <br>
✅​ Eliminar un tema. <br>

### Diagrama ER, Base de datos

![image](https://github.com/user-attachments/assets/cabd9748-8ba9-43e7-b16e-dbb1aaa2bc03)

### Configuración
⚙️ Crear variables de entorno Name/Value:
- API_Secret/"Tu clave particular para crear el token JWT".
- DB_HOST_FORO/localhost:3306.
- DB_NAME_FORO/"Nombre para base de datos".
- DB_USER_FORO/"User creado para tu base de datos, por defecto para MySQL es 'root' ".
- DB_PSW_FORO/"Tu clave de acceso a la base de datos".

⚙️ Ruta del proyecto
- ...\src\main\java\com\monsa\ForoHubAlura\ForoHubAluraApplication.java

⚙️ Datos de prueba MySQL
- Ver y ejecutar el Script [DatosPruebas](ForoDataDummy.sql).

## USO DE LA API.
Aquí tienes algunos ejemplos de cómo interactuar con la API:<br>

## ✳️ Crear un nuevo tema
### ​POST /temas
http://localhost:server-port/temas<br>
Content-Type: application/json

{<br>
    &emsp;&emsp;"id_usuario": "Número entero sin comillas",<br> 
    &emsp;&emsp;"titulo": "Título del tema",<br>
    &emsp;&emsp;"mensaje": "Mensaje del tema",<br>
    &emsp;&emsp;"curso": "Nombre del curso"<br>
}<br>

## ✳️ Mostrar todos los temas creados <br>
### ​GET /temas
http://localhost:server-port/temas<br>
Content-Type: application/json<br>
Retorna datos paginados con todos los temas almacenados. La página se puede configurar por tamaño y número de página:<br> 
http://localhost:server-port/temas?pagina=0&tamano=10&orden=fechaCreacion.

{<br>
    &emsp;&emsp;"id": "Número entero sin comillas",<br>
    &emsp;&emsp;"titulo": "Titulo del tema",<br>
    &emsp;&emsp;"mensaje": "Mensaje del tema",<br>
    &emsp;&emsp;"fechaCreacion": "Fecha y hora",<br>
       &emsp;&emsp;"curso": {<br>
            &emsp;&emsp;&emsp;"id_curso": "Número entero sin comillas",<br>
            &emsp;&emsp;&emsp;"Curso": "Nombre del curso tipo ENUM",<br>
            &emsp;&emsp;&emsp;"categoria": "Asignatura tipo ENUM"<br>
        &emsp;&emsp;}<br>
}<br>

### ✳️ Mostrar un tema específico <br>
### ​GET /temas/{id}
http://localhost:server-port/temas/id<br>
Content-Type: application/json

{<br>
    &emsp;&emsp;"id_foro": "Número entero sin comillas",<br>
    &emsp;&emsp;"titulo": "Titulo del tema",<br>
    &emsp;&emsp;"mensaje": "Mensaje del tema",<br>
    &emsp;&emsp;"fecha_de_creacion": "Fecha y hora",<br>
    &emsp;&emsp;"activo": true/false,<br>
    &emsp;&emsp;"usuario": {<br>
        &emsp;&emsp;&emsp;&emsp;"id_usuario": "Número entero sin comillas",<br>
        &emsp;&emsp;&emsp;&emsp;"nombre": "Nombre",<br>
        &emsp;&emsp;&emsp;&emsp;"email": "email",<br>
        &emsp;&emsp;&emsp;&emsp;"usuario": "usuario"<br>
    &emsp;&emsp;},<br>
    &emsp;&emsp;"curso": {<br>
        &emsp;&emsp;&emsp;&emsp;"id_curso": "Número entero sin comillas",<br>
        &emsp;&emsp;&emsp;&emsp;"Curso": "Nombre del curso tipo ENUM",<br>
        &emsp;&emsp;&emsp;&emsp;"categoria": "Asignatura tipo ENUM"<br>
    &emsp;&emsp;},<br>
    &emsp;&emsp;"respuestas": {<br>
        &emsp;&emsp;{<br>
            &emsp;&emsp;&emsp;&emsp;"id_respuesta": "Número entero sin comillas",<br>
            &emsp;&emsp;&emsp;&emsp;"mensaje": "Mensaje respuesta del tema",<br>
            &emsp;&emsp;&emsp;&emsp;"fecha_de_creacion": "Fecha y hora",<br>
            &emsp;&emsp;&emsp;&emsp;"solucion": "Nombre de la solución",<br>
            &emsp;&emsp;&emsp;&emsp;"usuario": {<br>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"id_usuario": "Número entero sin comillas",<br>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"nombre": "Nombre de quien responde",<br>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"email": "email",<br>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"usuario": "Usuario quien responde"<br>
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;}<br>
        &emsp;&emsp;&emsp;&emsp;}<br>
    &emsp;&emsp;}<br>
}<br>

### ✳️ Actualizar un tema <br>
### ​PUT /temas/{id}
http://localhost:server-port/temas/id<br>
Content-Type: application/json
De acuerdo con las reglas de negocio, no se puede duplicar títulos y mensajes

{<br>
    &emsp;&emsp;"id_usuario": "Número entero sin comillas",<br> 
    &emsp;&emsp;"titulo": "Nuevo título del tema",<br>
    &emsp;&emsp;"mensaje": "Nuevo mensaje del tema",<br>
    &emsp;&emsp;"curso": "Nombre del curso"<br>
}<br>

### ✳️ Eliminar un tema <br>
### ​DELETE /temas/{id}
http://localhost:server-port/temas/id
<br>
<br>

## Licencias

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

### Licencias de Dependencias

Este proyecto utiliza las siguientes bibliotecas y frameworks, cada uno con sus respectivas licencias:
- **JDK de Java 17**: Disponible bajo la [Licencia Pública General de GNU, versión 2, con la excepción de la clase de biblioteca](https://openjdk.java.net/legal/gplv2+ce.html).
- **Spring Boot**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Data**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Web**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Security**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **MySQL**: Licenciado bajo la [GNU General Public License v2](https://www.gnu.org/licenses/old-licenses/gpl-2.0.html).

### Demo

https://youtu.be/BMAsHdx2myw

### Autor
Johnn Montañez Sarmiento
