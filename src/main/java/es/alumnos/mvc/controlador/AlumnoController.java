package es.alumnos.mvc.controlador;

import java.util.List;

import es.alumnos.mvc.modelo.Alumno;
import es.alumnos.mvc.modelo.AlumnoDAO;

public class AlumnoController {

    private final AlumnoDAO alumnoDAO;

    public AlumnoController(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public Alumno insertarAlumno(Alumno alumno) {
        return alumnoDAO.insertarAlumno(alumno);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoDAO.listaAlumnos();
    }
}