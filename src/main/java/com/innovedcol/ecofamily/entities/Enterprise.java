package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
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


    //@OneToMany(mappedBy="enterprise", targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="employees")
    @JsonManagedReference
    private Set<Employee> employees;

    //@OneToMany(mappedBy="enterprise", targetEntity = Transaction.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="transactions", nullable = true)
    @JsonManagedReference
    private Set<Transaction> transactions;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;


}
