package org.neo4j.tips.sdn.sdn6.movies;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;


@ToString(of = {"id"})
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Slf4j
@Node
@NoArgsConstructor
public class Entity<D extends EntityData> implements EntityDataInterfaceSecond {

    @Id
    @GeneratedValue
    protected UUID id;

}
