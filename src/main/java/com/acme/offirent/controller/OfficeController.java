package com.acme.offirent.controller;


import com.acme.offirent.domain.model.Office;
import com.acme.offirent.domain.service.OfficeService;
import com.acme.offirent.resource.OfficeResource;
import com.acme.offirent.resource.SaveOfficeResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OfficeController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OfficeService officeService;


    @Operation(summary = "Get Offices", description = "Get All Offices by Pages", tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Offices returned", content = @Content(mediaType = "application/json"))
                })
    @GetMapping("/offices")
    public Page<OfficeResource> getAllOffices(Pageable pageable){

       List<OfficeResource> offices= officeService.getAllOffices(pageable)
               .getContent().stream().map(this::convertToResource)
               .collect(Collectors.toList());

       int officesCount= offices.size();
       return new PageImpl<>(offices,pageable,officesCount);
    }



    @Operation(summary = "Get Office by Id", description = "Get Office for given Id", tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Office returned", content = @Content(mediaType = "application/json"))
                 })
    @GetMapping("/offices/{id}")
    public OfficeResource getOfficeById(@PathVariable(name = "id") Long officeId){
        return convertToResource(officeService.getOfficeById(officeId));
    }





    @Operation(summary = "Get offices by Price",description = "Get offices with price equal or less than a given price",tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get offices with price equal or less than the given price",content =@Content(mediaType = "application/json") )
                })
    @GetMapping("/offices/{price}/offices")
    public Page<OfficeResource> getAllOfficesByPriceLessThanEqual(@PathVariable(name="price") Float price, Pageable pageable){

        List<OfficeResource> offices= officeService.getAllOfficesByPriceLessThanEqual(price ,pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());

        int officesCount=offices.size();
        return new PageImpl<>(offices,pageable,officesCount);
    }

    @Operation(summary = "Create Offices ",description = "Create a new Office",tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new Office for given information",content =@Content(mediaType = "application/json") )
    })
    @PostMapping("/offices")
    public OfficeResource createOffice(@Valid @RequestBody SaveOfficeResource resource){
        Office office = convertToEntity(resource);
        return convertToResource(officeService.createOffice(office));
    }


    @Operation(summary = "Update Offices",description = "Update Office for given Id",tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update information of office for given Id",content =@Content(mediaType = "application/json") )
    })
    @PutMapping("/offices/{id}")
    public OfficeResource updateOffice(@PathVariable(name = "id")   Long officeId,@Valid @RequestBody SaveOfficeResource resource){
        return convertToResource(officeService.updateOffice(officeId,convertToEntity(resource)));
    }

    @Operation(summary = "Delete Offices",description = "Delete Office for given Id",tags = {"offices"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete office for given Id",content =@Content(mediaType = "application/json") )
    })
    @DeleteMapping("/offices/{id}")
    public ResponseEntity<?> deleteOffice(@PathVariable(name="id") Long officeId){
        return officeService.deleteOffice(officeId);
    }

    private Office convertToEntity(SaveOfficeResource resource){
        return mapper.map(resource, Office.class);
    }

    private OfficeResource convertToResource(Office entity){
        return mapper.map(entity, OfficeResource.class);
    }

}
