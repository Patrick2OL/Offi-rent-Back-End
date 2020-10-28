package com.acme.offirent.domain.repository;

import com.acme.offirent.domain.model.Office;
import com.acme.offirent.domain.model.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    //TODO
    //Page<PaymentMethod> findByAccountId (Long AccountId,Pageable pageable );
}