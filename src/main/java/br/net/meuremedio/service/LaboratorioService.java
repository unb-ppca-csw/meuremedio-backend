package br.net.meuremedio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.net.meuremedio.service.dto.LaboratorioDTO;

/**
 * Service Interface for managing Laboratorio.
 */
public interface LaboratorioService {

    /**
     * Save a laboratorio.
     *
     * @param laboratorioDTO the entity to save
     * @return the persisted entity
     */
    LaboratorioDTO save(LaboratorioDTO laboratorioDTO);

    /**
     * Get all the laboratorios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<LaboratorioDTO> findAll(Pageable pageable);

    /**
     * Get the "id" laboratorio.
     *
     * @param id the id of the entity
     * @return the entity
     */
    LaboratorioDTO findOne(Long id);

    /**
     * Delete the "id" laboratorio.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
