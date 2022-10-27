package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//extends PagingAndSortingRepository<Person, Long>
public interface PersonRepository {
	List<Person> findByLastName(@Param("name") String name);
}
