package com.airline.airlineticketing.service.impl;

import com.airline.airlineticketing.dto.PassengerDto;
import com.airline.airlineticketing.model.Passenger;
import com.airline.airlineticketing.repository.PassengerRepository;
import com.airline.airlineticketing.service.PassengerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDTO) {
        Passenger passenger = new Passenger(passengerDTO.getFirstName(), passengerDTO.getEmail());
        Passenger savedPassenger = passengerRepository.save(passenger);
        return new PassengerDto(savedPassenger.getId(),
                savedPassenger.getFirstName(), savedPassenger.getEmail());
    }

    @Override
    public PassengerDto getPassengerById(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            return new PassengerDto(passenger.getId(), passenger.getFirstName(), passenger.getEmail());
        } else {
            return null;
        }
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<PassengerDto> passengerDTOs = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerDTOs.add(new PassengerDto(passenger.getId(),
                    passenger.getFirstName(), passenger.getEmail()));
        }
        return passengerDTOs;
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
