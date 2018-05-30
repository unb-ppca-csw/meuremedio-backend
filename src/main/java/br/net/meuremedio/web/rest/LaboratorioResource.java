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

import br.net.meuremedio.service.LaboratorioService;
import br.net.meuremedio.service.dto.LaboratorioDTO;
import br.net.meuremedio.web.rest.errors.BadRequestAlertException;
import br.net.meuremedio.web.rest.util.HeaderUtil;
import br.net.meuremedio.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Laboratorio.
 */
@RestController
@RequestMapping("/api")
public class LaboratorioResource {

    private final Logger log = LoggerFactory.getLogger(LaboratorioResource.class);

    private static final String ENTITY_NAME = "laboratorio";

    private final LaboratorioService laboratorioService;

    public LaboratorioResource(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    /**
     * POST  /laboratorios : Create a new laboratorio.
     *
     * @param laboratorioDTO the laboratorioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new laboratorioDTO, or with status 400 (Bad Request) if the laboratorio has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/laboratorios")
    public ResponseEntity<LaboratorioDTO> createLaboratorio(@Valid @RequestBody LaboratorioDTO laboratorioDTO) throws URISyntaxException {
        log.debug("REST request to save Laboratorio : {}", laboratorioDTO);
        if (laboratorioDTO.getId() != null) {
            throw new BadRequestAlertException("A new laboratorio cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LaboratorioDTO result = laboratorioService.save(laboratorioDTO);
        return ResponseEntity.created(new URI("/api/laboratorios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /laboratorios : Updates an existing laboratorio.
     *
     * @param laboratorioDTO the laboratorioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated laboratorioDTO,
     * or with status 400 (Bad Request) if the laboratorioDTO is not valid,
     * or with status 500 (Internal Server Error) if the laboratorioDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/laboratorios")
    public ResponseEntity<LaboratorioDTO> updateLaboratorio(@Valid @RequestBody LaboratorioDTO laboratorioDTO) throws URISyntaxException {
        log.debug("REST request to update Laboratorio : {}", laboratorioDTO);
        if (laboratorioDTO.getId() == null) {
            return createLaboratorio(laboratorioDTO);
        }
        LaboratorioDTO result = laboratorioService.save(laboratorioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, laboratorioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /laboratorios : get all the laboratorios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of laboratorios in body
     */
    @GetMapping("/laboratorios")
    public ResponseEntity<List<LaboratorioDTO>> getAllLaboratorios(Pageable pageable) {
        log.debug("REST request to get a page of Laboratorios");
        Page<LaboratorioDTO> page = laboratorioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/laboratorios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /laboratorios/:id : get the "id" laboratorio.
     *
     * @param id the id of the laboratorioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the laboratorioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/laboratorios/{id}")
    public ResponseEntity<LaboratorioDTO> getLaboratorio(@PathVariable Long id) {
        log.debug("REST request to get Laboratorio : {}", id);
        LaboratorioDTO laboratorioDTO = laboratorioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(laboratorioDTO));
    }

    /**
     * DELETE  /laboratorios/:id : delete the "id" laboratorio.
     *
     * @param id the id of the laboratorioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/laboratorios/{id}")
    public ResponseEntity<Void> deleteLaboratorio(@PathVariable Long id) {
        log.debug("REST request to delete Laboratorio : {}", id);
        laboratorioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
