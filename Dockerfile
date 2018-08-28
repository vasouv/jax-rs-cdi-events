FROM airhacks/glassfish
COPY ./target/jax-rs-cdi-events.war ${DEPLOYMENT_DIR}
