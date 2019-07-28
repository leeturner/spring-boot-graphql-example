# A Spring Boot/GraphQL Example App

This is a little Spring Boot REST application exposing a GraphQL interface designed to show the minimum needed to get up and running with GraphQL.  It is basically the result of a few hours over a weekend to lean about what GraphQL is and what it brings to the table for REST based Spring Boot apps.

## H2 Database

This app used the H2 in-memory database and JPA to expose 2 simple entities - an `Invoice` and a `Client`.  In this example, a `Client` can have multiple `Invoice`'s issued to them.  This is mapped by the JPA `@ManyToOne` annotation.

The H2 console has been enabled to enabled vi adding these properties in the `application.properties` file:

    spring.h2.console.enabled = true
    spring.h2.console.path = /h2-console

The console can be accessed via this url - [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp)

## GraphQL

GraphQL is enabled via adding the starter dependency from `com.graphql-java-kickstart`:

    <dependency>
      <groupId>com.graphql-java-kickstart</groupId>
      <artifactId>graphql-spring-boot-starter</artifactId>
      <version>5.10.0</version>
    </dependency>
    
This enables the GraphQL servlet on the default location - `/graphql`.  In this example we use the GraphQL schema language to build the `graphql-java` schema.  These files are stored in the `/resources/graphql/`:

client.graphqls:

    type Client {
        id: ID!
        name: String!
        paymentTerms: Int!
        addressLine1: String!
        addressLine2: String
        city: String!
        postCode: String!
    }

    type Query {
        findAllClients: [Client]!
        countClients: Int
    }

invoice.graphqls:

    type Invoice {
        id: ID!
        client: Client!
        status: String!
        issuedDate: String
        currency: String!
        gross: Float!
        net: Float!
        vat: Float!
    }

    extend type Query {
        findAllInvoices: [Invoice]!
        findInvoicesByStatus(status: String): [Invoice]!
        countInvoices: Int
    }
