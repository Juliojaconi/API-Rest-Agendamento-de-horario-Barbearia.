package br.com.nexusDev.demo.DTOs;

import br.com.nexusDev.demo.model.Usuario;

import java.util.Set;

public record ProfissionalDTO(
        UsuarioDTO usuario,
        String especialidade,
        Set<Long> servicosAtendidosIds
) {
}
