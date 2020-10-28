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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DepartamentDistrictsController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ModelMapper mapper;


    @Operation(summary = "Get Districts by Departament", description = "Get Districts for given Departament's", tags = {"departaments"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Districts within the Departament with entered id",content =@Content(mediaType = "application/json") )
    })
    @GetMapping("/departaments/{id}/districts")
    public Page<DistrictResource> getAllDistrictByDepartamentId(@PathVariable(name = "id") Long departamentId, Pageable pageable){
        List<DistrictResource> districts=districtService.getAllDistrictByDepartamentId(departamentId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());

        int districtsCount= districts.size();
        return new PageImpl<>(districts,pageable,districtsCount);
    }

    private District convertToEntity(SaveDistrictResource resource){return  mapper.map(resource, District.class);}

    private DistrictResource convertToResource(District entity){return  mapper.map(entity,DistrictResource.class);}
}
