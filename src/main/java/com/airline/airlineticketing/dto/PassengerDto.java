package com.airline.airlineticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PassengerDto  {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

    public PassengerDto(Long id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    public PassengerDto() {
    }
}
