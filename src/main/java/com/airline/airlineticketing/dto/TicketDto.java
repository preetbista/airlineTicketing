package com.airline.airlineticketing.dto;

import com.airline.airlineticketing.model.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TicketDto implements Serializable {
    private Long id;

    private String flightNumber;

    private String departureAirport;

    private String arrivalAirport;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private double price;

    public TicketDto(Ticket ticket) {
    }

    public TicketDto() {
    }
}
