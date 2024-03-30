package com.devstack.lms.programserviceapi.repo;

import com.devstack.lms.programserviceapi.entity.Program;
import com.devstack.lms.programserviceapi.entity.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegistrationRepository extends MongoRepository<Registration,String> {
    List<Registration> findByEmail(String email);
}
