package com.project.invoice_manager.domain;

import com.project.invoice_manager.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {

    Invoice findByInvoiceId(String id);

    void deleteByInvoiceId(String id);
}
