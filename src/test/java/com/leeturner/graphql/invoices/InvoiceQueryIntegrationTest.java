package com.leeturner.graphql.invoices;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.leeturner.graphql.invoices.model.Client;
import com.leeturner.graphql.invoices.model.Invoice;
import com.leeturner.graphql.invoices.repository.ClientRepository;
import com.leeturner.graphql.invoices.repository.InvoiceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceQueryIntegrationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @BeforeEach
    void seedDatabase() {
        // seed the database with some example data so we can have a play with the GraphQL queries
        Client bobsMarketingAgency = new Client("Bobs Marketing Agency", 28, "23 Brighton Street", "Rottingdean", "Brighton", "BN2 7DP");
        Invoice bobsInvoice1 = new Invoice("DRAFT", null, "GBP", 120.00, 100.00, 20.00, bobsMarketingAgency);
        Invoice bobsInvoice2 = new Invoice("ISSUED", "2019-07-28", "GBP", 1200.00, 1000.00, 200.0, bobsMarketingAgency);

        Client jillsAccountancyCompany = new Client("Jills Accountancy Company", 28, "24 Eastbourne Rd", null, "Eastboaurne", "BN23 5GP");
        Invoice jillsInvoice1 = new Invoice("DRAFT", null, "GBP", 120.00, 100.00, 20.00, jillsAccountancyCompany);

        this.clientRepository.saveAll(List.of(bobsMarketingAgency,jillsAccountancyCompany));
        this.invoiceRepository.saveAll(List.of(bobsInvoice1, bobsInvoice2, jillsInvoice1));
    }

    @AfterEach
    void clearDatabase() {
        this.invoiceRepository.deleteAll();
        this.clientRepository.deleteAll();
    }

    @Test
    void testInvoiceCountReturnsTheCorrectNumberOfInvoices() throws IOException {
        GraphQLResponse response  = this.graphQLTestTemplate.postForResource("/graphql/invoices/query/invoiceCount.graphql");
        assertThat(response.isOk()).isTrue();
        JsonNode rootNode = response.readTree();
        assertThat(rootNode.path("data").path("invoiceCount").asInt()).isEqualTo(3);
    }

    @Test
    void testInvoicesReturnsAllInvoices() throws IOException {
        GraphQLResponse response  = this.graphQLTestTemplate.postForResource("/graphql/invoices/query/invoices.graphql");
        assertThat(response.isOk()).isTrue();
        JsonNode rootNode = response.readTree();
        assertThat(rootNode.path("data").path("invoices").size()).isEqualTo(3);
    }

}
