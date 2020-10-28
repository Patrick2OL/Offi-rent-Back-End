package com.acme.offirent.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;
/*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="country_id", nullable = false)
    private Country country;
*/

    @OneToMany(mappedBy = "departament")
    private List<District> districts;

    public Long getId() {
        return id;
    }

    public Departament setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Departament setName(String name) {
        this.name = name;
        return this;
    }
/*
    public Country getCountry() {
        return country;
    }

    public Departament setCountry(Country country) {
        this.country = country;
        return this;
    }*/

    public List<District> getDistricts() {
        return districts;
    }

    public Departament setDistricts(List<District> districts) {
        this.districts = districts;
        return this;
    }
}
