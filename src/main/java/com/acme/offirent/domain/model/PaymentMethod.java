package com.acme.offirent.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Table(name="payment_methods")
public class PaymentMethod{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cardNumber;

    @NotNull
    private String ownerName;

    @NotNull
    private String dueDate;

    @NotNull
    private String cv;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    // mappedBy = "accounts")
    // private List<Account> accounts;
    //TODO: GETTER SETTER


    public Long getId() {
        return id;
    }

    public PaymentMethod setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PaymentMethod setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public PaymentMethod setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public PaymentMethod setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getCv() {
        return cv;
    }

    public PaymentMethod setCv(String cv) {
        this.cv = cv;
        return this;
    }

    
}