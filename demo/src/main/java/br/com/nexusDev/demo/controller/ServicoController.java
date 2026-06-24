package br.com.nexusDev.demo.controller;

import br.com.nexusDev.demo.DTOs.ServicoDTO;
import br.com.nexusDev.demo.model.Servico;
import br.com.nexusDev.demo.repository.ServicoRepository;
import br.com.nexusDev.demo.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {


    private final ServicoService servicoService;


    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarTodos()
    {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody ServicoDTO dto) {
        return ResponseEntity.ok(servicoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok(servicoService.atualizar(id, servicoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
