package com.varsha.app.service;

import com.varsha.app.model.Car;
import com.varsha.app.model.ParkingEnd;
import com.varsha.app.model.ParkingStart;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class ParkingService {
    private static final Logger logger = LoggerFactory.getLogger(ParkingService.class);
    private final AmqpTemplate amqpTemplate;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.parkingStart.routingkey.name}")
    String parkingStartRoutingKeyName;
    @Value("${rabbitmq.parkingStart.queue.name}")
    String parkingStartqueuename;
    @Value("parkingEnd.routingkey")
    String parkingEndRoutingKeyName;
    @Value("parking-end-request.out")
    String parkingEndRequestOut;
    private ParkingStart parkingStart;
    //private ParkingEnd parkingEnd;
    public ParkingService(AmqpTemplate amqpTemplate, ParkingStart parkingStart) {
        this.amqpTemplate = amqpTemplate;
        this.parkingStart = parkingStart;

    }
    public ParkingStart startParking(
            Car car, String parkingNo) {
        parkingStart.setParkingNo(parkingNo);
        parkingStart.setStartTime(new Date());
        parkingStart.setStatus("start");
        parkingStart.setRegNo(car.getRegNo());

        logger.info("ParkingStart: {}", parkingStart.toString());
        amqpTemplate.convertAndSend(exchangeName, parkingStartRoutingKeyName,parkingStart);
        return parkingStart;
    }

    public ParkingEnd endParking(String regNo) {

        ParkingEnd parkingEnd = new ParkingEnd();
        parkingEnd.setParkingNo(parkingStart.getParkingNo());
        parkingEnd.setStartTime(parkingStart.getStartTime());
        parkingEnd.setStatus("End");
        parkingEnd.setRegNo(regNo);
        parkingEnd.setEndTime(new Date());
        long timedifference =( parkingEnd.getEndTime().getTime() - parkingEnd.getStartTime().getTime());
        long mints =timedifference/(1000*60);
        parkingEnd.setPrice((int)(mints*2));
        logger.info(parkingEnd.toString());
        amqpTemplate.convertAndSend(exchangeName, parkingEndRoutingKeyName,parkingEnd);
        return parkingEnd;
    }

}
