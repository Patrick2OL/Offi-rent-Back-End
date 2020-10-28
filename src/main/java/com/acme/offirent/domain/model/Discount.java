package com.acme.offirent.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="discounts")
public class Discount{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotNull
    private float percentage;

    @Lob
    @NotNull
    private String description;

    // @OneToMany(mappedBy = "account") //TODO
    // private List<Account> accounts;

    public long getId() {
        return id;
    }

    public Discount setId(long id) {
        this.id = id;
        return this;
    }

    public float getPercentage() {
        return percentage;
    }

    public Discount setPercentage(float percentage) {
        this.percentage = percentage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Discount setDescription(String description) {
        this.description = description;
        return this;
    }

    // public List<Account> getAccounts() {
    //     return accounts;
    // }

    // public Discount setAccounts(List<Account> accounts) {
    //     this.accounts = accounts;
    //     return this;
    // }
}