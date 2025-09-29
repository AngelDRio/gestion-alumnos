package es.alumnos.mvc.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data @AllArgsConstructor @ToString

public class Alumno {
    private String nombre;
    private String apellidos;
    private int edad;
}


