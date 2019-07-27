package com.leeturner.graphql.invoices;

import com.leeturner.graphql.invoices.model.Client;
import com.leeturner.graphql.invoices.model.Invoice;
import com.leeturner.graphql.invoices.repository.ClientRepository;
import com.leeturner.graphql.invoices.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoicesApplication.class, args);
    }

    @Bean
    public CommandLineRunner invoices(InvoiceRepository invoiceRepository, ClientRepository clientRepository) {
        return (args) -> {
            Client client = new Client("Bobs Marketing Agency", 28, "23 Brighton Street", "Rottingdean", "Brighton", "BN2 7DP");
            clientRepository.save(client);

            Invoice invoice = new Invoice("DRAFT", null, "GBP", client);
            invoiceRepository.save(invoice);
        };
    }

}
