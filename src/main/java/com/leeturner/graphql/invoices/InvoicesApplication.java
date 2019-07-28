package com.leeturner.graphql.invoices;

import java.util.List;

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
            // seed the database with some example data so we can have a play with the GraphQL queries
            Client bobsMarketingAgency = new Client("Bobs Marketing Agency", 28, "23 Brighton Street", "Rottingdean", "Brighton", "BN2 7DP");
            Invoice bobsInvoice1 = new Invoice("DRAFT", null, "GBP", 120.00, 100.00, 20.00, bobsMarketingAgency);
            Invoice bobsInvoice2 = new Invoice("ISSUED", "2019-07-28", "GBP", 1200.00, 1000.00, 200.0, bobsMarketingAgency);

            Client jillsAccountancyCompany = new Client("Jills Accountancy Company", 28, "24 Eastbourne Rd", null, "Eastboaurne", "BN23 5GP");
            Invoice jillsInvoice1 = new Invoice("DRAFT", null, "GBP", 120.00, 100.00, 20.00, jillsAccountancyCompany);

            clientRepository.saveAll(List.of(bobsMarketingAgency,jillsAccountancyCompany));
            invoiceRepository.saveAll(List.of(bobsInvoice1, bobsInvoice2, jillsInvoice1));
        };
    }

}
