package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ENTERPRISES")
public class Enterprise {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // TODO: OK segun el video del 14/09/22
    @OneToMany(mappedBy="enterprise")
    @Column(name="employees")
    public Set<Employee> employees;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // TODO: OK segun el video del 14/09/22
    @OneToMany(mappedBy="enterprise")
    @Column(name="transactions", nullable = true)
    public Set<Transaction> transactions;
    //private List<Transaction> transactions;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;
}
