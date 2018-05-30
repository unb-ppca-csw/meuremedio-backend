package br.net.meuremedio.service.mapper;

import org.mapstruct.*;

import br.net.meuremedio.domain.*;
import br.net.meuremedio.service.dto.MedicamentoDTO;

/**
 * Mapper for the entity Medicamento and its DTO MedicamentoDTO.
 */
@Mapper(componentModel = "spring", uses = {LaboratorioMapper.class})
public interface MedicamentoMapper extends EntityMapper<MedicamentoDTO, Medicamento> {

    @Mapping(source = "laboratorio.id", target = "laboratorioId")
    @Mapping(source = "laboratorio.nome", target = "laboratorioNome")
    MedicamentoDTO toDto(Medicamento medicamento);

    @Mapping(target = "denuncias", ignore = true)
    @Mapping(source = "laboratorioId", target = "laboratorio")
    Medicamento toEntity(MedicamentoDTO medicamentoDTO);

    default Medicamento fromId(Long id) {
        if (id == null) {
            return null;
        }
        Medicamento medicamento = new Medicamento();
        medicamento.setId(id);
        return medicamento;
    }
}
