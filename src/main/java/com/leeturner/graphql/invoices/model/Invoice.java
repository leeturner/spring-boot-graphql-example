package com.leeturner.graphql.invoices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String issuedDate;

    private String currency;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, updatable = false)
    private Client client;

    public Invoice() {

    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Invoice(String status, String issuedDate, String currency, Client client) {
        this.status = status;
        this.issuedDate = issuedDate;
        this.currency = currency;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equal(getId(), invoice.getId()) &&
            Objects.equal(getStatus(), invoice.getStatus()) &&
            Objects.equal(getIssuedDate(), invoice.getIssuedDate()) &&
            Objects.equal(getCurrency(), invoice.getCurrency()) &&
            Objects.equal(getClient(), invoice.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getStatus(), getIssuedDate(), getCurrency(), getClient());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("status", status)
            .add("issuedDate", issuedDate)
            .add("currency", currency)
            .add("client", client)
            .toString();
    }
}
