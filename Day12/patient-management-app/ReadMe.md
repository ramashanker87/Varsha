# Application for Patient Information

## Build application with maven

```Bash
mvn clean install
```

## Run Application with maven

```Bash
mvn spring-boot:run
```

## Verify End Point Controller



### Create Patient

```Bash
curl --location 'http://localhost:8080/patient/save' \
--header 'Content-Type: application/json' \
--data {
    "name":"patient1",
    "id": "p1",
    "hospitalName": "hospital1",
    "age":55,
    "gender": "M"
}
```

### Read All Patient Data

```Bash
curl --location 'http://localhost:8080/patient/age/all'
```

### Update Patient Data

```Bash
curl --location --request PUT 'http://localhost:8080/patient/update?id=p1&hospitalName=Medica'
```

### Delete Patient Data

```Bash
curl --location --request DELETE 'http://localhost:8080/patient/delete?id=p1'
```
