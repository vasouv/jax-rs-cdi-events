# JAX-RS-CDI-Events

The project is a playgroung to learn about JAX-RS and CDi events.

## Deploy
Build and deploy the .war on Payara 5 since I'm using the embedded H2 database.

## Endpoints
`localhost:8080/jax-rs-cdi-events/resources/messages`

GET: finds all messages from the db

POST: creates new message : { "title" = "whatever" }

`localhost:8080/jax-rs-cdi-events/resources/messages`

GET: finds all messages that have been created with the POST method
