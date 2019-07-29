# A Spring Boot/GraphQL Example App

This is a little Spring Boot REST application exposing a GraphQL interface designed to show the minimum needed to get up and running with GraphQL.  It is basically the result of a few hours over a weekend to lean about what GraphQL is and what it brings to the table for REST based Spring Boot apps.  At the moment this project only supports GraphQL `Query`s (retrieving data from our service).  `Mutation`s (updating data managed via our service) will be coming soon.

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

## Usage

Pull down the repo and build in the usual way.  This is a Java 12 project so make sure you are using the correct version of the jdk either on the command line or within your IDE.

Once the service is up and running you can query the data using the queries defined in the `.graphqls` files.  Below are some example queries based on the queries we have defined:

Query:

    {countInvoices}

Result:

    {
     "data": {
       "countInvoices": 3
     }
    } 

Query:

    {countClients}

Result:

    {
      "data": {
        "countClients": 2
      }
    } 

Query:

    {findAllClients{id name paymentTerms}}

Result:

    {
       "data": {
         "findAllClients": [
           {
             "id": "1",
             "name": "Bobs Marketing Agency",
             "paymentTerms": 28
           },
           {
             "id": "2",
             "name": "Jills Accountancy Company",
             "paymentTerms": 28
           }
         ]
       }
    } 

You will notice that the above query does not contain all the parameters managed by the `Client` entity.  We can return more or less data in the response by added more fields to the query:

Query:

    {findAllClients{id name paymentTerms addressLine1 addressLine2 city postCode}}

Result:

    {
      "data": {
        "findAllClients": [
          {
            "id": "1",
            "name": "Bobs Marketing Agency",
            "paymentTerms": 28,
            "addressLine1": "23 Brighton Street",
            "addressLine2": "Rottingdean",
            "city": "Brighton",
            "postCode": "BN2 7DP"
          },
          {
            "id": "2",
            "name": "Jills Accountancy Company",
            "paymentTerms": 28,
            "addressLine1": "24 Eastbourne Rd",
            "addressLine2": null,
            "city": "Eastboaurne",
            "postCode": "BN23 5GP"
          }
        ]
      }
    } 
