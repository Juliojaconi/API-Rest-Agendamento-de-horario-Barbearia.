package br.com.nexusDev.demo.service;

import br.com.nexusDev.demo.model.Cliente;
import br.com.nexusDev.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cliente criar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setCpf(clienteAtualizado.getCpf());

        // Atualizando os dados do usuário associado
        if (clienteExistente.getUsuario() != null && clienteAtualizado.getUsuario() != null) {
            clienteExistente.getUsuario().setNome(clienteAtualizado.getUsuario().getNome());
            clienteExistente.getUsuario().setEmail(clienteAtualizado.getUsuario().getEmail());
            clienteExistente.getUsuario().setTelefone(clienteAtualizado.getUsuario().getTelefone());
        }

        return repository.save(clienteExistente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}