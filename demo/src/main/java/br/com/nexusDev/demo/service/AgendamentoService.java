package br.com.nexusDev.demo.service;

import br.com.nexusDev.demo.DTOs.AgendamentoDTO;
import br.com.nexusDev.demo.model.*;
import br.com.nexusDev.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final ProfissionalRepository profissionalRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoService(AgendamentoRepository repository, ProfissionalRepository profissionalRepository,
                              ClienteRepository clienteRepository, ServicoRepository servicoRepository) {
        this.repository = repository;
        this.profissionalRepository = profissionalRepository;
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agendamento criar(AgendamentoDTO dto) {
        Profissional profissional = profissionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Servico servico = servicoRepository.findById(dto.servicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setProfissional(profissional);
        agendamento.setServico(servico);
        agendamento.setDataHoraInicio(dto.dataHoraInicio());
        agendamento.setDataHoraFim(dto.dataHoraFim());

        return repository.save(agendamento);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Agendamento salvar(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}