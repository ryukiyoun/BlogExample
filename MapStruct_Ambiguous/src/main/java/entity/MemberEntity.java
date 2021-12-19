package entity;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    private String name;

    private String nickName;

    private int age;

    private TeamEntity team;
}
