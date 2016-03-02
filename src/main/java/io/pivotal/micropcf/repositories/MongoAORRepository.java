package io.pivotal.micropcf.repositories;

import io.pivotal.micropcf.domain.AOR;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;


public interface MongoAORRepository extends MongoRepository<AOR, BigInteger> {}
