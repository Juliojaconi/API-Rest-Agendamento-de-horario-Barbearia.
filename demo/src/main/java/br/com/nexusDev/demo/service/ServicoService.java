package br.com.nexusDev.demo.service;

import br.com.nexusDev.demo.DTOs.ServicoDTO;
import br.com.nexusDev.demo.model.Servico;
import br.com.nexusDev.demo.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarTodos(){
        if (servicoRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nenhum serviço encontrado.");
        }
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
    }

    public Servico criar(ServicoDTO servicoDTO){
        Servico servico = new Servico();
        servico.setNome(servicoDTO.nome());
        servico.setDescricao(servicoDTO.descricao());
        servico.setPreco(servicoDTO.preco());
        servico.setDuracaoMinutos(servicoDTO.duracaoMinutos());
        return servicoRepository.save(servico);

    }

    public Servico atualizar(Long id, ServicoDTO servicoDTO){
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado com o ID: " + id);
        }
        Servico servico = new Servico();
        servico.setId(id);
        servico.setNome(servicoDTO.nome());
        servico.setDescricao(servicoDTO.descricao());
        servico.setPreco(servicoDTO.preco());
        servico.setDuracaoMinutos(servicoDTO.duracaoMinutos());
        servicoRepository.save(servico);
        return servico;
    }

    public void deletar(Long id){
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado com o ID: " + id);
        }
        servicoRepository.deleteById(id);

    }
}
