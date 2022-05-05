package org.neo4j.tips.sdn.sdn6;

import org.junit.jupiter.api.Test;
import org.neo4j.tips.sdn.sdn6.movies.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = {
        "org.neo4j.migrations.locations-to-scan=classpath:neo4j/migrations,classpath:example-data"})
public class PeopleRepositoryIntegrationTest extends ApplicationAbstractTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void shouldFindPeople() {

        final var result = peopleRepository.getPersonWithParents("Angela Scope");

        // then
        assertThat(result).isPresent();
//        final Person resultPerson = result.get();
//        assertThat(resultPerson.getParentRels()).hasSize(1);
//        assertThat(resultPerson.getParents()).hasSize(1);
//        assertThat(resultPerson.getParents().get(0).getName()).isEqualTo("Paul Blythe");
    }
}
