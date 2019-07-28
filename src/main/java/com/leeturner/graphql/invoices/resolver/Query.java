package com.leeturner.graphql.invoices.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.leeturner.graphql.invoices.model.Client;
import com.leeturner.graphql.invoices.model.Invoice;
import com.leeturner.graphql.invoices.repository.ClientRepository;
import com.leeturner.graphql.invoices.repository.InvoiceRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private InvoiceRepository invoiceRepository;
    private ClientRepository clientRepository;

    public Query(InvoiceRepository invoiceRepository, ClientRepository clientRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientRepository = clientRepository;
    }

    public Iterable<Invoice> findAllInvoices() {
        return this.invoiceRepository.findAll();
    }

    public Iterable<Invoice> findInvoicesByStatus(String status) {
        return this.invoiceRepository.findByStatus(status);
    }

    public long countInvoices() {
        return this.invoiceRepository.count();
    }

    public Iterable<Client> findAllClients() {
        return this.clientRepository.findAll();
    }

    public long countClients() {
        return this.clientRepository.count();
    }
}
