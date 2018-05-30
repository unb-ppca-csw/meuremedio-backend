package br.net.meuremedio.repository;

import org.springframework.stereotype.Repository;

import br.net.meuremedio.domain.Comentario;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Comentario entity.
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
