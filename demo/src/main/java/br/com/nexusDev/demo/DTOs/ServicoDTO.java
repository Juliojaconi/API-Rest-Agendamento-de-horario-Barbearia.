package br.com.nexusDev.demo.DTOs;

import java.math.BigDecimal;

public record ServicoDTO(
        String nome,
        String descricao,
        BigDecimal preco,
        Integer duracaoMinutos

) {
}
