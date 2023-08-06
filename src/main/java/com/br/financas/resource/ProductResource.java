package com.br.financas.resource;

import com.br.financas.domain.Product;
import com.br.financas.domain.Seller;
import com.br.financas.service.ProductService;
import com.br.financas.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOneProduct(@PathVariable Long id) {
        Product product = productService.findOneProduct(id).orElse(null);
        if (Objects.nonNull(product)) {
            return ResponseEntity.ok(product);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public void save(@Valid @RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
