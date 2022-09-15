package com.innovedcol.ecofamily.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
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
    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Employee employee;

    // TODO: Se cambiaron estas relaciones hoy 12/09
    //@ManyToOne(fetch=FetchType.LAZY, optional = false)
    //@JoinColumn(name = "enterprise_id", referencedColumnName = "id", nullable = false)

    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Enterprise enterprise;

    @Column(nullable = false)
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date updatedAt;
}
