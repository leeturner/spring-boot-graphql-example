package com.leeturner.graphql.invoices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int paymentTerms;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String postCode;

    public Client() {

    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(String name, int paymentTerms, String addressLine1, String addressLine2, String city, String postCode) {
        this.name = name;
        this.paymentTerms = paymentTerms;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postCode = postCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(int paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return new EqualsBuilder().append(getPaymentTerms(), client.getPaymentTerms()).append(getId(), client.getId()).append(getName(), client.getName()).append(getAddressLine1(), client.getAddressLine1()).append(getAddressLine2(), client.getAddressLine2()).append(getCity(), client.getCity()).append(getPostCode(), client.getPostCode()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getName()).append(getPaymentTerms()).append(getAddressLine1()).append(getAddressLine2()).append(getCity()).append(getPostCode()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("paymentTerms", paymentTerms)
            .append("addressLine1", addressLine1)
            .append("addressLine2", addressLine2)
            .append("city", city)
            .append("postCode", postCode)
            .toString();
    }
}
