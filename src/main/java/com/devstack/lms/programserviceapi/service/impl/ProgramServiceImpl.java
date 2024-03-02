package com.devstack.lms.programserviceapi.service.impl;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.repo.ProgramRepository;
import com.devstack.lms.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder()
                .name(programDto.getName())
                .price(programDto.getPrice())
                .startDate(programDto.getStartDate())
                .subjects(programDto.getSubjects())
                .build();

        programRepository.save(program);
    }
}
