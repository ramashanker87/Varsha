package com.varsha.app.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Owner {
    private String name;
    private String address;
    private String age;
}
