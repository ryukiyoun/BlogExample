package mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface CommonMapper<E, D> {
    @Named("defaultE2D")
    D entityToDTO(E entity);

    @Named("defaultD2E")
    E dtoToEntity(D DTO);

    @IterableMapping(qualifiedByName = "defaultE2D")
    List<D> entityListToDTOList(List<E> entityList);

    @IterableMapping(qualifiedByName = "defaultD2E")
    List<E> dtoListToEntityList(List<D> dtoList);
}
