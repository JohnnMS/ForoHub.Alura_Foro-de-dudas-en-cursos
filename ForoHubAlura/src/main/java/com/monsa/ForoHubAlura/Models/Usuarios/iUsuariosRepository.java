package com.monsa.ForoHubAlura.Models.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface iUsuariosRepository extends JpaRepository<JPAUsuarios, Long>{
    // Método declarado para AutenticacionAPI
    UserDetails findByUsuario(String usuario);

}
