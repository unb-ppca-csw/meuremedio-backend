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

import br.net.meuremedio.service.DenunciaService;
import br.net.meuremedio.service.dto.DenunciaDTO;
import br.net.meuremedio.web.rest.errors.BadRequestAlertException;
import br.net.meuremedio.web.rest.util.HeaderUtil;
import br.net.meuremedio.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Denuncia.
 */
@RestController
@RequestMapping("/api")
public class DenunciaResource {

    private final Logger log = LoggerFactory.getLogger(DenunciaResource.class);

    private static final String ENTITY_NAME = "denuncia";

    private final DenunciaService denunciaService;

    public DenunciaResource(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    /**
     * POST  /denuncias : Create a new denuncia.
     *
     * @param denunciaDTO the denunciaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new denunciaDTO, or with status 400 (Bad Request) if the denuncia has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/denuncias")
    public ResponseEntity<DenunciaDTO> createDenuncia(@Valid @RequestBody DenunciaDTO denunciaDTO) throws URISyntaxException {
        log.debug("REST request to save Denuncia : {}", denunciaDTO);
        if (denunciaDTO.getId() != null) {
            throw new BadRequestAlertException("A new denuncia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DenunciaDTO result = denunciaService.save(denunciaDTO);
        return ResponseEntity.created(new URI("/api/denuncias/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /denuncias : Updates an existing denuncia.
     *
     * @param denunciaDTO the denunciaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated denunciaDTO,
     * or with status 400 (Bad Request) if the denunciaDTO is not valid,
     * or with status 500 (Internal Server Error) if the denunciaDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/denuncias")
    public ResponseEntity<DenunciaDTO> updateDenuncia(@Valid @RequestBody DenunciaDTO denunciaDTO) throws URISyntaxException {
        log.debug("REST request to update Denuncia : {}", denunciaDTO);
        if (denunciaDTO.getId() == null) {
            return createDenuncia(denunciaDTO);
        }
        DenunciaDTO result = denunciaService.save(denunciaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, denunciaDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /denuncias : get all the denuncias.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of denuncias in body
     */
    @GetMapping("/denuncias")
    public List<DenunciaDTO> getAllDenuncias() {
        log.debug("REST request to get a page of Denuncias");
        List<DenunciaDTO> lista = denunciaService.findAll();        
        return lista;
    }
//    public ResponseEntity<List<DenunciaDTO>> getAllDenuncias(Pageable pageable) {
//        log.debug("REST request to get a page of Denuncias");
//        Page<DenunciaDTO> page = denunciaService.findAll(pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/denuncias");
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }

    /**
     * GET  /denuncias/:id : get the "id" denuncia.
     *
     * @param id the id of the denunciaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the denunciaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/denuncias/{id}")
    public ResponseEntity<DenunciaDTO> getDenuncia(@PathVariable Long id) {
        log.debug("REST request to get Denuncia : {}", id);
        DenunciaDTO denunciaDTO = denunciaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(denunciaDTO));
    }

    /**
     * DELETE  /denuncias/:id : delete the "id" denuncia.
     *
     * @param id the id of the denunciaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/denuncias/{id}")
    public ResponseEntity<Void> deleteDenuncia(@PathVariable Long id) {
        log.debug("REST request to delete Denuncia : {}", id);
        denunciaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
