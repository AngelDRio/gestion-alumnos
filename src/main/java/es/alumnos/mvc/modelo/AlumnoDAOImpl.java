package es.alumnos.mvc.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {

    private final List<Alumno> listaAlumnos = new ArrayList<>();

    @Override
    public Alumno insertarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
        return alumno;
    }

    @Override
    public List<Alumno> listaAlumnos() {
        return new ArrayList<>(listaAlumnos);
    }
}