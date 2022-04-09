package com.example.oil.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="data_type_id")
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name="liquid_type_id")
    private LiquidType liquidType;

    @Column(nullable = false)
    private Integer value;

    public Data(Company company, Date date, DataType dataType, LiquidType liquidType, Integer value) {
        this.company = company;
        this.date = date;
        this.dataType = dataType;
        this.liquidType = liquidType;
        this.value = value;
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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public LiquidType getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(LiquidType liquidType) {
        this.liquidType = liquidType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}