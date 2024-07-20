# CHALLENGE 4: ForoHub.Alura, foro de dudas para cursos online 🗂️​
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
⚙️ Crear variables de entorno Name / Value:
- API_Secret / "Tu clave".
> [!NOTE]
> Clave para la firma de los web token JWT.
- DB_HOST_FORO / localhost:3306
- DB_NAME_FORO / "Nombre para la base de datos"
- DB_USER_FORO / "tu usuario de acceso a la base de datos".
> [!NOTE]
> Por defecto para MySQL el usuario es 'root'.
- DB_PSW_FORO / "Tu clave de acceso a la base de datos"

⚙️ Ruta del proyecto
- ...\src\main\java\com\monsa\ForoHubAlura\ForoHubAluraApplication.java

⚙️ Datos de prueba MySQL
- Ver y ejecutar el Script [DatosPruebas](ForoDataDummy.sql).

## USO DE LA API.
Aquí tienes algunos ejemplos de cómo interactuar con la API:<br>

## ✳️ Autenticación
### ​POST /login
Content-Type: application/json <br>
Auth type: Bearer Token

![image](https://github.com/user-attachments/assets/d31548b6-e1bb-4e78-a619-efc5c51ffb5e)

> [!NOTE]
>  Ver datos de usuarios en la base de datos. Las claves se encuentran codificadas con *Bcrypt password hashes*. Administrador clave: 123456, otros usuarios: clave123 

## ✳️ Crear un nuevo tema
### ​POST /temas
Content-Type: application/json

![image](https://github.com/user-attachments/assets/6cc00394-f19d-4d9b-a0e4-7bb9915abed2)

> [!NOTE]
> Ver nombres de los cursos en la base de datos.


## ✳️ Mostrar todos los temas creados <br>
### ​GET /temas
Content-Type: application/json<br>
Retorna datos paginados con todos los temas almacenados. La página se puede configurar por tamaño y número de página:<br> 

![image](https://github.com/user-attachments/assets/993db71b-8760-4c8e-88cf-4bd6e540feca)


## ✳️ Mostrar un tema específico <br>
### ​GET /temas/{id}
Content-Type: application/json

![image](https://github.com/user-attachments/assets/0b7bfe74-2b7d-4269-ba60-e5a53359dd24)


## ✳️ Actualizar un tema <br>
### ​PUT /temas/{id}
Content-Type: application/json <br>
De acuerdo con las reglas de negocio, no se puede duplicar ni títulos, ni mensajes para un mismo {id}

![image](https://github.com/user-attachments/assets/4e0dd0bb-fa8b-482e-a321-617c105915ba)


## ✳️ Eliminar un tema <br>
### ​DELETE /temas/{id}
La API responde con los código de estado: 200 OK, 403 Forbidden o 404 Not Found, según el caso

![image](https://github.com/user-attachments/assets/a86032df-25b8-49c6-9b85-fde15ba23f49)
<br>

## Licencias

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Licencias de Dependencias

Este proyecto utiliza las siguientes bibliotecas y frameworks, cada uno con sus respectivas licencias:
- **JDK de Java 17**: Disponible bajo la [Licencia Pública General de GNU, versión 2, con la excepción de la clase de biblioteca](https://openjdk.java.net/legal/gplv2+ce.html).
- **Spring Boot**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Data**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Web**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **Spring Security**: Licenciado bajo la [Licencia Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
- **MySQL**: Licenciado bajo la [GNU General Public License v2](https://www.gnu.org/licenses/old-licenses/gpl-2.0.html).

## Demo

[https://youtu.be/BMAsHdx2myw](https://youtu.be/NXfdXpZHLvo)

## Autor
Johnn Montañez Sarmiento
