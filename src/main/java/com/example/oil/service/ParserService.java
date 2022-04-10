package com.example.oil.service;

import com.example.oil.model.*;
import com.example.oil.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.oil.utils.DateUtils.getRandomDate;

@Service
public class ParserService {

    @Autowired
    DataRepository dataRepository;
    @Autowired
    SourceTypeRepository sourceTypeRepository;
    @Autowired
    LiquidTypeRepository liquidTypeRepository;
    @Autowired
    DataTypeRepository dataTypeRepository;
    @Autowired
    CompanyRepository companyRepository;

    public void start() {

        Company company = getCompany("company");
        SourceType sourceType = getSourceTypeByName("forecast");
        LiquidType liquidType = getLiquidTypeByName("oil");
        DataType dataType = getDataType("data1");

        Data data = new Data(company, getRandomDate(), sourceType, liquidType, dataType,  15);

        dataRepository.save(data);
    }

    private Company getCompany(String name) {
        Company company = companyRepository.findByName(name);
        if (company==null){
            Company tmp = new Company();
            tmp.setName(name);
            companyRepository.save(tmp);
            company = companyRepository.findByName(name);
        }
        return company;
    }

    private DataType getDataType(String name) {
        DataType dataType = dataTypeRepository.findByName(name);
        if (dataType==null){
            DataType tmp = new DataType();
            tmp.setName(name);
            dataTypeRepository.save(tmp);
            dataType = dataTypeRepository.findByName(name);
        }
        return dataType;
    }

    private LiquidType getLiquidTypeByName(String name) {
        LiquidType liquidType = liquidTypeRepository.findByName(name);
        if (liquidType==null){
            LiquidType tmp = new LiquidType();
            tmp.setName(name);
            liquidTypeRepository.save(tmp);
            liquidType = liquidTypeRepository.findByName(name);
        }
        return liquidType;
    }

    private SourceType getSourceTypeByName(String name) {
        SourceType sourceType = sourceTypeRepository.findByName(name);
        if (sourceType==null){
            SourceType tmp = new SourceType();
            tmp.setName(name);
            sourceTypeRepository.save(tmp);
            sourceType = sourceTypeRepository.findByName(name);
        }
        return sourceType;
    }

}
