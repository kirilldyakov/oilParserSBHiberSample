package com.example.oil.model;

public enum ColumnType {
    SOURCE_TYPE("source_type"),
    LIQUID_TYPE("liquid_type"),
    DATA_TYPE("data_type");

    public final String name;

    ColumnType(String name) {
        this.name = name;
    }

    public static ColumnType get(int i) {
        if (i < values().length) {
            return values()[i];
        }
        return null;
    }
}
