package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.entity.Person;
import com.app.repo.PersonRepository;

import io.swagger.annotations.Api;

@Api(value = "PersonRestController", description = "REST Apis related to Person Entity!!!!")
@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("persons/{id}")
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") Integer id) {
		Optional<Person> person = personRepository.findById(id);
		return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
	}

	@GetMapping("persons")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> list = personRepository.findAll();
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}

	@PostMapping("persons")
	public ResponseEntity<Void> addPerson(@RequestBody Person person, UriComponentsBuilder builder) {
		boolean flag = personRepository.save(person) != null;
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/persons/{id}").buildAndExpand(person.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("persons")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		personRepository.save(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@DeleteMapping("persons/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id) {
		personRepository.deleteById(id);
		return new ResponseEntity<String>("Person Delete by" + id + "perosn id", HttpStatus.NO_CONTENT);
	}

}
