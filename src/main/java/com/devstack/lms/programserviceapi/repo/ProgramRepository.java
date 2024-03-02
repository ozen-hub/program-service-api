package com.devstack.lms.programserviceapi.repo;

import com.devstack.lms.programserviceapi.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program,String> {
}
