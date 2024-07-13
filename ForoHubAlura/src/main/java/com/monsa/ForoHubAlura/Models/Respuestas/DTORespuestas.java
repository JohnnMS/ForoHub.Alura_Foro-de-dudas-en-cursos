package com.monsa.ForoHubAlura.Models.Respuestas;

import java.util.Date;

import com.monsa.ForoHubAlura.Models.Usuarios.DTOUsuarios;

public record DTORespuestas(
    
    Long id_respuesta, 
    String mensaje, 
    Date fecha_de_creacion, 
    String solucion, 
    DTOUsuarios usuario) {
   
    public DTORespuestas(JPARespuestas respuesta) {
        this(
            respuesta.getIdRespuesta(), 
            respuesta.getMensaje(), 
            respuesta.getFechaCreacion(), 
            respuesta.getSolucion(),
            new DTOUsuarios(respuesta.getUsuarios()));
    }
}
