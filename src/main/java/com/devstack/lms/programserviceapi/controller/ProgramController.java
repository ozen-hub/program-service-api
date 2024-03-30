package com.devstack.lms.programserviceapi.controller;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.service.ProgramService;
import com.devstack.lms.programserviceapi.service.impl.JwtService;
import com.devstack.lms.programserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {

    @Autowired
    private  ProgramService programService;
    @Autowired
    private  JwtService jwtService;

    @PostMapping
    public ResponseEntity<StandardResponse> createProgram(
            @RequestBody RequestProgramDto requestProgramDto
    ) {
        programService.createProgram(requestProgramDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Program was Saved!",
                        requestProgramDto.getName()),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<StandardResponse> findAllPrograms() {
        return new ResponseEntity<>(
                new StandardResponse(200, "lis of programs!",
                        programService.findAllPrograms()),
                HttpStatus.OK
        );
    }

}
