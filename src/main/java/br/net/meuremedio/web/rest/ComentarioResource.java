package br.net.meuremedio.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.meuremedio.service.ComentarioService;
import br.net.meuremedio.service.dto.ComentarioDTO;
import br.net.meuremedio.web.rest.errors.BadRequestAlertException;
import br.net.meuremedio.web.rest.util.HeaderUtil;
import br.net.meuremedio.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Comentario.
 */
@RestController
@RequestMapping("/api")
public class ComentarioResource {

    private final Logger log = LoggerFactory.getLogger(ComentarioResource.class);

    private static final String ENTITY_NAME = "comentario";

    private final ComentarioService comentarioService;

    public ComentarioResource(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    /**
     * POST  /comentarios : Create a new comentario.
     *
     * @param comentarioDTO the comentarioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new comentarioDTO, or with status 400 (Bad Request) if the comentario has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/comentarios")
    public ResponseEntity<ComentarioDTO> createComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws URISyntaxException {
        log.debug("REST request to save Comentario : {}", comentarioDTO);
        if (comentarioDTO.getId() != null) {
            throw new BadRequestAlertException("A new comentario cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ComentarioDTO result = comentarioService.save(comentarioDTO);
        return ResponseEntity.created(new URI("/api/comentarios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /comentarios : Updates an existing comentario.
     *
     * @param comentarioDTO the comentarioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated comentarioDTO,
     * or with status 400 (Bad Request) if the comentarioDTO is not valid,
     * or with status 500 (Internal Server Error) if the comentarioDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/comentarios")
    public ResponseEntity<ComentarioDTO> updateComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws URISyntaxException {
        log.debug("REST request to update Comentario : {}", comentarioDTO);
        if (comentarioDTO.getId() == null) {
            return createComentario(comentarioDTO);
        }
        ComentarioDTO result = comentarioService.save(comentarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, comentarioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /comentarios : get all the comentarios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of comentarios in body
     */
    @GetMapping("/comentarios")
    public List<ComentarioDTO> getAllComentarios() {
        log.debug("REST request to get a page of Comentarios");
        List<ComentarioDTO> lista = comentarioService.findAll();     
        return lista;
    }
//    public ResponseEntity<List<ComentarioDTO>> getAllComentarios(Pageable pageable) {
//        log.debug("REST request to get a page of Comentarios");
//        Page<ComentarioDTO> page = comentarioService.findAll(pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/comentarios");
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }

    /**
     * GET  /comentarios/:id : get the "id" comentario.
     *
     * @param id the id of the comentarioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the comentarioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> getComentario(@PathVariable Long id) {
        log.debug("REST request to get Comentario : {}", id);
        ComentarioDTO comentarioDTO = comentarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(comentarioDTO));
    }

    /**
     * DELETE  /comentarios/:id : delete the "id" comentario.
     *
     * @param id the id of the comentarioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable Long id) {
        log.debug("REST request to delete Comentario : {}", id);
        comentarioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
