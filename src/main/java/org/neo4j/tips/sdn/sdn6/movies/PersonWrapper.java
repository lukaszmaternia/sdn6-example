package org.neo4j.tips.sdn.sdn6.movies;

import lombok.Value;

import java.util.List;

@Value
public class PersonWrapper {

    String name;
    List<Person> parents;
}
