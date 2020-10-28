package com.acme.offirent.domain.repository;

import com.acme.offirent.domain.model.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office, Long> {
       Page<Office> findByDistrictId (Long districtId, Pageable pageable);   //al final no se llega a utilizar
       Optional<Page<Office>> findByPriceLessThanEqual (Float price, Pageable pageable);

}
