package com.devstack.lms.programserviceapi.dto.request;

import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestRegistrationDto {
    private String email;
    private BigDecimal amount;
    private Date date;
    private Program program;
}
