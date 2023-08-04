package com.br.financas.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@DynamicUpdate
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceProduct")
    @SequenceGenerator(name = "SequenceProduct", sequenceName = "seq_product", allocationSize = 1)
    private Long id;
    @NotNull
    @NotEmpty(message = "Valor do nome não pode ser vazio")
    private String name;
    @NotNull
    @NotEmpty(message = "Valor da medida não pode ser vazio")
    private String measure;
    @NotNull
    @NotEmpty(message = "Valor da quantidade não pode ser vazio")
    private String quantity;

    public Product() {

    }

}
