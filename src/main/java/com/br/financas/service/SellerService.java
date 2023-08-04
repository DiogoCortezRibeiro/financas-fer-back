package com.br.financas.service;

import com.br.financas.domain.Seller;
import com.br.financas.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> findOneSeller(Long id) {
        return sellerRepository.findById(id);
    }

    public void save(Seller seller) {
        sellerRepository.save(seller);
    }

    public void delete(Long id) {
        sellerRepository.deleteById(id);
    }
}
