package br.net.meuremedio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.net.meuremedio.service.dto.ComentarioDTO;

/**
 * Service Interface for managing Comentario.
 */
public interface ComentarioService {

    /**
     * Save a comentario.
     *
     * @param comentarioDTO the entity to save
     * @return the persisted entity
     */
    ComentarioDTO save(ComentarioDTO comentarioDTO);

    /**
     * Get all the comentarios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ComentarioDTO> findAll(Pageable pageable);
    
    List<ComentarioDTO> findAll();

    /**
     * Get the "id" comentario.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ComentarioDTO findOne(Long id);

    /**
     * Delete the "id" comentario.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
