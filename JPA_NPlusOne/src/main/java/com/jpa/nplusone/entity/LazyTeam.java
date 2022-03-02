package com.jpa.nplusone.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LazyTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String teamName;
}
