package com.example.demo.controllers;


import com.example.demo.models.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.DetailService;
import com.example.demo.service.InvoiceService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
@CrossOrigin("*")
public class InvoicesController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices(
            @RequestParam(required = false, name = "receiver_nif") @Nullable String receiverNif
    ) {
        if(receiverNif != null) {
            return invoiceService.findAllInvoicesByReceiverNif(receiverNif);
        }
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoiceService.findById(id).orElse(null);
    }

    @PostMapping
    public Invoice postInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice putInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        if(id != null) {
            invoice.setId(id);
            return invoiceService.updateInvoice(invoice);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoiceById(id);
    }
}

