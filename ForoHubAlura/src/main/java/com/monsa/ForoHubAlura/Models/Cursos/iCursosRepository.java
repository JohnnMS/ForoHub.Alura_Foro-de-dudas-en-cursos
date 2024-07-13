package com.monsa.ForoHubAlura.Models.Cursos;

import org.springframework.data.jpa.repository.JpaRepository;


public interface iCursosRepository extends JpaRepository<JPACursos, Long>{

    JPACursos findIdByNombreCurso(String nombreCurso);

}
