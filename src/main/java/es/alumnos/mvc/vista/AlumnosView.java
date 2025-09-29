package es.alumnos.mvc.vista;

import java.util.Scanner;

import es.alumnos.mvc.controlador.AlumnoController;
import es.alumnos.mvc.modelo.Alumno;
import es.alumnos.mvc.modelo.AlumnoDAO;
import es.alumnos.mvc.modelo.AlumnoDAOImpl;

public class AlumnosView {

    // Constantes para opciones de menú
    private static final int OPCION_INSERTAR = 1;
    private static final int OPCION_LISTAR = 2;
    private static final int OPCION_SALIR = 0;

    // Constantes para índices de datos del alumno
    private static final int PARTES_ESPERADAS = 3;
    private static final int IDX_NOMBRE = 0;
    private static final int IDX_APELLIDOS = 1;
    private static final int IDX_EDAD = 2;

    // Constantes para validación de edad
    private static final int EDAD_MINIMA = 0;
    private static final int EDAD_MAXIMA = 150;

    // Constantes de textos
    private static final String TEXTO_MENU_TITULO = "==== Menú ====";
    private static final String TEXTO_MENU_INSERTAR = OPCION_INSERTAR + ". Insertar alumno";
    private static final String TEXTO_MENU_LISTAR = OPCION_LISTAR + ". Listar alumnos";
    private static final String TEXTO_MENU_SALIR = OPCION_SALIR + ". Salir";
    private static final String TEXTO_MENU_PEDIR_OPCION = "Elige una opción: ";

    private static final String TEXTO_PEDIR_DATOS = "Introduce los datos del alumno (nombre apellidos edad):";
    private static final String TEXTO_ALUMNO_INSERTADO = "Alumno insertado correctamente.";
    private static final String TEXTO_LISTADO_ALUMNOS = "Listado de alumnos:";
    private static final String TEXTO_SALIENDO = "Saliendo de la aplicación...";
    private static final String TEXTO_OPCION_INVALIDA = "Opción no válida.";

    private static final String TEXTO_ERROR_FORMATO = "Formato incorrecto. Debe ser: nombre apellidos edad";
    private static final String TEXTO_ERROR_EDAD = "La edad debe estar entre " + EDAD_MINIMA + " y " + EDAD_MAXIMA;
    private static final String TEXTO_ERROR_NUMERO = "Error: La edad debe ser un número válido.";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlumnoDAO alumnoDao = new AlumnoDAOImpl();
        AlumnoController controlador = new AlumnoController(alumnoDao);

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case OPCION_INSERTAR -> {
                    System.out.println(TEXTO_PEDIR_DATOS);
                    String input = sc.nextLine().trim();
                    String[] partes = input.split("\\s+");

                    try {
                        if (partes.length != PARTES_ESPERADAS || partes[IDX_NOMBRE].isBlank() || partes[IDX_APELLIDOS].isBlank() || partes[IDX_EDAD].isBlank()) {
                            throw new IllegalArgumentException(TEXTO_ERROR_FORMATO);
                        }

                        if (!esTextoValido(partes[IDX_NOMBRE]) || !esTextoValido(partes[IDX_APELLIDOS])) {
                            throw new IllegalArgumentException(TEXTO_ERROR_FORMATO);
                        }

                        String nombre = partes[IDX_NOMBRE];
                        String apellidos = partes[IDX_APELLIDOS];
                        int edad = Integer.parseInt(partes[IDX_EDAD]);

                        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
                            throw new IllegalArgumentException(TEXTO_ERROR_EDAD);
                        }

                        Alumno alumno = new Alumno(nombre, apellidos, edad);
                        controlador.insertarAlumno(alumno);
                        System.out.println(TEXTO_ALUMNO_INSERTADO);
                        
                    } catch (NumberFormatException errorFormatoNumero) {
                        System.out.println(TEXTO_ERROR_NUMERO);
                    } catch (IllegalArgumentException errorArgumentoInvalido) {
                        System.out.println(errorArgumentoInvalido.getMessage());
                    }
                }
                case OPCION_LISTAR -> {
                    System.out.println(TEXTO_LISTADO_ALUMNOS);
                    controlador.listarAlumnos().forEach(System.out::println);
                }
                case OPCION_SALIR -> {
                    salir = true;
                    System.out.println(TEXTO_SALIENDO);
                }
                default -> System.out.println(TEXTO_OPCION_INVALIDA);
            }
        }
    }
    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println(TEXTO_MENU_TITULO);
        System.out.println(TEXTO_MENU_INSERTAR);
        System.out.println(TEXTO_MENU_LISTAR);
        System.out.println(TEXTO_MENU_SALIR);
        System.out.print(TEXTO_MENU_PEDIR_OPCION);
    }

    // Método para validar que un texto contiene solo letras (incluyendo acentos y eñes)
    private static boolean esTextoValido(String s) {
    return s.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ]+");
    }
}


