package com.airline.airlineticketing.service.impl;

import com.airline.airlineticketing.dto.TicketDto;
import com.airline.airlineticketing.model.Passenger;
import com.airline.airlineticketing.model.Ticket;
import com.airline.airlineticketing.repository.PassengerRepository;
import com.airline.airlineticketing.repository.TicketRepository;
import com.airline.airlineticketing.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    @Transactional
    public TicketDto createTicket(TicketDto ticketDTO) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(ticketDTO.getId());

        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            Ticket ticket = new Ticket(passenger);
            ticket.setPrice(ticketDTO.getPrice());
            ticketRepository.save(ticket);

            return new TicketDto(ticket);
        }

        return null;
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDto> ticketDTOs = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOs.add(new TicketDto(ticket));
        }
        return ticketDTOs;
    }

    @Override
    public TicketDto getTicketById(Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.map(TicketDto::new).orElse(null);
    }


}
