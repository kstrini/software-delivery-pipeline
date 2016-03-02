package io.pivotal.micropcf.repositories;

import io.pivotal.micropcf.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface MongoTrackRepository extends MongoRepository<Track, BigInteger> {}