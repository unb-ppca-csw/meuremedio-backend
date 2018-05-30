package br.net.meuremedio.repository;

import org.springframework.stereotype.Repository;

import br.net.meuremedio.domain.Laboratorio;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Laboratorio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

}
