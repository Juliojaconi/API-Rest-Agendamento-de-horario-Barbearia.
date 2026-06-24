package br.com.nexusDev.demo.DTOs;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        long clienteId,
        long profissionalId,
        long servicoId
) {
}
