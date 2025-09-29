**##GESTOR DE ALUMNOS##**
##Creado por: Ángel Del Río García.##
---
**##Descripción##**

En este ejercicio se busca realizar un gestor de alumnos capaz de insertar alumnos mediante nombre, apellido y edad así como poder listar que alumnos han sido dados de alta en el programa.
Para ello se ha hecho uso de herramientas como **markdonw**, **maven**, **lombok**, **git**, **junit** y **mockito**.
También se ha creado una estructura de tipo modelo, vista, controlador para respetas el principio de indepencia de la información.
---
**##Explicación del pom.xml**

En este apartado vamos a desglosar el archivo *pom.xml* y explicar cada una de las dependencias seleccionadas para este proyecto.

- **Lombok**: En este proyecto se utiliza **Lombok** para la creación de getters y setters así como el contructor en la clase alumno.
- **JUnit 5**: Usamos la dependencia de **JUnit 5** para inicializar este mismo. JUnit 5 nos ayuda a realizar pruebas unitarias que usaremos en los apartador de **Test**.
- **Mockito**: El uso de **Mockito** es clave para este proyecto ya que en el apartado de **Test** usaremos **Mockito** para simular el comprotamiento de la base de datos al llamar a un alumno o listar a estos mismos.
- **Byte Buddie**: La implementación de la dependencia de **ByteBuddie** puede parecer extraña en un inicio, pero tiene una explicación válida. Al realizar los tests correspondientes usando **Mockito** saltaba un error en cada implementación de @Test, el error en cuestión se debía a que la versión de **Byte Buddie** y **Mockito** no soportaba la versión de Java utilizada para este proyecto (Java 25), debido a sto se tuvo que hacer una actualización de dichas herramientas y especificar la verión de cada una en el archivo pom.xml.
- **Compilador de Maven**: El compilador de **Maven** no es una dependencia en sí, si no una plugin. Este se usa para que, al realizar proyectos con **Maven**, este pueda compilar y empaquetar el código.
- **Surefire**: Este, al igual que el compilador, es otro plugin de **Maven**, en este caso, este plugin es el encargado de detectar y ejecutar todos los tests unitarios realizados con JUnit.
---
**##Explicación carpeta mvc##**

Esta carpeta se divide a su vez en otras tres llamadas: **Modelo**, **vista** y **controlador**. Este método de programación es muy típico cuando se quiere mantener el principio de dependencia.

- **Carpeta modelo**: En esta carpeta encontramos tres archivos: **Alumno**, **AlumnoDAO** y **AlumnoDAOImpl**. Estas tres carpetas hacen referencia al modelo del proyecto, en otras palabras, el backend, donde se guardan y registran todos los datos.

    - **Alumno**: Crea e inicializa la clase alumno mediante Lombok.
    - **AlumnoDAO**: Este archivo guarda la intefaz **AlumnoDAO**.
    - **AlumnoDAOImpl**: Este archivo implementa los metodos definidos en la interfaz (**AlumnoDAO**).

-**Carpeta vista**: En esta carpeta encontramos un solo archivo: **AlumnosView**, este archivo hace referencia a la vista del proyecto, es decir, la parte que se muestra al usuario y por la que se recogen los datos insertados por el mismo para más tarde ser almacenados.

-**Carpeta controlador**: El único archivo que rellena esta carpeta es el archivo **AlumnoController**, que hace referencia al controlador del proyecto, también conocido como el puente entre la vista y el modelo. El controlador se encarga de unir ambas partes del trabajo: *Backend* y *Frontend*.
---
**##Explicación carpeta Test##**

En esta carpeta encontramos dos archivos: 
    
    - **AlumnoControllerTest**: En este archivo se realizan tests inyectando **Mockito** sobre el controlador y mocketizando la clase AlumnoDAO, es decir, simulando dicha clase ya que no contamos con una base de datos real.
    - **AlumnoDAOImplTest**: Este archivo contiene pruebas unitarias sobre el archivo AlumnoDAO, para comprobar si la inicialización de alumnos es correcta. En este archivo pordríamos realizar infinidad de pruebas unitarias pero se ha realizado una de prueba para comprobar la utilidad de las pruebas unitarias, al igual que en el archivo anterior se comprueban los test *doubles*.
---
**##Herramientas utilizadas##**

Este trabajo se ha realizado en el entorno de **Visual Studio Code**, programado en lenguaje **Java**, tanto en la versión 25 (casa) como en la 21 (clase).
Como apoyo para la realización del trabajo se han utilizado diferentes herramientas como **ChatGPT** para consultar dudas de codificación, estructura y actualizaciones de las distintas dependencias para que sean compatibles con el entorno utilizado.
También se ha hecho uso de los apuntes y códigos de ejemplo proporcionados por el profesor, los cuales se han usado como inspiración para la realización del proyecto.
---





