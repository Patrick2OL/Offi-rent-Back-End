package com.acme.offirent.controller;

import com.acme.offirent.domain.model.Office;
import com.acme.offirent.domain.service.OfficeService;
import com.acme.offirent.resource.OfficeResource;
import com.acme.offirent.resource.SaveOfficeResource;
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
public class DistrictOfficesController {


    @Autowired
    private OfficeService officeService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get Offices by District", description = "Get Offices for given District's id", tags = {"districts"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Offices within the District with entered id",content =@Content(mediaType = "application/json") )
    })
    @GetMapping("/districts/{districtId}/offices")
    public Page<OfficeResource> getAllOfficesByDistrictId(@PathVariable(name="districtId")Long districtId, Pageable pageable ){

        List<OfficeResource> offices= officeService.getAllOfficesByDistrictId(districtId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());

        int officesCount=offices.size();
        return new PageImpl<>(offices, pageable, officesCount);
    }

    private Office convertToEntity(SaveOfficeResource resource){
        return mapper.map(resource, Office.class);
    }

    private OfficeResource convertToResource(Office entity){
        return mapper.map(entity, OfficeResource.class);
    }
}
