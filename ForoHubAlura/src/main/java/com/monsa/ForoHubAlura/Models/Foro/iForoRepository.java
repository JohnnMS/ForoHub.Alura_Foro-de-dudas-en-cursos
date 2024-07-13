package com.monsa.ForoHubAlura.Models.Foro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface iForoRepository extends JpaRepository<JPAForo, Long>{

    Page<JPAForo> findByIsActiveTrue(Pageable paginacion);
    JPAForo findByIdForoAndIsActiveTrue(Long idForo);
    JPAForo findByTituloAndMensajeAndUsuariosIdUsuario(String titulo, String mensaje, Long idUsuario);

}

