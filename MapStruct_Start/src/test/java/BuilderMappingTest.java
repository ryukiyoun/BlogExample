import dto.MemberBuilderDTO;
import entity.MemberBuilderEntity;
import mapper.MemberBuilderMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BuilderMappingTest {
    static MemberBuilderEntity memberEntity;
    static MemberBuilderDTO memberDTO;

    @BeforeClass
    public static void setInit(){
        memberEntity = MemberBuilderEntity.builder()
                .name("member")
                .nickName("test_member")
                .age(25)
                .build();

        memberDTO = MemberBuilderDTO.builder()
                .name("member")
                .nickName("test_member")
                .age(25)
                .build();
    }

    @Test
    public void EntityToDTOMapStruct(){
        MemberBuilderDTO mappingMemberDTO = MemberBuilderMapper.INSTANCE.entityToDTO(memberEntity);

        assertThat(memberEntity.getName(), is(mappingMemberDTO.getName()));
        assertThat(memberEntity.getNickName(), is(mappingMemberDTO.getNickName()));
        assertThat(memberEntity.getAge(), is(mappingMemberDTO.getAge()));
    }

    @Test
    public void DTOToEntityOMapStruct(){
        MemberBuilderEntity memberEntity = MemberBuilderMapper.INSTANCE.DTOToEntity(memberDTO);

        assertThat(memberDTO.getName(), is(memberEntity.getName()));
        assertThat(memberDTO.getNickName(), is(memberEntity.getNickName()));
        assertThat(memberDTO.getAge(), is(memberEntity.getAge()));
    }
}
