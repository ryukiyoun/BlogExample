package dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDTO {
    private String name;

    private String nickName;

    private int age;

    private TeamDTO team;
}
