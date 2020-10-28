package com.acme.offirent.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="resources")
public class Resource{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long quantity;

    @Lob
    @NotNull
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="office_id", nullable = false)
    @JsonIgnore
    private Office office;

    public Long getId() {
        return id;
    }

    public Resource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Resource setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Resource setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Office getOffice() {
        return office;
    }

    public Resource setOffice(Office office) {
        this.office = office;
        return this;
    }
}