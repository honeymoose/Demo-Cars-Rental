package com.crd.demo.common.service;

import com.crd.demo.common.dao.repository.CarsRepository;
import com.crd.demo.common.model.models.Cars;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * CommonManufacturerService to Process data logic
 */
@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    @Override
    public Cars saveCars(Cars cars) {
        return carsRepository.save(cars);
    }
}
