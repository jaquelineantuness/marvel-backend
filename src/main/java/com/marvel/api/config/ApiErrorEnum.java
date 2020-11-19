package com.marvel.api.config;

public enum ApiErrorEnum {
    RECORD_NOT_FOUND_MESSAGE("Record not found"),
    RECORD_IS_EXIST("Character already exists");

    private String descricao;
    private ApiErrorEnum (String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
