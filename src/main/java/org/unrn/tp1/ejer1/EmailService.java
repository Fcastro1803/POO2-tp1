package org.unrn.tp1.ejer1;

import io.mailtrap.client.MailtrapClient;
import io.mailtrap.config.MailtrapConfig;
import io.mailtrap.factory.MailtrapClientFactory;
import io.mailtrap.model.request.emails.Address;
import io.mailtrap.model.request.emails.MailtrapMail;

import java.time.LocalDate;
import java.util.List;

public class EmailService {

    private static final String TOKEN = "67c055987384fdea4f384d862678a264";
    private static final Long INBOX_ID = 4531952L;

    private MailtrapClient client;

    public EmailService() {
        final MailtrapConfig config = new MailtrapConfig.Builder()
                .sandbox(true)
                .inboxId(INBOX_ID)
                .token(TOKEN)
                .build();

        this.client = MailtrapClientFactory.createMailtrapClient(config);
    }

    public void enviarEmailParticipante(Participante participante, String nombreConcurso, LocalDate fecha) {
        String mensaje = String.format(
                "Participante: %s\nID: %d\nConcurso: %s\nFecha: %s",
                participante.getName(),
                participante.getId(),
                nombreConcurso,
                fecha
        );

        final MailtrapMail mail = MailtrapMail.builder()
                .from(new Address("hello@example.com", "Test"))
                .to(List.of(new Address("federicocastro.18.94@gmail.com")))
                .subject("Datos del Participante")
                .text(mensaje)
                .build();

        try {
            System.out.println(client.send(mail));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
