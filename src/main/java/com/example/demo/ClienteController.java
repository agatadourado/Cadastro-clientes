package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {

    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {
        this.repo = repo;
    }

    // LISTAR
    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll();
    }

    // CADASTRAR
    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return repo.save(cliente);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // EDITAR
    @PutMapping("/{id}")
    public Cliente editar(@PathVariable Long id, @RequestBody Cliente dados) {
        Cliente cliente = repo.findById(id).orElseThrow();
        cliente.setNome(dados.getNome());
        cliente.setTelefone(dados.getTelefone());
        cliente.setEmail(dados.getEmail());
        cliente.setEndereco(dados.getEndereco());
        return repo.save(cliente);
    }
}