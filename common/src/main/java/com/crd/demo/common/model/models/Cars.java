package com.crd.demo.common.model.models;

import com.crd.demo.common.dao.DataObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * ORM For Table: CARS
 */
@Entity
@Table(name = "CARS", schema = "h2")
public class Cars extends DataObject implements Serializable {


    @Column(name = "name")
    private String manufacturerName;

    /**
     * Constructor
     */
    public Cars() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
