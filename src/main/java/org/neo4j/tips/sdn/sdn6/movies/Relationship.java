package org.neo4j.tips.sdn.sdn6.movies;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Getter
public class Relationship<T> {

    @RelationshipId
    protected Long id;

    /*
        With generic T its 50% of ConverterNotFoundException in PeopleRepositoryIntegrationTest
        Change to Person and 100% of runs test will be green
     */
    @TargetNode
    protected T person;


    public Relationship(T person) {
        this.person = person;
    }
}
