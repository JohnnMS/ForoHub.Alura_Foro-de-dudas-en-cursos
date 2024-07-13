package com.monsa.ForoHubAlura.Models.Foro;

import java.util.Date;

import com.monsa.ForoHubAlura.Models.Cursos.DTOCursos;
import com.monsa.ForoHubAlura.Models.Usuarios.DTOUsuarios;

public record DTOPostReturnTemaForo(
    Long id_foro,
    String titulo,
    String mensaje,
    Date fecha_de_creacion,
    DTOUsuarios usuario,
    DTOCursos curso
){

    public DTOPostReturnTemaForo(JPAForo foroCreado) {
         this(
            foroCreado.getIdForo(),
            foroCreado.getTitulo(),
            foroCreado.getMensaje(),
            foroCreado.getFechaCreacion(),
            new DTOUsuarios(foroCreado.getUsuarios()),
            new DTOCursos(foroCreado.getCursos())
            );
    }

}
