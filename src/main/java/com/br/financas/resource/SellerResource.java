package com.br.financas.resource;

import com.br.financas.domain.Seller;
import com.br.financas.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/seller")
public class SellerResource {

    private final SellerService sellerService;

    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<List<Seller>> findAll() {
        List<Seller> sellers = sellerService.findAll();
        if (!sellers.isEmpty()) {
            return ResponseEntity.ok(sellers);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public void save(@Valid @RequestBody Seller seller) {
        sellerService.save(seller);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sellerService.delete(id);
    }
}
