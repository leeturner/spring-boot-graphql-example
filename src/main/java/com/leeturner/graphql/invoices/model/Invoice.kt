package com.leeturner.graphql.invoices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String issuedDate;

    private String currency;

    private Double gross;

    private Double net;

    private Double vat;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, updatable = false)
    private Client client;

    public Invoice() { }

    public Invoice(Long id) {
        this.id = id;
    }

    public Invoice(String status, String issuedDate, String currency, Double gross, Double net, Double vat, Client client) {
        this.status = status;
        this.issuedDate = issuedDate;
        this.currency = currency;
        this.gross = gross;
        this.net = net;
        this.vat = vat;
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

        return new EqualsBuilder().append(getId(), invoice.getId()).append(getStatus(), invoice.getStatus()).append(getIssuedDate(), invoice.getIssuedDate()).append(getCurrency(), invoice.getCurrency()).append(gross, invoice.gross).append(net, invoice.net).append(vat, invoice.vat).append(getClient(), invoice.getClient()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getStatus()).append(getIssuedDate()).append(getCurrency()).append(gross).append(net).append(vat).append(getClient()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("status", status)
            .append("issuedDate", issuedDate)
            .append("currency", currency)
            .append("gross", gross)
            .append("net", net)
            .append("vat", vat)
            .append("client", client)
            .toString();
    }
}
