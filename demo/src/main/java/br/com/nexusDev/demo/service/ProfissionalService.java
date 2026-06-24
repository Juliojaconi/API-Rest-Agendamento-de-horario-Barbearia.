package br.com.nexusDev.demo.service;

import br.com.nexusDev.demo.DTOs.ProfissionalDTO;
import br.com.nexusDev.demo.model.Profissional;
import br.com.nexusDev.demo.model.Servico;
import br.com.nexusDev.demo.model.Usuario;
import br.com.nexusDev.demo.repository.ProfissionalRepository;
import br.com.nexusDev.demo.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;
    private final ServicoRepository servicoRepository;

    public ProfissionalService(ProfissionalRepository repository, ServicoRepository servicoRepository) {
        this.repository = repository;
        this.servicoRepository = servicoRepository;
    }

    public List<Profissional> listarTodos() {
        return repository.findAll();
    }

    public Optional<Profissional> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Profissional criar(ProfissionalDTO dto) {
        Profissional profissional = new Profissional();

        Usuario usuario = new Usuario();
        usuario.setNome(dto.usuario().nome());
        usuario.setEmail(dto.usuario().email());
        usuario.setTelefone(dto.usuario().telefone());

        profissional.setUsuario(usuario);
        profissional.setEspecialidade(dto.especialidade());

        List<Servico> servicosList = servicoRepository.findAllById(dto.servicosAtendidosIds());
        profissional.setServicosAtendidos(new HashSet<>(servicosList));

        return repository.save(profissional);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Profissional atualizar(Long id, Profissional profissional) {
        profissional.setId(id);
        return repository.save(profissional);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}