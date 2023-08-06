package com.br.financas.resource;

import com.br.financas.domain.Product;
import com.br.financas.domain.Sale;
import com.br.financas.service.ProductService;
import com.br.financas.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/sale")
public class SaleResource {

    private final SaleService saleService;

    public SaleResource(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sales = saleService.findAll();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findOneProduct(@PathVariable Long id) {
        Sale sale = saleService.findOneProduct(id).orElse(null);
        if (Objects.nonNull(sale)) {
            return ResponseEntity.ok(sale);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleService.delete(id);
    }
}
