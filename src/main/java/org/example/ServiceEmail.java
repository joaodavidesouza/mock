package org.example;

public class ServiceEmail {
    private final EmailClient emailClient;

    public ServiceEmail(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void enviarMensagemBoasVindas(String destinatario) {
        String mensagem = "Bem vindo ao time";
        emailClient.enviar(destinatario, mensagem);
    }
}
