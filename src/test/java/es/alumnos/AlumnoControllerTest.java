package es.alumnos;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.alumnos.mvc.controlador.AlumnoController;
import es.alumnos.mvc.modelo.Alumno;
import es.alumnos.mvc.modelo.AlumnoDAO;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlumnoControllerTest {

    @Mock
    private AlumnoDAO alumnoDAO;

    @InjectMocks
    private AlumnoController alumnoController;

    @Test
    void testInsertarAlumno() {
        Alumno alumno = new Alumno("Juan", "Pérez", 20);
        when(alumnoDAO.insertarAlumno(any(Alumno.class))).thenReturn(alumno);

        Alumno resultado = alumnoController.insertarAlumno(alumno);

        assertEquals("Juan", resultado.getNombre());
        assertEquals("Pérez", resultado.getApellidos());
        assertEquals(20, resultado.getEdad());
        verify(alumnoDAO).insertarAlumno(alumno);
    }

    @Test
    void testListarAlumnos() {
        Alumno a1 = new Alumno("Ana", "García", 22);
        Alumno a2 = new Alumno("Luis", "Martínez", 19);

        when(alumnoDAO.listaAlumnos()).thenReturn(Arrays.asList(a1, a2));

        List<Alumno> alumnos = alumnoController.listarAlumnos();

        assertEquals(2, alumnos.size());
        assertEquals("Ana", alumnos.get(0).getNombre());
        verify(alumnoDAO).listaAlumnos();
    }
}