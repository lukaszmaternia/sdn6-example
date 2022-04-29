package org.neo4j.tips.sdn.sdn6;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static java.util.Optional.ofNullable;


@Slf4j
class ApplicationAbstractTest {

    private static Neo4j embeddedDatabaseServer;

    @BeforeAll
    static void init() {
        embeddedDatabaseServer = ofNullable(embeddedDatabaseServer).orElseGet(() -> {
            registerShutdownHook();
            return Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()//disable http server
                .build();

        });
        log.info("Started neo4j embedded server uri: {}", embeddedDatabaseServer.boltURI());

    }

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", embeddedDatabaseServer::boltURI);

    }

    private static void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                embeddedDatabaseServer.close();
                log.debug("Embedded neo4j is shutdown");
            }
        });
    }

}
