package com.snachalo.repository;

import com.snachalo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by weddy on 24.01.17.
 * Customer repository.
 * Database : MongoDB
 */
@RepositoryRestResource
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
