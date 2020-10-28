package com.acme.offirent.resource;

import javax.validation.constraints.NotNull;

public class OfficeResource {

    private Long id;
    private String address;
    private Long floor;
    private Long capacity;
    private boolean allowResource;
    private float score;
    private String description;
    private float price;
    private boolean status;
    private String comment;

    public Long getId() {
        return id;
    }

    public OfficeResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OfficeResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getFloor() {
        return floor;
    }

    public OfficeResource setFloor(Long floor) {
        this.floor = floor;
        return this;
    }

    public Long getCapacity() {
        return capacity;
    }

    public OfficeResource setCapacity(Long capacity) {
        this.capacity = capacity;
        return this;
    }

    public boolean getAllowResource() {
        return allowResource;
    }

    public OfficeResource setAllowResource(boolean allowResource) {
        this.allowResource = allowResource;
        return this;
    }

    public float getScore() {
        return score;
    }

    public OfficeResource setScore(float score) {
        this.score = score;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfficeResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public OfficeResource setPrice(float price) {
        this.price = price;
        return this;
    }

    public boolean getStatus() {
        return status;
    }

    public OfficeResource setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OfficeResource setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
