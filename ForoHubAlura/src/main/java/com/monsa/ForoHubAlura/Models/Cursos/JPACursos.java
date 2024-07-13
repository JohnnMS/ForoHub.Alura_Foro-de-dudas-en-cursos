package com.monsa.ForoHubAlura.Models.Cursos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monsa.ForoHubAlura.Models.Foro.JPAForo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class JPACursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumCategoria categoria;

    // Foro, 1-N
    @OneToMany(mappedBy = "cursos")
    @JsonManagedReference
    private List<JPAForo> foro;

}
