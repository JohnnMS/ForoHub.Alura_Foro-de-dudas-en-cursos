package com.monsa.ForoHubAlura.Models.Cursos;

public enum EnumCategoria {

    INTRODUCCION_CURSOS("Introducción a los Cursos"),
    SOPORTE_TECNICO("Soporte Técnico"),
    PROGRAMACION("Programación"),
    DISENO_GRAFICO("Diseño Gráfico"),
    MARKETING_DIGITAL("Marketing Digital"),
    NEGOCIOS_Y_EMPRENDIMIENTO("Negocios y Emprendimiento"),
    IDIOMAS("Idiomas"),
    CIENCIAS("Ciencias"),
    HABILIDADES_BLANDAS("Habilidades Blandas"),
    MATEMATICAS("Matemáticas"),
    DESARROLLO_PERSONAL("Desarrollo Personal"),
    CERTIFICACIONES_Y_EXAMENES("Certificaciones y Exámenes"),
    PROYECTOS_Y_PORTAFOLIOS("Proyectos y Portafolios"),
    NOTICIAS_Y_ACTUALIZACIONES("Noticias y Actualizaciones"),
    EVENTOS_Y_WEBINARS("Eventos y Webinars"),
    TRABAJO_FINAL("Trabajo final");

    private String categoria;

    EnumCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public static EnumCategoria categoriaForo(String text) {
        for (EnumCategoria enumCategoria : EnumCategoria.values()) {
            if (enumCategoria.categoria.equalsIgnoreCase(text)) {
                return enumCategoria;
            }
        }
        throw new IllegalArgumentException("Categoría no encontrada: " + text);
    }
    
}


