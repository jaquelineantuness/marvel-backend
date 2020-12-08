package com.marvel.api.config;

public enum ApiErrorEnum {

    RECORD_NOT_FOUND_MESSAGE("Record not found"),
    RECORD_IS_EXIST("Record already exists");

    private String descricao;
    ApiErrorEnum(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
