package br.net.meuremedio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.net.meuremedio.service.dto.DenunciaDTO;

/**
 * Service Interface for managing Denuncia.
 */
public interface DenunciaService {

    /**
     * Save a denuncia.
     *
     * @param denunciaDTO the entity to save
     * @return the persisted entity
     */
    DenunciaDTO save(DenunciaDTO denunciaDTO);

    /**
     * Get all the denuncias.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<DenunciaDTO> findAll(Pageable pageable);
    
    List<DenunciaDTO> findAll();

    /**
     * Get the "id" denuncia.
     *
     * @param id the id of the entity
     * @return the entity
     */
    DenunciaDTO findOne(Long id);

    /**
     * Delete the "id" denuncia.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
