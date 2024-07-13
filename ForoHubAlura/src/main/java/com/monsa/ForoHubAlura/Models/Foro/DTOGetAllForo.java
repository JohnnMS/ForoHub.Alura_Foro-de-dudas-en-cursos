package com.monsa.ForoHubAlura.Models.Foro;

import java.util.Date;

import com.monsa.ForoHubAlura.Models.Cursos.DTOCursos;

public record DTOGetAllForo(
    Long id,
    String titulo,
    String mensaje,
    Date fechaCreacion,
    DTOCursos curso) {

    public DTOGetAllForo(JPAForo foro) {
        this(
            foro.getIdForo(),
            foro.getTitulo(),
            foro.getMensaje(),
            foro.getFechaCreacion(),
            new DTOCursos(foro.getCursos()));
    }
}