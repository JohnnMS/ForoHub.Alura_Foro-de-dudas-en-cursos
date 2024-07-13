package com.monsa.ForoHubAlura.Models.Usuarios;

public record DTOUsuarios(
    
    Long id_usuario, 
    String nombre, 
    String email, 
    String usuario) {
    
    public DTOUsuarios(JPAUsuarios usuario) {
        this(
            usuario.getIdUsuario(), 
            usuario.getNombre(), 
            usuario.getEmail(), 
            usuario.getUsuario());
    }
}
