package com.monsa.ForoHubAlura.Controllers;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.monsa.ForoHubAlura.Models.Foro.DTOGetOneForo;
import com.monsa.ForoHubAlura.Models.Foro.DTOPostCrearTemaForo;
import com.monsa.ForoHubAlura.Models.Foro.DTOPostReturnTemaForo;
import com.monsa.ForoHubAlura.Models.Foro.DTOPostUpdateTemaForo;
import com.monsa.ForoHubAlura.Models.Cursos.JPACursos;
import com.monsa.ForoHubAlura.Models.Cursos.iCursosRepository;
import com.monsa.ForoHubAlura.Models.Foro.DTOGetAllForo;
import com.monsa.ForoHubAlura.Models.Foro.JPAForo;
import com.monsa.ForoHubAlura.Models.Foro.iForoRepository;
import com.monsa.ForoHubAlura.Models.Usuarios.JPAUsuarios;
import com.monsa.ForoHubAlura.Models.Usuarios.iUsuariosRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/temas")
public class ForoController {

    private final iForoRepository foroRepository;
    private final iUsuariosRepository usuariosRepository;
    private final iCursosRepository cursosRepository;

    public ForoController(iForoRepository foroRepository,
                          iUsuariosRepository usuariosRepository,
                          iCursosRepository cursosRepository) {
        this.foroRepository = foroRepository;
        this.usuariosRepository = usuariosRepository;
        this.cursosRepository = cursosRepository;
    }

    /**
     * Guarda un tema en el Foro
     * 
     * @param id
     * @return
     */
    @PostMapping
    @Transactional
    public ResponseEntity<DTOPostReturnTemaForo> addTema(@Valid @RequestBody DTOPostCrearTemaForo temaForo, UriComponentsBuilder uriComponentsBuilder) {
        
        Optional<JPAUsuarios> usuario = usuariosRepository.findById(temaForo.id_usuario());
        if (usuario.isEmpty()) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
        JPACursos curso = cursosRepository.findIdByNombreCurso(temaForo.curso());
        if (curso == null) {
            throw new EntityNotFoundException("Curso no encontrado");
        }

        JPAForo nuevoForo = new JPAForo();
        nuevoForo.setTitulo(temaForo.titulo());
        nuevoForo.setMensaje(temaForo.mensaje());
        nuevoForo.setFechaCreacion(new Date());
        nuevoForo.setIsActive(true);
        nuevoForo.setUsuarios(usuario.get());
        nuevoForo.setCursos(curso);
        
        try {
            foroRepository.save(nuevoForo);
        } catch (Exception e) {
            throw new ValidationException("No se pudo guardar el registro debido a una restricción de integridad de datos...");
        }
        
        JPAForo foroCreado = foroRepository.findByTituloAndMensajeAndUsuariosIdUsuario(temaForo.titulo(), temaForo.mensaje(), temaForo.id_usuario());
        if (foroCreado == null) {
            throw new EntityNotFoundException("foro no encontrado");
        }

        URI url = uriComponentsBuilder.path("/temas/{id}").buildAndExpand(foroCreado.getIdForo()).toUri();

        DTOPostReturnTemaForo temaForoDTO = new DTOPostReturnTemaForo(foroCreado);

        return ResponseEntity.created(url).body(temaForoDTO);

    }
    
    /**
     * Obtiene todos los temas de los Foros que estén activos
     * 
     * @param pagina
     * @param tamano
     * @param orden
     * @return
     */
    @GetMapping
    @Transactional
    public ResponseEntity<Page<DTOGetAllForo>> getTemas(@RequestParam(defaultValue = "0") int pagina,
                                                        @RequestParam(defaultValue = "10") int tamano,
                                                        @RequestParam(defaultValue = "fechaCreacion") String orden) {

        Pageable page = PageRequest.of(pagina, tamano, Sort.by(orden).descending());
        Page<JPAForo> temasForo = foroRepository.findByIsActiveTrue(page);
        if (temasForo != null) {
            if (temasForo.getContent().isEmpty()) {
                return ResponseEntity.noContent().build(); 
            } else {
                Page<DTOGetAllForo> temasForoDTO = temasForo.map(DTOGetAllForo::new);
                return ResponseEntity.ok(temasForoDTO);
            } 
        } else {
            return ResponseEntity.noContent().build(); 
        }

    }

    /**
     * Obtiene detalles completos de un tema especifico por Id en el Foro
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> getTema(@PathVariable Long id) {
        
        JPAForo foro = foroRepository.findByIdForoAndIsActiveTrue(id);
        if (foro != null) {
            DTOGetOneForo temaForoDTO = new DTOGetOneForo(foro);
            return ResponseEntity.ok(temaForoDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
        
    }

    /**
     * Actualiza un tema propuesto en un Foro
     * No debe tener el mismo titulo, tampoco el mismo mensaje
     * 
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> updateTema(@PathVariable Long id, @Valid @RequestBody DTOPostUpdateTemaForo updateForo, UriComponentsBuilder uriComponentsBuilder) {
        
        Optional<JPAForo> readForo = foroRepository.findById(id);
        if (readForo.isEmpty()) {
            throw new EntityNotFoundException("Foro no encontrado");
        }
        JPACursos curso = cursosRepository.findIdByNombreCurso(updateForo.curso());
        if (curso == null) {
            throw new EntityNotFoundException("Curso no encontrado");
        }

        JPAForo foro = readForo.get();
        boolean tituloIgual = foro.getTitulo().trim().equals(updateForo.titulo().trim());
        boolean mensajeIgual = foro.getMensaje().trim().equals(updateForo.mensaje().trim());

        if (!tituloIgual && !mensajeIgual) {
            
            foro.setTitulo(updateForo.titulo());
            foro.setMensaje(updateForo.mensaje());
            foro.setFechaCreacion(new Date());
            foro.setCursos(curso);

            try {
                foroRepository.save(foro);
            } catch (Exception e) {
                throw new ValidationException("No se pudo guardar el registro debido a una restricción de integridad de datos...");
            }

            return ResponseEntity.ok().build();
            
        } else {
            throw new ValidationException("El título y el mensaje son iguales al anterior");
        }
    
    }

    /**
     * Borra un tema de un foro
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteTema(@Valid @RequestBody @PathVariable Long id) {

        Optional<JPAForo> foro = foroRepository.findById(id);
        if (foro.isPresent()) {
            try {
                foroRepository.deleteById(id);
            } catch (Exception e) {
                throw new ValidationException("No se pudo borrar el registro debido a una restricción de integridad de datos...");
            }
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }

    }

}
