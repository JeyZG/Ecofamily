package com.innovedcol.ecofamily.entities;

import com.innovedcol.ecofamily.enums.EnumRoleEmployee;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Employee")
public class Employee {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(nullable = true)
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, name="role")
    private EnumRoleEmployee role;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private Enterprise enterprise;

    @OneToMany(cascade= {CascadeType.ALL}, mappedBy="user")
    @Column(nullable = false)
    private List<Transaction> transactions;

    @Column(nullable = false)
    private Calendar createdAt;

    @Column(nullable = false)
    private Calendar updatedAt;

}
