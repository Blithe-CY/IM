package com.project.invoice_manager.controller;

import com.project.invoice_manager.entity.Invoice;
import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.service.InvoiceService;
import com.project.invoice_manager.service.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

// 支持跨域
@CrossOrigin
@RestController
@RequestMapping(value="/invoice")
public class InvoiceController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(value = "/upload")
    public Response InvoiceUpload(@RequestBody Invoice invoice,@RequestBody Map<String,Object> info){
        try{

            System.out.println(invoice.getInvoice_name());
            long l = System.currentTimeMillis();
            Date time = new Date(l);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            invoice.setUpload_time(sdf.format(time));
            invoice.setInvoiceId((String)info.get("invoice_id"));
            invoiceService.save(invoice);
            return ResponseFactory.SuccessResponse(sdf.format(time));
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }


    @PostMapping(value="/myInvoice")
    public Response getMyInvoice(@RequestBody Map<String,String> info){
        try{
            String user_id = info.get("user_id");
            ArrayList<Invoice> myInvoice = new ArrayList<> (invoiceService.getInvoiceListByUserId(user_id));
            return ResponseFactory.SuccessResponse(myInvoice);
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }

    }
}
