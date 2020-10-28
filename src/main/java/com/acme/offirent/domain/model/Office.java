package com.acme.offirent.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    @NotNull
    private Long floor;

    @NotNull
    private Long capacity;

    @NotNull
    private boolean allowResource;

    @NotNull
    private float score;

    @NotNull
    private String description;

    @NotNull
    private float price;

    @NotNull
    private boolean status;

    @NotNull
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="district_id")
    @JsonIgnore
    private District district;

    public Office(@NotNull String address, @NotNull Long floor, @NotNull Long capacity, @NotNull boolean allowResource, @NotNull float score, @NotNull String description, @NotNull float price, @NotNull boolean status, @NotNull String comment) {
        this.address = address;
        this.floor = floor;
        this.capacity = capacity;
        this.allowResource = allowResource;
        this.score = score;
        this.description = description;
        this.price = price;
        this.status = status;
        this.comment = comment;
    }

    public Office(){}

    public Long getId() {
        return id;
    }

    public Office setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Office setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getFloor() {
        return floor;
    }

    public Office setFloor(Long floor) {
        this.floor = floor;
        return this;
    }

    public Long getCapacity() {
        return capacity;
    }

    public Office setCapacity(Long capacity) {
        this.capacity = capacity;
        return this;
    }

    public boolean getAllowResource() {
        return allowResource;
    }

    public Office setAllowResource(boolean allowResource) {
        this.allowResource = allowResource;
        return this;
    }

    public float getScore() {
        return score;
    }

    public Office setScore(float score) {
        this.score = score;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Office setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Office setPrice(float price) {
        this.price = price;
        return this;
    }

    public boolean getStatus() {
        return status;
    }

    public Office setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Office setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public District getDistrict() {
        return district;
    }

    public Office setDistrict(District district) {
        this.district = district;
        return this;
    }
    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="account_id", nullable = false)
    @JsonIgnore
    private Account account;

    @OneToMany(mappedBy = "office")
    private List<Resource> resources;*/



    /*public Account getAccount() {
        return account;
    }

    public Office setAccount(Account account) {
        this.account = account;
        return this;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Office setResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }*/
}
