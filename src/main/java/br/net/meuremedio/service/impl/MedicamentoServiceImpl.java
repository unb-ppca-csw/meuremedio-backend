package br.net.meuremedio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.meuremedio.domain.Medicamento;
import br.net.meuremedio.repository.MedicamentoRepository;
import br.net.meuremedio.service.MedicamentoService;
import br.net.meuremedio.service.dto.ConsultaDTO;
import br.net.meuremedio.service.dto.MedicamentoDTO;
import br.net.meuremedio.service.mapper.MedicamentoMapper;


/**
 * Service Implementation for managing Medicamento.
 */
@Service
@Transactional
public class MedicamentoServiceImpl implements MedicamentoService {

    private final Logger log = LoggerFactory.getLogger(MedicamentoServiceImpl.class);

    private final MedicamentoRepository medicamentoRepository;

    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoServiceImpl(MedicamentoRepository medicamentoRepository, MedicamentoMapper medicamentoMapper) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
    }

    /**
     * Save a medicamento.
     *
     * @param medicamentoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MedicamentoDTO save(MedicamentoDTO medicamentoDTO) {
        log.debug("Request to save Medicamento : {}", medicamentoDTO);
        Medicamento medicamento = medicamentoMapper.toEntity(medicamentoDTO);
        medicamento = medicamentoRepository.save(medicamento);
        return medicamentoMapper.toDto(medicamento);
    }

    /**
     * Get all the medicamentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MedicamentoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Medicamentos");
        return medicamentoRepository.findAll(pageable)
            .map(medicamentoMapper::toDto);
    }

    /**
     * Get one medicamento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public MedicamentoDTO findOne(Long id) {
        log.debug("Request to get Medicamento : {}", id);
        Optional<Medicamento> optional = medicamentoRepository.findById(id);  
        Medicamento medicamento = optional.orElse(new Medicamento());
//        Medicamento medicamento = medicamentoRepository.findOne(id);
        return medicamentoMapper.toDto(medicamento);
    }

    /**
     * Delete the medicamento by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Medicamento : {}", id);
        medicamentoRepository.deleteById(id);
//        medicamentoRepository.delete(id);
    }

	@Override
	public List<ConsultaDTO> realizarConsulta(String valor) {
		log.debug("Realizando consulta: "+valor);
		List<Medicamento> medicamentos = medicamentoRepository.realizarConsulta(valor);
		
		log.warn("RESULTADO: "+medicamentos.size());		
		
		return medicamentos.stream().map(m -> toConsultaDTO(m)).collect(Collectors.toList());
	}
	
	
	private ConsultaDTO toConsultaDTO(Medicamento medicamento) {
		ConsultaDTO dto = new ConsultaDTO();
		dto.setApresentacao(medicamento.getApresentacao());
		dto.setClasseTerapeutica(medicamento.getClasseTerapeutica());
		dto.setIdMedicamento(medicamento.getId());
		dto.setLaboratorioCnpj(medicamento.getLaboratorio().getCnpj());
		dto.setLaboratorioNome(medicamento.getLaboratorio().getNome());
		dto.setLaboratorioRegistro(medicamento.getLaboratorio().getRegistro());
		dto.setNome(medicamento.getNome());
		dto.setPrecoFabrica(medicamento.getPrecoFabrica());
		dto.setPrecoConsumidor0(medicamento.getPrecoConsumidor0());
		dto.setPrecoConsumidor12(medicamento.getPrecoConsumidor12());
		dto.setPrecoConsumidor17(medicamento.getPrecoConsumidor17());
		dto.setPrecoConsumidor20(medicamento.getPrecoConsumidor20());		
		dto.setPrincipioAtivo(medicamento.getPrincipioAtivo());
		dto.setRestricaoHospitalar(medicamento.isRestricaoHospitalar());
		dto.setTarja(medicamento.getTarja().getLabel());
		dto.setTipo(medicamento.getTipo());
		return dto;
	}
}
