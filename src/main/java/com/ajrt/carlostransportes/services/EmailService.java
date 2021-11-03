package com.ajrt.carlostransportes.services;

import com.ajrt.carlostransportes.dtos.FeedbackDTO;
import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import com.ajrt.carlostransportes.dtos.TransportItemsDTO;
import com.ajrt.carlostransportes.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Properties;
import java.util.stream.Collectors;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService
{
    @Autowired
    private Environment env;

    @Value("${email-user-email}")
    private String username;

    @Value("${email-user-password}")
    private String password;

    public void sendEmail(ConfigEmail configEmail) {


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("joaovictorteixeira981998199819@gmail.com");
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(configEmail.getSubject());//Assunto
            message.setContent(configEmail.getContent(), "text/html; charset=ISO-8859-1");
            Transport.send(message);
            System.out.println("Email Enviado");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHtmlQuotationCreated(String title, QuotationRequestDTO quotation) {

        String itemsToTransport = getItemsToTransport(quotation);

        String content =
            "<h2>" + title + "</h2>\n" +
            "<br>" +
                (quotation.getQuotationType() != null ? "<p> Tipo cotação: " + quotation.getQuotationType() + "</p>" : "") +
                (quotation.getRequesterName() != null ? "<p> Solicitante: " + quotation.getRequesterName() + "</p>" : "") +
                (quotation.getRequesterMainTelephone() != null ? "<p> Telefone principal: " + quotation.getRequesterMainTelephone() + "</p>" : "") +
                (quotation.getRequesterSecondaryTelephone() != null ? "<p> Telefone secundário: " + quotation.getRequesterSecondaryTelephone() + "</p>" : "" )+
                (quotation.getDateSolicitation() != null ? "<p> Data solicitação: " + quotation.getDateSolicitation() + "</p>" : "")+
                (quotation.getCnpjSender() != null ? "<p> Cnpj Remetente: " +  quotation.getCnpjSender() + "</p>" : "") +
                (quotation.getCnpjRecipient() != null ? "<p> Cnpj Destinatário: " +  quotation.getCnpjRecipient() + "</p>" : "") +
                (quotation.getPaidAtOrigin() != null ? "<p> Pago na origem?: " + quotation.getPaidAtOrigin()  + "</p>" : "") +
                (quotation.isNeedHelper() != false ? "<p> Precisa de ajudante?: " + quotation.isNeedHelper()  + "</p>" : "") +
                (quotation.getTypeHousing() != null ? "<p> Tipo de casa: " + quotation.getTypeHousing()  + "</p>" : "") +
                (quotation.getOriginCep() != null ? "<p> CEP origem: " + quotation.getOriginCep()  + "</p>" : "") +
                (quotation.getOriginCity() != null ? "<p> Cidade de origem: " + quotation.getOriginCity() + "</p>" : "") +
                (quotation.getOriginAddress() != null ? "<p> Endereco de origem: " + quotation.getOriginAddress() + "</p>" : "") +
                (quotation.getOriginDistrict() != null ? "<p> Bairro de origem: " + quotation.getOriginDistrict() + "</p>" : "") +
                (quotation.getOriginNumber() != null ? "<p> Número de origem: " + quotation.getOriginNumber() + "</p>" : "")  +
                (quotation.getDestinyCep() != null ? "<p> CEP destino: " + quotation.getDestinyCep() + "</p>" : "")  +
                (quotation.getDestinyCity() != null ? "<p> Cidade de destino: " + quotation.getDestinyCity()  + "</p>" : "")  +
                (quotation.getDestinyddress() != null ? "<p> Endereco de destino: " + quotation.getDestinyddress() + "</p>" : "")  +
                (quotation.getDestinyDistrict() != null ? "<p> Bairro de destino: " + quotation.getDestinyDistrict() + "</p>" : "") +
                (quotation.getDestinyNumber() != null ? "<p> Número de destino: " + quotation.getDestinyNumber()  + "</p>" : "")  +
                (quotation.getWeight() != null ? "<p> Peso mercadoria: " + quotation.getWeight()  + " kg</p>" : "")  +
                (quotation.getQuantityItems() != null ? "<p> Quant. items" + quotation.getQuantityItems() + "</p>" : "")  +
                (quotation.getQuantityItems() != null ? "<p> Precisa de ajudant?" + quotation.getQuantityItems() + "</p>" : "")  +
                (quotation.getDateToCollect() != null ? "<p> Data e hora de coleta: " + quotation.getDateToCollect() + "</p>" : "")  +
                (quotation.getCollectObservations() != null ? "<p> Observações para coleta: " + quotation.getCollectObservations() + "</p>" : "")  +
                (quotation.getMerchandiseObservations() != null ? "<p> Observações para mercadoria: " +  quotation.getMerchandiseObservations() + "</p>" : "") +
            itemsToTransport;

        return htmlWrap(content);
    }

    public String getHtmlFeedbackCreated(FeedbackDTO feedbackDTO) {

        String content =
                "<h2>Feedback recebido</h2>" +
                "<p>Avaliação de 0 a 5 : </p>" + feedbackDTO.getAvaliation() +
                "<br> <br> <p>Estamos indo bem? </p>" + feedbackDTO.getDescription();

        return htmlWrap(content);
    }

    private String getItemsToTransport(QuotationRequestDTO quotation) {
        String itemsToTransport = "<br> <h1> Itens para transportar: </h1>";
        quotation.getTransportItems().forEach(e -> {
            String item = e.getItem();
            Integer quantity = e.getQuantity();
            String text = "<br> <br> <p> Item: " + item + "</p> <p> Quantity: " + quantity + "</p>";

            itemsToTransport.concat(text);
        });
        return itemsToTransport;
    }

    private String htmlWrap(String content) {
        return  "<html> " +
                    "<body> " +
                        content +
                    "</body> " +
                "</html>";
    }
}