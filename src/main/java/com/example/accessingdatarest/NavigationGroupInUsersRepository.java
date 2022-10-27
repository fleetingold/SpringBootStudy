package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface NavigationGroupInUsersRepository extends PagingAndSortingRepository<NavigationGroupInUsers, String> {
    
    List<Person> findBynavigationGroupId(@Param("navigationgroupid") String navigationgroupid);
    
}
