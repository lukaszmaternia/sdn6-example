package org.neo4j.tips.sdn.sdn6.movies;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	private final PeopleRepository peopleRepository;
	private final MovieRepository movieRepository;


	public PeopleController(PeopleRepository peopleRepository, MovieRepository movieRepository) {
		this.peopleRepository = peopleRepository;
		this.movieRepository = movieRepository;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	Person createNewPerson(@RequestBody Person person) {

		return peopleRepository.save(person);
	}

	@GetMapping({ "/init" })
	public void get() {
		Person person1 = peopleRepository.save(new Person("Michal", 1982));
		Person person2 = peopleRepository.save(new Person("Michalrtrt", 1952));
		Person person3 = peopleRepository.save(new Person("rtrtMichal", 1972));
		Movie movie = new Movie("Obcy" ,"sdfdfi oirwrtg", newArrayList(), newArrayList(person3));
		movieRepository.save(movie);
		Actor actor = new Actor(person1, movie, newArrayList("rambo"));
		movie = new Movie("Obcy" ,"sdfdfi oirwrtg", newArrayList(actor), newArrayList(person3));
		movieRepository.save(movie);
	}
}
