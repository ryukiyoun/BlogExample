package com.jpa.fetch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EagerMember {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String nickName;

    private int age;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "team_id")
    EagerTeam eagerTeam;
}
