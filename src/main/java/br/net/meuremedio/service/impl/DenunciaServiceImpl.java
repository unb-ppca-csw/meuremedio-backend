package br.net.meuremedio.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.meuremedio.domain.Denuncia;
import br.net.meuremedio.repository.DenunciaRepository;
import br.net.meuremedio.service.DenunciaService;
import br.net.meuremedio.service.dto.DenunciaDTO;
import br.net.meuremedio.service.mapper.DenunciaMapper;

/**
 * Service Implementation for managing Denuncia.
 */
@Service
@Transactional
public class DenunciaServiceImpl implements DenunciaService {

	private final Logger log = LoggerFactory.getLogger(DenunciaServiceImpl.class);

	private final DenunciaRepository denunciaRepository;

	private final DenunciaMapper denunciaMapper;

	public DenunciaServiceImpl(DenunciaRepository denunciaRepository, DenunciaMapper denunciaMapper) {
		this.denunciaRepository = denunciaRepository;
		this.denunciaMapper = denunciaMapper;
	}

	/**
	 * Save a denuncia.
	 *
	 * @param denunciaDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public DenunciaDTO save(DenunciaDTO denunciaDTO) {
		log.debug("Request to save Denuncia : {}", denunciaDTO);
		Denuncia denuncia = denunciaMapper.toEntity(denunciaDTO);
		denuncia.setData(new Timestamp(System.currentTimeMillis()));
		denuncia = denunciaRepository.save(denuncia);
		return denunciaMapper.toDto(denuncia);
	}

	/**
	 * Get all the denuncias.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<DenunciaDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Denuncias");
		return denunciaRepository.findAll(pageable).map(denunciaMapper::toDto);
	}

	@Transactional(readOnly = true)
	public List<DenunciaDTO> findAll() {
		return denunciaRepository.findAll().stream().map(denunciaMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Get one denuncia by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public DenunciaDTO findOne(Long id) {
		log.debug("Request to get Denuncia : {}", id);
		Optional<Denuncia> optional = denunciaRepository.findById(id);
		Denuncia denuncia = optional.orElse(new Denuncia());
		// Denuncia denuncia = denunciaRepository.findOne(id);
		return denunciaMapper.toDto(denuncia);
	}

	/**
	 * Delete the denuncia by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Denuncia : {}", id);
		denunciaRepository.deleteById(id);
		// denunciaRepository.delete(id);
	}
}
