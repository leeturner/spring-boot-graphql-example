package com.leeturner.graphql.invoices.config;

import com.leeturner.graphql.invoices.repository.ClientRepository;
import com.leeturner.graphql.invoices.resolver.InvoiceResolver;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public InvoiceResolver clientResolver(ClientRepository clientRepository) {
        return new InvoiceResolver(clientRepository);
    }
}
