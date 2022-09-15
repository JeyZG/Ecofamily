package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.innovedcol.ecofamily.enums.EnumTypeTransaction;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
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

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@ManyToOne(fetch=FetchType.LAZY, optional = false)
    //@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    //@JsonIgnore
    // TODO: OK segun el video del 14/09/22
    @ManyToOne
    @JoinColumn(name = "user")
    private Employee user;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@ManyToOne(fetch=FetchType.LAZY, optional = false)
    //@JoinColumn(name = "enterprise_id", referencedColumnName = "id", nullable = false)
    // TODO: OK segun el video del 14/09/22
    @ManyToOne
    @JoinColumn(name = "enterprise")
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
