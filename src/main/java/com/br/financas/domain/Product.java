package com.br.financas.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "product")
@Data
public class Product implements Serializable {

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
    private Long quantity;

    public Product() {

    }

    public Product(String name, String measure, Long quantity) {
        this.name = name;
        this.measure = measure;
        this.quantity = quantity;
    }
}
