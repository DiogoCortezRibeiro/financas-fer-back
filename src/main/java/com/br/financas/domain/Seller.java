package com.br.financas.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@DynamicUpdate
@Table(name = "seller")
@Data
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceSeller")
    @SequenceGenerator(name = "SequenceSeller", sequenceName = "seq_seller", allocationSize = 1)
    private Long id;
    @NotNull
    @NotEmpty(message = "Valor do nome não pode ser vazio")
    private String name;

    public Seller() {

    }

}
