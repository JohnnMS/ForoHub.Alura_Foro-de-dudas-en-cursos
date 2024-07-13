package com.monsa.ForoHubAlura.Models.Foro;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monsa.ForoHubAlura.Models.Cursos.JPACursos;
import com.monsa.ForoHubAlura.Models.Respuestas.JPARespuestas;
import com.monsa.ForoHubAlura.Models.Usuarios.JPAUsuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "foro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JPAForo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foro", nullable = false)
    private Long idForo;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String mensaje;
    
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    
    @Column(name = "status", nullable = false)
    @JsonIgnore
    private Boolean isActive; 
   
    // Usuarios, N-1
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private JPAUsuarios usuarios;

    // Cursos, N-1
    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonBackReference
    private JPACursos cursos;

    // Respuestas, 1-N
    @OneToMany(mappedBy = "foro")
    @JsonManagedReference
    private List<JPARespuestas> respuestas;

}
