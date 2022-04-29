package org.neo4j.tips.sdn.sdn6.movies;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends Neo4jRepository<Movie, UUID> {


    @Query(
            "MATCH (movie:Movie)<-[actedInRel:ACTED_IN]-(person:Person {name: $name}) " +
                    "OPTIONAL MATCH (person)<-[parentRel:PARENT_TO_CHILD]-(parent:Person) " +
                    "RETURN DISTINCT movie as movie"
                    + ", collect(DISTINCT person) as persons "
                    + ", collect(DISTINCT actedInRel) as actedInRels "
                    + ", collect(DISTINCT parent) AS parents "
                    + ", collect(DISTINCT parentRel) AS parentRels"
    )
    Optional<Movie> getMovieWithPersonWithParents(String name);
}
