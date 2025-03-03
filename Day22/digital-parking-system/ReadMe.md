## To run the application
mvn clean install

### First run the docker compose to start rabbitMQ and mysql
docker-compose up

### now run the car-parking-registration application and car-parking-registration
mvn spring-boot:run

POST http://localhost:8082/parking/start

#### parameter - parkingNumber 1-A
#### Body
{
"ownerName": "car1",
"registrationNumber":"park1",
"modelNumber":"start",
"fuelType":"diesel"
}

DELETE  http://localhost:8082/parking/end
parameter - parkingNumber : 1-A

### To check data in mysql
docker exec -it mysql mysql -u user -p

password

use parking;

select * from car;
select * from parking_start;
select * from parking_end;


