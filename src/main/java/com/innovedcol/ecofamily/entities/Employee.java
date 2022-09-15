package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.innovedcol.ecofamily.enums.EnumRoleEmployee;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private EnumRoleEmployee role;

    @Column(nullable = false)
    private String image;

    //@ManyToOne(fetch=FetchType.LAZY, optional = false)
    //@JsonIgnore
    // TODO: Se cambiaron estas relaciones hoy 12/09
    // TODO: OK segun el video del 14/09/22
    @ManyToOne
    @JoinColumn(name = "enterprise")
    @JsonIgnore
    private Enterprise enterprise;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // TODO: OK segun el video del 14/09/22
    @OneToMany(mappedBy= "user")
    public Set<Transaction> transactions;
    //private List<Transaction> transactions;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;

}
