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
@Table(name = "employee")
public class Employee {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    //@JoinColumn(name = "profile", nullable = false)
    @JoinColumn(name = "profile", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private EnumRoleEmployee role;

    //@ManyToOne(fetch=FetchType.LAZY, optional = false)
    //@JsonIgnore
    // TODO: Se cambiaron estas relaciones hoy 12/09
    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Enterprise enterprise;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy="employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @Column(name = "transactions", nullable = true)
    @JsonIgnore
    public Set<Transaction> transactions;
    //private List<Transaction> transactions;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;

}
