package es.alumnos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.alumnos.mvc.modelo.Alumno;
import es.alumnos.mvc.modelo.AlumnoDAOImpl;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoDAOImplTest {

    private AlumnoDAOImpl alumnoRepo;

    @BeforeEach
    void setUp(){
        alumnoRepo = new AlumnoDAOImpl();
    }

    @Test
    void testGuardarYListarAlumno() {
        Alumno alumno = new Alumno("Carlos", "Lopez", 21);

        alumnoRepo.insertarAlumno(alumno);

        List<Alumno> alumnos = alumnoRepo.listaAlumnos();

        assertEquals(1, alumnos.size());
        assertEquals("Carlos", alumnos.get(0).getNombre());
    }
}