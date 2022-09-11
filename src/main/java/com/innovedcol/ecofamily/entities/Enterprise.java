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
@Table(name = "Enterprise")
public class Enterprise {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @OneToMany(cascade= {CascadeType.ALL}, mappedBy="enterprise")
    @JoinColumn(nullable = false)
    private List<Employee> users;

    @OneToMany(cascade= {CascadeType.ALL}, mappedBy="enterprise")
    @Column(nullable = false)
    private List<Transaction> transactions;

    @Column(nullable = false)
    private Calendar createdAt;

    @Column(nullable = false)
    private Calendar updatedAt;
}
