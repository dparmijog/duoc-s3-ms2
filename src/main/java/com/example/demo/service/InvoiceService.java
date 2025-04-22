package com.example.demo.service;

import com.example.demo.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Optional<Invoice> findById(Long id);

    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    void deleteInvoiceById(Long id);
    List<Invoice> findAllInvoices();
    List<Invoice> findAllInvoicesByReceiverNif(String receiverNif);

}

