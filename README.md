# product-catalog-service
* This service exposes products availabe along with their details.
* This service is used by cart-service to get products and their prices
* This service cannot be accessed by outside world.
* Only the microserices having microservice scope can consume this service
* GRANT_TYPE - client_credentials is using for securing this service

## Endpoints
1. http://localhost:8090/catalog-service/prodcuts GET
2. http://localhost:8090/catalog-service/product/{productId} GET
3. http://localhost:8090/catalog-service/prodcuts POST
