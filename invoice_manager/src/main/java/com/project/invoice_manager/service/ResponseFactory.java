package com.project.invoice_manager.service;


import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.model.ResponseCode;

public class ResponseFactory {

    public static Response SuccessResponse(Object data) {
        System.out.println(ResponseCode.SUCCESS);
        return new Response(ResponseCode.SUCCESS, "成功", data);
    }

    public static Response FailResponse(String message) {
        return new Response(ResponseCode.FAIL, message,null);
    }

    public static Response OneResponse(ResponseCode responseCode,String message, Object data){
        return new Response(responseCode, message, data);
    }
}

