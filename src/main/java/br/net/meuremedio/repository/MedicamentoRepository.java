package br.net.meuremedio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.net.meuremedio.domain.Medicamento;


/**
 * Spring Data JPA repository for the Medicamento entity.
 */
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

	@Query(QUERY)
	public List<Medicamento> realizarConsulta(String valor);
	
	
	static final String QUERY = 
			   "SELECT m " + 
			  " FROM Medicamento m" + 
			  "	WHERE m.principioAtivo like %?1%" + 
			  "	OR m.nome like %?1%" + 
			  "	order by principio_ativo, nome, preco_fabrica, preco_consumidor_20, apresentacao ASC";
	
	
//	static final String QUERY = 
//			   "SELECT m " + 
//			  " FROM Medicamento m" + 
//			  "	WHERE m.classeTerapeutica like %?1%" + 
//			  "	OR m.principioAtivo like %?1%" + 
//			  "	OR m.nome like %?1%" + 
//			  "	order by classe_terapeutica, principio_ativo, nome, preco_fabrica, preco_consumidor_20, apresentacao ASC";
	
}
