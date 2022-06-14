package com.crd.demo.common.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Resolution;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DataObject
 */
@MappedSuperclass
public abstract class DataObject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cluSeqGen")
    @SequenceGenerator(name = "cluSeqGen", sequenceName = "DBO.CLU_SEQ", allocationSize = 500)
    private Long id;


    @Column(name = "date_created")
    private Date dateCreated;


    @Column(name = "date_modified")
    private Date dateModified;


    @Column(name = "uuid")
    private String uuid;

    @JsonProperty
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return
     */
    @JsonProperty
    @DateBridge(resolution = Resolution.SECOND)
    @Column(nullable = false, updatable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCreated(String dateCreated) throws ParseException {
        this.dateCreated = new SimpleDateFormat("dd/MM/yy H:mm").parse(dateCreated);
    }

    @JsonProperty
    @DateBridge(resolution = Resolution.SECOND)
    @Column(nullable = false)
    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setDateModified(String dateModified) throws ParseException {
        this.dateModified = new SimpleDateFormat("dd/MM/yy H:mm").parse(dateModified);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataObject that = (DataObject) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        var hashId = id == null ? 0 : id;
        return (int) (hashId ^ (hashId >>> 32));
    }
}
