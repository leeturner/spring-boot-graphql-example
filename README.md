# A Spring Boot/GraphQL Example App
This is a little Spring Boot REST application exposing a GraphQL interface designed to show the minimum needed to get up and running with GraphQL.  It is basically the result of a few hours over a weekend to lean about what GraphQL is and what it brings to the table for REST based Spring Boot apps.

This app used the H2 in-memory database and JPA to expose 2 simple entities - an `Invoice` and a `Client`.  In this example, a `Client` can have multiple `Invoice`'s issued to them.  This is mapped by the JPA `@ManyToOne` annotation.
