package com.monsa.ForoHubAlura.Models.Perfiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.monsa.ForoHubAlura.Models.Usuarios.JPAUsuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class JPAPerfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPerfil perfil;

    //Usuarios, N a N
    @ManyToMany(mappedBy = "perfiles")
    @JsonBackReference
    private List<JPAUsuarios> usuarios; 

}
