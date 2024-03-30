package com.devstack.lms.programserviceapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponsePaymentDto {
    private String transactionId;
    private Date date;
    private BigDecimal amount;
    private String programName;
}
