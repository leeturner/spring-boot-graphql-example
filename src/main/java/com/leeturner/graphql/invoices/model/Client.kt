package com.leeturner.graphql.invoices.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String? = null,
    var paymentTerms: Int = 0,
    var addressLine1: String? = null,
    var addressLine2: String? = null,
    var city: String? = null,
    var postCode: String? = null,
)