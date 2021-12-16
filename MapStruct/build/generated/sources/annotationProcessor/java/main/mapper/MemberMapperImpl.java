package mapper;

import dto.MemberDTO;
import entity.MemberEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-16T21:35:12+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.5.jar, environment: Java 11.0.9 (Oracle Corporation)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO entityToDTO(MemberEntity memberEntity) {
        if ( memberEntity == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName( memberEntity.getName() );
        memberDTO.setNickName( memberEntity.getNickName() );
        memberDTO.setAge( memberEntity.getAge() );

        return memberDTO;
    }

    @Override
    public MemberEntity DTOToEntity(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setName( memberDTO.getName() );
        memberEntity.setNickName( memberDTO.getNickName() );
        memberEntity.setAge( memberDTO.getAge() );

        return memberEntity;
    }
}
