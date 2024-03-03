package com.devstack.lms.programserviceapi.service.impl;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.entity.Subject;
import com.devstack.lms.programserviceapi.repo.ProgramRepository;
import com.devstack.lms.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final WebClient webClient;

    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder()
                .name(programDto.getName())
                .price(programDto.getPrice())
                .startDate(programDto.getStartDate())
                .subjects(programDto.getSubjects())
                .build();

        List<Long> ids = program.getSubjects().stream()
                        .map(Subject::getId).toList();

        System.out.println(ids);

        Boolean isOk = webClient.get().uri("http://localhost:8082/api/v1/subjects",
                uriBuilder -> uriBuilder.pathSegment(String.valueOf(ids)).build())
                        .retrieve()
                                .bodyToMono(Boolean.class)
                                        .block();

        if(Boolean.TRUE.equals(isOk)){
            programRepository.save(program);
        }else{
            throw new IllegalArgumentException("Try again with available Languages");
        }

    }
}
