# Application for Employee Information

## Build application with maven

```Bash
mvn clean install
```

## Run Application with maven

```Bash
mvn spring-boot:run
```

## Verify End Point Controller

### Verify application Health

```Bash
curl --location 'http://localhost:8080/actuator/health'
```

### Create patient

```Bash
curl --location 'http://localhost:8080/employee/create/employee' \
--header 'Content-Type: application/json' \
--data '{
     "id":"1",
     "name": "emp1",
     "age":25
}'
```

### Read All patient Data

```Bash
curl --location 'http://localhost:8080/patient/get/all/patient'
```

### Update patient Data

```Bash
curl --location --request PUT 'http://localhost:8080/patient/update/patient?id=1&age=22'
```

### Delete patient Data

```Bash
curl --location --request DELETE 'http://localhost:8080/patient/delete/patient?id=2'
```