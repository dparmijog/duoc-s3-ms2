package com.example.demo.controllers;


import com.example.demo.models.Invoice;
import com.example.demo.repository.InvoicesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return InvoicesRepository.getAll();
    }

    @GetMapping("/random")
    public Optional<Invoice> getAny() {
        return InvoicesRepository.getAny();
    }

    @GetMapping("/{id}")
    public Optional<Invoice> getInvoiceById(@PathVariable String id) {
        return InvoicesRepository.getOneById(id);
    }
}
