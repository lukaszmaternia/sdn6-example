package org.neo4j.tips.sdn.sdn6.movies;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class ParentToChild {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @TargetNode
    @JsonUnwrapped
    @JsonIgnoreProperties({ "id" })
    private final Person person;

    public ParentToChild(Person person) {
        this.person = person;
    }
}
