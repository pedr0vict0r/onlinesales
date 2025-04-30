# Bootcamp: Arquiteto de Software

### Aluno: Pedro Victor Costa Nascimento

## Código de Entrega do Desafio Final

---

### Aqui estão os exemplos de comandos curl para testar as funcionalidades CRUD para Customer, Product e Order.

## 1. Customer

### Criar um novo Customer
```bash
curl -X POST http://localhost:8080/customers \
-H "Content-Type: application/json" \
-d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "address": "123 Main St"
}'
```

### Buscar todos os Customers
```bash
curl -X GET http://localhost:8080/customers
```

### Buscar um Customer por ID
```bash
curl -X GET http://localhost:8080/customers/1
```

### Atualizar um Customer
```bash
curl -X PUT http://localhost:8080/customers/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "John Doe Updated",
    "email": "john.doe.updated@example.com",
    "address": "456 Another St"
}'
```

### Deletar um Customer
```bash
curl -X DELETE http://localhost:8080/customers/1
```

## 2. Product

### Criar um novo Product
```bash
curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{
    "name": "Laptop",
    "description": "High performance laptop",
    "price": 1500.00
}'
```

### Buscar todos os Products
```bash
curl -X GET http://localhost:8080/products
```

### Buscar um Product por ID
```bash
curl -X GET http://localhost:8080/products/1
```

### Atualizar um Product
```bash
curl -X PUT http://localhost:8080/products/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "Laptop Updated",
    "description": "Updated high performance laptop",
    "price": 1600.00
}'
```

### Deletar um Product
```bash
curl -X DELETE http://localhost:8080/products/1
```

## 3. Order

### Criar um novo Order
```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
    "customerId": 1,
    "productId": 1,
    "quantity": 2
}'
```

### Buscar todos os Orders
```bash
curl -X GET http://localhost:8080/orders
```

### Buscar um Order por ID
```bash
curl -X GET http://localhost:8080/orders/1
```

### Atualizar um Order
```bash
curl -X PUT http://localhost:8080/orders/1 \
-H "Content-Type: application/json" \
-d '{
    "customerId": 1,
    "productId": 1,
    "quantity": 3
}'
```

### Deletar um Order
```bash
curl -X DELETE http://localhost:8080/orders/1
```
