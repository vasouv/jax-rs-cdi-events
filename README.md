# Build
mvn clean package && docker build -t vs/jax-rs-cdi-events .

# RUN

docker rm -f jax-rs-cdi-events || true && docker run -d -p 8080:8080 -p 4848:4848 --name jax-rs-cdi-events vs/jax-rs-cdi-events 