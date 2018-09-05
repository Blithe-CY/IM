package com.project.invoice_manager.controller;

import com.project.invoice_manager.entity.Invoice;
import com.project.invoice_manager.model.Response;
import com.project.invoice_manager.service.InvoiceService;
import com.project.invoice_manager.service.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;



@RestController
public class InvoiceController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(value = "/upload")
    public Response InvoiceUpload(Invoice invoice,String invoiceId){
        try{
            long l = System.currentTimeMillis();
            Date time = new Date(l);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            invoice.setUpload_time(time);
            invoiceService.save(invoice);
            return ResponseFactory.SuccessResponse(sdf.format(time));
        }
        catch (Exception e){
            logger.info(e.toString());
            return ResponseFactory.FailResponse(null);
        }
    }
}
