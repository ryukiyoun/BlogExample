package com.jpa.nplusone.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EagerMember {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    EagerTeam eagerTeam;
}
