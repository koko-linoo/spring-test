# Getting Started

## Installation

```bash
mvn clean install
```

## Running the application

```bash
mvn spring-boot:run
```

## Swagger 

```bash
http://localhost:8080/swagger-ui/index.html
```

## Testing

```bash
curl -X POST -H "Content-Type: application/json" -d '
{
  "users": [
    { "id": 1, "name": "John Doe", "email": "john@example.com" },
    { "id": 2, "name": "Bob Smith", "email": "bob_new@example.com" },
    { "name": "New User", "email": "new@example.com" }
  ]
}
' http://localhost:8080/app
```
