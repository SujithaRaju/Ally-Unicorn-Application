package com.ally.assignment.unicorn.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "IdentifiableMarks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IdentifiableMarks {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Side")
    private String side;

    @Column(name="Location")
    private String location;

    @Column(name="Mark")
    private String mark;

    @Column(name="Color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "fk_unicornId")
    private Unicorn unicorn;
}
