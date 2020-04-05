package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
