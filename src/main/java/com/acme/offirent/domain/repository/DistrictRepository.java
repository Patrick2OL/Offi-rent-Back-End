package com.acme.offirent.domain.repository;

import com.acme.offirent.domain.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    Page<District> findByDepartamentId (Long departamentId, Pageable pageable);  //al final no se llega a utilizar

}
