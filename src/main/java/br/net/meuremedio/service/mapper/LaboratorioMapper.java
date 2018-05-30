package br.net.meuremedio.service.mapper;

import org.mapstruct.*;

import br.net.meuremedio.domain.*;
import br.net.meuremedio.service.dto.LaboratorioDTO;

/**
 * Mapper for the entity Laboratorio and its DTO LaboratorioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LaboratorioMapper extends EntityMapper<LaboratorioDTO, Laboratorio> {


    @Mapping(target = "medicamentos", ignore = true)
    Laboratorio toEntity(LaboratorioDTO laboratorioDTO);

    default Laboratorio fromId(Long id) {
        if (id == null) {
            return null;
        }
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setId(id);
        return laboratorio;
    }
}
