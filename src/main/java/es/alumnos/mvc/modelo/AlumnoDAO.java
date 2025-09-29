package es.alumnos.mvc.modelo;

import java.util.List;

public interface AlumnoDAO {
    Alumno insertarAlumno(Alumno alumno);
    List<Alumno> listaAlumnos();
}