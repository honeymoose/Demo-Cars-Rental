package com.crd.demo.common.dao.repository;


import com.crd.demo.common.model.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    Cars findCommonManufacturerByUuid(String uuid);
}
