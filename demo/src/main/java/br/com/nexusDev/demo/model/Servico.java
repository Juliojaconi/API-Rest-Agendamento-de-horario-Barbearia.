package br.com.nexusDev.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "servicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Min(value = 0, message = "O preço deve ser positivo")
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer duracaoMinutos;
}
