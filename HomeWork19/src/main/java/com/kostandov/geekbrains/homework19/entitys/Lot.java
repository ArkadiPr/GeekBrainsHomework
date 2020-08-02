package com.kostandov.geekbrains.homework19.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Table(name = "lots")
@Getter
@Setter
@NoArgsConstructor
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "sum")
    private int sum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Version
    private Long version;


}
