package com.airline.airlineticketing.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;

    private Long mobileNumber;

    private String username;

    private String password;

    private String role;

    public UserDto(Long id, Long mobileNumber, String username, String password, String role) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDto(Long id, String userName, String password, Long mobileNumber, String role) {
    }

    public UserDto() {
    }
}
