package br.net.meuremedio.service.mapper;

import org.mapstruct.Mapper;

import br.net.meuremedio.domain.Comentario;
import br.net.meuremedio.service.dto.ComentarioDTO;

/**
 * Mapper for the entity Comentario and its DTO ComentarioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ComentarioMapper extends EntityMapper<ComentarioDTO, Comentario> {



    default Comentario fromId(Long id) {
        if (id == null) {
            return null;
        }
        Comentario comentario = new Comentario();
        comentario.setId(id);
        return comentario;
    }
}
