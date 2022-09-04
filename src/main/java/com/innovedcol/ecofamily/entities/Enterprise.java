package com.innovedcol.ecofamily.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "users", nullable = true)
    private List<Employee> listEmployees;
    @OneToMany(cascade= {CascadeType.ALL})
    @Column(name = "transactions", nullable = true)
    private List<Transaction> listTransactions;
    @Column(nullable = false)
    private Calendar createdAt;
    @Column(nullable = false)
    private Calendar updatedAt;

    // Constructor vacio
    public Enterprise() {
    }

    // Constructor completo


    public Enterprise(Long id, String name, String document, String phone, String address, List<Employee> listEmployees, List<Transaction> listTransactions, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.listEmployees = listEmployees;
        this.listTransactions = listTransactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public List<Transaction> getListTransactions() {
        return listTransactions;
    }

    public void setListTransactions(List<Transaction> listTransactions) {
        this.listTransactions = listTransactions;
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
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", listEmployees=" + listEmployees +
                ", listTransactions=" + listTransactions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
