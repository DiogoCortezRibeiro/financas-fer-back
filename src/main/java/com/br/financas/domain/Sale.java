package com.br.financas.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "sale")
@Data
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceSale")
    @SequenceGenerator(name = "SequenceSale", sequenceName = "seq_sale", allocationSize = 1)
    private Long id;
    private Long quantity;
    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    @OneToOne(fetch = FetchType.EAGER)
    private Seller seller;
}
