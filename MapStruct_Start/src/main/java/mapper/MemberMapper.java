package mapper;

import dto.MemberDTO;
import entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDTO entityToDTO(MemberEntity memberEntity);
    MemberEntity DTOToEntity(MemberDTO memberDTO);
}
