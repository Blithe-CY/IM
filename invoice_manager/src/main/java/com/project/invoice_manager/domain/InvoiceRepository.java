package com.project.invoice_manager.domain;

import com.project.invoice_manager.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {

    Invoice findByInvoiceId(String id);

    void deleteByInvoiceId(String id);
    List<Invoice> findByUserId(String id);
}
