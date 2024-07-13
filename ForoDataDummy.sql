SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE usuario_perfil;
TRUNCATE TABLE respuestas;
TRUNCATE TABLE foro;
TRUNCATE TABLE usuarios;
TRUNCATE TABLE perfiles;
TRUNCATE TABLE cursos;

SET FOREIGN_KEY_CHECKS = 1;

-- Insertar datos en la tabla 'cursos'
INSERT INTO cursos (categoria, nombre_curso) VALUES 
('PROGRAMACION', 'Introducción a Java'),
('MARKETING_DIGITAL', 'Marketing en Redes Sociales'),
('IDIOMAS', 'Inglés Básico'),
('MATEMATICAS', 'Álgebra Intermedia'),
('NEGOCIOS_Y_EMPRENDIMIENTO', 'Emprendimiento 101'),
('HABILIDADES_BLANDAS', 'Comunicación Efectiva'),
('DESARROLLO_PERSONAL', 'Gestión del Tiempo'),
('DISENO_GRAFICO', 'Photoshop para Principiantes'),
('CERTIFICACIONES_Y_EXAMENES', 'Preparación para SAT'),
('CIENCIAS', 'Introducción a la Física'),
('EVENTOS_Y_WEBINARS', 'Organización de Eventos'),
('NOTICIAS_Y_ACTUALIZACIONES', 'Novedades Tecnológicas'),
('PROYECTOS_Y_PORTAFOLIOS', 'Cómo crear un Portafolio'),
('SOPORTE_TECNICO', 'Soporte Técnico Básico'),
('TRABAJO_FINAL', 'Proyecto Final de Carrera'),
('INTRODUCCION_CURSOS', 'Curso de Bienvenida'),
('PROGRAMACION', 'Python para Principiantes'),
('MARKETING_DIGITAL', 'SEO Básico'),
('IDIOMAS', 'Francés Básico'),
('MATEMATICAS', 'Cálculo Diferencial');

-- Insertar datos en la tabla 'usuarios' clave: clave123, 123456
INSERT INTO usuarios (clave, email, nombre, usuario) VALUES 
('$2a$12$iGPVrY1UWGMppoqaFAPQlOJcgSx3RzB6Ok1O9sy45KFyUE9Zmsofa', 'user1@example.com', 'Juan Perez', 'juanperez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user2@example.com', 'Maria Lopez', 'marialopez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user3@example.com', 'Carlos Ruiz', 'carlosruiz'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user4@example.com', 'Ana Garcia', 'anagarcia'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user5@example.com', 'Luis Fernandez', 'luisfernandez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user6@example.com', 'Elena Gomez', 'elenagomez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user7@example.com', 'Pedro Martinez', 'pedromartinez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user8@example.com', 'Laura Torres', 'lauratorres'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user9@example.com', 'Jorge Sanchez', 'jorgesanchez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user10@example.com', 'Lucia Diaz', 'luciadiaz'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user11@example.com', 'Alberto Silva', 'albertosilva'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user12@example.com', 'Carmen Flores', 'carmenflores'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user13@example.com', 'Roberto Castro', 'robertocastro'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user14@example.com', 'Paula Ramos', 'paularamos'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user15@example.com', 'Miguel Ortiz', 'miguelortiz'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user16@example.com', 'Sara Chavez', 'sarachavez'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user17@example.com', 'Diego Moreno', 'diegomoreno'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user18@example.com', 'Valeria Rojas', 'valeriarojas'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user19@example.com', 'Pablo Mendoza', 'pablomendoza'),
('$2a$12$lKQVYeuD6qaAMuLSrPoK6Oj5WYdozzOR03eMF/uYXdVHBhPCZetUe', 'user20@example.com', 'Natalia Romero', 'nataliaromero');

-- Insertar datos en la tabla 'perfiles'
INSERT INTO perfiles (perfil) VALUES 
('ADMINISTRADOR'),
('EXPERTO'),
('MODERADOR'),
('USUARIO');

INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 4),
(6, 4),
(7, 4),
(8, 4),
(9, 4),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(16, 4),
(17, 4),
(18, 4),
(19, 4),
(20, 4),
(8, 3),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2);

-- Insertar datos en la tabla 'foro'
INSERT INTO foro (fecha_creacion, status, mensaje, titulo, id_curso, id_usuario) VALUES 
('2024-07-08 12:00:00', 1, '¿Cómo se instala Java?', 'Instalación de Java', 1, 1),
('2024-07-08 12:30:00', 1, '¿Qué es SEO?', 'Introducción a SEO', 17, 2),
('2024-07-08 13:00:00', 1, '¿Alguien tiene recursos para aprender Inglés?', 'Recursos para Inglés', 3, 3),
('2024-07-08 13:30:00', 1, '¿Cómo se resuelven ecuaciones cuadráticas?', 'Ecuaciones cuadráticas', 4, 4),
('2024-07-08 14:00:00', 1, '¿Qué es un MVP?', 'Definición de MVP', 5, 5),
('2024-07-08 14:30:00', 1, '¿Cómo mejorar la comunicación?', 'Técnicas de comunicación', 6, 6),
('2024-07-08 15:00:00', 1, '¿Cómo gestionar el tiempo?', 'Gestión del tiempo', 7, 7),
('2024-07-08 15:30:00', 1, '¿Cómo usar Photoshop?', 'Tutorial básico de Photoshop', 8, 8),
('2024-07-08 16:00:00', 1, '¿Cómo preparar el SAT?', 'Consejos para el SAT', 9, 9),
('2024-07-08 16:30:00', 1, '¿Qué es la física?', 'Introducción a la física', 10, 10),
('2024-07-08 17:00:00', 1, '¿Cómo organizar eventos?', 'Organización de eventos', 11, 11),
('2024-07-08 17:30:00', 1, '¿Cuáles son las últimas novedades tecnológicas?', 'Novedades tecnológicas', 12, 12),
('2024-07-08 18:00:00', 1, '¿Cómo crear un portafolio?', 'Creación de portafolios', 13, 13),
('2024-07-08 18:30:00', 1, '¿Cómo solucionar problemas técnicos?', 'Soporte técnico básico', 14, 14),
('2024-07-08 19:00:00', 1, '¿Qué se debe incluir en un proyecto final?', 'Contenido de proyectos finales', 15, 15),
('2024-07-08 19:30:00', 1, '¿Qué se ve en el curso de bienvenida?', 'Curso de bienvenida', 16, 16),
('2024-07-08 20:00:00', 1, '¿Cómo aprender Python?', 'Introducción a Python', 17, 17),
('2024-07-08 20:30:00', 1, '¿Cómo hacer marketing digital?', 'Marketing en redes sociales', 2, 18),
('2024-07-08 21:00:00', 1, '¿Cómo aprender francés?', 'Recursos para francés', 19, 19),
('2024-07-08 21:30:00', 1, '¿Cómo se resuelven derivadas?', 'Resolución de derivadas', 20, 20),
('2024-07-09 10:00:00', 1, '¿Cómo mejorar la productividad en el trabajo?', 'Productividad en el trabajo', 7, 1),
('2024-07-09 10:30:00', 1, '¿Cuáles son las mejores herramientas para diseño gráfico?', 'Herramientas de diseño gráfico', 8, 1),
('2024-07-09 11:00:00', 1, '¿Qué técnicas de SEO son más efectivas?', 'Técnicas de SEO efectivas', 17, 1),
('2024-07-09 11:30:00', 1, '¿Cómo iniciar un negocio online?', 'Negocios online', 5, 2),
('2024-07-09 12:00:00', 1, '¿Cómo preparar una presentación efectiva?', 'Presentaciones efectivas', 6, 2),
('2024-07-09 12:30:00', 1, '¿Cómo desarrollar una aplicación móvil?', 'Desarrollo de apps móviles', 1, 3),
('2024-07-09 13:00:00', 1, '¿Qué es el marketing de contenido?', 'Marketing de contenido', 2, 4),
('2024-07-09 13:30:00', 1, '¿Cómo mejorar la pronunciación en inglés?', 'Pronunciación en inglés', 3, 5),
('2024-07-09 14:00:00', 1, '¿Cuáles son las mejores prácticas para el desarrollo personal?', 'Desarrollo personal', 7, 6),
('2024-07-09 14:30:00', 1, '¿Cómo organizar eventos exitosos?', 'Organización de eventos exitosos', 11, 7);

-- Insertar datos en la tabla 'respuestas'
INSERT INTO respuestas (fecha_creacion, mensaje, solucion, id_foro, id_usuario) VALUES 
('2024-07-08 12:10:00', 'Primero debes descargar el JDK.', 'Instalar el JDK de Oracle.', 1, 2),
('2024-07-08 12:40:00', 'SEO significa optimización para motores de búsqueda.', 'Consulta recursos en línea como blogs.', 2, 3),
('2024-07-08 13:10:00', 'Puedes usar aplicaciones móviles.', 'Prueba Duolingo.', 3, 4),
('2024-07-08 13:40:00', 'Debes usar la fórmula cuadrática.', 'Consulta el libro de álgebra.', 4, 5),
('2024-07-08 14:10:00', 'Es un producto mínimo viable.', 'Lee sobre Lean Startup.', 5, 6),
('2024-07-08 14:40:00', 'Practica la escucha activa.', 'Realiza ejercicios de comunicación.', 6, 7),
('2024-07-08 15:10:00', 'Haz una lista de tareas.', 'Usa herramientas como Trello.', 7, 8),
('2024-07-08 15:40:00', 'Empieza con lo básico.', 'Consulta tutoriales en YouTube.', 8, 9),
('2024-07-08 16:10:00', 'Realiza simulacros.', 'Revisa exámenes anteriores.', 9, 10),
('2024-07-08 16:40:00', 'Es el estudio de la materia y energía.', 'Consulta libros de física básica.', 10, 11),
('2024-07-08 17:10:00', 'Empieza con un plan detallado.', 'Utiliza un software de gestión de eventos.', 11, 12),
('2024-07-08 17:40:00', 'Revisa las últimas noticias en tecnología.', 'Suscríbete a blogs de tecnología.', 12, 13),
('2024-07-08 18:10:00', 'Incluye tus mejores trabajos.', 'Utiliza plantillas profesionales.', 13, 14),
('2024-07-08 18:40:00', 'Revisa los problemas comunes.', 'Consulta manuales de usuario.', 14, 15),
('2024-07-08 19:10:00', 'Consulta las guías de tu institución.', 'Revisa proyectos anteriores.', 15, 16),
('2024-07-08 19:40:00', 'Revisa el contenido del curso.', 'Consulta con el instructor.', 16, 17),
('2024-07-08 20:10:00', 'Empieza con lo básico.', 'Consulta tutoriales en línea.', 17, 18),
('2024-07-08 20:40:00', 'Utiliza plataformas de redes sociales.', 'Consulta cursos en línea.', 18, 19),
('2024-07-08 21:10:00', 'Empieza con vocabulario básico.', 'Utiliza aplicaciones móviles.', 19, 20),
('2024-07-08 21:40:00', 'Utiliza las reglas de derivación.', 'Consulta libros de cálculo.', 20, 1),
('2024-07-09 10:10:00', 'Haz listas de tareas y prioriza.', 'Usa una app de gestión de tareas.', 21, 8),
('2024-07-09 10:40:00', 'Prueba Photoshop e Illustrator.', 'Consulta tutoriales en línea.', 22, 9),
('2024-07-09 11:10:00', 'Usa palabras clave de cola larga.', 'Consulta blogs de SEO.', 23, 10),
('2024-07-09 11:40:00', 'Empieza con un plan de negocio.', 'Lee sobre modelos de negocio.', 24, 1),
('2024-07-09 12:10:00', 'Practica tu discurso.', 'Usa herramientas de presentación.', 25, 2),
('2024-07-09 12:40:00', 'Aprende sobre frameworks móviles.', 'Consulta cursos en línea.', 26, 3),
('2024-07-09 13:10:00', 'Crea contenido de valor.', 'Usa herramientas de análisis.', 27, 4),
('2024-07-09 13:40:00', 'Practica con un hablante nativo.', 'Utiliza apps de idiomas.', 28, 5),
('2024-07-09 14:10:00', 'Establece metas claras.', 'Consulta libros de autoayuda.', 29, 6),
('2024-07-09 14:40:00', 'Planifica con antelación.', 'Usa herramientas de gestión.', 30, 7);