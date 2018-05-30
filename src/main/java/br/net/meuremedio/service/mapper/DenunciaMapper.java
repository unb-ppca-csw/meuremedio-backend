package br.net.meuremedio.service.mapper;

import org.mapstruct.*;

import br.net.meuremedio.domain.*;
import br.net.meuremedio.service.dto.DenunciaDTO;

/**
 * Mapper for the entity Denuncia and its DTO DenunciaDTO.
 */
@Mapper(componentModel = "spring", uses = {MedicamentoMapper.class})
public interface DenunciaMapper extends EntityMapper<DenunciaDTO, Denuncia> {

    @Mapping(source = "medicamento.id", target = "medicamentoId")
    @Mapping(source = "medicamento.nome", target = "medicamentoNome")
    DenunciaDTO toDto(Denuncia denuncia);

    @Mapping(source = "medicamentoId", target = "medicamento")
    Denuncia toEntity(DenunciaDTO denunciaDTO);

    default Denuncia fromId(Long id) {
        if (id == null) {
            return null;
        }
        Denuncia denuncia = new Denuncia();
        denuncia.setId(id);
        return denuncia;
    }
}
