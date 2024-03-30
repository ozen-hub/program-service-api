package com.devstack.lms.programserviceapi.controller;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.dto.request.RequestRegistrationDto;
import com.devstack.lms.programserviceapi.service.ProgramService;
import com.devstack.lms.programserviceapi.service.RegistrationService;
import com.devstack.lms.programserviceapi.service.impl.JwtService;
import com.devstack.lms.programserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<StandardResponse> register(
            @RequestBody RequestRegistrationDto data

    ) {
        registrationService.register(
                data.getProgram(),
                data.getEmail(),data.getAmount(),data.getDate()
        );
        return new ResponseEntity<>(
                new StandardResponse(201, "Registration was Saved!",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/my-list")
    public ResponseEntity<StandardResponse> findMyPrograms(
            @RequestHeader("Authorization") String tokenHeader
    ) {
        String token = tokenHeader.replace("Bearer ", "");
        String email = jwtService.getEmail(token);
        return new ResponseEntity<>(
                new StandardResponse(200, "lis of my programs!",
                        registrationService.findAllMyPrograms(email)),
                HttpStatus.OK
        );
    }

    @GetMapping("/my-payments")
    public ResponseEntity<StandardResponse> findMyPayments(
            @RequestHeader("Authorization") String tokenHeader
    ) {
        String token = tokenHeader.replace("Bearer ", "");
        String email = jwtService.getEmail(token);
        return new ResponseEntity<>(
                new StandardResponse(200, "lis of my programs!",
                        registrationService.findAllMyPayments(email)),
                HttpStatus.OK
        );
    }

}
