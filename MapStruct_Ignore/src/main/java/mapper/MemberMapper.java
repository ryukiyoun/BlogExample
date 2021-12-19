package mapper;

import dto.MemberDTO;
import entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper extends CommonMapper<MemberEntity, MemberDTO> {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Named("ignoreTeamE2D")
    @Mapping(target = "team", ignore = true)
    MemberDTO ignoreTeamEntityToDTO(MemberEntity entity);

    @Named("ignoreAgeE2D")
    @Mapping(target = "age", ignore = true)
    MemberDTO ignoreAgeEntityToDTO(MemberEntity entity);
}
