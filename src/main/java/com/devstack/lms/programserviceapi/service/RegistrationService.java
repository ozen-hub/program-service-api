package com.devstack.lms.programserviceapi.service;

import com.devstack.lms.programserviceapi.dto.request.RequestProgramDto;
import com.devstack.lms.programserviceapi.dto.response.ResponsePaymentDto;
import com.devstack.lms.programserviceapi.dto.response.ResponseProgramDto;
import com.devstack.lms.programserviceapi.entity.Program;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RegistrationService {
    public void register(Program program, String email, BigDecimal amount, Date date);

    List<ResponseProgramDto> findAllMyPrograms(String email);

    List<ResponsePaymentDto> findAllMyPayments(String email);
}
