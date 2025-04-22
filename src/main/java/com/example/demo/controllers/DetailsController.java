package com.example.demo.controllers;

import com.example.demo.models.Detail;
import com.example.demo.service.DetailService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/details")
@CrossOrigin("*")
public class DetailsController {

    @Autowired
    DetailService detailService;

    @GetMapping
    public List<Detail> getAllDetails(
            @RequestParam(required = false, name = "invoice_id") @Nullable Long invoiceId
    ) {
        if(invoiceId != null) {
            return detailService.findAllDetailsByInvoiceId(invoiceId);
        }
        return detailService.findAllDetails();
    }

    @PostMapping
    public Detail postDetail(@RequestBody Detail detail) {
        return detailService.createDetail(detail);
    }

    @PutMapping("/{id}")
    public Detail putDetail(@PathVariable Long id, @RequestBody Detail detail) {
        return detailService.updateDetail(id, detail);
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable Long id) {
        detailService.deleteDetailById(id);
    }

}
