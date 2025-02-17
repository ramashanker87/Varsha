package com.varsha.app.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vehicle {

    private String vehicleNumber;
    private String vehicleType;
    private String fuelType;
}

