package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServiceEmailTest {
    @Test
    public void enviarMensagemBoasVindas() {
        //ARRANGE
        EmailClient mockEmailClient = mock(EmailClient.class);
        ServiceEmail serviceEmail = new ServiceEmail(mockEmailClient);

        //ACT
        serviceEmail.enviarMensagemBoasVindas("joao@gmail.com");

        //ASSERT
        verify(mockEmailClient).enviar("joao@gmail.com", "Bem vindo ao time");
    }
}