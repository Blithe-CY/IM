package com.project.invoice_manager.model;

//Response Code 方便修改

public enum ResponseCode {
    SUCCESS("SUCCESS"),
    FAIL("FAIL"),
    NOT_FOUND("NOT_FOUND"),
    INTERNAL_SERVER_ERROR("ERROR");

    public String code;
    ResponseCode(String  code){
        this.code = code;
    }
//    public int value(){
//        return this.code;
//    }
}
