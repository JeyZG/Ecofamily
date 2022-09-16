package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.innovedcol.ecofamily.enums.EnumTypeTransaction;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
@Table(name = "TRANSACTIONS")
public class Transaction {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String concept;

    @Column(nullable = false)
    private double amount;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee")
    @JsonBackReference
    private Employee employee;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "enterprise")
    @JsonBackReference
    //@JsonIgnore
    private Enterprise enterprise;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private EnumTypeTransaction type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;

}
