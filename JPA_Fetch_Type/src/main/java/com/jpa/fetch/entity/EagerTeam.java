package com.jpa.fetch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EagerTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToMany(mappedBy = "eagerTeam", fetch = FetchType.EAGER)
    List<EagerMember> memberList;
}



