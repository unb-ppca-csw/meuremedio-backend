package br.net.meuremedio.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.meuremedio.service.MedicamentoService;
import br.net.meuremedio.service.dto.ConsultaDTO;

@RestController
@RequestMapping("/api")
public class ConsultaResource {

	private final Logger log = LoggerFactory.getLogger(ConsultaResource.class);

	private final MedicamentoService medicamentoService;

	public ConsultaResource(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}

	/**
	 * GET /medicamentos/:value : search for medicamentos with "valor".
	 *
	 * @param value
	 *            the value to search into principioAtivo and nome of medicamentoDTO
	 * @return
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         medicamentoDTO, or with status 404 (Not Found)
	 */
	//http://127.0.0.1:8080/api/consulta/dorflex
//	 @GetMapping("/consulta/{value}")
//	 public List<ConsultaDTO> realizarConsulta(@PathVariable String value) {
	//localhost:8080/api/consulta?value=dorflex
	
	//https://stackoverflow.com/questions/35091524/spring-cors-no-access-control-allow-origin-header-is-present
	//https://blog.ionicframework.com/handling-cors-issues-in-ionic/
	
	@CrossOrigin
	@GetMapping("/consulta")
	public List<ConsultaDTO> realizarConsulta(@RequestParam(value="value") String value) {
		log.debug("REST request to search Medicamentos by value: " + value);
		List<ConsultaDTO> resultadoConsulta = medicamentoService.realizarConsulta(value);
		// TODO
		return resultadoConsulta;

	}

}
