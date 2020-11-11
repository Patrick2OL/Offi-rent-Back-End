package com.acme.offirent.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payment_methods")
public class PaymentMethod{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cardNumber;

    @NotNull
    private String ownerName;

    @NotNull
    private String dueDate;

    @NotNull
    private String cv;

    
}