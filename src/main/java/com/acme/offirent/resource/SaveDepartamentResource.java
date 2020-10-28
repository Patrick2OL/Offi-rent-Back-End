package com.acme.offirent.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveDepartamentResource {
    @NotNull
    @Size(max = 100)
    private String name;
}
