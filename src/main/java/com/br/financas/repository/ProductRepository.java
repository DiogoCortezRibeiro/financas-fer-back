package com.br.financas.repository;

import com.br.financas.domain.Product;
import com.br.financas.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
