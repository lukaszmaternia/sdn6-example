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
                    "OPTIONAL MATCH (person)<-[parentRel:PARENT_TO_CHILD]-(parent:Person) " +
                    "OPTIONAL MATCH (person)-[childRel:PARENT_TO_CHILD]->(child:Person) " +
                    "RETURN person.id as id, " +
                    "person, " +
                    "collect(DISTINCT parent) AS parents, " +
                    "collect(DISTINCT parentRel) AS parentRels, " +
                    "collect(DISTINCT child) AS children, " +
                    "collect(DISTINCT childRel) AS childRels"
    )
    Optional<PersonWrapper> getPersonWithParents(String name);
}
