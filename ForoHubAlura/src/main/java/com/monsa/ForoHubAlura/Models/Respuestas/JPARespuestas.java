package com.monsa.ForoHubAlura.Models.Respuestas;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.monsa.ForoHubAlura.Models.Foro.JPAForo;
import com.monsa.ForoHubAlura.Models.Usuarios.JPAUsuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class JPARespuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta", nullable = false)
    private Long idRespuesta;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

   @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String solucion;

    // Foro, N a 1
    @ManyToOne
    @JoinColumn(name = "id_foro")
    @JsonBackReference
    private JPAForo foro;

    // Usuarios, N a 1
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private JPAUsuarios usuarios;


}
