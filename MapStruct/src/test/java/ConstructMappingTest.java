import dto.MemberDTO;
import entity.MemberEntity;
import mapper.MemberMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConstructMappingTest {
    static MemberEntity memberEntity;
    static MemberDTO memberDTO;

    @BeforeClass
    public static void setInit(){
        memberEntity = new MemberEntity();
        memberEntity.setName("member");
        memberEntity.setNickName("test_member");
        memberEntity.setAge(25);

        memberDTO = new MemberDTO();
        memberDTO.setName("member");
        memberDTO.setNickName("test_member");
        memberDTO.setAge(25);
    }
    @Test
    public void EntityToDTOMapStruct(){
        MemberDTO mappingMemberDTO = MemberMapper.INSTANCE.entityToDTO(memberEntity);

        assertThat(memberEntity.getName(), is(mappingMemberDTO.getName()));
        assertThat(memberEntity.getNickName(), is(mappingMemberDTO.getNickName()));
        assertThat(memberEntity.getAge(), is(mappingMemberDTO.getAge()));
    }

    @Test
    public void DTOToEntityOMapStruct(){
        MemberEntity memberEntity = MemberMapper.INSTANCE.DTOToEntity(memberDTO);

        assertThat(memberDTO.getName(), is(memberEntity.getName()));
        assertThat(memberDTO.getNickName(), is(memberEntity.getNickName()));
        assertThat(memberDTO.getAge(), is(memberEntity.getAge()));
    }
}
