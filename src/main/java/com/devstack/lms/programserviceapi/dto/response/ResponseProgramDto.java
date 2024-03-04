package com.devstack.lms.programserviceapi.dto.response;

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
public class ResponseProgramDto {
    private String id;
    private String name;
    private BigDecimal price;
    private Date startDate;
    private List<Subject> subjects;
}
