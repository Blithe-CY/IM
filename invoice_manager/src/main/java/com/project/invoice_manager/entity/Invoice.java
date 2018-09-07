package com.project.invoice_manager.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity(name="tbl_invoice")
public class Invoice {

    @Id
    @Column(name="invoice_id",unique = true,nullable = false,length = 8)
    private String invoiceId;

    @Column(name="user_id",nullable = false)
    private String userId;

    @Column(nullable = false)
    private String invoice_name;

    @Column(nullable = false)
    private String invoice_type;

    @Column(nullable = false)
    private String invoice_money;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String fee_type;

    @Column(nullable = false)
    private String partner;

    @Column(nullable = false)
    private String invoice_time;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String upload_time;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoice_name() {
        return invoice_name;
    }

    public void setInvoice_name(String invoice_name) {
        this.invoice_name = invoice_name;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public String getInvoice_money() {
        return invoice_money;
    }

    public void setInvoice_money(String invoice_money) {
        this.invoice_money = invoice_money;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getInvoice_time() {
        return invoice_time;
    }

    public void setInvoice_time(String invoice_time) {
        this.invoice_time = invoice_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String userId) {
        this.userId = userId;
    }
}
