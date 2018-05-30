package br.net.meuremedio.repository;

import org.springframework.stereotype.Repository;

import br.net.meuremedio.domain.Denuncia;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Denuncia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

}
