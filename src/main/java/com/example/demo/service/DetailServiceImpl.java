package com.example.demo.service;

import com.example.demo.models.Detail;
import com.example.demo.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public Detail createDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public Detail updateDetail(Long id, Detail detail) {
        return detailRepository.findById(id)
                .map(existingDetail -> {
                    detail.setId(existingDetail.getId());
                    return detailRepository.save(detail);
                })
                .orElseThrow(() -> new RuntimeException("Detail not found"));
    }

    @Override
    public void deleteDetailById(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public List<Detail> findAllDetails() {
        return detailRepository.findAll();
    }

    @Override
    public List<Detail> findAllDetailsByInvoiceId(Long invoiceId) {
        return findAllDetails().stream()
                .filter(detail -> detail.getInvoiceId().equals(invoiceId))
                .toList();
    }
}
