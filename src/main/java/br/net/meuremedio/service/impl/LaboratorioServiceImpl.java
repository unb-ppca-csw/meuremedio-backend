package br.net.meuremedio.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.meuremedio.domain.Laboratorio;
import br.net.meuremedio.repository.LaboratorioRepository;
import br.net.meuremedio.service.LaboratorioService;
import br.net.meuremedio.service.dto.LaboratorioDTO;
import br.net.meuremedio.service.mapper.LaboratorioMapper;

/**
 * Service Implementation for managing Laboratorio.
 */
@Service
@Transactional
public class LaboratorioServiceImpl implements LaboratorioService {

	private final Logger log = LoggerFactory.getLogger(LaboratorioServiceImpl.class);

	private final LaboratorioRepository laboratorioRepository;

	private final LaboratorioMapper laboratorioMapper;

	public LaboratorioServiceImpl(LaboratorioRepository laboratorioRepository, LaboratorioMapper laboratorioMapper) {
		this.laboratorioRepository = laboratorioRepository;
		this.laboratorioMapper = laboratorioMapper;
	}

	/**
	 * Save a laboratorio.
	 *
	 * @param laboratorioDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public LaboratorioDTO save(LaboratorioDTO laboratorioDTO) {
		log.debug("Request to save Laboratorio : {}", laboratorioDTO);
		Laboratorio laboratorio = laboratorioMapper.toEntity(laboratorioDTO);
		laboratorio = laboratorioRepository.save(laboratorio);
		return laboratorioMapper.toDto(laboratorio);
	}

	/**
	 * Get all the laboratorios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<LaboratorioDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Laboratorios");
		return laboratorioRepository.findAll(pageable).map(laboratorioMapper::toDto);
	}

	/**
	 * Get one laboratorio by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public LaboratorioDTO findOne(Long id) {
		log.debug("Request to get Laboratorio : {}", id);
		Optional<Laboratorio> optional = laboratorioRepository.findById(id);
		Laboratorio laboratorio = optional.orElse(new Laboratorio());
		// Laboratorio laboratorio = laboratorioRepository.findOne(id);
		return laboratorioMapper.toDto(laboratorio);
	}

	/**
	 * Delete the laboratorio by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Laboratorio : {}", id);
		laboratorioRepository.deleteById(id);
		// laboratorioRepository.delete(id);
	}
}
