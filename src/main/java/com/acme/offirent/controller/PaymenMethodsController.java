package com.acme.offirent.controller;

import com.acme.offirent.domain.model.PaymentMethod;
import com.acme.offirent.domain.model.Resource;
import com.acme.offirent.domain.service.PaymentMethodService;
import com.acme.offirent.resource.PaymentMethodResource;
import com.acme.offirent.resource.ResourceResource;
import com.acme.offirent.resource.SavePaymentMethodResource;
import com.acme.offirent.resource.SaveResourceResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PaymenMethodsController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get payment method by id",description = "Get PaymentMethod by given Id",tags = {"payment-methods"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get PaymentMethod by given Id",content =@Content(mediaType = "application/json") )
    })
    @GetMapping("/payment-methods/{paymentMethodId}")
    public PaymentMethodResource getPaymentMethodById(@PathVariable(name = "paymentMethodId") Long paymentMethodId){

        PaymentMethod paymentMethod = paymentMethodService.getById(paymentMethodId);
        return convertToResource(paymentMethod);
    }

    private PaymentMethod convertToEntity(SavePaymentMethodResource resource){return  mapper.map(resource, PaymentMethod.class);}

    private PaymentMethodResource convertToResource(PaymentMethod entity){return  mapper.map(entity,PaymentMethodResource.class);}
}
