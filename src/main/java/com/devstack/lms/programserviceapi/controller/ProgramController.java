package com.devstack.lms.programserviceapi.controller;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.service.ProgramService;
import com.devstack.lms.programserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController {

    /*
    *
    * {
    "name":"Fullstak Development Program",
    "price":50000,
    "startDate":"2024-03-20",
    "subjects":[
        {"id":1,"name":"Java"},
        {"id":2,"name":"Html"},
        {"id":3,"name":"Css"},
        {"id":4,"name":"Java Script"},
        {"id":1,"name":"C#"}
    ]
}
    *
    *
    *
    * */

    private final ProgramService programService;

    @PostMapping
    private ResponseEntity<StandardResponse> createProgram(
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
    private ResponseEntity<StandardResponse> findAllPrograms() {
        ;
        return new ResponseEntity<>(
                new StandardResponse(200, "Program was Saved!",
                        programService.findAllPrograms()),
                HttpStatus.OK
        );
    }
}
