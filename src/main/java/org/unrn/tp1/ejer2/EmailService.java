package org.unrn.tp1.ejer2;

import io.mailtrap.client.MailtrapClient;
import io.mailtrap.config.MailtrapConfig;
import io.mailtrap.factory.MailtrapClientFactory;
import io.mailtrap.model.request.emails.Address;
import io.mailtrap.model.request.emails.MailtrapMail;

import java.time.LocalDate;
import java.util.List;

public class EmailService implements ServiceMail {

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

    @Override
    public void enviarEmailPedido(LocalDate fecha, double totalPagar, String tarjeta) {
        String mensaje = String.format(
                "Fecha de Pedido: %s\nTotal A Pagar: %.2f\nTarjeta Utilizada: %s",
                fecha,
                totalPagar,
                tarjeta
        );

        final MailtrapMail mail = MailtrapMail.builder()
                .from(new Address("hello@example.com", "Test"))
                .to(List.of(new Address("federicocastro.18.94@gmail.com")))
                .subject("Datos del Pedido")
                .text(mensaje)
                .build();

        try {
            System.out.println(client.send(mail));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
