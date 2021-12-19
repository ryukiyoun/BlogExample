import dto.MemberDTO;
import entity.MemberEntity;
import entity.TeamEntity;
import mapper.MemberMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AmbiguousMappingTest {
    private static List<MemberEntity> memberEntityList;

    @BeforeClass
    public static void setInit(){
        memberEntityList = new ArrayList<>();

        memberEntityList.add(MemberEntity.builder()
                .name("member1")
                .nickName("test_member1")
                .age(20)
                .team(TeamEntity.builder()
                        .name("team1")
                        .capacity(10)
                        .build())
                .build());

        memberEntityList.add(MemberEntity.builder()
                .name("member2")
                .nickName("test_member2")
                .age(25)
                .team(TeamEntity.builder()
                        .name("team2")
                        .capacity(20)
                        .build())
                .build());
    }

    @Test
    public void NonAmbiguousCollectionMapping(){
        List<MemberDTO> memberDTOList = MemberMapper.INSTANCE.entityListToDTOList(memberEntityList);

        assertThat(memberDTOList.size(), is(2));

        assertThat(memberDTOList.get(0).getName(), is(memberEntityList.get(0).getName()));
        assertThat(memberDTOList.get(0).getNickName(), is(memberEntityList.get(0).getNickName()));
        assertThat(memberDTOList.get(0).getAge(), is(20));
        assertNotNull(memberDTOList.get(0).getTeam());

        assertThat(memberDTOList.get(1).getName(), is(memberEntityList.get(1).getName()));
        assertThat(memberDTOList.get(1).getNickName(), is(memberEntityList.get(1).getNickName()));
        assertThat(memberDTOList.get(1).getAge(), is(25));
        assertNotNull(memberDTOList.get(1).getTeam());
    }
}
