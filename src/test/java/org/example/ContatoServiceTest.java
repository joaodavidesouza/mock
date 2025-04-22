package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContatoServiceTest {

    @Mock
    private ContatoRepository repoMock;

    private ContatoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ContatoService(repoMock);
    }

    @Test
    void deveListarTodosOsContatos() {
        // Arrange
        List<Contato> contatos = Arrays.asList(
                new Contato(1L, "Maria", "maria@gmail.com"),
                new Contato(2L, "João", "joao@gmail.com")
        );

        when(repoMock.listarTodos()).thenReturn(contatos);

        // Act
        List<Contato> resultado = service.listarTodos();

        // Assert
        assertEquals(2, resultado.size());
        verify(repoMock).listarTodos();
    }

    @Test
    void deveSalvarContato() {
        // Arrange
        Contato contato = new Contato(null, "Pedro", "pedro@gmail.com");
        Contato contatoSalvo = new Contato(3L, "Pedro", "pedro@gmail.com");

        when(repoMock.salvar(contato)).thenReturn(contatoSalvo);

        // Act
        Contato resultado = service.salvar(contato);

        // Assert
        assertNotNull(resultado.getId());
        assertEquals("Pedro", resultado.getNome());
        assertEquals("pedro@gmail.com", resultado.getEmail());
        verify(repoMock).salvar(contato);
    }

    @Test
    void deveAtualizarContato() {
        // Arrange
        Contato contato = new Contato(1L, "Maria Atualizada", "maria.atualizada@gmail.com");

        when(repoMock.atualizar(contato)).thenReturn(contato);

        // Act
        Contato resultado = service.atualizar(contato);

        // Assert
        assertEquals("Maria Atualizada", resultado.getNome());
        assertEquals("maria.atualizada@gmail.com", resultado.getEmail());
        verify(repoMock).atualizar(contato);
    }

    @Test
    void deveExcluirContato() {
        // Arrange
        Long id = 1L;

        // Act
        service.excluir(id);

        // Assert
        verify(repoMock).excluir(id);
    }

    @Test
    void deveBuscarContatoPorId() {
        // Arrange
        Long id = 1L;
        Contato contato = new Contato(id, "Maria", "maria@gmail.com");

        when(repoMock.buscarPorId(id)).thenReturn(Optional.of(contato));

        // Act
        Optional<Contato> resultado = service.buscarPorId(id);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Maria", resultado.get().getNome());
        assertEquals("maria@gmail.com", resultado.get().getEmail());
        verify(repoMock).buscarPorId(id);
    }

    @Test
    void deveBuscarContatoPorIdInexistente() {
        // Arrange
        Long id = 99L;

        when(repoMock.buscarPorId(id)).thenReturn(Optional.empty());

        // Act
        Optional<Contato> resultado = service.buscarPorId(id);

        // Assert
        assertFalse(resultado.isPresent());
        verify(repoMock).buscarPorId(id);
    }
}