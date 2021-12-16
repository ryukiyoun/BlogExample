package mapper;

import dto.MemberBuilderDTO;
import dto.MemberBuilderDTO.MemberBuilderDTOBuilder;
import entity.MemberBuilderEntity;
import entity.MemberBuilderEntity.MemberBuilderEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-16T21:35:12+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.5.jar, environment: Java 11.0.9 (Oracle Corporation)"
)
public class MemberBuilderMapperImpl implements MemberBuilderMapper {

    @Override
    public MemberBuilderDTO entityToDTO(MemberBuilderEntity memberBuilderEntity) {
        if ( memberBuilderEntity == null ) {
            return null;
        }

        MemberBuilderDTOBuilder memberBuilderDTO = MemberBuilderDTO.builder();

        memberBuilderDTO.name( memberBuilderEntity.getName() );
        memberBuilderDTO.nickName( memberBuilderEntity.getNickName() );
        memberBuilderDTO.age( memberBuilderEntity.getAge() );

        return memberBuilderDTO.build();
    }

    @Override
    public MemberBuilderEntity DTOToEntity(MemberBuilderDTO memberBuilderDTO) {
        if ( memberBuilderDTO == null ) {
            return null;
        }

        MemberBuilderEntityBuilder memberBuilderEntity = MemberBuilderEntity.builder();

        memberBuilderEntity.name( memberBuilderDTO.getName() );
        memberBuilderEntity.nickName( memberBuilderDTO.getNickName() );
        memberBuilderEntity.age( memberBuilderDTO.getAge() );

        return memberBuilderEntity.build();
    }
}
