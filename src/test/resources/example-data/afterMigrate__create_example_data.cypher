CREATE (PaulBlythe:Person {name:'Paul Blythe'})
CREATE (AngelaScope:Person {name:'Angela Scope'})
CREATE (JessicaThompson:Person {name:'Jessica Thompson'})
CREATE (JamesThompson:Person {name:'James Thompson'})

CREATE
(JamesThompson)-[:PARENT_TO_CHILD]->(JessicaThompson),
(AngelaScope)-[:PARENT_TO_CHILD]->(JessicaThompson),
(PaulBlythe)-[:PARENT_TO_CHILD]->(AngelaScope)

CREATE (movie:Movie {title:'Abc'})
CREATE (movie)<-[:ACTED_IN]-(AngelaScope)
