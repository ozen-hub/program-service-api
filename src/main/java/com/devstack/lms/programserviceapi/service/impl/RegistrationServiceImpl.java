package com.devstack.lms.programserviceapi.service.impl;

import com.devstack.lms.programserviceapi.dto.response.ResponsePaymentDto;
import com.devstack.lms.programserviceapi.dto.response.ResponseProgramDto;
import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.entity.Registration;
import com.devstack.lms.programserviceapi.entity.Subject;
import com.devstack.lms.programserviceapi.repo.RegistrationRepository;
import com.devstack.lms.programserviceapi.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public void register(Program program, String email, BigDecimal amount, Date date) {
        Registration registration = Registration.builder()
                .program(program)
                .email(email)
                .amount(amount)
                .date(date)
                .build();

        registrationRepository.save(registration);
    }

    @Override
    public List<ResponseProgramDto> findAllMyPrograms(String email) {
        List<Registration> registrations = registrationRepository.findByEmail(email);
        return registrations.stream()
                .map(this::mapToResponseProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponsePaymentDto> findAllMyPayments(String email) {
        List<Registration> registrations = registrationRepository.findByEmail(email);
        return registrations.stream()
                .map(this::mapToResponsePaymentDto)
                .collect(Collectors.toList());
    }
    private ResponsePaymentDto mapToResponsePaymentDto(Registration registration) {
        return ResponsePaymentDto.builder()
                .transactionId(registration.getId())
                .date(registration.getDate())
                .amount(registration.getAmount())
                .programName(registration.getProgram().getName())
                .build();
    }
    private ResponseProgramDto mapToResponseProgramDto(Registration registration) {
        return ResponseProgramDto.builder()
                .id(registration.getProgram().getId())
                .name(registration.getProgram().getName())
                .price(registration.getProgram().getPrice())
                .startDate(registration.getProgram().getStartDate())
                .subjects(registration.getProgram().getSubjects())
                .build();
    }
}
