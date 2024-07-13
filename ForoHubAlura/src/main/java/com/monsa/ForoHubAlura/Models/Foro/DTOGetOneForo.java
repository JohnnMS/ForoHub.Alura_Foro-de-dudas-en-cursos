package com.monsa.ForoHubAlura.Models.Foro;

import java.util.Date;
import java.util.List;

import com.monsa.ForoHubAlura.Models.Cursos.DTOCursos;
import com.monsa.ForoHubAlura.Models.Respuestas.DTORespuestas;
import com.monsa.ForoHubAlura.Models.Usuarios.DTOUsuarios;

public record DTOGetOneForo(
    Long id_foro,
    String titulo,
    String mensaje,
    Date fecha_de_creacion,
    Boolean activo,
    DTOUsuarios usuario,
    DTOCursos curso,
    List<DTORespuestas> respuestas) {

    public DTOGetOneForo(JPAForo foro) {
        this(
            foro.getIdForo(),
            foro.getTitulo(),
            foro.getMensaje(),
            foro.getFechaCreacion(),
            foro.getIsActive(),
            new DTOUsuarios(foro.getUsuarios()),
            new DTOCursos(foro.getCursos()),
            foro.getRespuestas().stream().map(DTORespuestas::new).toList()
        );
    }
}