package org.example;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository {
    List<Contato> listarTodos();

    Contato salvar(Contato contato);

    Contato atualizar(Contato contato);

    void excluir(Long id);

    Optional<Contato> buscarPorId(Long id);
}