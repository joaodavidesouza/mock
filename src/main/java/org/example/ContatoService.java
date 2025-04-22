package org.example;

import java.util.List;
import java.util.Optional;

public class ContatoService {
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public List<Contato> listarTodos() {
        return repository.listarTodos();
    }

    public Contato salvar(Contato contato) {
        return repository.salvar(contato);
    }

    public Contato atualizar(Contato contato) {
        return repository.atualizar(contato);
    }

    public void excluir(Long id) {
        repository.excluir(id);
    }

    public Optional<Contato> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }
}