package org.neo4j.tips.sdn.sdn6.movies;


import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@RelationshipProperties
public class ParentToChild extends Relationship<Person> {


    public ParentToChild(Person person) {
        super(person);
    }
}
