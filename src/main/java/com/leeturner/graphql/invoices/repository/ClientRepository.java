package com.leeturner.graphql.invoices.repository;

import com.leeturner.graphql.invoices.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
