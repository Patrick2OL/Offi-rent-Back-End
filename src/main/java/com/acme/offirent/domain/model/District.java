package com.acme.offirent.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Office> offices;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="departament_id", nullable = false)
    @JsonIgnore
    private Departament departament;

    public Long getId() {
        return id;
    }

    public District setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public District setName(String name) {
        this.name = name;
        return this;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public District setOffices(List<Office> offices) {
        this.offices = offices;
        return this;
    }

    public Departament getDepartament() {
        return departament;
    }

    public District setDepartament(Departament departament) {
        this.departament = departament;
        return this;
    }
}
