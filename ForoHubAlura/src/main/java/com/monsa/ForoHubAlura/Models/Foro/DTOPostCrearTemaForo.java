package com.monsa.ForoHubAlura.Models.Foro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DTOPostCrearTemaForo(
    @NotNull
    Long id_usuario,
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje,
    @NotBlank
    String curso ) {}
