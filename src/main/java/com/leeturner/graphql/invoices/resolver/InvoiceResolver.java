package com.leeturner.graphql.invoices.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.leeturner.graphql.invoices.model.Client;
import com.leeturner.graphql.invoices.model.Invoice;
import com.leeturner.graphql.invoices.repository.ClientRepository;

public class InvoiceResolver implements GraphQLResolver<Invoice> {

    private ClientRepository clientRepository;

    public InvoiceResolver(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClient(Invoice invoice) {
        return this.clientRepository.findById(invoice.getClient().getId());
    }
}
