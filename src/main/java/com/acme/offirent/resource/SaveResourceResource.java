package com.acme.offirent.resource;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveResourceResource {

    @NotNull
    private String name;

    @NotNull
    private long quantity;

    @Lob
    @NotNull
    private String comment;

}
