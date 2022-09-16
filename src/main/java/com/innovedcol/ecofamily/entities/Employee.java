package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference(value="enterprise_employee")
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "enterprise")
    //@JsonIgnore
    private Enterprise enterprise;

    @JsonManagedReference
    @OneToMany(mappedBy= "employee", targetEntity = Transaction.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="transactions", nullable = true)
    public Set<Transaction> transactions;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;

}
