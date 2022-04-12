package com.example.oil.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer extId;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "source_type_id")
    private SourceType sourceType;

    @ManyToOne
    @JoinColumn(name = "liquid_type_id")
    private LiquidType liquidType;

    @ManyToOne
    @JoinColumn(name = "data_type_id")
    private DataType dataType;

    @Column(nullable = false)
    private Integer value;

    public Data() {
    }

    public Data(Integer extId, Company company, Date date, SourceType sourceType, LiquidType liquidType, DataType dataType, Integer value) {
        this.extId = extId;
        this.company = company;
        this.date = date;
        this.sourceType = sourceType;
        this.liquidType = liquidType;
        this.dataType = dataType;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExtId() {
        return extId;
    }

    public void setExtId(Integer extId) {
        this.extId = extId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public LiquidType getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(LiquidType liquidType) {
        this.liquidType = liquidType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}