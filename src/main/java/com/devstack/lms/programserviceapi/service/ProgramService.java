package com.devstack.lms.programserviceapi.service;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;

public interface ProgramService {
    public void createProgram(RequestProgramDto programDto);
}
