package com.crd.toolkits.tests.dao;

//import com.crd.demo.common.dao.repository.CarsRepository;

import com.crd.demo.common.model.models.Cars;
import com.crd.demo.common.service.CarsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * HeatMap data test case
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class DataTest {
    private final static Logger logger = LoggerFactory.getLogger(DataTest.class);

    private CarsService carsService;

    private static List<Integer> loopList = new ArrayList<Integer>();




    @BeforeAll
    public void setUp() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

    }

    @Test
    public void testTestConnection() {

        logger.debug(">>>");
        Cars cars = new Cars();
        cars.setId(1L);
        carsService.saveCars(cars);

//        Cars cars = new Cars();
//        cars.setId(1L);
//        carsRepository.save(cars);
    }


}

