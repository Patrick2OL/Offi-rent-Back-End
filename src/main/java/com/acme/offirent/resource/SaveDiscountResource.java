package com.acme.offirent.resource;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
public class SaveDiscountResource {

    @Lob
    @NotNull
    private String description;

    @NotNull
    private float percentage;
}