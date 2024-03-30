package com.devstack.lms.programserviceapi.service;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.dto.response.ResponseProgramDto;

import java.util.List;

public interface ProgramService {
    public void createProgram(RequestProgramDto programDto);

    List<ResponseProgramDto> findAllPrograms();

    List<ResponseProgramDto> findAllMyPrograms(String email);
}
