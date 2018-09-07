package com.project.invoice_manager.model;


public class Response {
    private ResponseCode code;
    private String message;
    private Object  data;

    public Response(ResponseCode code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
