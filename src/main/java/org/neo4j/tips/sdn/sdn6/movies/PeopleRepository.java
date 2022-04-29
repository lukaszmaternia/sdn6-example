package org.neo4j.tips.sdn.sdn6.movies;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @author Michael J. Simons
 */
public interface PeopleRepository extends Neo4jRepository<Person, UUID> {

	@Query(
			"MATCH (person:Person {name: $name}) " +
					"OPTIONAL MATCH (person)-[:DIRECTED]->(d:Movie) "+
					"OPTIONAL MATCH (person)<-[r:ACTED_IN]->(a:Movie) "+
					"OPTIONAL MATCH (person)-->(movies)<-[relatedRole:ACTED_IN]-(relatedPerson)	"	+
					"RETURN DISTINCT person, "+
					"collect(DISTINCT d) AS directed, "+
					"collect(DISTINCT a) AS actedIn, "+
					"collect(DISTINCT relatedPerson) AS related"
	)
	Optional<PersonDetails> getDetailsByName(String name);

	@Query(
			"MATCH (person:Person {name: $name}) " +
					"OPTIONAL MATCH (person)<-[parentRel:PARENT_TO_CHILD]-(parent:Person) " +
					"RETURN person.id as id, " +
					"person, "+
					"collect(DISTINCT parent) AS parents, "+
					"collect(DISTINCT parentRel) AS parentRels"
	)
	Optional<PersonWrapper> getPersonWithParents(String name);
}
