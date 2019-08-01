package com.leeturner.graphql.invoices.resolver;

import java.util.Optional;

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

    public Optional<Invoice> invoice(Long id) {
        return this.invoiceRepository.findById(id);
    }

    public Iterable<Invoice> invoices() {
        return this.invoiceRepository.findAll();
    }

    public Iterable<Invoice> invoicesByStatus(String status) {
        return this.invoiceRepository.findByStatus(status);
    }

    public long invoiceCount() {
        return this.invoiceRepository.count();
    }

    public Optional<Client> client(Long id) {
        return this.clientRepository.findById(id);
    }

    public Iterable<Client> clients() {
        return this.clientRepository.findAll();
    }

    public long clientCount() {
        return this.clientRepository.count();
    }
}
