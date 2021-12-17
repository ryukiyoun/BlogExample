package mapper;

import dto.MemberBuilderDTO;
import entity.MemberBuilderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberBuilderMapper {
    MemberBuilderMapper INSTANCE = Mappers.getMapper(MemberBuilderMapper.class);

    MemberBuilderDTO entityToDTO(MemberBuilderEntity memberBuilderEntity);
    MemberBuilderEntity DTOToEntity(MemberBuilderDTO memberBuilderDTO);
}
