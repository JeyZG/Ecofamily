package com.innovedcol.ecofamily.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Transaction")
public class Transaction {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String concept;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(nullable = false, name = "employee_id")
    private Employee user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "enterprise_id")
    private Enterprise enterprise;

    @Column(nullable = false)
    private String type;
}
