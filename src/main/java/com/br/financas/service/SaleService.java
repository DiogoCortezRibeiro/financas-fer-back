package com.br.financas.service;

import com.br.financas.domain.Product;
import com.br.financas.domain.Sale;
import com.br.financas.repository.ProductRepository;
import com.br.financas.repository.SaleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;

    public SaleService(SaleRepository saleRepository, ProductService productService) {
        this.saleRepository = saleRepository;
        this.productService = productService;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Optional<Sale> findOneProduct(Long id) {
        return saleRepository.findById(id);
    }

    public ResponseEntity<Void> save(Sale sale) {
        Optional<Product> productOptional = productService.findOneProduct(sale.getProduct().getId());

        if (productOptional.isEmpty() || productOptional.get().getQuantity() < sale.getQuantity()) {
            return ResponseEntity.badRequest().build();
        } else {
            Product product = productOptional.get();
            product.setQuantity(product.getQuantity() - sale.getQuantity());
            productService.save(product);
            saleRepository.save(sale);
            return ResponseEntity.ok().build();
        }

    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }
}
