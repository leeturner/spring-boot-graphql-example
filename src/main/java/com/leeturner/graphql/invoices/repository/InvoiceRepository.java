package com.leeturner.graphql.invoices.repository;

import com.leeturner.graphql.invoices.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
