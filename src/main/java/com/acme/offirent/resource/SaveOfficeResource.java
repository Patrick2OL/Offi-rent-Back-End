package com.acme.offirent.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveOfficeResource {

    @NotNull
    @NotBlank
    @Size(max = 100)
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
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    private float price;

    @NotNull
    private boolean status;


    @NotNull
    @NotBlank
    @Size(max = 250)
    private String comment;

    public String getAddress() {
        return address;
    }

    public SaveOfficeResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getFloor() {
        return floor;
    }

    public SaveOfficeResource setFloor(Long floor) {
        this.floor = floor;
        return this;
    }

    public Long getCapacity() {
        return capacity;
    }

    public SaveOfficeResource setCapacity(Long capacity) {
        this.capacity = capacity;
        return this;
    }

    public boolean getAllowResource() {
        return allowResource;
    }

    public SaveOfficeResource setAllowResource(boolean allowResource) {
        this.allowResource = allowResource;
        return this;
    }

    public float getScore() {
        return score;
    }

    public SaveOfficeResource setScore(float score) {
        this.score = score;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveOfficeResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public SaveOfficeResource setPrice(float price) {
        this.price = price;
        return this;
    }

    public boolean getStatus() {
        return status;
    }

    public SaveOfficeResource setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SaveOfficeResource setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
