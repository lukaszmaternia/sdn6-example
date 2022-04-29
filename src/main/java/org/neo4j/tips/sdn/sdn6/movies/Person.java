package org.neo4j.tips.sdn.sdn6.movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.neo4j.core.schema.Relationship;


@Getter
@Setter
@ToString(of = {}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Node
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(callSuper = true, of = {})
public final class Person extends Entity<PersonData> {


	private String name;

	private Integer born;
//
//	@Relationship(value = "PARENT_TO_CHILD", direction = Relationship.Direction.INCOMING)
//	private List<Person> parents;
//
//	@Relationship(value = "PARENT_TO_CHILD", direction = Relationship.Direction.OUTGOING)
//	private List<Person> children;

	@Getter(value = AccessLevel.NONE)
	@Relationship(type = "PARENT_TO_CHILD", direction = Relationship.Direction.INCOMING)
	private List<ParentToChild> parentRels = new ArrayList<>();

	@Getter(value = AccessLevel.NONE)
	@Relationship(type = "PARENT_TO_CHILD", direction = Relationship.Direction.OUTGOING)
	private List<ParentToChild> childRels = new ArrayList<>();

	@PersistenceConstructor
//	private Person(UUID id, String name, Integer born, List<Person> parents, List<Person> children) {
	private Person(UUID id, String name, Integer born) {
		this.id = id;
		this.born = born;
		this.name = name;
//		this.parents = parents == null ? List.of() : new ArrayList<>(parents);
//		this.children = children == null ? List.of() : new ArrayList<>(children);
	}

	@JsonCreator
	public Person(String name, Integer born) {
//		this(null, name, born, List.of(), List.of());
		this(null, name, born);
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getBorn() {
		return born;
	}

	public void setBorn(Integer born) {
		this.born = born;
	}
//
//	public List<Person> getParents() {
//		return parents;
//	}
//
//	public List<Person> getChildren() {
//		return children;
//	}


	public List<ParentToChild> getParentRels() {
		return parentRels;
	}

	public List<ParentToChild> getChildRels() {
		return childRels;
	}
}
