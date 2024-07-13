package com.monsa.ForoHubAlura.Models.Cursos;

public record DTOCursos(
    
    Long id_curso, 
    String Curso, 
    String categoria) {

    public DTOCursos(JPACursos curso) {
        this(
            curso.getIdCurso(), 
            curso.getNombreCurso(), 
            curso.getCategoria().toString());
    }
}
