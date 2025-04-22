package com.example.demo.service;

import com.example.demo.models.Detail;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DetailService {
    Optional<Detail> findById(Long id);
    Detail createDetail(Detail detail);
    Detail updateDetail(Long id, Detail detail);
    void deleteDetailById(Long id);
    List<Detail> findAllDetails();
    List<Detail> findAllDetailsByInvoiceId(Long invoiceId);
}
