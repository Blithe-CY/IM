package com.project.invoice_manager.service;

import com.project.invoice_manager.domain.InvoiceRepository;
import com.project.invoice_manager.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getInvoiceList(){
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findInvoiceById(String id){
        return invoiceRepository.findByInvoiceId(id);
    }

    @Override
    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoiceById(String id){
        invoiceRepository.deleteByInvoiceId(id);
    }

    @Override
    public List<Invoice> getInvoiceListByUserId(String id)
    {
        return invoiceRepository.findByUserId(id);
    }

}
