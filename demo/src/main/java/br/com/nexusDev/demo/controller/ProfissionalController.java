package br.com.nexusDev.demo.controller;

import br.com.nexusDev.demo.DTOs.ProfissionalDTO;
import br.com.nexusDev.demo.model.Profissional;
import br.com.nexusDev.demo.model.Servico;
import br.com.nexusDev.demo.model.Usuario;
import br.com.nexusDev.demo.repository.ProfissionalRepository;
import br.com.nexusDev.demo.repository.ServicoRepository;
import br.com.nexusDev.demo.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profissional> criar(@RequestBody ProfissionalDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, @RequestBody Profissional profissional) {
        if (!service.existsById(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.atualizar(id, profissional));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.existsById(id)) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}