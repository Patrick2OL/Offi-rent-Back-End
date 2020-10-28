package com.acme.offirent.controller;

import com.acme.offirent.domain.model.District;
import com.acme.offirent.domain.service.DistrictService;
import com.acme.offirent.resource.DistrictResource;
import com.acme.offirent.resource.SaveDistrictResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
public class DistrictsController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get District by Id", description = "Get District for given Id", tags = {"districts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "District returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/districts/{id}")
    public DistrictResource getDistrictById(@PathVariable(name = "id") Long districtId){
        return convertToResource(districtService.getDistrictById(districtId));
    }




    @Operation(summary = "Create District ",description = "Enter a new District at register",tags = {"districts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enter a new Office for given information",content =@Content(mediaType = "application/json") )
    })
    @PostMapping("/districts")
    public DistrictResource createDistrict(@Valid @RequestBody SaveDistrictResource resource){
        return convertToResource(
                districtService.createDistrict(convertToEntity(resource)));
    }

    @Operation(summary = "Delete District",description = "Delete District for given Id at register",tags = {"districts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete District for given Id",content =@Content(mediaType = "application/json") )
    })
    @DeleteMapping("/districts/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable(name = "id") Long districtId){
        return districtService.deleteDistrict(districtId);
    }



    private District convertToEntity(SaveDistrictResource resource){return  mapper.map(resource, District.class);}

    private DistrictResource convertToResource(District entity){return  mapper.map(entity,DistrictResource.class);}
}
