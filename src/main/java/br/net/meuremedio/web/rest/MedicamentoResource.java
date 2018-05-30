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

import br.net.meuremedio.service.MedicamentoService;
import br.net.meuremedio.service.dto.MedicamentoDTO;
import br.net.meuremedio.web.rest.errors.BadRequestAlertException;
import br.net.meuremedio.web.rest.util.HeaderUtil;
import br.net.meuremedio.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Medicamento.
 */
@RestController
@RequestMapping("/api")
public class MedicamentoResource {

    private final Logger log = LoggerFactory.getLogger(MedicamentoResource.class);

    private static final String ENTITY_NAME = "medicamento";

    private final MedicamentoService medicamentoService;

    public MedicamentoResource(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    /**
     * POST  /medicamentos : Create a new medicamento.
     *
     * @param medicamentoDTO the medicamentoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new medicamentoDTO, or with status 400 (Bad Request) if the medicamento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/medicamentos")
    public ResponseEntity<MedicamentoDTO> createMedicamento(@Valid @RequestBody MedicamentoDTO medicamentoDTO) throws URISyntaxException {
        log.debug("REST request to save Medicamento : {}", medicamentoDTO);
        if (medicamentoDTO.getId() != null) {
            throw new BadRequestAlertException("A new medicamento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MedicamentoDTO result = medicamentoService.save(medicamentoDTO);
        return ResponseEntity.created(new URI("/api/medicamentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /medicamentos : Updates an existing medicamento.
     *
     * @param medicamentoDTO the medicamentoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated medicamentoDTO,
     * or with status 400 (Bad Request) if the medicamentoDTO is not valid,
     * or with status 500 (Internal Server Error) if the medicamentoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/medicamentos")
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@Valid @RequestBody MedicamentoDTO medicamentoDTO) throws URISyntaxException {
        log.debug("REST request to update Medicamento : {}", medicamentoDTO);
        if (medicamentoDTO.getId() == null) {
            return createMedicamento(medicamentoDTO);
        }
        MedicamentoDTO result = medicamentoService.save(medicamentoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, medicamentoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /medicamentos : get all the medicamentos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of medicamentos in body
     */
    @GetMapping("/medicamentos")
    public ResponseEntity<List<MedicamentoDTO>> getAllMedicamentos(Pageable pageable) {
        log.debug("REST request to get a page of Medicamentos");
        Page<MedicamentoDTO> page = medicamentoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/medicamentos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /medicamentos/:id : get the "id" medicamento.
     *
     * @param id the id of the medicamentoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the medicamentoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/medicamentos/{id}")
    public ResponseEntity<MedicamentoDTO> getMedicamento(@PathVariable Long id) {
        log.debug("REST request to get Medicamento : {}", id);
        MedicamentoDTO medicamentoDTO = medicamentoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(medicamentoDTO));
    }

    /**
     * DELETE  /medicamentos/:id : delete the "id" medicamento.
     *
     * @param id the id of the medicamentoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/medicamentos/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        log.debug("REST request to delete Medicamento : {}", id);
        medicamentoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
