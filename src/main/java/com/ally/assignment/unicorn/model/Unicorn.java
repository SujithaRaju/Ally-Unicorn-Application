package com.ally.assignment.unicorn.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="UNICORN")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Unicorn {

    @Id
    @GeneratedValue
    @Column(name = "unicornId")
    private long unicornId;

    @Column(name = "Unicorn_Name")
    private String name;

    @Column(name="Hair_Color")
    private String hairColor;

    @Column(name="Horn_Length")
    private long hornLength;

    @Column(name="Horn_Color")
    private String hornColor;

    @Column(name="Eye_Color")
    private String eyeColor;

    @Column(name="Height")
    private long height;

    @Column(name="Height_Unit")
    private String heightUnit;

    @Column(name="Weight")
    private long weight;

    @Column(name="Weight_Unit")
    private String weightUnit;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_unicornId")
    private Set<IdentifiableMarks> identifiableMarks = new HashSet<>();

}
