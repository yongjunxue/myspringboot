package com.test.repositoty.elastic;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.pojo.elastic.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
