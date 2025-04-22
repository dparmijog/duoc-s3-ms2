package com.example.demo.repository;

import com.example.demo.models.Detail;
import com.example.demo.models.Invoice;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
