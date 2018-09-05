package com.project.invoice_manager.service;

import com.project.invoice_manager.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getInvoiceList();
    Invoice findInvoiceById(String id);
    void save(Invoice invoice);
    void deleteInvoiceById(String id);
}
