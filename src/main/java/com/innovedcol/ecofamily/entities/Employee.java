package com.innovedcol.ecofamily.entities;

import javax.persistence.*;
import java.util.*;

@Entity
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
    @Column(nullable = false)
    private String role;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Enterprise enterprise;
    @OneToMany(cascade= {CascadeType.ALL})
    @Column(nullable = true)
    private List<Transaction> transactions;
    @Column(nullable = false)
    private Calendar createdAt;
    @Column(nullable = false)
    private Calendar updatedAt;

    // Constructor vacio
    public Employee() {
    }

    // Constructor completo
    public Employee(Long id, String name, String email, Profile profile, String role, Enterprise enterprise, ArrayList<Transaction> transactions, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                ", role='" + role + '\'' +
                ", enterprise=" + enterprise +
                ", transactions=" + transactions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
