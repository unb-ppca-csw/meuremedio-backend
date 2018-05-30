package br.net.meuremedio.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.meuremedio.domain.Comentario;
import br.net.meuremedio.repository.ComentarioRepository;
import br.net.meuremedio.service.ComentarioService;
import br.net.meuremedio.service.dto.ComentarioDTO;
import br.net.meuremedio.service.mapper.ComentarioMapper;

/**
 * Service Implementation for managing Comentario.
 */
@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

	private final Logger log = LoggerFactory.getLogger(ComentarioServiceImpl.class);

	private final ComentarioRepository comentarioRepository;

	private final ComentarioMapper comentarioMapper;

	public ComentarioServiceImpl(ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper) {
		this.comentarioRepository = comentarioRepository;
		this.comentarioMapper = comentarioMapper;
	}

	/**
	 * Save a comentario.
	 *
	 * @param comentarioDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public ComentarioDTO save(ComentarioDTO comentarioDTO) {
		log.debug("Request to save Comentario : {}", comentarioDTO);
		Comentario comentario = comentarioMapper.toEntity(comentarioDTO);
		comentario.setData(new Timestamp(System.currentTimeMillis()));
		comentario = comentarioRepository.save(comentario);
		return comentarioMapper.toDto(comentario);
	}

	/**
	 * Get all the comentarios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<ComentarioDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Comentarios pageable");
		return comentarioRepository.findAll(pageable).map(comentarioMapper::toDto);
	}

	public List<ComentarioDTO> findAll() {
		log.debug("Request to get all Comentarios");
		Sort ordenacao = new Sort(Direction.DESC, "data");
		return comentarioRepository.findAll(ordenacao).stream().map(comentarioMapper::toDto)
				.collect(Collectors.toList());
	}

	/**
	 * Get one comentario by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public ComentarioDTO findOne(Long id) {
		log.debug("Request to get Comentario : {}", id);
		Optional<Comentario> optional = comentarioRepository.findById(id);
		Comentario comentario = optional.orElse(new Comentario());
		// Comentario comentario = comentarioRepository.findOne(id);
		return comentarioMapper.toDto(comentario);
	}

	/**
	 * Delete the comentario by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Comentario : {}", id);
		comentarioRepository.deleteById(id);
		// comentarioRepository.delete(id);
	}
}
