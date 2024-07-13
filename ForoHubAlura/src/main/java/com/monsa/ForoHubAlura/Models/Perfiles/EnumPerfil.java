package com.monsa.ForoHubAlura.Models.Perfiles;

public enum EnumPerfil {

    ADMINISTRADOR("Administrador"),
    MODERADOR("Moderador"),
    USUARIO("Usuario"),
    EXPERTO("Experto");

    private String perfilNombre;

    EnumPerfil(String perfilNombre) {
        this.perfilNombre = perfilNombre;
    }

    public String getPerfilNombre() {
        return perfilNombre;
    }

    public static EnumPerfil usuarioPerfil(String text) {
        for (EnumPerfil enumPerfil : EnumPerfil.values()) {
            if (enumPerfil.perfilNombre.equalsIgnoreCase(text)) {
                return enumPerfil;
            }
        }
        throw new IllegalArgumentException("Perfil no encontrado: " + text);
    }

}
