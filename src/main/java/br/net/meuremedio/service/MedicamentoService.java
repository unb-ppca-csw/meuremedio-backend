package br.net.meuremedio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.net.meuremedio.service.dto.ConsultaDTO;
import br.net.meuremedio.service.dto.MedicamentoDTO;

/**
 * Service Interface for managing Medicamento.
 */
public interface MedicamentoService {

    /**
     * Save a medicamento.
     *
     * @param medicamentoDTO the entity to save
     * @return the persisted entity
     */
    MedicamentoDTO save(MedicamentoDTO medicamentoDTO);

    /**
     * Get all the medicamentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MedicamentoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" medicamento.
     *
     * @param id the id of the entity
     * @return the entity
     */
    MedicamentoDTO findOne(Long id);

    /**
     * Delete the "id" medicamento.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    
    /** Realiza a consulta de acordo com o parâmetro
     * @param valor parâmetro para consulta (principioAtivo ou nome)
     * @return Lista de medicamentos que possuem o 'valor' em seu princípio ativo ou nome
     */
    List<ConsultaDTO> realizarConsulta(String valor);
}
