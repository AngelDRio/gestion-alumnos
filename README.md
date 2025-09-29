# GESTOR DE ALUMNOS  
### Creado por: Ángel Del Río García  

---

## Descripción  

En este ejercicio se busca realizar un gestor de alumnos capaz de insertar alumnos mediante nombre, apellido y edad, así como poder listar qué alumnos han sido dados de alta en el programa.  
Para ello se ha hecho uso de herramientas como **Markdown, Maven, Lombok, Git, JUnit y Mockito**.  
También se ha creado una estructura de tipo **modelo, vista, controlador (MVC)** para respetar el principio de independencia de la información.  

---

## Explicación del pom.xml  

En este apartado vamos a desglosar el archivo **pom.xml** y explicar cada una de las dependencias seleccionadas para este proyecto:  

- **Lombok**: Se utiliza para la creación de getters y setters, así como el constructor en la clase Alumno.  
- **JUnit 5**: Permite realizar pruebas unitarias que se usan en el apartado de Test.  
- **Mockito**: Clave para simular el comportamiento de la base de datos al llamar o listar alumnos.  
- **Byte Buddie**: Fue necesario actualizar esta dependencia debido a problemas de compatibilidad entre **Mockito** y **Java 25**.  
- **Compilador de Maven**: Plugin que permite compilar y empaquetar el código.  
- **Surefire**: Plugin de Maven encargado de detectar y ejecutar todos los tests unitarios con JUnit.  

---

## Explicación carpeta MVC  

Esta carpeta se divide en tres: **Modelo, Vista y Controlador**.  
Este método de programación es típico cuando se quiere mantener el principio de dependencia.  

- **Carpeta modelo**  
  Contiene tres archivos:  
  - `Alumno`: Crea e inicializa la clase Alumno mediante Lombok.  
  - `AlumnoDAO`: Guarda la interfaz AlumnoDAO.  
  - `AlumnoDAOImpl`: Implementa los métodos definidos en la interfaz AlumnoDAO.  

- **Carpeta vista**  
  - `AlumnosView`: Hace referencia a la vista del proyecto (interfaz con el usuario).  

- **Carpeta controlador**  
  - `AlumnoController`: Actúa como puente entre la vista y el modelo, uniendo el backend y el frontend.  

---

## Explicación carpeta Test  

En esta carpeta encontramos dos archivos:  

- **AlumnoControllerTest**: Realiza tests inyectando **Mockito** sobre el controlador y *mockeando* la clase AlumnoDAO.  
- **AlumnoDAOImplTest**: Contiene pruebas unitarias sobre AlumnoDAO, comprobando la correcta inicialización de alumnos.  

---

## Herramientas utilizadas  

Este trabajo se ha realizado en **Visual Studio Code**, programado en **Java 25 (casa)** y **Java 21 (clase)**.  

Se utilizaron como apoyo:  
- **ChatGPT** para dudas de codificación y dependencias así como ayuda con las distintas actualizaciones de varias dependencias para que fueran compatibles con el entorno utilizado.  
- **Apuntes y códigos de ejemplo** proporcionados por el profesor, los cuales se han usado como inspiración para la realización del proyecto.  

---






