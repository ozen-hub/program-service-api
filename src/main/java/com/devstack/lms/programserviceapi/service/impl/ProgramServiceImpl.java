package com.devstack.lms.programserviceapi.service.impl;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.dto.response.ResponseProgramDto;
import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.entity.Subject;
import com.devstack.lms.programserviceapi.repo.ProgramRepository;
import com.devstack.lms.programserviceapi.service.ProgramService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final ProgramAspectsServiceImpl programAspectsService;


    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder()
                .name(programDto.getName())
                .price(programDto.getPrice())
                .startDate(programDto.getStartDate())
                .subjects(programDto.getSubjects())
                .build();

        ArrayList<Long> list = new ArrayList<>();
        for (Subject sub:program.getSubjects()
             ) {
            list.add(sub.getId());
        }

        String ids =  list.stream().map(Object::toString).collect(Collectors.joining(", "));

        Boolean isOk = programAspectsService.checkSubjects(ids);

        if(Boolean.TRUE.equals(isOk)){
            programRepository.save(program);
        }else{
            throw new IllegalArgumentException("Try again with available Languages");
        }

    }


    @Override
    public List<ResponseProgramDto> findAllPrograms() {
        List<Program> all = programRepository.findAll();
        List<ResponseProgramDto> list = new ArrayList<>();
        for (Program p:all
             ) {
            list.add(new ResponseProgramDto(
                    p.getId(),p.getName(),p.getPrice(),p.getStartDate(),p.getSubjects()
            ));
        }
        return list;
    }

    @Override
    public List<ResponseProgramDto> findAllMyPrograms(String email) {
        List<Program> all = programRepository.findAll();
        List<ResponseProgramDto> list = new ArrayList<>();
        for (Program p:all
        ) {
            list.add(new ResponseProgramDto(
                    p.getId(),p.getName(),p.getPrice(),p.getStartDate(),p.getSubjects()
            ));
        }
        return list;
    }
}
