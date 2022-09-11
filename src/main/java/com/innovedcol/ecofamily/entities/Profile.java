package com.innovedcol.ecofamily.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Profile")
public class Profile {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String phone;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Employee user;

    @Column(nullable = false)
    private Calendar createdAt;

    @Column(nullable = false)
    private Calendar updatedAt;

}
